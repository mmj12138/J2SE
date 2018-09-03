package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class ChengFaBiao {
    static void chengFa(){
        for(int i = 1;i<=9;i++){
            for(int j = 1;j<=i;j++){
                int sum=j*i;
                System.out.print(j+"*"+i+"="+sum+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        chengFa();
    }
}
