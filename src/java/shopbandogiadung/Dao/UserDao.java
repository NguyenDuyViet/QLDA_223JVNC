/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Dao;

import java.util.ArrayList;
import shopbandogiadung.model.User;
import java.sql.*;
import shopbandogiadung.model.TKUser;

/**
 *
 * @author ADMIN
 */
public class UserDao {
    public ArrayList<User> getAllUser(){
        ArrayList<User> users = new ArrayList<User>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM Users";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                user.setHo(rs.getString("Ho"));
                user.setTen(rs.getString("Ten"));
                user.setSDT(rs.getString("SDT"));
                user.setEmail(rs.getString("Email"));
                user.setDiaChi(rs.getString("DiaChi"));
                user.setMatKhau(rs.getString("MatKhau"));
                
                users.add(user);
            }
            
            // Đóng ResultSet và PreparedStatement
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    public void addUser(User user){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO Users(Ho, Ten, SDT, Email, DiaChi, MatKhau) VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getHo());
            preparedStatement.setString(2, user.getTen());
            preparedStatement.setString(3, user.getSDT());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getDiaChi());
            preparedStatement.setString(6, user.getMatKhau());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<TKUser> getAllTKUser(){
        ArrayList<TKUser> tkUsers = new ArrayList<TKUser>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM Users";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                TKUser tkuser = new TKUser();
                
                tkuser.setSdt(rs.getString("SDT"));
                tkuser.setEmail(rs.getString("Email"));
                tkuser.setPassword(rs.getString("MatKhau"));
                
                tkUsers.add(tkuser);
            }
            
            // Đóng ResultSet và PreparedStatement
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tkUsers;
    }
    public User findUser(String username, String password){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM Users Where (SDT = "+username+" or Email = "+ username + ")and MatKhau="+password;
        
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                user.setHo(rs.getString("Ho"));
                user.setTen(rs.getString("Ten"));
                user.setSDT(rs.getString("SDT"));
                user.setEmail(rs.getString("Email"));
                user.setDiaChi(rs.getString("DiaChi"));
                user.setMatKhau(rs.getString("MatKhau"));
            }
            
            // Đóng ResultSet và PreparedStatement
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
