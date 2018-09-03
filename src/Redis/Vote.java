package Redis;
import java.util.*;

import redis.clients.jedis.Jedis;


public class Vote {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    public String postArticle(Jedis conn, String user, String title, String link) {
        String articleId = String.valueOf(conn.incr("article:"));
        String voted = "voted:" + articleId;
        conn.sadd(voted, user);
        conn.expire(voted, ONE_WEEK_IN_SECONDS);
        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        HashMap<String,String> articleData = new HashMap<String,String>();
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("user", user);
        articleData.put("now", String.valueOf(now));
        articleData.put("votes", "0");
        articleData.put("users","1");
        conn.hmset(article, articleData);
        conn.zadd("score:", now + VOTE_SCORE, article);
        conn.zadd("time:", now, article);
                System.out.println("��������һƪ���£�idΪ��: " + articleId);
        System.out.println("���µ���ϸ��Ϣ���£�");
        for (Map.Entry<String,String> entry : articleData.entrySet()){
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        return articleId;
    }


    public void articleVote(Jedis conn, String user, String article) {
        long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
        if (conn.zscore("time:", article) < cutoff){
            return;
        }
        conn.zincrby("score:", VOTE_SCORE, article);
        conn.hincrBy(article, "votes", 1L);
    }

    public List<Map<String,String>> getArticles(Jedis conn, int page) {
        return getArticles(conn, page, "score:");
    }
    public List<Map<String,String>> getArticles(Jedis conn, int page, String order) {
        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;
        Set<String> ids = conn.zrevrange(order, start, end);
        List<Map<String,String>> articles = new ArrayList<Map<String,String>>();
        for (String id : ids){
            Map<String,String> articleData = conn.hgetAll(id);
            articleData.put("id", id);
            articles.add(articleData);
        }

        return articles;
    }
    public void tuiJian(Jedis conn){
        System.out.println("��ǰֵ���Ƽ��������ǣ�");
        List<Map<String,String>> articles = getArticles(conn, 1);
        for(int i = 0;i<articles.size();i++){
            System.out.println("����Ϊ"+articles.get(i).get("user")+"��ĿΪ��"+articles.get(i).get("title")+"Ʊ��"+articles.get(i).get("votes"));
        }
        System.out.println("-----------------------------------------------------------------");

        for(int i = 0;i<articles.size();i++){
            int num = Integer.parseInt(articles.get(i).get("votes"));
            if(num>2){
                System.out.println("����Ϊ"+articles.get(i).get("user")+"��ĿΪ��"+articles.get(i).get("title"));
            }
        }
        System.out.println();
    }

    public void run() {
        //1����ʼ��redis����
        Jedis conn = new Jedis("localhost");
        conn.select(15);
        Scanner sc = new Scanner(System.in);
        boolean f = true;
        while (f){
            System.out.println("����������ִ�еĲ�����Ӧ�����֣�1���������£�2��Ϊ����ͶƱ");
            int x = sc.nextInt();
            if(x==1){//2����������
                System.out.println("�������������ߣ�");
                String user = sc.next();
                System.out.println("������������Ŀ��");
                String title = sc.next();
                postArticle(conn, user, title, "http://www.google.com");
                System.out.println();
            }else if(x==2){
                tuiJian(conn);
                System.out.println("�����������û�����");
                String me = sc.next();
                System.out.println("����ͶƱ������IDΪ��");
                String id = sc.next();
                String article = "article:" + id;
                String user=conn.hget(article,"user");
                String users=conn.hget(article,"users");
                boolean flag = true;
                if(users.contains(".")) {
                    String cc[] = users.split("\\.");
                    for (int i = 0; i < cc.length; i++) {
                        if (cc[i].equals(me)) {
                            flag = false;
                        }
                    }
                }else{
                    if(users.equals(me)){
                        flag = false;
                    }
                }
                if(flag==false){
                    System.out.println("����Ϊ������Ͷ��Ʊ��");
                    return;
                }else{
                    String o=conn.hget(article,"users");
                    String fina = o+"."+me;
                    conn.hset(article,"users",fina);
                    articleVote(conn, user, article);
                    String votes = conn.hget(article, "votes");
                    System.out.println("����Ϊ������ͶƱ��Ŀǰ�����µ�Ʊ�� " + votes);
                    assert Integer.parseInt(votes) > 1;
                }

            }
            System.out.println("�����������ô(yes or no)����");
            String ff = sc.next();
            if(ff.equals("no")){
                f=false;
            }
        }

    }
    public static void main(String[] args) {
        new Vote().run();
    }
}

