package com.my.db;

import com.my.db.entity.User;
import com.my.db.entity.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.my.db.DBManager.getConnection;

public class UserInfoDAO {

    public void  insertUserInf(User user, UserInfo userInfo){
        try(Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement("INSERT INTO user_info (id, first_name, last_name, patronymic, city, region, school, uk_lang, uk_liter, eng, algebra, informatics, geometry, uk_history, ph_training, physics, eie_uk_lang, eie_math) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {

            stat.setInt(1,user.getId());
            stat.setString(2,userInfo.getFirstName());
            stat.setString(3,userInfo.getLastName());
            stat.setString(4,userInfo.getPartonymic());
            stat.setString(5,userInfo.getCity());
            stat.setString(6,userInfo.getRegion());
            stat.setString(7,userInfo.getSchool());
            stat.setInt(8,userInfo.getUkLang());
            stat.setInt(9,userInfo.getUkLiter());
            stat.setInt(10,userInfo.getEng());
            stat.setInt(11,userInfo.getAlgebra());
            stat.setInt(12,userInfo.getInformatics());
            stat.setInt(13,userInfo.getGeometry());
            stat.setInt(14,userInfo.getUkHistory());
            stat.setInt(15,userInfo.getPhTraining());
            stat.setInt(16,userInfo.getPhysics());
            stat.setInt(17,userInfo.getEieUkLang());
            stat.setInt(18,userInfo.getEieMath());
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setIsAdmin(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            //add logger
        }
    }
}
