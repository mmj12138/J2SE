/**
 * Created by mengmengjiang on 2017/10/29.
 */
public class N {
    static void money(){
        float money=0;
        int day = 0;
        while(money<=100){
            day++;
            money+=2.5f;
            if(day%5==0){
                money-=6;
            }
        }
        System.out.println(day);
    }
    public static void main(String[] args) {
        money();
    }
}
