package SuanFa;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/10.
 */
public class n6 {
    public static void main(String[] args) {
        while(true){
            N6();
        }

    }
    static void N6(){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char []a=s.toCharArray();
        int []flagPrint=new int[a.length];//不可以输出字符的状态置为1
        int count=0;//计数有几对括号
        int m=0;//左括号
        int n=0;//右括号

//        标记成数组
        for(char i:a){
            System.out.print(i);
        }
        System.out.println();

        for(char i:a){
            if(i=='('){
                count++;//
            }
        }
//        System.out.println(count);
        for(int i=0;i<count;i++){//每对括号的循环
            for(int j=i;j<a.length;j++){//先找到第一个右侧的括号
                if(a[j]==')'&&flagPrint[j]==0){
                    n=j;
                    flagPrint[j]++;//将这个括号的标志位从0改为1，下次就不会找到这个括号了
                    break;//找到了就不再继续找
                }
            }
            for(int j=n;j>=0;j--){//在找到与这个右侧括号向左相邻的第一个左侧的括号
                if(a[j]=='('&&flagPrint[j]==0){
                    m=j;
                    flagPrint[j]++;
                    break;
                }
            }
            System.out.println();
            System.out.println("m===="+m);
            System.out.println("n==="+n);
            int count1=0;//括号里面加减号的数量
            for(int j=m+1;j<n;j++){
                if (a[j]=='+'||a[j]=='-'){
                    count1++;
                }
            }

            if((m!=0&&n==a.length-1&&a[m-1]=='/')||(m==0&&n!=a.length-1&&a[n+1]=='/')||(m!=0&&n!=a.length-1&&(a[m-1]=='/'||a[n+1]=='/'))){
//                System.out.println("不能去掉");
                continue;
            }
            if(count1==0&&(m!=0&&n==a.length-1&&a[m-1]=='-')||(m==0&&n!=a.length-1&&a[n+1]=='-')||(m!=0&&n!=a.length-1&&(a[m-1]=='-'||a[n+1]=='-'))){
                flagPrint[m]++;//可以去掉 就将输出标志位置1
                flagPrint[n]++;
                continue;
            }
            if(((m!=0&&n==a.length-1&&a[m-1]=='*')||(m==0&&n!=a.length-1&&a[n+1]=='*')||(m!=0&&n!=a.length-1&&(a[m-1]=='*'||a[n+1]=='*')))){
                continue;
            }
            if(count1!=0&&(m!=0&&n==a.length-1&&a[m-1]=='-')||(m==0&&n!=a.length-1&&a[n+1]=='-')||(m!=0&&n!=a.length-1&&(a[m-1]=='-'||a[n+1]=='-'))){
                continue;
            }

            //||a[m-1]=='/'||a[n+1]=='/'
            if(m!=0&&n!=a.length-1&&(a[m-1]=='*'||a[n+1]=='*')){//两个括号都在边上,且至少有一边括号旁边是* 或/
//                System.out.println("不可去掉当前这组括号");
                continue;
            }else if(m!=0&&n==a.length-1&& (a[m-1]=='*' )) {//n再边上 m不在判断乘除号
//                System.out.println("不可 左侧不满足");
                continue;
            }else if(m==0&&n!=a.length-1&&(a[n+1]=='*')){//m再边上，n不在 判断乘除号
//                System.out.println("不可 右侧不满足去括号条件");
                continue;
            }else{
//                System.out.println("可以去掉");
                flagPrint[m]++;//可以去掉 就将输出标志位置1
                flagPrint[n]++;
            }


        }
        for(int i=0;i<a.length;i++){//输出
            if(flagPrint[i]==2)
                continue;
            System.out.print(a[i]);
        }
        System.out.println();
    }
}


