package SuanFa.Si;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/9.
 * 54���� �������������ƣ�ÿ��ÿ��������1�ţ������4��
 * ˭�õ����һ����˭������
 * ģ���������ұ�ʤ���㷨
 * ����1���4  1+4==5  54%5==4
 * �����ͺð���
 * ������3�� Ȼ��ÿһ�ζ���5-i�� ����һ��ʣ��1��
 * ���õ��Է����� ���һ��
 * �Լ���Ӯ��
 */
public class n3 {
    public static void main(String[] args) {
        int n = 54;//54����
        System.out.println("������3��");
        n=n-3;
        System.out.println("���ڻ�ʣ"+n+"��");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int a = sc.nextInt();
            if (a < 1 || a > 4) {
                System.out.println("�㷸���ˣ�");
            } else {
                System.out.println("����" + (5 - a) + "��");
                n=n-5;
                System.out.println("���ڻ�ʣ" +n+"��");
                if(n==1){
                    System.out.println("�����ˣ�����");
                    return;
                }
            }
        }
    }
}
