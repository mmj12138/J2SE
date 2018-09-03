package com.mengmeng.A.Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/24.
 */
public class MyClient {
    public static void main(String[] args) {
        Socket client = null;
        PrintWriter writer = null;
        Scanner sc= null;
        try {
            client=new Socket("127.0.0.1",9081);
            writer = new PrintWriter(client.getOutputStream(),true);
            sc = new Scanner(System.in);

            while (sc.hasNext()){
                writer.println(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
