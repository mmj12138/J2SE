package SuanFa;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/29.
 */
public class n19 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String ss = sc.next();
        char [] str = ss.toCharArray();
        int n = str.length;
        int [] num = new int[100];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(str[i]=='A'|str[i]=='B'|
                    str[i]=='C'|str[i]=='D'|
                    str[i]=='E'|str[i]=='F')
                num[i]=str[i]-55;
            if(str[i]=='a'|str[i]=='b'|
                    str[i]=='c'|str[i]=='d'|
                    str[i]=='e'|str[i]=='f')
                num[i]=str[i]-87;
            if(str[i]=='1'|str[i]=='2'|
                    str[i]=='3'|str[i]=='4'|
                    str[i]=='5'|str[i]=='6'|
                    str[i]=='7'|str[i]=='8'|
                    str[i]=='9'|str[i]=='0')
                num[i]=str[i]-48;
        }
        int i;
        for(i=0;i<n-1;i++)
            sum=(sum+num[i])*16;
        sum=sum+num[i];
        System.out.printf("十进制数为：%d\n",sum);
    }
}
