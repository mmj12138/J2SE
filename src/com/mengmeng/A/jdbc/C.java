package com.mengmeng.A.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

public class C {
    @Test
    public void add(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bz?useCoding=true&characterEncoding=utf-8&useSSL=false","root","root");
            ps = conn.prepareStatement("insert into a(name) values(?)");
            ps.setString(1,"lala");
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
    public void sel(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bz?useCoding=true&characterEnCoding=utf-8&useSSL=false","root","root");
            ps = conn.prepareStatement("select * from customers where cust_id = ?");
            ps.setInt(1,10001);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("cust_name"));
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
}