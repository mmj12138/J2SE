package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class QingNianRen {
    static void choose(int age){//����1����ѧ���ֶ�
        if(age>20&&age<=40){
            System.out.println("������");
        }else if(age<=60){
            System.out.println("������");
        }else if(age>60){
            System.out.println("������");
        }
    }
    static void choose2(int age){//��������&&����Χ
        if(age>60){
            System.out.println("������");
        }else if(age>40){
            System.out.println("������");
        }else if(age>20){
            System.out.println("������");
        }
    }

    public static void main(String[] args) {//������
        int age=45;//��������Ϊ45
        choose(age);//���÷���1
        choose2(age);//���÷���2
    }
}
