package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class JiJie {
    static void judgeSeason(int month){//有参数无返回值（空）方法
        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println("春天");//345月为春天
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏天");//678为夏天
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋天");//9、10、11月为秋天
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬天");//12、1、2月为冬天
                break;
        }
    }

    public static void main(String[] args) {//主方法
        int month=3;//定义月份
        judgeSeason(month);//调用方法输出
    }
}
