package com.my.db;

import com.my.db.entity.User;
import com.my.db.entity.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.my.db.DBManager.getConnection;

public class UserInfoDAO {
    public static final String GET_USER_NAME = "SELECT * FROM user_info WHERE user_id=?";
    public static final String INSERT_USER_INFO = "INSERT INTO user_info (first_name, last_name, patronymic, city, region, school, uk_lang, uk_liter, eng, algebra, informatics, geometry, uk_history, ph_training, physics, eie_uk_lang, eie_math,user_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public void  insertUserInf(Connection conn,User user, UserInfo userInfo){
        try(//Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(INSERT_USER_INFO)) {

            stat.setString(1,userInfo.getFirstName());
            stat.setString(2,userInfo.getLastName());
            stat.setString(3,userInfo.getPartonymic());
            stat.setString(4,userInfo.getCity());
            stat.setString(5,userInfo.getRegion());
            stat.setString(6,userInfo.getSchool());
            stat.setInt(7,userInfo.getUkLang());
            stat.setInt(8,userInfo.getUkLiter());
            stat.setInt(9,userInfo.getEng());
            stat.setInt(10,userInfo.getAlgebra());
            stat.setInt(11,userInfo.getInformatics());
            stat.setInt(12,userInfo.getGeometry());
            stat.setInt(13,userInfo.getUkHistory());
            stat.setInt(14,userInfo.getPhTraining());
            stat.setInt(15,userInfo.getPhysics());
            stat.setInt(16,userInfo.getEieUkLang());
            stat.setInt(17,userInfo.getEieMath());
            stat.setInt(18,user.getId());

            stat.executeUpdate();
          /*  try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setIsAdmin(generatedKeys.getInt(1));
                }
            }*/
        } catch (SQLException e) {
            //add logger
        }
    }

    public String  getUserName(Connection conn,int id){
        String name = "";
        try(//Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(GET_USER_NAME)) {

            stat.setInt(1,id);

            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    name = resultSet.getString(2);

                }
            }
        } catch (SQLException e) {
            //add logger
        }
        return name;
    }
}
