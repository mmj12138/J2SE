package SuanFa;

/**
 * Created by Administrator on 2017/11/29.
 */
public class n14 {
    public static void main(String[] args) {
        for(int i =10;i<=31;i++){
            int n = i*i;
            int [] a = new int[3];
            a[0]=n%10;
            a[1]=(n/10)%10;
            a[2]=(n/100)%10;
            if(a[0]==a[1]){
                if(a[0]!=a[2]&&a[1]!=a[2]){
                    System.out.println(n);
                }
            }else{
                if((a[0]==a[2]&&a[1]!=a[2])||(a[1]==a[2]&&a[0]!=a[2])){
                    System.out.println(n);
                }
            }
        }
    }
}
