package SuanFa;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/10.
 */
public class n6 {
    public static void main(String[] args) {
        while(true){
            N6();
        }

    }
    static void N6(){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char []a=s.toCharArray();
        int []flagPrint=new int[a.length];//����������ַ���״̬��Ϊ1
        int count=0;//�����м�������
        int m=0;//������
        int n=0;//������

//        ��ǳ�����
        for(char i:a){
            System.out.print(i);
        }
        System.out.println();

        for(char i:a){
            if(i=='('){
                count++;//
            }
        }
//        System.out.println(count);
        for(int i=0;i<count;i++){//ÿ�����ŵ�ѭ��
            for(int j=i;j<a.length;j++){//���ҵ���һ���Ҳ������
                if(a[j]==')'&&flagPrint[j]==0){
                    n=j;
                    flagPrint[j]++;//��������ŵı�־λ��0��Ϊ1���´ξͲ����ҵ����������
                    break;//�ҵ��˾Ͳ��ټ�����
                }
            }
            for(int j=n;j>=0;j--){//���ҵ�������Ҳ������������ڵĵ�һ����������
                if(a[j]=='('&&flagPrint[j]==0){
                    m=j;
                    flagPrint[j]++;
                    break;
                }
            }
            System.out.println();
            System.out.println("m===="+m);
            System.out.println("n==="+n);
            int count1=0;//��������Ӽ��ŵ�����
            for(int j=m+1;j<n;j++){
                if (a[j]=='+'||a[j]=='-'){
                    count1++;
                }
            }

            if((m!=0&&n==a.length-1&&a[m-1]=='/')||(m==0&&n!=a.length-1&&a[n+1]=='/')||(m!=0&&n!=a.length-1&&(a[m-1]=='/'||a[n+1]=='/'))){
//                System.out.println("����ȥ��");
                continue;
            }
            if(count1==0&&(m!=0&&n==a.length-1&&a[m-1]=='-')||(m==0&&n!=a.length-1&&a[n+1]=='-')||(m!=0&&n!=a.length-1&&(a[m-1]=='-'||a[n+1]=='-'))){
                flagPrint[m]++;//����ȥ�� �ͽ������־λ��1
                flagPrint[n]++;
                continue;
            }
            if(((m!=0&&n==a.length-1&&a[m-1]=='*')||(m==0&&n!=a.length-1&&a[n+1]=='*')||(m!=0&&n!=a.length-1&&(a[m-1]=='*'||a[n+1]=='*')))){
                continue;
            }
            if(count1!=0&&(m!=0&&n==a.length-1&&a[m-1]=='-')||(m==0&&n!=a.length-1&&a[n+1]=='-')||(m!=0&&n!=a.length-1&&(a[m-1]=='-'||a[n+1]=='-'))){
                continue;
            }

            //||a[m-1]=='/'||a[n+1]=='/'
            if(m!=0&&n!=a.length-1&&(a[m-1]=='*'||a[n+1]=='*')){//�������Ŷ��ڱ���,��������һ�������Ա���* ��/
//                System.out.println("����ȥ����ǰ��������");
                continue;
            }else if(m!=0&&n==a.length-1&& (a[m-1]=='*' )) {//n�ٱ��� m�����жϳ˳���
//                System.out.println("���� ��಻����");
                continue;
            }else if(m==0&&n!=a.length-1&&(a[n+1]=='*')){//m�ٱ��ϣ�n���� �жϳ˳���
//                System.out.println("���� �Ҳ಻����ȥ��������");
                continue;
            }else{
//                System.out.println("����ȥ��");
                flagPrint[m]++;//����ȥ�� �ͽ������־λ��1
                flagPrint[n]++;
            }


        }
        for(int i=0;i<a.length;i++){//���
            if(flagPrint[i]==2)
                continue;
            System.out.print(a[i]);
        }
        System.out.println();
    }
}


