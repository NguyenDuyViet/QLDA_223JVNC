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
public class B_KhoHang {
   
    GUI.CH_QLDDD GuiQLCH;
    PROCESSDATA.P_KhoHang ProQLCH;

    public B_KhoHang(GUI.CH_QLDDD khohang) {
        GuiQLCH = khohang;
        ProQLCH = new PROCESSDATA.P_KhoHang();

        LoadKhoHang();
    }

    public void LoadKhoHang() {
        GuiQLCH.jTable4.setModel(new B_KhoHang_ModelData(this.ProQLCH.DanhSachKhoHang()));
    }

 

    public int InsertLoai() {
        int k = this.ProQLCH.ThemLoai(GuiQLCH.jTextField27.getText(),GuiQLCH.jTextField28.getText());
        return k;
    }

    public int DeleteLoai() {
        int k = this.ProQLCH.XoaLoai(GuiQLCH.jTextField27.getText());
        return k;
    }

    public int UpdateLoai() {
        int k = this.ProQLCH.SuaLoai(GuiQLCH.jTextField27.getText(),GuiQLCH.jTextField28.getText());
        return k;
    }
 
}
