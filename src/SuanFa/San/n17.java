package SuanFa;

/**
 * Created by Administrator on 2017/11/29.
 */
public class n17 {
    public static void main(String[] args) {
        int a=1;
        int b=0;
        int c=5;
        for(int i=1;i<=100;i++){
            if(i%3==a&&i%4==b&&i%7==c){
                System.out.println("这个数是："+i);
            }
        }
    }
}
