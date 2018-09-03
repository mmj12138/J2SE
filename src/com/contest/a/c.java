package com.contest.a;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/15.
 */
public class c {
    public static void main(String[] args) {
        String cc = "bkpstor";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String ss = sc.nextLine();
            if(ss.contains(cc)){
                System.out.println("Warning");
            }else{
                System.out.println("Safe");
            }
        }
    }
}
