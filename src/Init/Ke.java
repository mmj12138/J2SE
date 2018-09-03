package Init;

/**
 * Created by Administrator on 2017/12/2.
 */
public class Ke {
    public static void main(String[] args) throws CloneNotSupportedException {
        Professor pro = new Professor("ÄÐ");
        Dog dog = new Dog("huagou",1,pro);
        Dog dog1 = (Dog) dog.clone();
        dog.getPro().setSex("Å®");
        System.out.println(dog1.getPro().getSex());
    }


}
class Dog implements Cloneable{
    private Professor pro;
    private String name;
    private int age;
    public Dog(){}
    public Dog(String name, int age,Professor pro) {
        this.name = name;
        this.age = age;
        this.pro=pro;
    }

    public Professor getPro() {
        return pro;
    }

    public void setPro(Professor pro) {
        this.pro = pro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Professor pro1=(Professor) this.pro.clone();
        Dog dog1=(Dog)super.clone();
        dog1.pro=pro1;
        return dog1;
    }
}
class Professor implements Cloneable{
    private String sex;
    public Professor(){}
    public Professor(String sex) {
        this.sex = sex;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
