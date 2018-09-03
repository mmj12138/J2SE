package Singleton;

/**
 * Created by mengmengjiang on 2017/11/1.
 */
public class SingleObject {
    //����SingleObject��һ������
    private static SingleObject instance = new SingleObject();

    //�ù��췽��˽�У���������Ͳ��ᱻʵ����
    private SingleObject(){}

    //��ȡΨһ���õĶ���
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
