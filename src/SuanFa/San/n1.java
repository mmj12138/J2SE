package SuanFa;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/15.
 * ��2+22+222+��������������+2222222��n��2��
 * �㷨��ƣ�
 * ����n=1����λһ��2
 *     n=2; ��λ��������ʮλһ����
 *     n=3;3��2,2��2,1��2
 *     �ɴ˿����Ƴ�����λ2��ӵĸ�����n�Ĺ�ϵ��
 *     ���ǵ���λ�Ĺ�ϵ��Ҫ���һ����λ
 *     �������λ������Զ��2���������۽�λ���ٶ�����������ʲ��ؿ������λ�����
 */
public class n1 {
    public static void main(String[] args) {
        int  n = 10;
        int jinWei=0;
        int [] num=new int[n];
        //�����λ����
        for(int i=n;i>0;i--){
            num[i-1]=(jinWei+i*2)%10;
            jinWei=(jinWei+i*2)/10;
        }
        for(int i=0;i<=n-1;i++){
            System.out.print(num[i]+"");
        }
    }

}
