package SuanFa;

/**
 * Created by Administrator on 2017/11/13.
 */
public class n24 {
    public static void main(String[] args) {
        int []num=new int[8];
        for(int i=1;i<=9;i++){
            for(int j=100;j<=999;j++){
                if(i*j>=1000&&i*j<=9999){
                    for(int k=0;k<3;k++){
                        num[k]=j%(int)Math.pow(10,k+1)/(int)Math.pow(10,k);
                    }
                    for(int k=3;k<7;k++){
                        num[k]=j*i%(int)Math.pow(10,k-2)/(int)Math.pow(10,k-3);
                    }
                    num[7]=i;
                    boolean flag=true;
                    for(int k:num){
                        if(k==0||k==1||k==4||k==6||k==8||k==9){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.println("三位数"+j+"  一位数是"+i+"  结果是"+i*j);
                    }
                }
            }
        }
    }
}
