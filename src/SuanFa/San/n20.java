package SuanFa;

/**
 * Created by Administrator on 2017/11/13.
 */
public class n20 {
    public static void main(String[] args) {
        int []num=new int[9];
        for(int i=10;i<=99;i++){//��λ��
            for(int j=100;j<=999;j++){//��λ��
                if(i*j>=1000&&i*j<=9999){
                    for(int k=0;k<2;k++){
                        num[k]=i%(int)Math.pow(10,k+1)/(int)Math.pow(10,k);
                    }
                    for(int k=2;k<5;k++){
                        num[k]=j%(int)Math.pow(10,k-1)/(int)Math.pow(10,k-2);
                    }
                    for(int k=5;k<9;k++){
                        num[k]=i*j%(int)Math.pow(10,k-4)/(int)Math.pow(10,k-5);
                    }
                    int []flag= new int[10];
                    int count=0;
                    for(int k:num){
                        flag[k]++;
                        if(flag[k]>1||k==0){
                            break;
                        }else {
                            count++;
                        }
                    }
                    if(count==9){
                        System.out.println("i��"+i+"  j��"+j+"  �����"+i*j);

                    }


                }
            }
        }


    }
}
