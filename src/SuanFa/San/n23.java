package SuanFa;
import java.util.Scanner;
/**
 * Created by Administrator on 2017/11/13.
 */
public class n23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int []num=new int[5];
        int count=0;
        for(int i=5;i>=1;i--)
        {
            num[i-1]=n%(int)Math.pow(10,i)/(int)Math.pow(10,i-1);
            if(num[i-1]!=0){
                System.out.print(num[i-1]);
                count++;
            }
        }
        System.out.println();
        for(int i=0;i<5;i++){
            if(num[i]!=0){
                System.out.print(num[i]);
            }
        }
        System.out.println();
        System.out.println(count+"Î»Êý");
    }
}
