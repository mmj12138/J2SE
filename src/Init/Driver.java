package Init;

/**
 * Created by Administrator on 2017/11/10.
 */
public class Driver {
    private String name;
    public void setName(String name1){
        name = name1;
    }
    public String getName(){
        return name;
    }
    Driver(String name){
        this.name=name;
    }
    public static void main(String[] args) {
        Driver d = new Driver("����");
        Car c = new Car();
        c.setSpeed(20);
        System.out.println(d.getName()+"��ǰ���ٶ���"+c.getSpeed()+"km/h");

    }
}
