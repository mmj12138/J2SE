package SuanFa.Si;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/9.
 * ��n�������ų�һȦ������Ҫ�����ҳ�����������
 * ����һ������n,����һ������Ϊn������
 * ����������������ʼ������������
 * ����ѭ��ȷ����ʼ�ͽ�������ȡģ������ѭ�����������������
 * ÿһ����ʼ���Ӻͣ��������ֵ��������ֵ�Լ���ʼ�����ֹ�㣬���������������
 * �����max�������ֵ������ʼ��������鵽��ֹ�㣬��������Ӵ�
 */
public class n20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int start = 0;
        int end = 0;
        int max=a[0];
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j=i;j<i+n;j++){
                int m = j%n;
                sum+=a[m];
                if(sum>max){
                    start=i;
                    end=m;
                    max=sum;
                }
            }
        }
        System.out.println("��������Ϊ��");
        for(int i = start;i<=end;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("�������ĺ�Ϊ��");
        System.out.println(max);

    }
}
