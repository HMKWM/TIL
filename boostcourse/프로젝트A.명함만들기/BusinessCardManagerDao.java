package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.*;

import java.util.Date;
import java.util.List;

public interface BusinessCardManagerDao {
    public List<BusinessCard> searchBusinessCard(String keyword);

    public BusinessCard addBusinessCard(BusinessCard businessCard);
}
