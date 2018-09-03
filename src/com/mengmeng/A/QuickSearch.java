package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class QuickSearch {
    static void quick(int [] a,int start,int end){
        int i=start;
        int j=end;
        if(i>=j){
            return;
        }
        boolean flag=true;
        while(i<j){
            int tmp=0;
            if(a[i]>a[j]){
                tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                flag=!flag;
            }
            if(flag){
                j--;
            }else{
                i++;
            }
        }
        i--;
        j++;
        quick(a,start,i);
        quick(a,j,end);
    }

    public static void main(String[] args) {
        int [] a = {3,4,2,6,1,5,9,8,7};
        quick(a,0,a.length-1);
        for(int x : a){
            System.out.println(x);
        }
    }
}
