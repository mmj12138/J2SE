package SheJiMoShi.ShiYan;

/**
 * Created by Administrator on 2017/12/2.
 */
public class Client2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        ZuoBiao z1=new ZuoBiao(2,1,3,3);
        JuXing j1=new JuXing(z1,"内容");
        JuXing j2=(JuXing)j1.clone();
        System.out.println("克隆的横坐标："+j2.getZuoBiao().getX1());
        z1.setX1(4);
        System.out.println("修改后的横坐标："+j2.getZuoBiao().getX1());
    }
}
class JuXing implements Cloneable {
    private ZuoBiao zuoBiao;
    private String text;
    public JuXing(){}

    public JuXing(ZuoBiao zuoBiao, String text) {
        this.zuoBiao = zuoBiao;
        this.text = text;
    }

    public ZuoBiao getZuoBiao() {
        return zuoBiao;
    }

    public void setZuoBiao(ZuoBiao zuoBiao) {
        this.zuoBiao = zuoBiao;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class ZuoBiao implements Cloneable {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    public ZuoBiao(){}
    public ZuoBiao(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

