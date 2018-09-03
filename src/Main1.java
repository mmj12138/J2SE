/**
 * Created by Administrator on 2018/6/4.
 */

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws ParseException {
        String str="{\"name\":\"tiger\",\"age\":21,\"birthday\":\"2018-04-08\"}";
        String s = str.replaceAll("\"","");
        String s1 = s.replaceAll("\\{","");
        String s2 = s1.replaceAll("\\}","");
        String[] keyValue = s2.split(",");
        Student student = new Student();
        student.setName(keyValue[0].split(":")[1]);
        student.setAge(Integer.parseInt(keyValue[1].split(":")[1]));
        int start = keyValue[2].indexOf(":");
        String time = keyValue[2].substring(start+1);
        student.setBirthday(Date.valueOf(time));
//        System.out.println(student.getName());
        new Main1().add(student);

    }
    public void add(Student stu){  //增加
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/python?useUnicode=true&character=utf-8",
                    "root","root");
            String sql = "INSERT INTO student(name,age,birthday) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,stu.getName());
            pstmt.setInt(2,stu.getAge());
            pstmt.setDate(3,stu.getBirthday());

            int flag = pstmt.executeUpdate();
            if(flag>0){
                System.out.println("增加成功！");
            } else {
                System.out.println("增加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null){
                    pstmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


