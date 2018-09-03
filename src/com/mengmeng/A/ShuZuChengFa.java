package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class ShuZuChengFa {
    static void cheng(){
        int [][] a = {{1,2,3},{4,5,6}};
        int [][] b = {{7,8,9},{1,2,3}};
        int [][] c = new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                c[i][j]=c[i][j]+a[i][j]*b[j][i];
            }
        }
        for(int [] i:c){
            for(int j:i){
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        cheng();
    }
}
