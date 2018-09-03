package SuanFa.San;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/13.
 */
public class n27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String []month={"January ","February","March","April","May","June","July","August","September","October","November","December"};
        System.out.println(month[n-1]);

    }

}