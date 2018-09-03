package biShi;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/31.
 */
public class AB {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int sum = 0;
        if(b+d==a){
           sum = sum+c*d;
        }
        System.out.println(sum);
    }
}
