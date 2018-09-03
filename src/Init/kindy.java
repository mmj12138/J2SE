package Init;

/**
 * Created by mengmengjiang on 2017/11/4.
 */
public class kindy {
    static void kindy(){
        int [] a = new int[17];
        for(int i = 0;i<a.length;i++){
            a[i]=1;//记录状态，没出去的为1，出去的为0
        }
        int k = 0;//记录当前人的序号
        int p = 0;//记录出去了多少人
        int x=0;//叫的序号
        while (p <16) {//剩最后一个人的时候退出循环
            x+=a[k];//没退出加1，退出加0
            if (a[k]==1 &&x % 3 == 0) {//如果没退出且是三的倍数
                a[k] = 0;
                p += 1;
            }
            k += 1;
            k%=17;
        }
        for(int i = 0;i<a.length;i++){
            if(a[i]==1){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        kindy();
    }
}
