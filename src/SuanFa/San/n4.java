package SuanFa;

/**
 * Created by Administrator on 2017/11/20.
 * 打印n*n的上三角阵
 */
public class n4 {
    public static void main(String[] args) {
        int n =5;
        int [][] a = new int [n][n];
        a[0][0]=1;//第一个数字一定是1
        for(int i=1;i<n;i++){
            a[i][0]=a[i-1][0]+i;//每一行的第一个数字是上一行加行号
            for(int j=1;j<n-i+1;j++){
                a[i-1][j]=a[i-1][j-1]+j+i;//再向后移动找规律
            }
        }
        for(int x[]:a){
            for(int y:x){
                if(y!=0) {
                    System.out.printf("%4d",y);
                }
            }
            System.out.println();
        }
    }
}

