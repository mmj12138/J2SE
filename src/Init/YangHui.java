import org.junit.Test;

/**
 * Created by mengmengjiang on 2017/10/30.
 */
public class YangHui {
    static void yangHui(){
        int [][] arr1 = new int[100][100];
        //int [][] arr2 = new int[100][100];
        arr1[0][0]=1;
        for(int i = 1;i<=14;i++){
            for(int k = 0;k<14-i;k++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                arr1[i][j]=arr1[i-1][j-1]+arr1[i-1][j];
                //arr1[i][j]=arr2[i][j];
                System.out.printf(arr1[i][j]+"  ");
            }
            System.out.println();
        }

        for (int i = 13; i > 0; i-- ) {
            for(int k = 0;k<14-i;k++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print(arr1[i][j]+"  ");
            }
            System.out.println();
        }

    }



    public static void main(String[] args) {
        yangHui();
    }


}
