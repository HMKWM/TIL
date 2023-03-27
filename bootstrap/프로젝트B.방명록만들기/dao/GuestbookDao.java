package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {

    private volatile static GuestbookDao instance = null;

    private GuestbookDao(){}

    public static GuestbookDao getGuestbookDao(){
        if(instance == null){
            synchronized (GuestbookDao.class) {
                if(instance == null) {
                    instance = new GuestbookDao();
                }
            }
        }
        return instance;
    }
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();

        String sql = "select id, name, content, regdate from guestbook";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String content = rs.getString("content");
                Date date = rs.getDate("regdate");
                list.add(new Guestbook(id, name, content, date));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }

        return list;
    }

    public void addGuestbook(Guestbook guestbook){
        // 코드를 작성하세요.
        String sql = "insert into guestbook(name, content, regdate) values (?, ?, now())";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;


        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guestbook.getName());
            pstmt.setString(2, guestbook.getContent());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }
}
