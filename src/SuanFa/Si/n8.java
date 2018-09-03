package SuanFa.Si;

/**
 * Created by Administrator on 2017/12/9.
 * 寻找满足以下条件的4位整数， 无重复数字 千位数字非0
 * 能整除它的各个位数字和的平方
 * 4位整数 千位非0 即确定数字范围1012--9876
 * 将该数的各个位数字分别提出并进行判断
 * 满足各个位不相等后
 * 判断其是否等于各个位数字之和的平方
 * 若等于，输出
 */
public class n8 {
    public static void main(String[] args) {
        int i,sum,a,b,c,d;
        for(i=1012;i<=9876;i++) {
            a=i%10;//个位
            b=i/10%10;//十位
            if(a!=b) {
                c=i/100%10;//百位
                if(a!=c&&b!=c) {
                    d=i/1000%10;//千位
                    if(a!=d&&b!=d&&c!=d) {
                        sum=(a+b+c+d)*(a+b+c+d);
                        if(i%sum==0)
                            System.out.println(i);
                    }
                }
            }
        }
    }
}
