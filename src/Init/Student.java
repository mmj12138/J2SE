package Init;

/**
 * Created by Administrator on 2017/11/10.
 */
public class Student {

    public static void main(String[] args) {
        Student s = new Student();
        s.setName("姜萌萌");
        s.setGrade(3);
        s.setNo("1504010710");
        System.out.println("我的名字是："+s.getName());
        System.out.println("我是大"+s.getGrade()+"的");
        System.out.println("我的学号是："+s.getNo());
    }
    Student(){

    }
    /*
   getter setter 【sex name salary height weight birth address email alias zip】
    */
    String sex;
    void setSex(String sex){
        this.sex=sex;
    }
    String getSex(){
        return sex;
    }
    double salary;
    void setSalary(double salary){
        this.salary=salary;
    }
    double getSalary(){
        return salary;
    }
    double height;
    void setHeight(double height){
        this.height=height;
    }
    double getHeight(){
        return height;
    }
    double weight;
    void setWeight(double weight){
        this.weight=weight;
    }
    double getWeight(){
        return weight;
    }
    String birth;
    void setBirth(String birth){
        this.birth=birth;
    }
    String getBirth(){
        return birth;
    }
    String address;
    void setAddress(String address){
        this.address=address;
    }
    String getAddress(){
        return address;
    }
    String email;
    void setEmail(String email){
        this.email=email;
    }
    String getEmail(){
        return email;
    }
    String alias;
    void setAlias(String alias){
        this.email=email;
    }
    String getAlias(){
        return alias;
    }
    String zip;
    void setZip(String zip){
        this.zip=zip;
    }
    String getZip(){
        return zip;
    }
    String name;
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
    int grade;
    void setGrade(int grade1){
        grade=grade1;
    }
    int getGrade(){
        return grade;
    }
    String no;
    void setNo(String no1){
        no=no1;
    }
    String getNo(){
        return no;
    }

}
