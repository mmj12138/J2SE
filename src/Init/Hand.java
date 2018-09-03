package Init;
public class Hand{
    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    Hand(String name){
        this.name=name;
    }
}

class Person{
    private Hand lhand;
    private Hand rhand;
    Person(){
        lhand=new Hand("×óÊÖ");
        rhand=new Hand("ÓÒÊÖ");
    }

    public static void main(String[] args) {
        System.out.println(new Person().lhand.getName());
    }

}
