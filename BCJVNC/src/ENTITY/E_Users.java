/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author ZEQ
 */
public class E_Users {
        private int     MaKH;
        private String	Ho;
        private String	Ten;
        private String	SDT;
        private String	Email;
        private String	DiaChi;
        private String	MatKhau ;

    public E_Users() {
    }

    public E_Users(int MaKH, String Ho, String Ten, String SDT, String Email, String DiaChi, String MatKhau) {
        this.MaKH = MaKH;
        this.Ho = Ho;
        this.Ten = Ten;
        this.SDT = SDT;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.MatKhau = MatKhau;
    }

        
        
        
    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
        
}
