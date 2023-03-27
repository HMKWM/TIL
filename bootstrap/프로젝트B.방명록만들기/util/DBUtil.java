package org.edwith.webbe.guestbook.util;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection(){
        // 본인 database에 맞게끔 수정해주세요.
        String url = "jdbc:mysql://127.0.0.1:3306/boostcourse?useUnicode=true&characterEncoding=utf8&useSSL=false";
        return getConnection(url,"root","0000");
    }

    public static Connection getConnection(String dbURL, String dbId, String dbPassword){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Connection Error");
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        try{
            pstmt.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
