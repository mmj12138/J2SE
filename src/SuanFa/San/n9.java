package SuanFa;
import java.util.Scanner;
/**
 * Created by Administrator on 2017/11/27.
 */
public class  n9{
    public static void main(String args[]){
        int x, y;
        Scanner s= new Scanner(System.in);
        System.out.println("input x");
        x=s.nextInt();
        System.out.println("input y");
        y=s.nextInt();
        System.out.println("result:"+f(x,y));
    }
    public static int f(int a,int b){
        int result=0;
        if(b-a==1)
            result= 1;
        if(b-a==2){
            result= 2;
        }
        if(b-a>2){
            result= f(a,b-1)+f(a,b-2);
        }
        return result;
    }

}