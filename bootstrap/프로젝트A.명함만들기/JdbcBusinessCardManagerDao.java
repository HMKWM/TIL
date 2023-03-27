package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBusinessCardManagerDao implements BusinessCardManagerDao{

    private String url = "jdbc:mysql://127.0.0.1:3306/boostcourse?characterEncoding=UTF-8&serverTimezone=UTC";

    @Override
    public List<BusinessCard> searchBusinessCard(String keyword) {
        String sql = "select * from BusinessCard where name like ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BusinessCard> list = new ArrayList<>();

        try{
            conn = getConnection(url);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, keyword+"%");
            rs = pstmt.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String companyName = rs.getString("company_name");
                Date createDate = rs.getDate("create_date");
                BusinessCard businessCard = new BusinessCard(name, phone, companyName);
                businessCard.setCreateDate(createDate);

                list.add(businessCard);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public BusinessCard addBusinessCard(BusinessCard businessCard) {
        String sql = "insert into BusinessCard(name, phone, company_name, create_date) values " +
                "(?, ?, ?, now())";

        Connection conn = null;
        
        PreparedStatement pstmt = null;

        try{
            conn = getConnection(url);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, businessCard.getName());
            pstmt.setString(2, businessCard.getPhone());
            pstmt.setString(3, businessCard.getCompanyName());

            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return businessCard;
    }

    private Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url, "root", "0000");
    }
}
