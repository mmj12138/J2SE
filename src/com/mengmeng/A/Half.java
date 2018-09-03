package com.mengmeng.A;

/**
 * Created by Administrator on 2017/12/2.
 */
public class Half {
    public static void main(String[] args) {
        int [] a = {2,3,4,1,5,1,6};
        int key = 4;
        quickSearch(a,0,a.length-1);
        System.out.println(half(a,key));
    }
    static int half(int [] a,int key){
        int low=0;
        int high = a.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(key>a[mid]){
                low=mid;
            }else if(key<a[mid]){
                high=mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
    static void quickSearch(int [] a,int start,int end){
        int i = start;
        int j = end;
        if(i>=j){
            return;
        }
        boolean flag = true;
        while(i<j){
            int temp=0;
            if(a[i]>a[j]){
                temp = a[i];
                a[i]=a[j];
                a[j]=temp;
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
        quickSearch(a,start,i);
        quickSearch(a,j,end);
    }
}
