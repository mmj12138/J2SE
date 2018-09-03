package SheJiMoShi.ShiYan;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/9.
 */
public class Client4 {
    public static void main(String[] args) {
        MySubject sub = new Cat();

        MyObserver obs1,obs2,obs3;
        obs1=new Mouse();

    }
}
abstract class MySubject{
    protected ArrayList obs = new ArrayList();

    public void attach(MyObserver ob){
        obs.add(ob);
    }

    public void detach(MyObserver ob){
        obs.remove(ob);
    }

    public abstract void cry();
}
interface MyObserver{
    void response();
}
class Cat extends MySubject{

    @Override
    public void cry() {
        System.out.println("√®Ω–£°");
        System.out.println("----------------");
        for(Object obb:obs){
            ((MyObserver)obs).response();
        }
    }
}
class Mouse implements MyObserver{

    @Override
    public void response() {
        System.out.println("¿œ Û‘⁄≈¨¡¶Ã”≈‹£°");
    }
}
class Dog implements MyObserver{

    @Override
    public void response() {
        System.out.println("π∑‘⁄Ω–£°");
    }
}


