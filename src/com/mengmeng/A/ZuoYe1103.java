package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class ZuoYe1103 {
    /*
   2.作业：应用foreach进行累加
    */
    static void sum(int a[]){
        int sum=0;
        for(int x:a){
            sum+=x;
        }
        System.out.println(sum);
    }
    /*
    3.作业：找出一个数组中最大的数，要求 for each 三目。做到最优解。
     */
    static void max(int []a){
        int t = a[0];
        for(int x:a){
            t = x>t?x:t;
        }
        System.out.println(t);
    }
    /*
    4.作业：颠倒数组元素顺序，最优折半写法。
     */
    static void order(int [] a){
        int temp;
        for(int i = 0;i<a.length/2;i++){
            temp=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=temp;
        }
        for(int x : a){
            System.out.print(x+" ");
        }
    }
    /*
    5.作业：针对arraycopy，fill，copyOf进行练习
     */
    static void lianXi(int [] a){

    }
    public static void main(String[] args) {
        int[] a = {3,2,5,4,1,7,6,10,9,8};
        sum(a);
        max(a);
        order(a);
    }
}
