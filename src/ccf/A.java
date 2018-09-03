package ccf;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/17.
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int num = 0;
        int temp = 0;
        int min = 0;
        if(n==1){
            System.out.println(a[0]);
            return;
        }else{
            Arrays.sort(a);
            for(int i = 0;i<(n-1);i++){
                if(a[i]==a[i+1]){
                    num++;
                }
                else{
                    num=1;
                }
                if(num>temp){
                    temp = num;
                    min = a[i];
                }
            }
        }
        System.out.println(min);
    }
}
