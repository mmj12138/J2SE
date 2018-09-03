package com.mengmeng.A.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2018/1/24.
 */
public class Myserver {
    public static void main(String[] args) {
        //1�������������Ӷ��� �ر�
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader br=null;
        try {
            System.out.println("�����ɹ�");
            server = new ServerSocket(9081);
            //2���տͻ����ֽ�������
            socket=server.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            //3�����ֽ�������
            boolean flag = true;
            while(flag){
                String msg=br.readLine();
                if(msg.toLowerCase().equals("exit")){
                    flag=false;
                    System.out.println("������");
                }else{
                    System.out.printf("%s\n",msg);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
