package Init;

/**
 * Created by Administrator on 2017/11/19.
 */
public class Computer {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Person02{
    private Computer computer;
    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    public static void main(String [] args){
        Person02 p2 = new Person02();
        Computer c = new Computer();
        c.setName("БЄПл");
        p2.setComputer(c);
        String name = p2.getComputer().getName();
        System.out.println(name);
    }
}
