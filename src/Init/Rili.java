package com.date20171124;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by xxoo on 2017/11/27.
 */
public class Rili {
    /*
    打印某一年中某一月的日历
     */
    public static void main(String[] args) throws ParseException {
        int year=2012;
        int month=3;
        int day1=27;   //当前日期
        String ss=year+"/"+month+"/"+1;
        int [] m={1,3,5,7,8,10,12,   4,6,9,11};   //表示月份  下标小于7时的数字代表的月份天数为31  其余为30天
        //        0,1,2,3,4, 5, 6,   7,8,9,10
        int day=0;   //表示当前年份中要判断的月份的天数
         // 判断闰年
            if(month==2){
                if((year%4==0&&year%100!=0 )||( year%400==0)){
                    day=29;
            }
            else{
                    day=28;
                }
        }
        for(int i=0;i<m.length;i++){
                if(month==m[i]){
                    day=(i<7)?31:30;  //对月份中的天数进行判断并赋值
                }
            }
            System.out.println(year+"年"+month+"月的日历如下：");
        System.out.println("星期日 星期一 星期二 星期三 星期四 星期五 星期六");
        Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        SimpleDateFormat s=new SimpleDateFormat("yyyy/MM/dd");
        c.setTime(s.parse(ss));   //将要判断的某天所在月的1号设为当前日期
        int cc=c.get(Calendar.DAY_OF_WEEK);
        if(cc!=1){   //为了使形式美观，打印的空格

            for(int j=0;j<7*(cc-1);j++){
               System.out.print(" ");
            }
        }
        for(int i=1;i<=day;i++){
            int count=c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DAY_OF_MONTH,1);
            if(i==day1){
                System.out.printf("  %2d*  ",i);   //如果日期是今天  在日期后标注*
            }else{
                System.out.printf("  %2d   ",i);
            }
            if(count==7){    //每次到星期六时要换行
                System.out.println();
            }
        }
    }
}
