package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class FangFa {
    static void getArea(){//�޲��޷���ֵ
        int length = 20;
        int width = 30;
        int area = length * width;
        System.out.println(area);
    }
    static void getArea(int length,int width){//�в����޷���ֵ
        int area = length * width;
        System.out.println(area);
    }
    static int getArea1(){//�޲����з���ֵ
        int length = 20;
        int width = 40;
        int area = length * width;
        return area;
    }

    public static void main(String[] args) {
        int length = 10;
        int width = 20;
        getArea();
        getArea(length,width);
        int area1 = getArea1();
        System.out.println(area1);
    }
}
