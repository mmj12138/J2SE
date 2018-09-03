package SuanFa.Wu;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/8.
 * 运用数学法来解此题
 * 连续自然数可以看成是一个等差数列 其差值是1，
 * 那么从i到j的等差数列之和公式就是
 * Sn=n*(i+j)/2   n=j-i+1  n表示的是这个数列有几个数
 * 知道了这个原理 这道题就变得好办多了
 * 首先要知道如果输入一个数n去求对应的连续自然数之和，
 * 那么这个连续的自然数中最大的不会超过(n+1)/2（小于等于）
 * 因为如果是奇数的话必然会有一个序列是它除以二的前后两个值例如15=7+8
 * 但再大就不会了两个数如果都大于他的一半，相加一定会大于他
 * 如果是偶数 最大不会超过n/2，因为他的一半加上任何一个比一半大的数字都会比他本身大
 * 所以就用两层for遍历所有可能的情况
 * 第一层for来确定起始位置第二层for来确定终点位置
 * 用变量sum 来存储每一次的和 然后判断是否符合要求
 * 满足的话利用for循环式子输出
 * 所有情况遍历结束后所有可能的式子也就输出了
 */
public class n12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        for(int i = 1;i<=n/2;i++){
            for(int j = 1;j<=(n+1)/2;j++){
                sum=((j-i+1)*(i+j))/2;
                if(sum==n){
                    System.out.print(i);
                    for(int k =i+1;k<=j;k++){
                        System.out.print("+"+k);
                    }
                    System.out.println("="+sum);
                }
            }
        }
    }
}
