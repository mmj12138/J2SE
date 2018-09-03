package Init;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/2.
 */
public class She {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        String []s = ss.split("\\.");
        char c=ss.charAt(ss.length()-1);
        if(c=='5'){
            System.out.println(ss);
        }else{
            double d= Double.parseDouble(ss);
            BigDecimal d1 = new BigDecimal(d);
            System.out.println(d1.setScale(ss.length()-s[0].length()-2,BigDecimal.ROUND_HALF_UP));
        }

    }
}
