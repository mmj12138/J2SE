package ccf;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/17.
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i]= sc.nextInt();
        }
        int max = 0;
        int s = 0;
        for(int i = 0;i<n;i++){
            int h = a[i];
            int w = 1;
            int temp1 = i-1;
            int temp2 = i+1;
            while(temp1>0){
                if(a[temp1]>h){
                    w++;
                }
            }
            while(temp2<n){
                if(a[temp2]>h){
                    w++;
                    temp2++;
                }else{
                    break;
                }
            }
            s=h*w;
            if(s>max){
                max=s;
            }
        }
        System.out.println(max);
    }
}
