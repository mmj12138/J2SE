package SuanFa;

/**
 * Created by Administrator on 2017/11/20.
 * ��ӡn*n����������
 */
public class n4 {
    public static void main(String[] args) {
        int n =5;
        int [][] a = new int [n][n];
        a[0][0]=1;//��һ������һ����1
        for(int i=1;i<n;i++){
            a[i][0]=a[i-1][0]+i;//ÿһ�еĵ�һ����������һ�м��к�
            for(int j=1;j<n-i+1;j++){
                a[i-1][j]=a[i-1][j-1]+j+i;//������ƶ��ҹ���
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

