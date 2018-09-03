package SuanFa;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/15.
 * 求2+22+222+·······+2222222（n个2）
 * 算法设计：
 * 假设n=1；个位一个2
 *     n=2; 个位两个二，十位一个二
 *     n=3;3个2,2个2,1个2
 *     由此可以推出各个位2相加的个数和n的关系，
 *     考虑到进位的关系还要存出一个进位
 *     由于最高位本身永远是2，所以无论进位多少都不会溢出，故不必考虑最高位的溢出
 */
public class n1 {
    public static void main(String[] args) {
        int  n = 10;
        int jinWei=0;
        int [] num=new int[n];
        //输出个位的数
        for(int i=n;i>0;i--){
            num[i-1]=(jinWei+i*2)%10;
            jinWei=(jinWei+i*2)/10;
        }
        for(int i=0;i<=n-1;i++){
            System.out.print(num[i]+"");
        }
    }

}
