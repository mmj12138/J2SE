package Init;

/**
 * Created by Administrator on 2017/11/10.
 */
public class Car {
    Car(){

    }
    private double speed;
    public void setSpeed(double speed1){
        if(speed1>40){
            speed=40;
        }else{
            speed=speed1;
        }
    }


    public double getSpeed(){
        return speed;
    }
}
