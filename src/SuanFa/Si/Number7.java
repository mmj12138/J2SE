package SuanFa.Si;

/**
 * Created by Administrator on 2017/12/17.
 * 上一个算法由于是一次判断，所以要一个数字一个数字的走，
 * 七个七个的数能够整除，所以就变成了七个七个的走，那我就在想能不能让他买的步子更大一点
 * 于是 想到了这个算法
 * 这个算法的前提应该是要考虑到倍数
 * 一开始依旧是七个七个的走，当碰到一个数能够%6==5时这时每次加六就能一直满足这个条件
 * 但还要满足%7==0，所以每一次就要加6*7==42，这样就大大减少了循环次数
 * %5==4这个条件也是一样的，一旦满足便每次加（5*6*7==210）
 * 但由于最后的2和3时6的约数，所以就不能在跨越了，直接判断
 * 满足就输出 break
 *
 */
public class Number7 {
    public static void main(String[] args) {
        for(int i =1;;i++){
            int m = i * 7;
            if(m%6==5){
                for(int j = m;;j+=42){
                    if(j%5==4){
                        for(int k = j;;k+=210){
                            if(k%3==2&&k%2==1){
                                System.out.println(k);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}

