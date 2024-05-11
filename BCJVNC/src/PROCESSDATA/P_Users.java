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
public class P_Users {
    SQLSeverDataAccess con;
    String sqlSelectUS;
    String sqlInsertUS;
    String sqlDeleteUS;
    String sqlUpdateUS;



      public int ThemUS(String Ho,String Ten, String SDT, String Email, String Dchi, String Matkhau)
    {
     sqlInsertUS="insert into Users(Ho,Ten,SDT,Email,DiaChi,MatKhau)" 
                +"values (N'"+Ho+"',N'"+Ten+"','"+SDT+"','"+Email+"',N'"+Dchi+"','"+Matkhau+"')";
       int k= con.ExecuteUpdateSQL( sqlInsertUS);
       return  k;
    }
    public int XoaUS(String MaKH)
    {
        sqlDeleteUS = "Delete from Users WHERE MaKH = "+MaKH;
        int k = con.ExecuteUpdateSQL(sqlDeleteUS);
        return k;
    }
    public int SuaUS(String MaKH, String Ho, String Ten, String SDT, String Email, String Dchi, String Matkhau)
    {
        sqlUpdateUS = "update Users set Ho= N'"+Ho+"',Ten= N'"+Ten+"',SDT = '"+SDT+"',Email = '"+Email+"',Diachi = N'"+Dchi+"',Matkhau = '"+Matkhau+"' where MaKH= '"+MaKH+"'";
        int k = con.ExecuteUpdateSQL(sqlUpdateUS);
        return k;
    }
    
    
    public P_Users(){
        con = new SQLSeverDataAccess();
    }
    
        public Vector<ENTITY.E_Users> DanhSachKhachHang(){
        Vector<ENTITY.E_Users> vt=new Vector<ENTITY.E_Users>();
     try{
           sqlSelectUS="select * from KhoHang";
        ResultSet rs = con.getResultSet(sqlSelectUS);
            while (rs.next()) {
                ENTITY.E_Users us=new ENTITY.E_Users();
                us.setMaKH(rs.getInt("MaKH"));
                us.setHo(rs.getString("Ho"));
                us.setTen(rs.getString("Ten"));
                us.setSDT(rs.getString("SDT"));
                us.setEmail(rs.getString("Email"));
                us.setDiaChi(rs.getString("DiaChi"));
                us.setMatKhau(rs.getString("MatKhau"));

                vt.addElement(us);
            }          
     }catch(SQLException ex) {
         return null;
     }
     return  vt;
    }
   
}
    
    

