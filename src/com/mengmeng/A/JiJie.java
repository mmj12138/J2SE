package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class JiJie {
    static void judgeSeason(int month){//�в����޷���ֵ���գ�����
        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println("����");//345��Ϊ����
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("����");//678Ϊ����
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("����");//9��10��11��Ϊ����
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("����");//12��1��2��Ϊ����
                break;
        }
    }

    public static void main(String[] args) {//������
        int month=3;//�����·�
        judgeSeason(month);//���÷������
    }
}
