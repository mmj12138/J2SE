package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class GetArea {
    public static float PI = 3.14f;
    static void getArea(){
        int r=10;
        float s=PI*r*r;
        System.out.println(s);
    }
    static void getArea(int r){
        float s=PI*r*r;
        System.out.println(s);
    }
    static float getArea2(){
        int r=5;
        float s=PI*r*r;
        return s;
    }

    public static void main(String[] args) {
        getArea();
        getArea(20);
        float s1 = getArea2();
        System.out.println(s1);
    }
}
