package SuanFa.Si;

/**
 * Created by Administrator on 2017/12/9.
 * 一堆棋子 2个2个的数剩一个（%2==1）
 *          3个3个的数剩2个（%3==2）
 *          5个5个的数剩4个（%5==4）
 *          6个6个的数剩5个（%6==5）
 *7个7个的数正好数完 那么就按着7的倍数走，每一次都进行一次判断
 * 满足条件就输出且退出循环 否则就继续往下走
 */
public class n7 {
    public static void main(String[] args) {
        for(int i = 1;;i++){
            int m = i*7;
            if(m%2==1&&m%3==2&&m%5==4&&m%6==5){
                System.out.println(m);
                return;
            }
        }
    }
}
