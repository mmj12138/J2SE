package Init;

/**
 * Created by Administrator on 2017/11/19.
 */
public class Car1 {
    protected String color;
    protected String xingHao;

    public void setColor(String color) {
        this.color = color;
    }
    Car1(){
        color="red";
        xingHao="�γ�";
    }
    Car1(String color,String xingHao){
        this.color=color;
        this.xingHao=xingHao;
    }
    String getColor(){
        return this.color;
    }
    String getXingHao(){
        return this.xingHao;
    }
}
class Car2 extends Car1{
    private String productor;
    Car2(String productor,String color,String xingHao){
        super(color,xingHao);
        this.productor=productor;
    }
    Car2(String color){
        this.color=color;
        this.productor="����";
    }
    Car2(){
        this("��ɫ");
    }
    public static void main(String [] args){
        Car2 c = new Car2();// �����޲ι��췽��������һ��Car1����
        System.out.println("��һ��������ϸ��Ϣ����:");
        System.out.println("�������ң�" + c.productor);// ����Car1��produce����
        System.out.println(c.getColor());		// �����丸��Car��showColor����
        System.out.println(c.getXingHao());		// �����丸��Car��showModel����
        Car2 c1 = new Car2("����ɫ");
        System.out.println("\n�ڶ���������ϸ��Ϣ����:");
        System.out.println("�������ң�" + c1.productor);
        System.out.println(c1.getColor());		// �����丸��Car��showColor����
        System.out.println(c1.getXingHao());
        Car2 c2 = new Car2("��ɫ", "����", "���һ��");
        System.out.println("\n������������ϸ��Ϣ����:");
        System.out.println("�������ң�" + c2.productor);
        System.out.println(c2.getColor());		// �����丸��Car��showColor����
        System.out.println(c2.getXingHao());
    }
}
