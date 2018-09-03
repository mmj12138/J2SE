package Init;

/**
 * Created by Administrator on 2017/11/19.
 */
public class SunZi extends ErZi {
    private int age = 100;
    {
        age=300;
        System.out.println(age);
    }
    SunZi(){
        this(200);
        System.out.println(age);
    }
    SunZi(int age){
        super();
        this.age= age;
        System.out.println(3);
    }

    public static void main(String[] args) {
        new SunZi();
    }
}
class ErZi{
    {
        System.out.println(5);
    }
    ErZi(){
        System.out.println(4);
    }
}

