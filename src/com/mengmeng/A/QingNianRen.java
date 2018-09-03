package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class QingNianRen {
    static void choose(int age){//方法1，数学法分段
        if(age>20&&age<=40){
            System.out.println("青年人");
        }else if(age<=60){
            System.out.println("中年人");
        }else if(age>60){
            System.out.println("老年人");
        }
    }
    static void choose2(int age){//方法二，&&出范围
        if(age>60){
            System.out.println("老年人");
        }else if(age>40){
            System.out.println("中年人");
        }else if(age>20){
            System.out.println("青年人");
        }
    }

    public static void main(String[] args) {//主方法
        int age=45;//定义年龄为45
        choose(age);//调用方法1
        choose2(age);//调用方法2
    }
}
