package SuanFa.Wu;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/10.
 * ͬ��һ���㷨����ʼ�ķ�Χ������1��n/2,������һ�β��ؿ��ƽ�β
 * ��һ�ε�˼���Ǵ�i(1-n/2)��ʼ�����ӣ���Ӻ������Ϊsum
 * ��sumС��nʱ�������¼ӣ����������ô������ҽ�����һ��ѭ��
 * �����ֱ�Ӿʹ�����ֱ���˳�������һ��ѭ����
 * ˵���ˣ�����С��nʱ����β���ӣ����ڵ���nʱ����ͷ���ӣ����е���nʱ���
 * ֱ��i>n/2ʱ�������������˳�����
 */
public class Number12 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =1;i<=n/2;i++){
            int sum=0;
            int j =i-1;
            while(true){
                sum+=++j;
                if(sum>n){
                    break;
                }else if(sum==n){
                    System.out.print(i);
                    for(int k =i+1;k<=j;k++){
                        System.out.print("+"+k);
                    }
                    System.out.println("="+sum);
                    break;
                }
            }
        }
    }
}
