package SheJiMoShi.ShiJian;

/**
 * Created by Administrator on 2017/12/15.
 */
public class Client4 {
    public static void main(String[] args) {
        SearchContext objJava,objSQL,objUML;

        objJava = new JavaSearchContext();
        objSQL = new SQLSearchContext();
        objUML = new UMLSearchContext();

        objJava.setSuccessor(objSQL);
        objSQL.setSuccessor(objUML);

        SearchKey key1 = new SearchKey("java");
        objJava.handleRequest(key1);

        SearchKey key2 = new SearchKey("sql");
        objSQL.handleRequest(key2);

        SearchKey key3 = new SearchKey("uml");
        objUML.handleRequest(key3);
    }
}
class SearchKey{
    private String oneKey;

    public SearchKey(String oneKey) {
        this.oneKey = oneKey;
    }

    public String getKey() {
        return oneKey;
    }

    public void setKey(String oneKey) {
        this.oneKey = oneKey;
    }
}
abstract class SearchContext {
    protected SearchContext successor;
    public void setSuccessor(SearchContext successor) {
        this.successor = successor;
    }
    public abstract void handleRequest(SearchKey key);
}

class JavaSearchContext extends SearchContext{
    public void handleRequest(SearchKey key) {
        String key1 = "java";
        if(key1.equals(key.getKey()))
            System.out.println("在Java中找到了");
        else
        if(this.successor != null) this.successor.handleRequest(key);
    }
}
class SQLSearchContext extends SearchContext{
    public void handleRequest(SearchKey key) {
        String key1 = "sql";
        if(key1.equals(key.getKey()))
            System.out.println("在SQL中找到了");
        else
        if(this.successor != null) this.successor.handleRequest(key);
    }
}
class UMLSearchContext extends SearchContext{
    public void handleRequest(SearchKey key) {
        String key1 = "uml";
        if(key1.equals(key.getKey()))
            System.out.println("在UML中找到了");
        else
        if(this.successor != null) this.successor.handleRequest(key);
    }
}