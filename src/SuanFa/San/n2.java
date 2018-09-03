package SuanFa;

/**
 * Created by Administrator on 2017/11/15.
 * 给出一维数组来打印出一个方阵
 * 定义一个一维数组，假设这个一维数组是持续循环的，
 * 那么不难看出每一列的起点向前一位，再依次向后走出数组长度的距离
 * 由此可以利用双层for循环，第一层来定位开始的位置，利用--来使起始位置向前移位
 * 然后里面再嵌套一个for循环来保证每一行向后走，长度为数组长度
 * 每一行走完后要换行
 */
public class n2 {
    public static void main(String[] args) {
        int [] a={5,7,4,8,9,1};
        for(int i = 6;i>0;i--){
            for(int j=i;j<i+6;j++){
                System.out.print(a[j%6]+" ");
            }
            System.out.println();
        }
    }
}
