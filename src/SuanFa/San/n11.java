package SuanFa;

/**
 * Created by Administrator on 2017/11/27.
 */
import java.util.Scanner;
public class n11{
    public static void main(String[] args) {
        System.out.println("������һ����Ȼ��:");
        int n = new Scanner(System.in).nextInt();
        long fact = 1;
        for(int i = 1; i<=n; i++){
            fact*=i;
        }
        //ͳ�ƽ���е�0�ĸ���
        String result = fact+"";
        int count0 = 0;
        for(int i = 0; i<result.length(); i++){
            if(result.charAt(i) == '0'){
                count0++;
            }
        }
        System.out.println(n + "�Ľ׳���" + fact + ",�������" + count0 + "��0");
    }
}