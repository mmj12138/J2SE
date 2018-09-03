/**
 * Created by mengmengjiang on 2017/11/1.
 */
public class yangHui2 {
    static void yangHui2(){
        int arr[][]=new int[100][100];
        arr[0][0]=1;
        for(int i = 1;i<=14;i++){
            for(int k = 1;k<=42-3*i;k++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                System.out.printf("%6d",arr[i][j]);
            }
            System.out.println();
        }
        for(int i=13;i>=1;i--){
            for(int k = 1;k<=42-3*i;k++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.printf("%6d",arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        yangHui2();
    }
}
