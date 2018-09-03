package com.mengmeng.A.jdbc;

import org.junit.Test;

import java.sql.*;

public class B {
    @Test
    public void update(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bz?useCoding=true&character=utf-8&useSSL=false","root","root");
            ps = conn.prepareStatement("update a set name = ? where id = ?");
            ps.setString(1,"mengmeng");
            ps.setInt(2,1);
            System.out.println(ps.executeUpdate());

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
    }
    @Test
    public void del(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bz?useCoding=true$characterEncoding=utf-8&useSSL=false","root","root");
            ps = conn.prepareStatement("delete from a where id = ?");
            ps.setInt(1,2);
            System.out.println(ps.executeUpdate());

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
    }
    @Test
    public void add() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bz?useCoding=true&characterEncoding=utf-8&useSSL=false","root","root");
            ps = conn.prepareStatement("insert into a(name) values(?)");
            ps.setString(1,"mengmeng");
            System.out.println(ps.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }

        }
    }
    @Test
    public void sel(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bz?useCoding=true&characterEncoding=utf-8&useSSL=false","root","root");
            //  jdbc:mysql://127.0.0.1:3306/bz?useCoding=true&characterEncoding=utf-8&useSSL=                                              //
            ps = conn.prepareStatement("select * from a ");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {

                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
    }
    public void selAll(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bz?useCoding=true&characterEncoding=utf-8&useSSL=false","root","root");
            //3.执行sql(准备状态）
            ps = conn.prepareStatement("select * from customers");
            //4.遍历数据
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("cust_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
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
