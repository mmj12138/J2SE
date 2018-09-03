package Singleton;

/**
 * Created by mengmengjiang on 2017/11/1.
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        //显示信息
        object.showMessage();
    }
}
//思考问题。单例是否是安全的，如何变为安全的，会不会出现不是单例的这样的现象，没有考虑多线程的情况
//是工厂方式的思想1、成员2.构造方法3.公共的方法(接口）
