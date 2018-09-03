package Init;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/9.
 */
public class YinHang {
    public static void main(String[] args) {
        double money =10.1;
        operate(money);
    }
    static void operate(double money){
        int temp = (int)money;
        zhengShu(temp);
        double xiaoShu1 = money-temp;
        BigDecimal k = new BigDecimal(xiaoShu1);
        double xiaoShu2 = k.setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        //System.out.println(xiaoShu2);
        int m = (int)(xiaoShu2*100);
        if(m!=0){
            xiaoShu(m,temp);
        }else{
            System.out.println("Õû");
        }

    }
    static void zhengShu(int temp){
        int g = temp%10;
        int s = (temp/10)%10;
        int b = (temp/100)%10;
        int q = (temp/1000)%10;
        int w = (temp/10000)%10;
        int sw = (temp/100000)%10;
        int bw = (temp/1000000)%10;
        int qw = (temp/10000000)%10;

        if(qw!=0&&bw==0){
            exchange(qw);
            System.out.print("ÇªÍò");
        }
        if(qw!=0&&bw!=0){
            exchange(qw);
            System.out.print("Çª");
        }
        if(qw!=0&&bw==0&&sw!=0){
            System.out.print("Áã");
        }
        if(bw!=0&&sw==0){
            exchange(bw);
            System.out.print("°ÙÍò");
        }
        if(bw!=0&&sw!=0){
            exchange(bw);
            System.out.print("°Ù");
        }
        if((qw!=0||bw!=0)&&sw==0&&w!=0){
            System.out.print("Áã");
        }
        if(sw!=0&&w==0){
            exchange(sw);
            System.out.print("Ê®Íò");
        }
        if(sw!=0&&w!=0){
            exchange(sw);
            System.out.print("Ê®");
        }
        if((qw!=0||bw!=0||sw!=0)&&w==0&&q!=0){
            System.out.print("Áã");
        }
        if(w!=0){
            exchange(w);
            System.out.print("Íò");
        }
        if((qw!=0||bw!=0||sw!=0||w!=0)&&q==0&&b!=0){
            System.out.print("Áã");
        }
        if(q!=0){
            exchange(q);
            System.out.print("Çª");
        }

        if((qw!=0||bw!=0||sw!=0||w!=0||q!=0)&&b==0&&s!=0){
            System.out.print("Áã");
        }
        if(b!=0){
            exchange(b);
            System.out.print("°Û");
        }
        if((qw!=0||bw!=0||sw!=0||w!=0||q!=0||b!=0)&&s==0&&g!=0){
            System.out.print("Áã");
        }
        if(s!=0){
            exchange(s);
            System.out.print("Ê°");
        }
        if(g!=0){
            exchange(g);
        }
        if(qw!=0||bw!=0||sw!=0||w!=0||q!=0||b!=0||s!=0||g!=0){
            System.out.print("Ôª");
        }

    }
    static void xiaoShu(int k,int temp){
        int y = k%10;
        int e = (k/10)%10;
        if(temp!=0||e!=0){
            exchange(e);
            if(e!=0){
                System.out.print("½Ç");
            }
        }

        if(y!=0){
            exchange(y);
            System.out.print("·Ö");
        }
    }
    static void exchange(int x){
        switch(x){
            case 0:
                System.out.print("Áã");
                break;
            case 1:
                System.out.print("Ò¼");
                break;
            case 2:
                System.out.print("·¡");
                break;
            case 3:
                System.out.print("Èþ");
                break;
            case 4:
                System.out.print("ËÁ");
                break;
            case 5:
                System.out.print("Îé");
                break;
            case 6:
                System.out.print("Â½");
                break;
            case 7:
                System.out.print("Æâ");
                break;
            case 8:
                System.out.print("°Æ");
                break;
            case 9:
                System.out.print("¾Á");
                break;
        }
    }
}
