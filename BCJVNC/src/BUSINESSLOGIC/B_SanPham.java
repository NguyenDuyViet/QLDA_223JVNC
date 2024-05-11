/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSINESSLOGIC;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ZEQ
 */
public class B_SanPham {

    GUI.CH_QLDDD GuiQLCH;
    PROCESSDATA.P_SanPham ProQLCH;

    public B_SanPham(GUI.CH_QLDDD sanpham) {
        GuiQLCH = sanpham;
        ProQLCH = new PROCESSDATA.P_SanPham();

        LoadKhoHang();
        LoadSanPham();
    }

    public void LoadSanPham() {
        GuiQLCH.jTable1.setModel(new B_SanPham_ModelData(this.ProQLCH.DanhSachSP()));
    }

    public void LoadKhoHang() {
        DefaultComboBoxModel<ENTITY.E_KhoHang> model = new DefaultComboBoxModel<>(ProQLCH.DanhSachKhoHang());
        GuiQLCH.jComboBox16.setModel(model);

    }

    public int InsertSP() {
        int k = this.ProQLCH.ThemSP(GuiQLCH.jTextField1.getText(),GuiQLCH.jTextField2.getText(),GuiQLCH.jTextField3.getText(),Integer.parseInt(GuiQLCH.jTextField4.getText()),((ENTITY.E_KhoHang)GuiQLCH.jComboBox16.getSelectedItem()).getMaLoai());
        return k;
    }

    public int DeleteSP() {
        int k = this.ProQLCH.XoaSP(GuiQLCH.jTextField1.getText());
        return k;
    }

    public int UpdateSP() {
        int k = this.ProQLCH.SuaSP(GuiQLCH.jTextField1.getText(),GuiQLCH.jTextField2.getText(),GuiQLCH.jTextField3.getText(),Integer.parseInt(GuiQLCH.jTextField4.getText()),((ENTITY.E_KhoHang)GuiQLCH.jComboBox16.getSelectedItem()).getMaLoai());
        return k;
    }

}
