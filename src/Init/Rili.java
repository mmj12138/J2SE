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
    ��ӡĳһ����ĳһ�µ�����
     */
    public static void main(String[] args) throws ParseException {
        int year=2012;
        int month=3;
        int day1=27;   //��ǰ����
        String ss=year+"/"+month+"/"+1;
        int [] m={1,3,5,7,8,10,12,   4,6,9,11};   //��ʾ�·�  �±�С��7ʱ�����ִ�����·�����Ϊ31  ����Ϊ30��
        //        0,1,2,3,4, 5, 6,   7,8,9,10
        int day=0;   //��ʾ��ǰ�����Ҫ�жϵ��·ݵ�����
         // �ж�����
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
                    day=(i<7)?31:30;  //���·��е����������жϲ���ֵ
                }
            }
            System.out.println(year+"��"+month+"�µ��������£�");
        System.out.println("������ ����һ ���ڶ� ������ ������ ������ ������");
        Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        SimpleDateFormat s=new SimpleDateFormat("yyyy/MM/dd");
        c.setTime(s.parse(ss));   //��Ҫ�жϵ�ĳ�������µ�1����Ϊ��ǰ����
        int cc=c.get(Calendar.DAY_OF_WEEK);
        if(cc!=1){   //Ϊ��ʹ��ʽ���ۣ���ӡ�Ŀո�

            for(int j=0;j<7*(cc-1);j++){
               System.out.print(" ");
            }
        }
        for(int i=1;i<=day;i++){
            int count=c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DAY_OF_MONTH,1);
            if(i==day1){
                System.out.printf("  %2d*  ",i);   //��������ǽ���  �����ں��ע*
            }else{
                System.out.printf("  %2d   ",i);
            }
            if(count==7){    //ÿ�ε�������ʱҪ����
                System.out.println();
            }
        }
    }
}
