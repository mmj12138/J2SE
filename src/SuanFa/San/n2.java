package SuanFa;

/**
 * Created by Administrator on 2017/11/15.
 * ����һά��������ӡ��һ������
 * ����һ��һά���飬�������һά�����ǳ���ѭ���ģ�
 * ��ô���ѿ���ÿһ�е������ǰһλ������������߳����鳤�ȵľ���
 * �ɴ˿�������˫��forѭ������һ������λ��ʼ��λ�ã�����--��ʹ��ʼλ����ǰ��λ
 * Ȼ��������Ƕ��һ��forѭ������֤ÿһ������ߣ�����Ϊ���鳤��
 * ÿһ�������Ҫ����
 */
public class n2 {
    public static void main(String[] args) {
        int [] a={5,7,4,8,9,1};
        for(int i = 6;i>0;i--){
            for(int j=i;j<i+6;j++){
                System.out.print(a[j%6]+" ");
            }
            System.out.println();
        }
    }
}
