package SuanFa.San;


import java.util.Scanner;
/*
������
������ҹ��ɣ�Ҫ����������⣬һ��������Ƕ�ף�һ�����Ƿ�ȥ���š�

�Ƿ�ȥ���ţ�������ȼ�1Ϊ�Ӽ���2λ�˳��Ӽ���������Ϊ1��1ȥ���ţ�������Ϊ1��2��ȥ���ţ�
������Ϊ2��1ȥ���ţ�������Ϊ2��2ȥ���š���ע�⣬������ڵķ��Ų�����Ƕ����������ķ��ţ�

����Ƕ�ף�����ѭ���жϵ��±ꡣ
 */
public class n6n2 {

    private static final char REC = 10; ////�����������Ҫɾ���ͱ��ΪREC
    private static char[] a;
    private static int len;

    public static void main(String[] args) {
        int i;
        Scanner scanner = new Scanner(System.in);
        a = scanner.next().toCharArray();
        len = a.length;
        fun(0);
        for(i = 0; i < len; i ++){
            if(a[i] != REC){
                System.out.printf("%c", a[i]);
            }
        }
    }

    public static int judge (int k) {
        int outGrade = 0;   //����������ķ��ţ� 0 ˵������û���ţ� ����ȼ�1����ֻ�ǼӼ�������ȼ�2����������һ���˳�
        int inGrade = 0;    //���������ڲ��ķ��� ����������Ƕ������ķ��ţ� �� ����ȼ�1ֻ�мӼ�������ȼ�2������һ���˳�
        int num = 1;    //���iѭ�����ڼ���Ƕ�׵�����  һ��ʼֻ��һ��
        int i;
        int re = 0; //�������� �����û��Ƕ���ŷ����������±꣬�������Ƕ���ŷ�����Ƕ���ŵ�������-1����Ϊ�������ص�fun������for�����������������±꣩
        int judge = 0;  //��Ǽ�¼����ߵ���Ƕ������Ϊ����

        for(i = k+1; i < len && num > 0; i ++){   //�˳�����������ȫ�˳�����
            if(a[i] == '('){    //Ƕ��һ������
                num ++;
                if(judge == 0){
                    re = i-1;
                    judge = 1;
                }
            }

            if(num == 1){   //��Ҫ�����һ�������ڵķ�������ȼ�
                if(inGrade == 0){
                    if(a[i] == '+' || a[i] == '-'){
                        inGrade = 1;
                    } else if(a[i] == '*' || a[i] == '/') {
                        inGrade = 2;
                    }
                }
                if(inGrade == 1){
                    if(a[i] == '*' || a[i] == '/'){
                        inGrade = 2;
                    }
                }
            }
            if(a[i] == ')'){//�˳�һ������
                num --;
            }
        }
        i --;   //for�˻�ָ�������ŵ��±�
    /*

    k Ϊ�������±�
    i Ϊ�������±�

    */

        outGrade = 0;
        if(k-1 > -1){    //����з���
            if(a[k-1] == '+' || a[k-1] == '-'){
                outGrade = 1;
            } else{
                outGrade = 2;
            }
        }
        if(outGrade == 0 || outGrade == 1){ //����׼��Ƿ���Ҫ���
            if(i+1 < len){   //�ұ��з���
                if(a[i+1] == '+' || a[i+1] == '-'){
                    outGrade = 1;
                } else {
                    outGrade = 2;
                }
            }
        }

        //  printf("%d\n%d %d\n", i, inGrade, outGrade);
        if(inGrade == 0){   //�ڲ�û���ű��� 2+5+����-2�����
            a[k] = REC;
            a[i] = REC;
        } else if(inGrade == 1){
            if(outGrade == 1){  //��Ϊ1���Ӽ�������Ϊ1 ���Ӽ���ȥ����
                a[k] = REC;
                a[i] = REC;
                return i+1;
            } else {    //��Ϊ1���Ӽ�������Ϊ2 ���Ӽ�����ȥ����
            }
        } else if(inGrade == 2){    //��Ϊ2���Ӽ�������Ϊ2��1 ���Ӽ���ȥ����
            a[k] = REC;
            a[i] = REC;
        }
        if(re == 0) {
            re = i;
        }
        return re;
    }

    public static void fun (int k) {
        for(int i = 0; i < len; i ++){
            if(a[i] != '('){

            } else {    //���������ŵ����±�
                i = judge(i);   //�����±괦��Ƕ������
            }
        }
    }
}
