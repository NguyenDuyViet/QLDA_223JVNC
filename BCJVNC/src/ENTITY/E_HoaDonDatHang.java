/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Date;

/**
 *
 * @author ZEQ
 */
public class E_HoaDonDatHang {
    private int MaHoaDon ;
    private String  TrangThaiGiaoHang;
    private Date  NgayDatHang;
    private Date     NgayGiaoHang;
    private int SoLuongDat ;
    private String  GiaBan;
    private int     MaKH;
    private String  MaSanPham ;

    public E_HoaDonDatHang() {
    }

    public E_HoaDonDatHang(int MaHoaDon, String TrangThaiGiaoHang, Date NgayDatHang, Date NgayGiaoHang, int SoLuongDat, String GiaBan, int MaKH, String MaSanPham) {
        this.MaHoaDon = MaHoaDon;
        this.TrangThaiGiaoHang = TrangThaiGiaoHang;
        this.NgayDatHang = NgayDatHang;
        this.NgayGiaoHang = NgayGiaoHang;
        this.SoLuongDat = SoLuongDat;
        this.GiaBan = GiaBan;
        this.MaKH = MaKH;
        this.MaSanPham = MaSanPham;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getTrangThaiGiaoHang() {
        return TrangThaiGiaoHang;
    }

    public void setTrangThaiGiaoHang(String TrangThaiGiaoHang) {
        this.TrangThaiGiaoHang = TrangThaiGiaoHang;
    }

    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    public void setNgayDatHang(Date NgayDatHang) {
        this.NgayDatHang = NgayDatHang;
    }

    public Date getNgayGiaoHang() {
        return NgayGiaoHang;
    }

    public void setNgayGiaoHang(Date NgayGiaoHang) {
        this.NgayGiaoHang = NgayGiaoHang;
    }

    public int getSoLuongDat() {
        return SoLuongDat;
    }

    public void setSoLuongDat(int SoLuongDat) {
        this.SoLuongDat = SoLuongDat;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }


    

}
