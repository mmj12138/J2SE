package SuanFa;

/**
 * Created by Administrator on 2017/11/25.
 */
public class n7 {
    int ack(int m,int n)
    {
        if(m==0)
            return(n+1);
        else
        if(n==0)
            return(ack(m-1,1));
        else
            return(ack(m-1,ack(m,n-1)));
    }

    public static void main(String[] args) {
        n7 x = new n7();
        int m = 2;
        int n = 3;
        int y=x.ack(m,n);
        System.out.println(y);

    }
}
