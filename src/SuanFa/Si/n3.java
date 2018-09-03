package SuanFa.Si;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/9.
 * 54张牌 两个人轮流拿牌，每人每次最少拿1张，最多拿4张
 * 谁拿到最后一张牌谁就输了
 * 模拟先拿牌且必胜的算法
 * 最少1最多4  1+4==5  54%5==4
 * 这样就好办了
 * 先拿四3张 然后每一次都拿5-i张 最后就一定剩下1张
 * 正好到对方拿牌 最后一张
 * 自己就赢了
 */
public class n3 {
    public static void main(String[] args) {
        int n = 54;//54张牌
        System.out.println("我先拿3张");
        n=n-3;
        System.out.println("现在还剩"+n+"张");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int a = sc.nextInt();
            if (a < 1 || a > 4) {
                System.out.println("你犯规了！");
            } else {
                System.out.println("我拿" + (5 - a) + "张");
                n=n-5;
                System.out.println("现在还剩" +n+"张");
                if(n==1){
                    System.out.println("你输了，哈哈");
                    return;
                }
            }
        }
    }
}
