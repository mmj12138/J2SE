package com.mengmeng.A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/11/28.
 */
public class RiLi {
    public static void main(String[] args) throws ParseException {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        int year = 2017;
        int month = 10;
        int day =3;
        System.out.println(year+"年"+month+"月的日历如下：");
        System.out.println("星期日  星期一  星期二  星期三  星期四  星期五  星期六");
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
        String str = year+"-"+month+"-"+1;
        c.setTime(a.parse(str));
        int index=1;
        int d = c.get(Calendar.DAY_OF_WEEK);
            for (int i = 0; i < d-1; i++) {
                System.out.print("        ");
                index++;
            }
        int count;
        int [] e={31,29,31,30,31,30,31,31,30,31,30,31};
        int [] b={31,28,31,30,31,30,31,31,30,31,30,31};
        if((year%4==0&&year%100!=0)||year%400==0){
            count = e[month-1];
        }else{
            count = b[month-1];
        }
        int i = 1;
        while(i<=count){
            if(i==day){
                System.out.printf("  %2d*   ",i++);
            }else {
                System.out.printf("  %2d    ", i++);
            }
            ++index;
            if(index==8){
                System.out.println();
                index=1;
            }
        }
    }
 }

