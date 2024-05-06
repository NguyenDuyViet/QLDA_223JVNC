/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Dao;

import java.util.ArrayList;
import shopbandogiadung.model.User;
import java.sql.*;

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
                user.setMaKH(rs.getString("MaKH"));
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
        
        String sql = "INSERT INTO Users(MaKH, Ho, Ten, SDT, Email, DiaChi, MatKhau) VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getMaKH());
            preparedStatement.setString(2, user.getHo());
            preparedStatement.setString(3, user.getTen());
            preparedStatement.setString(4, user.getSDT());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getDiaChi());
            preparedStatement.setString(7, user.getMatKhau());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Object> getAllTKUser(){
        ArrayList<Object> tkUsers = new ArrayList<Object>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM Users";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                user.setSDT(rs.getString("SDT"));
                user.setEmail(rs.getString("Email"));
                user.setMatKhau(rs.getString("MatKhau"));
                
                tkUsers.add(user);
            }
            
            // Đóng ResultSet và PreparedStatement
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tkUsers;
    }
}
