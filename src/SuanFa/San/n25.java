package SuanFa.San;

/**
 * Created by Administrator on 2017/11/13.
 */
public class n25 {
    public static void main(String[] args) {
        int []num=new int[18];
        for(int i=100;i<=999;i++){
            for(int j=10;j<=99;j++){
                if(i*j>=10000&&i*j<=99999&&j%10*i>=1000&&j%10*i<=9999&&(j-j%10)*i>=10000&&(j-j%10)*i<=99999){
                    for(int k=0;k<3;k++){
                        num[k]=i%(int)Math.pow(10,k+1)/(int)Math.pow(10,k);
                    }
                    for(int k=3;k<5;k++){
                        num[k]=j%(int)Math.pow(10,k-2)/(int)Math.pow(10,k-3);
                    }
                    for(int k=5;k<9;k++){
                        num[k]=j%10*i%(int)Math.pow(10,k-4)/(int)Math.pow(10,k-5);
                    }
                    for(int k=9;k<13;k++){
                        num[k]=(j-j%10)/10*i%(int)Math.pow(10,k-8)/(int)Math.pow(10,k-9);
                    }
                    for(int k=13;k<18;k++){
                        num[k]=j*i%(int)Math.pow(10,k-12)/(int)Math.pow(10,k-13);
                    }
                    boolean flag=true;
                    for(int k:num){
                        if(k==0||k==1||k==4||k==6||k==8||k==9){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.print("三位数"+i+"  两位数是"+j+"  结果1是"+j%10*i+" 结果2是"+(j-j%10)*i/10);
                        System.out.println("  结果是"+i*j);
                    }
                }
            }
        }
    }
}
