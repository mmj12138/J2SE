package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class MaoPao {
    static void maoPao(){
        int [] a = {3,5,4,2,6,7,1};
        int c = 0;
        for(int i = 0;i<a.length-1;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    c=a[j+1];
                    a[j+1]=a[j];
                    a[j]=c;
                }
            }
        }
        for(int x : a){
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        maoPao();
    }
}
