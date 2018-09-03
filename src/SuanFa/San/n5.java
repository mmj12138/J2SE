package SuanFa;

/**
 * Created by Administrator on 2017/11/25.
 * ´òÓ¡ÂİĞı¾ØÕó
 */
public class n5 {
    public static void main(String[] args) {
        int n = 5;
        int a[][]=new int[n][n];
        int i=0,j=0,m=0;
        if(n%2==0)
            m=n/2;
        else
            m=n/2+1;
        for(i=0;i<=m-1;i++){
            for(j=i;j<=n-i-1;j++){
                a[i][j]=i+1;
            }
            for(j=i+1;j<=n-i-1;j++) {
                a[j][n-i-1]=i+1;
            }
            for(j=n-i-2;j>=i;j--){
                a[n-i-1][j]=i+1;
            }
            for(j=n-i-2;j>=i+1;j--){
                a[j][i]=i+1;
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(String.format("%3d",a[i][j]));
            }
            System.out.println();
        }
    }
}

