package SuanFa.Si;

/**
 * Created by Administrator on 2017/12/9.
 * Ѱ����������������4λ������ ���ظ����� ǧλ���ַ�0
 * ���������ĸ���λ���ֺ͵�ƽ��
 * 4λ���� ǧλ��0 ��ȷ�����ַ�Χ1012--9876
 * �������ĸ���λ���ֱַ�����������ж�
 * �������λ����Ⱥ�
 * �ж����Ƿ���ڸ���λ����֮�͵�ƽ��
 * �����ڣ����
 */
public class n8 {
    public static void main(String[] args) {
        int i,sum,a,b,c,d;
        for(i=1012;i<=9876;i++) {
            a=i%10;//��λ
            b=i/10%10;//ʮλ
            if(a!=b) {
                c=i/100%10;//��λ
                if(a!=c&&b!=c) {
                    d=i/1000%10;//ǧλ
                    if(a!=d&&b!=d&&c!=d) {
                        sum=(a+b+c+d)*(a+b+c+d);
                        if(i%sum==0)
                            System.out.println(i);
                    }
                }
            }
        }
    }
}
