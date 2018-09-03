package SuanFa;

/**
 * Created by Administrator on 2017/11/29.
 */
public class n16 {
    public static void main(String[] args) {
        int n=28;
        int sum=0;
        if(n%4==0){
            sum+=1;
        }
        if(n%7==0){
            sum+=2;
        }
        if(n%9==0){
            sum+=4;
        }
        if(sum==1){
            System.out.println("能被4整除。");
        }else if(sum==2){
            System.out.println("能被7整除。");
        }else if(sum==4){
            System.out.println("能被9整除。");
        }else if(sum==3){
            System.out.println("能被4、7整除。");
        }else if(sum==5){
            System.out.println("能被4、9整除。");
        }else if(sum==6){
            System.out.println("能被7、9整除。");
        }else if(sum==7){
            System.out.println("能同时被4,7,9整除。");
        }else if(sum==0){
            System.out.println("不能被4,7,9任一整除。");
        }
    }
}
