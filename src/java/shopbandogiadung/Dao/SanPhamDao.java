/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Dao;

import java.util.ArrayList;
import shopbandogiadung.model.SanPham;
import java.sql.*;
import shopbandogiadung.model.SanPhamDTO;

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
                produce.setImageProduct(rs.getString("ImageProduct"));
                
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
    

    public SanPhamDTO getSanPhambyMaSP(String maSP) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SanPham WHERE MaSanPham = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSP);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                SanPhamDTO produce = new SanPhamDTO();
                produce.setMaSanPham(rs.getString("MaSanPham"));
                produce.setTenSanPham(rs.getString("TenSanPham"));
                produce.setGiaBan(rs.getDouble("GiaBan"));
                produce.setSoLuong(rs.getInt("SoLuong"));
                produce.setMaLoai(rs.getString("MaLoai"));
                produce.setImageProduct(rs.getString("ImageProduct"));
                produce.setSoLuongCart(1);
                return produce;
            }
            
            // Đóng ResultSet và PreparedStatement
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
