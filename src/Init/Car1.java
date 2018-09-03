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
        xingHao="轿车";
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
        this.productor="宝马";
    }
    Car2(){
        this("蓝色");
    }
    public static void main(String [] args){
        Car2 c = new Car2();// 利用无参构造方法创建第一个Car1对象
        System.out.println("第一辆车的详细信息如下:");
        System.out.println("生产厂家：" + c.productor);// 调用Car1的produce属性
        System.out.println(c.getColor());		// 调用其父类Car的showColor方法
        System.out.println(c.getXingHao());		// 调用其父类Car的showModel方法
        Car2 c1 = new Car2("银白色");
        System.out.println("\n第二辆车的详细信息如下:");
        System.out.println("生产厂家：" + c1.productor);
        System.out.println(c1.getColor());		// 调用其父类Car的showColor方法
        System.out.println(c1.getXingHao());
        Car2 c2 = new Car2("蓝色", "卡车", "天津一汽");
        System.out.println("\n第三辆车的详细信息如下:");
        System.out.println("生产厂家：" + c2.productor);
        System.out.println(c2.getColor());		// 调用其父类Car的showColor方法
        System.out.println(c2.getXingHao());
    }
}
