package SuanFa.San;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Koreyoshi on 2017/11/15.
 */
public class n26 {
    static int is_xunhuan(int[] buf, int a, int b) {
        int i;
        if (a == b) {
            for (i = 1; i < 10; i++) {
                if (buf[a] == buf[a + i]) {
                } else
                    return 0;
            }
        } else
            for (i = a; i <= b; i++) {
                if (buf[i] == buf[i + b - a + 1]) {
                } else {
                    return 0;
                }
            }
        return 1;
    }
    public static void main(String[] args) {
        int[] buf = new int[1024];
        int yushu;
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int i, j, k;
        yushu = m;
        buf[0] = 0;
        i = 1;
        while (yushu != 0) {
            yushu = yushu * 10;
            buf[i] = yushu / n;
            yushu = yushu % n;
            i++;
            if (i == 1024)
                break;
        }
        if (i < 1024) {
            System.out.printf("有限小数\n");
            System.out.printf("%d.", buf[0]);
            for (j = 1; j < i; j++)
                System.out.printf("%d", buf[j]);
            System.out.printf("\n");
        } else {
            System.out.printf("循环小数\n");
            for (i = 1; i < 100; i++)
                for (j = i; j < 200; j++) {
                    if (is_xunhuan(buf, i, j)==1) {
                        System.out.printf("%d.", buf[0]);
                        if (i > 1) {
                            for (k = 1; k < i; k++)
                                System.out.printf("%d", buf[k]);
                        }
                        System.out.printf("(");
                        for (k = i; k <= j; k++)
                            System.out.printf("%d", buf[k]);
                        System.out.printf(")");
                        System.out.printf("\n");
                        return;
                    }
                }
        }
    }
}


