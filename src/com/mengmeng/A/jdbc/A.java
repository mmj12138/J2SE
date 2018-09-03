package com.mengmeng.A.jdbc;

import org.junit.Test;

import java.sql.*;


/**
 * Created by Administrator on 2018-02-08.
 */
public class A {
    @Test
    public void add(){

    }
    @Test
    public void query(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //1.加载驱动进入内存
            Class.forName("com.mysql.jdbc.Driver");
            //2.连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bz?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","root");
            //3.执行sql语句
            int onum = 20005;
            pstm = conn.prepareStatement("select * from orderitems where order_num=? and item_price<?");
            pstm.setInt(1,onum);
            pstm.setFloat(2,10);
            //4.遍历
            rs = pstm.executeQuery();
            while(rs.next()){
                System.out.printf("%.2f %d \n",rs.getFloat("item_price"),rs.getInt(1));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
