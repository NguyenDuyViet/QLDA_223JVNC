/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Dao;

import java.util.ArrayList;
import shopbandogiadung.model.SanPham;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class SanPhamDao {
    public ArrayList<SanPham> getAllProduce(){
        ArrayList<SanPham> Produces = new ArrayList<SanPham>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SanPham";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                SanPham produce = new SanPham();
                produce.setMaSanPham(rs.getString("MaSanPham"));
                produce.setTenSanPham(rs.getString("TenSanPham"));
                produce.setGiaBan(rs.getDouble("GiaBan"));
                produce.setSoLuong(rs.getInt("SoLuong"));
                produce.setMaLoai(rs.getString("MaLoai"));
                
                Produces.add(produce);
            }
            
            // Đóng ResultSet và PreparedStatement
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return Produces;
    }
}
