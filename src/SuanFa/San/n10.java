package SuanFa;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/27.
 */
public class n10 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int v = a - a / gcd(a, b);
        if (v == 0)
            System.out.println(-1);
        else
            System.out.println(v);
    }

    private static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int mod = max % min;
        if (mod == 0) {
            return min;
        } else {
            return gcd(mod, min);
        }
    }
}
