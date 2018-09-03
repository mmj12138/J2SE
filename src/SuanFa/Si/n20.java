package SuanFa.Si;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/9.
 * 有n个整数排成一圈，现在要从中找出和最大的数串
 * 输入一个长度n,输入一个长度为n的数组
 * 定义三个变量：开始，结束，最大和
 * 两层循环确定开始和结束，用取模来控制循环，遍历出所有情况
 * 每一个开始向后加和，大于最大值则更新最大值以及起始点和终止点，遍历出所有情况后
 * 输出的max便是最大值，从起始点遍历数组到终止点，便是这个子串
 */
public class n20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int start = 0;
        int end = 0;
        int max=a[0];
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j=i;j<i+n;j++){
                int m = j%n;
                sum+=a[m];
                if(sum>max){
                    start=i;
                    end=m;
                    max=sum;
                }
            }
        }
        System.out.println("最大的数串为：");
        for(int i = start;i<=end;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("其数串的和为：");
        System.out.println(max);

    }
}
