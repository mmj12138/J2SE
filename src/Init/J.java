/**
 * Created by mengmengjiang on 2017/10/28.
 * 作业[0-100] 用switch写出 1-5的等级
 */
public class J {
    static void getLevel(int level){//有参数无返回值（空）方法
        switch(level){//运用switch函数输出对应级别
            case 0:
                System.out.println("1级");
                break;
            case 1:
                System.out.println("2级");
                break;
            case 2:
                System.out.println("3级");
                break;
            case 3:
                System.out.println("4级");
                break;
            default:
                System.out.println("5级");
        }
    }

    public static void main(String[] args) {
        int score = 12;//定义分数
        int level = score/20;//运用除法截断分出等级
        getLevel(level);//调用方法输出
    }
}
