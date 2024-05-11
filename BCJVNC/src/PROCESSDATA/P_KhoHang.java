/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROCESSDATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ZEQ
 */
public class P_KhoHang {
    SQLSeverDataAccess con;
    String sqlSelectKhoHang;
    String sqlInsertKH;
    String sqlDeleteKH;
    String sqlUpdateKH;
    
      public int ThemLoai(String maLoai, String tenLoai)
    {
     sqlInsertKH="insert into KhoHang " 
                +"values('"+maLoai+"','"+tenLoai+"')";
       int k= con.ExecuteUpdateSQL( sqlInsertKH);
       return  k;
    }
    public int XoaLoai(String maLoai)
    {
        sqlDeleteKH = "Delete from KhoHang WHERE maLoai = '"+maLoai+"'";
        int k = con.ExecuteUpdateSQL(sqlDeleteKH);
        return k;
    }
    public int SuaLoai(String maLoai, String tenLoai)
    {
        sqlUpdateKH = "Update Khohang set tenLoai = '"+tenLoai+"' where maLoai= '"+maLoai+"'";
        int k = con.ExecuteUpdateSQL(sqlUpdateKH);
        return k;
    }
    
    
    public P_KhoHang(){
       con = new SQLSeverDataAccess();
   }
    
    public Vector<ENTITY.E_KhoHang> DanhSachKhoHang(){
        Vector<ENTITY.E_KhoHang> vt=new Vector<ENTITY.E_KhoHang>();
     try{
           sqlSelectKhoHang="select * from KhoHang";
        ResultSet rs = con.getResultSet(sqlSelectKhoHang);
            while (rs.next()) {
                ENTITY.E_KhoHang kh=new ENTITY.E_KhoHang();
                kh.setMaLoai(rs.getString("MaLoai"));
                kh.setTenLoai(rs.getString("TenLoai"));
                vt.addElement(kh);
            }          
     }catch(SQLException ex) {
         return null;
     }
     return  vt;
    }
}
