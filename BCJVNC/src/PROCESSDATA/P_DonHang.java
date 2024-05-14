/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROCESSDATA;

/**
 *
 * @author ZEQ
 */


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

public class P_DonHang {
    SQLSeverDataAccess con;
    String sqlSelectDonHang;
    String sqlInsertDH;
    String sqlDeleteDH;
    String sqlUpdateDH;


    
    public int ThemHoaDon(String TTDH, String NDH, String NGH, int SoLuongDat, String Giamua, int MaKH, String MSP) {
    sqlInsertDH="insert into HoaDonDatHang (TrangThaiGiaoHang,NgayDatHang,NgayGiaoHang,SoLuongDat,GiaMua,MaKH,MaSanPham) " 
                +"values(N'"+TTDH+"','"+NDH+"','"+NGH+"',"+SoLuongDat+",'"+Giamua+"',"+MaKH+",'"+MSP+"')";
    
       int k= con.ExecuteUpdateSQL( sqlInsertDH);
       return  k;
}

public int XoaHoaDon(String MaHoaDon) {
    sqlDeleteDH = "Delete from HoaDonDatHang WHERE MaHoaDon = "+MaHoaDon;
        int k = con.ExecuteUpdateSQL(sqlDeleteDH);
        return k;
}

   public int SuaHoaDon(int MHD,String TTDH, String NDH, String NGH, int SoLuongDat, String Giamua, int MaKH, String MSP)
    {
        sqlUpdateDH = "update HoaDonDatHang set TrangThaiGiaoHang= N'"+TTDH+"',NgayDatHang='"+NDH+"',NgayGiaoHang='"+NGH+"',SoLuongDat="+SoLuongDat+",GiaMua='"+Giamua+"',MaKH="+MaKH+",MaSanPham ='"+MSP+"' where MaHoaDon = "+MHD;

        int k = con.ExecuteUpdateSQL(sqlUpdateDH);
        return k;
    }
   
    public P_DonHang() {
       con = new SQLSeverDataAccess();
    }



 public Vector<ENTITY.E_HoaDonDatHang> DanhSachHoaDon(){
  Vector<ENTITY.E_HoaDonDatHang> vt=new Vector<ENTITY.E_HoaDonDatHang>();
     try{
           sqlSelectDonHang="select * from HoaDonDatHang";
        ResultSet rs = con.getResultSet(sqlSelectDonHang);
            while (rs.next()) {
                ENTITY.E_HoaDonDatHang dh=new ENTITY.E_HoaDonDatHang();
                dh.setMaHoaDon(rs.getInt("MaHoaDon"));
                dh.setTrangThaiGiaoHang(rs.getString("TrangThaiGiaoHang"));
                dh.setNgayDatHang((rs.getDate("NgayDatHang")));
                dh.setNgayGiaoHang((rs.getDate("NgayGiaoHang")));
                dh.setSoLuongDat(rs.getInt("SoLuongDat"));
                dh.setGiaMua(rs.getString("GiaMua"));
                dh.setMaKH(rs.getInt("MaKH"));
                dh.setMaSanPham(rs.getString("MaSanPham"));
                vt.addElement(dh);
            }          
     }catch(SQLException ex) {
         return null;
     }
     return  vt;
    }

}


