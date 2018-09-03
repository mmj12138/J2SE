package SuanFa.San;
import java.util.Scanner;
/**
 * Created by Administrator on 2017/11/29.
 */
public class n22 {
    public static void main(String[] args) {
        int max=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int m=0;
            for (int j = i; j < i+4; j++) {
                m+=a[j%n];
            }
            max=m>max?m:max;
        }
        System.out.println(max);
    }
}
