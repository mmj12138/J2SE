package Init;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/9.
 */
public class YinHang2 {
    public static void main(String[] args) {
        double money =23451.12;
        operate(money);
    }
    static void operate(double money){
        char [] b = {'��','Ҽ','��','��','��','��','½','��','��','��'};
        int temp = (int)money;
        zhengShu(temp,b);
        double xiaoShu1 = money-temp;
        int m = (int)(xiaoShu1*100);
        if(m!=0){
            xiaoShu(temp,m,b);
        }else{
            System.out.println("��");
        }

    }
    static void xiaoShu(int zhengShu,int k,char [] b){
        int y = k%10;
        int e = (k/10)%10;
        if(zhengShu!=0||e!=0){
            System.out.print(b[e]);
            if(e!=0){
                System.out.print("��");
            }
        }
        if(y!=0){
            System.out.print(b[y]);
            System.out.print("��");
        }
    }
    static void zhengShu(int shu,char [] b){
        int [] a = new int[9];
        int x = 1;
        for(int i=0;i<a.length;i++){
            a[i]=(shu/x)%10;
            x*=10;
        }
        if(a[8]!=0){
            System.out.println( b[a[7]]);
            System.out.print("��");
        }
        if(a[8]!=0&&a[7]==0&&a[6]!=0){
            System.out.print("��");
        }
        if(a[7]!=0&&a[6]==0){
            System.out.print( b[a[7]]);
            System.out.print("Ǫ��");
        }
        if(a[7]!=0&&a[6]!=0){
            System.out.print( b[a[7]]);
            System.out.print("Ǫ");
        }
        if((a[8]!=0||a[7]!=0)&&a[6]==0&&a[5]!=0){
            System.out.print("��");
        }
        if(a[6]!=0&&a[5]==0){
            System.out.print( b[a[6]]);
            System.out.print("����");
        }
        if(a[6]!=0&&a[5]!=0){
            System.out.print( b[a[6]]);
            System.out.print("��");
        }
        if((a[8]!=0||a[7]!=0||a[6]!=0)&&a[5]==0&&a[4]!=0){
            System.out.print("��");
        }
        if(a[5]!=0&&a[4]==0){
            System.out.print( b[a[5]]);
            System.out.print("ʮ��");
        }
        if(a[5]!=0&&a[4]!=0){
            System.out.print( b[a[5]]);
            System.out.print("ʮ");
        }
        if((a[7]!=0||a[6]!=0||a[5]!=0)&&a[4]==0&&a[3]!=0){
            System.out.print("��");
        }
        if(a[4]!=0){
            System.out.print( b[a[4]]);
            System.out.print("��");
        }
        if((a[8]!=0||a[7]!=0||a[6]!=0||a[5]!=0||a[4]!=0)&&a[3]==0&&a[2]!=0){
            System.out.print("��");
        }
        if(a[3]!=0){
            System.out.print( b[a[3]]);
            System.out.print("Ǫ");
        }

        if((a[8]!=0||a[7]!=0||a[6]!=0||a[5]!=0||a[4]!=0||a[3]!=0)&&a[2]==0&&a[1]!=0){
            System.out.print("��");
        }
        if(a[2]!=0){
            System.out.print( b[a[2]]);
            System.out.print("��");
        }
        if((a[8]!=0||a[7]!=0||a[6]!=0||a[5]!=0||a[4]!=0||a[3]!=0||a[2]!=0)&&a[1]==0&&a[0]!=0){
            System.out.print("��");
        }
        if(a[1]!=0){
            System.out.print( b[a[1]]);
            System.out.print("ʰ");
        }
        if(a[0]!=0){
            System.out.print( b[a[0]]);
        }
        if(a[8]!=0||a[7]!=0||a[6]!=0||a[5]!=0||a[4]!=0||a[3]!=0||a[2]!=0||a[1]!=0||a[0]!=0){
            System.out.print("Ԫ");
        }
    }
}
