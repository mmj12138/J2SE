package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class RunNian {
    /**
     * дһ������ͨ����Ŀ������ж����ǲ�������
     * �����������ܱ�4�������Ҳ��ܱ�һ������
     * ��
     * �ܱ�400����
     */
    static void choose(int year){//�в����޷���ֵ���գ�����
        if((year%4==0&&year%100!=0)||year%400==0){//����������Ϊ����
            System.out.println(year+"������");//���
        }else{//����Ϊƽ��
            System.out.println(year+"��ƽ��");//���
        }
    }
    public static void main(String[] args) {
        int year = 2008;//����һ�����
        //���������ܱ�4�����Ҳ��ܱ�100���������ܱ�400��������������꣬�������ƽ��
        System.out.println( (year%4==0&&year%100!=0)||year%400==0?"����":"ƽ��");
        choose(year);
    }
}
