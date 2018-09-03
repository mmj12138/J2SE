package Init;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/30.
 */
public class KongGe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        String [] s=ss.split(" ");
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]);
        }
    }
}
