package Singleton;

/**
 * Created by mengmengjiang on 2017/11/1.
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        //��ȡΨһ���õĶ���
        SingleObject object = SingleObject.getInstance();

        //��ʾ��Ϣ
        object.showMessage();
    }
}
//˼�����⡣�����Ƿ��ǰ�ȫ�ģ���α�Ϊ��ȫ�ģ��᲻����ֲ��ǵ���������������û�п��Ƕ��̵߳����
//�ǹ�����ʽ��˼��1����Ա2.���췽��3.�����ķ���(�ӿڣ�
