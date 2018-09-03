/**
 * Created by Administrator on 2017/11/15.
 */
public class Human {
    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public static void main(String[] args) {
        Human h = new Human();
        Cat c = new Cat();
        c.setColor("»¨Ã¨");
        h.setCat(c);
        System.out.println(h.getCat().getColor());

    }
}
class Cat{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}