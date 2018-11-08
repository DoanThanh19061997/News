package com.news.dao.impl;

import com.news.common.util.MySQLUtil;
import com.news.dao.UserDAO;
import com.news.entity.UserEntity;

import java.sql.*;

public class UserDaoImpl implements UserDAO {
    private String url;
    private String user;
    private String password;


    public UserDaoImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean createUser(UserEntity userEntity) {

        UserEntity userEntity1 = new UserEntity();
        MySQLUtil mySQLUtil = new MySQLUtil(url,user,password);
        Connection connection= mySQLUtil.getConnection();
        String sql="insert into news.user(username, password, firtname, lastname, createddate, email, sex, roleid) VALUES(?,?,?,?,?,?,?,?)";
      //  PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userEntity.getUserName());
            preparedStatement.setString(2,userEntity.getPassword());
            preparedStatement.setString(3,userEntity.getFirstName());
            preparedStatement.setString(4,userEntity.getLastName());
            preparedStatement.setTimestamp(5,userEntity.getCreatedDate());
            preparedStatement.setString(6,userEntity.getEmail());
            preparedStatement.setBoolean(7,userEntity.isSex());
            preparedStatement.setLong(8,userEntity.getRoleId());

              ResultSet x =preparedStatement.executeQuery(sql);
              while(x.next()){

              }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }



    /*public boolean  delete(UserEntity userEntity){
        boolean x = false;
        MySQLUtil mySQLUtil = new MySQLUtil(url,user,password);
        Connection connection = mySQLUtil.getConnection();
        String sql = "DELETE from user where userid =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,userEntity.getUserId());
            x = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }
    public boolean update(UserEntity userEntity){
        boolean x = false;
        MySQLUtil mySQLUtil = new MySQLUtil(url,user,password);
        Connection connection = mySQLUtil.getConnection();
        String sql = "UPDATE user SET username=?,password=?,fristname=?,lastname=?,createddate=?,email=?,sex=?";
        sql+= "WHERE userid=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userEntity.getUserName());
            preparedStatement.setString(2,userEntity.getPassword());
            preparedStatement.setString(3,userEntity.getFirstName());
            preparedStatement.setString(4,userEntity.getLastName());
            preparedStatement.setTimestamp(5,userEntity.getCreatedDate());
            preparedStatement.setString(6,userEntity.getEmail());
            preparedStatement.setBoolean(7,userEntity.isSex());
            preparedStatement.setLong(8,userEntity.getRoleId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }*/
    public static void main(String[] args) {
        boolean x = false;
        UserDAO userDAO= new UserDaoImpl("jdbc:mysql://localhost:3306/new","root","123456");
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("nhung");
        userEntity.setPassword("1234");
        userEntity.setFirstName("nhung");
        userEntity.setLastName("hấp");
        userEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userEntity.setEmail("nhungthankinh@gmail.com");
        userEntity.setRoleId(1);
         x = userDAO.createUser(userEntity);
        System.out.println(x);

    }
}

