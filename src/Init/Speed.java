package Init;

/**
 * Created by Administrator on 2017/11/24.
 * 速度等于 车轮半径*2*PI*转速
 */
class Test{
    public static void main(String [] args){
        Speed s = new Speed();
        s.setR(12);
        s.setRote(120);
        System.out.println("奥拓速度为："+s.getSpeed());

        Speed01 s1 = new Speed01();
        s1.setR(10);
        s1.setRote(120);
        System.out.println("奥迪的速度为："+s1.getSpeed());
    }
}
public class Speed extends Speed02 {
    public void setR(int r){
        this.r=r;
    }
    public void setRote(double rote){
        this.rote=rote;
    }
}
class Speed01 extends Speed02{
    public void setR(int r){
        this.r=r;
    }
    public void setRote(double rote){
        this.rote=rote;
    }
}
abstract class Speed02{
    protected int r;
    protected double rote;
    public abstract void setR(int r);
    public abstract void setRote(double rote);
    public double getSpeed(){
        return r*2*Math.PI*rote;
    }
}