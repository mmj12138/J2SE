package Init;

/**
 * Created by Administrator on 2017/11/19.
 */
public class Head {
    private String name;
    public String getName() {
        return name;
    }
    Head(String name){
        this.name=name;
    }
}
class Person01{
    private Head lhead;
    private Head rhead;
    Person01(){
        lhead=new Head("вСдт");
        rhead=new Head("срдт");
    }
    public static void main(String[] args) {
        System.out.println(new Person01().lhead.getName());
    }

}
