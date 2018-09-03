import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/4.
 */
public class JDBC {
    @org.junit.Test
    public void add(){  //增加
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/my_test?useUnicode=true&character=utf-8",
                    "root","root");
            String sql = "INSERT INTO student(name,age,birthday) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            java.util.Date today = new java.util.Date();
            pstmt.setString(1,"jjj");
            pstmt.setInt(2,12);
//            pstmt.setDate(3, new Date(today.getTime()));
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
