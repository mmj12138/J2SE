package SuanFa;

/**
 * Created by Administrator on 2017/11/27.
 */
import java.util.Scanner;
public class n11{
    public static void main(String[] args) {
        System.out.println("请输入一个自然数:");
        int n = new Scanner(System.in).nextInt();
        long fact = 1;
        for(int i = 1; i<=n; i++){
            fact*=i;
        }
        //统计结果中的0的个数
        String result = fact+"";
        int count0 = 0;
        for(int i = 0; i<result.length(); i++){
            if(result.charAt(i) == '0'){
                count0++;
            }
        }
        System.out.println(n + "的阶乘是" + fact + ",结果中有" + count0 + "个0");
    }
}