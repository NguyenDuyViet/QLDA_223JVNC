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

    public ArrayList<User> getAllUser() {
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

    public String generateCodeUser() {
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT TOP 1 * FROM Users ORDER BY MaKH DESC";

        String maKhTmp = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                maKhTmp = rs.getString("MaKH");
            }

            // Đóng ResultSet và PreparedStatement
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String maKhNew = "K0001";
        if (!maKhTmp.isEmpty()) {
            int numberKh = Integer.parseInt(maKhTmp.split("K")[1]);
            int numberNew = numberKh + 1;

            String firstKey = "K000";

            if (countNumber(numberNew) == 2) {
                firstKey = "K00";
            }
            if (countNumber(numberNew) == 3) {
                firstKey = "K0";
            }
            if (countNumber(numberNew) == 4) {
                firstKey = "K";
            }

            maKhNew = firstKey + numberNew;
        }

        return maKhNew;
    }

    public void addUser(User user) {
        Connection connection = JDBCConnection.getJDBCConnection();

        String maKh = generateCodeUser();
        String sql = "INSERT INTO Users(MaKH,Ho, Ten, SDT, Email, DiaChi, MatKhau) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maKh);
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
    
    public static int countNumber(int number) {
        int count = 0;

        while (number > 0) {
            number /= 10;
            count++;    // tăng biến count lên 1
        }
        return count;
    }

    public boolean checkLogin(String email, String password) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT TOP 1 * FROM Users WHERE Email=? AND MatKhau=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                return true;
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            return false;
        }

        return false;
    }
    
    public User getUserbyuserName(String username){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT TOP 1 * FROM Users WHERE Email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setHo(rs.getString("Ho"));
                user.setTen(rs.getString("Ten"));
                user.setSDT(rs.getString("SDT"));
                user.setEmail(rs.getString("Email"));
                user.setDiaChi(rs.getString("DiaChi"));
                user.setMatKhau(rs.getString("MatKhau"));
                return user;
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean checkSignup(String email, String sdt) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM Users WHERE Email=? OR SDT=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, sdt);
            
            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
