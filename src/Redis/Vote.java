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
                System.out.println("您发布了一篇文章，id为：: " + articleId);
        System.out.println("文章的详细信息如下：");
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
        System.out.println("当前值得推荐的文章是：");
        List<Map<String,String>> articles = getArticles(conn, 1);
        for(int i = 0;i<articles.size();i++){
            System.out.println("作者为"+articles.get(i).get("user")+"题目为："+articles.get(i).get("title")+"票数"+articles.get(i).get("votes"));
        }
        System.out.println("-----------------------------------------------------------------");

        for(int i = 0;i<articles.size();i++){
            int num = Integer.parseInt(articles.get(i).get("votes"));
            if(num>2){
                System.out.println("作者为"+articles.get(i).get("user")+"题目为："+articles.get(i).get("title"));
            }
        }
        System.out.println();
    }

    public void run() {
        //1、初始化redis连接
        Jedis conn = new Jedis("localhost");
        conn.select(15);
        Scanner sc = new Scanner(System.in);
        boolean f = true;
        while (f){
            System.out.println("请输入您想执行的操作对应的数字：1、发布文章，2、为文章投票");
            int x = sc.nextInt();
            if(x==1){//2、发布文章
                System.out.println("请输入文章作者：");
                String user = sc.next();
                System.out.println("请输入文章题目：");
                String title = sc.next();
                postArticle(conn, user, title, "http://www.google.com");
                System.out.println();
            }else if(x==2){
                tuiJian(conn);
                System.out.println("请输入您的用户名：");
                String me = sc.next();
                System.out.println("您想投票的文章ID为：");
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
                    System.out.println("您已为该文章投过票！");
                    return;
                }else{
                    String o=conn.hget(article,"users");
                    String fina = o+"."+me;
                    conn.hset(article,"users",fina);
                    articleVote(conn, user, article);
                    String votes = conn.hget(article, "votes");
                    System.out.println("您已为该文章投票，目前该文章的票数 " + votes);
                    assert Integer.parseInt(votes) > 1;
                }

            }
            System.out.println("你想继续操作么(yes or no)？：");
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

