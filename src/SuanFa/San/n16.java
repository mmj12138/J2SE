package SuanFa;

/**
 * Created by Administrator on 2017/11/29.
 */
public class n16 {
    public static void main(String[] args) {
        int n=28;
        int sum=0;
        if(n%4==0){
            sum+=1;
        }
        if(n%7==0){
            sum+=2;
        }
        if(n%9==0){
            sum+=4;
        }
        if(sum==1){
            System.out.println("�ܱ�4������");
        }else if(sum==2){
            System.out.println("�ܱ�7������");
        }else if(sum==4){
            System.out.println("�ܱ�9������");
        }else if(sum==3){
            System.out.println("�ܱ�4��7������");
        }else if(sum==5){
            System.out.println("�ܱ�4��9������");
        }else if(sum==6){
            System.out.println("�ܱ�7��9������");
        }else if(sum==7){
            System.out.println("��ͬʱ��4,7,9������");
        }else if(sum==0){
            System.out.println("���ܱ�4,7,9��һ������");
        }
    }
}
