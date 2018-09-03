package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class RunNian {
    /**
     * 写一个程序，通过三目运算符判断它是不是闰年
     * 闰年条件：能被4整除，且不能被一百整除
     * 或
     * 能被400整除
     */
    static void choose(int year){//有参数无返回值（空）方法
        if((year%4==0&&year%100!=0)||year%400==0){//满足条件，为闰年
            System.out.println(year+"是闰年");//输出
        }else{//否则，为平年
            System.out.println(year+"是平年");//输出
        }
    }
    public static void main(String[] args) {
        int year = 2008;//定义一个年份
        //如果该年份能被4整除且不能被100整除，或能被400整除，则输出闰年，否则输出平年
        System.out.println( (year%4==0&&year%100!=0)||year%400==0?"闰年":"平年");
        choose(year);
    }
}
