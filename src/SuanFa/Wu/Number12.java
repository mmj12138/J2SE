package SuanFa.Wu;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/10.
 * 同上一个算法，开始的范围依旧是1到n/2,但是这一次不必控制结尾
 * 这一次的思想是从i(1-n/2)开始向后相加，相加后的数字为sum
 * 当sum小于n时继续向下加，如果等于那么输出，且进行下一次循环
 * 但如果直接就大于则直接退出进行下一次循环，
 * 说白了，就是小于n时，结尾向后加，大于等于n时，开头向后加，其中等于n时输出
 * 直到i>n/2时，遍历结束。退出程序。
 */
public class Number12 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =1;i<=n/2;i++){
            int sum=0;
            int j =i-1;
            while(true){
                sum+=++j;
                if(sum>n){
                    break;
                }else if(sum==n){
                    System.out.print(i);
                    for(int k =i+1;k<=j;k++){
                        System.out.print("+"+k);
                    }
                    System.out.println("="+sum);
                    break;
                }
            }
        }
    }
}
