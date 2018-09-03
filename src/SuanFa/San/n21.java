package SuanFa;

/**
 * Created by Administrator on 2017/11/13.
 */
public class n21 {
    public static void main(String[] args) {
        int []num=new int[9];
        int  pow;
        for(int i=100;i<=999;i++){
            pow=i*i;
            if(pow>=100000&&pow<=999999){
                for(int j=0;j<6;j++){
                    num[j]=pow%(int)Math.pow(10,j+1)/(int)Math.pow(10,j);
                }
                for(int j=6;j<9;j++){
                    num[j]=i%(int)Math.pow(10,j-5)/(int)Math.pow(10,j-6);
                }
                int []flag= new int[10];
                int count=0;
                for(int j:num){
                    flag[j]++;
                    if(flag[j]>1){
                        break;
                    }else {
                        count++;
                    }
                }
                if(count==9){
                    System.out.println(i+" "+pow);
                }
            }
        }
    }
}
