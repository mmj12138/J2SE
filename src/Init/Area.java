package Init;

/**
 * Created by Administrator on 2017/11/24.
 * ʵ�ó������ò�ͬͼ�ε�������ܳ���Բ�Ρ������Ρ�����
 */
class Test01{
    public static void main(String [] args){
        Area01 a1 = new Area01();
        a1.setWidth(10);
        a1.setHeight(20);
        System.out.println("���ε�����ǣ�"+a1.getArea3());
        System.out.println("�����ε�����ǣ�"+a1.getArea1());
//        Area a=new Area();
//        a.setR(10);
//        System.out.println("Բ�ε������"+a.getArea2());

    }
}
//public class Area extends Area02 {
//    public void setR(int r){
//        this.r = r;
//    }
//}
class Area01 extends Area02{
    public void setWidth(int width){
        this.width=width;
    }
    public void setHeight(int height){
        this.height=height;
    }
}
abstract class Area02{
    protected int width;
    protected int height;
    protected int r;
//    public abstract void setR(int r);
    public abstract void setWidth(int width);
    public abstract void setHeight(int height);
    public float getArea1(){
        return (width*height)/2;
    }
    public double getArea2(){
        return Math.PI*r*r;
    }
    public int getArea3(){
        return width*height;
    }
}