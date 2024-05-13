/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.model;

/**
 *
 * @author ADMIN
 */
public class SanPhamDTO {
    private String MaSanPham;
    private String TenSanPham;
    private Double GiaBan;
    private int SoLuong;
    private String MaLoai;
    private String ImageProduct;
    private int SoLuongCart;
    private Double tongTienCart;

    public Double getTongTienCart() {
        return tongTienCart;
    }

    public void setTongTienCart(Double tongTienCart) {
        this.tongTienCart = tongTienCart;
    }
    
    public int getSoLuongCart() {
        return SoLuongCart;
    }

    public void setSoLuongCart(int SoLuongCart) {
        this.SoLuongCart = SoLuongCart;
    }

    public String getImageProduct() {
        return ImageProduct;
    }

    public void setImageProduct(String ImageProduct) {
        this.ImageProduct = ImageProduct;
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

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double GiaBan) {
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
    
}
