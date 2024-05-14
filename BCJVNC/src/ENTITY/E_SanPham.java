/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author ZEQ
 */
public class E_SanPham {
    private String  MaSanPham ;
    private String  TenSanPham;
    private String  GiaBan;
    private int     SoLuong;
    private String  MaLoai;
    private String  LinkAnh;


    public E_SanPham() {
    }

    public E_SanPham(String MaSanPham, String TenSanPham, String GiaBan, int SoLuong, String MaLoai) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.MaLoai = MaLoai;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getLinkAnh() {
        return LinkAnh;
    }

    public void setLinkAnh(String LinkAnh) {
        this.LinkAnh = LinkAnh;
    }
	
    
   
    
    

            
            
            
            
}
