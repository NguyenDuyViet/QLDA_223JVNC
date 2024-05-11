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
public class P_SanPham {
    SQLSeverDataAccess con;
    String sqlSelectKhoHang;
    String sqlInsertSP;
    String sqlSelectSP;
    String sqlDeleteSP;
    String sqlUpdateSP;
    
    
    
    public int ThemSP(String MaSP, String tenSP,String giasp, int SL, String maLoai)
    {
     sqlInsertSP="insert into SanPham (MaSanPham,TenSanPham,GiaBan,SoLuong,MaLoai)" 
                +"values ('"+MaSP+"',N'"+tenSP+"','"+giasp+"',"+SL+",'"+maLoai+"')";
       int k= con.ExecuteUpdateSQL( sqlInsertSP);
       return  k;
    }
    public int XoaSP(String MaSP)
    {
        sqlDeleteSP = "Delete from SanPham WHERE MaSanPham = '"+MaSP+"'";
        int k = con.ExecuteUpdateSQL(sqlDeleteSP);
        return k;
    }
    public int SuaSP(String MaSP, String tenSP,String giasp, int SL, String maLoai )
    {
        sqlUpdateSP = "update SanPham set TenSanPham=N'"+tenSP+"', GiaBan='"+giasp+"', SoLuong="+SL+",MaLoai='"+maLoai+"'where MaSanPham= '"+MaSP+"'";
        int k = con.ExecuteUpdateSQL(sqlUpdateSP);
        return k;
    }
    
    
    public P_SanPham(){
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
        
    public Vector<ENTITY.E_SanPham> DanhSachSP(){
        Vector<ENTITY.E_SanPham> vt=new Vector<ENTITY.E_SanPham>();
     try{
          sqlSelectSP="select * from SanPham";
        ResultSet rs = con.getResultSet(sqlSelectSP);
            while (rs.next()) {
                ENTITY.E_SanPham sp=new ENTITY.E_SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getString("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setMaLoai(rs.getString("MaLoai"));
                vt.addElement(sp);
            }          
     }catch(SQLException ex) {
         return null;
     }
     return  vt;
    }     
    
}
