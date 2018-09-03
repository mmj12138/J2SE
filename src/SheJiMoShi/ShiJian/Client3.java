package SheJiMoShi.ShiJian;

/**
 * Created by Administrator on 2017/12/15.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Client3 {

    public static void main(String[] args) {
        AbstractLog al;
        al=new LoggerProxy();
        al.method();
    }

}

interface AbstractLog{
    public void method();
}

class BusinessClass implements AbstractLog{
    @Override
    public void method() {
        System.out.println("方法内容。");
    }
}
class LoggerProxy implements AbstractLog{

    private BusinessClass business;

    public LoggerProxy(){
        business=new BusinessClass();
    }

    @Override
    public void method() {
        Calendar calendar=new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR)+12;
        int minu = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        String dateTime=year+"-"+month+"-"+day+" "+hour+":"+minu+":"+sec;
        System.out.println("方法method()在"+dateTime+"被调用！");
        try{
            business.method();
            System.out.println("method()方法调用成功！");
        }catch(Exception e){
            System.out.println("method()方法调用失败！");
        }

    }

}