/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSINESSLOGIC;

/**
 *
 * @author ZEQ
 */
public class B_Users {
       GUI.CH_QLDDD GuiQLCH;
    PROCESSDATA.P_Users ProQLCH;

    public B_Users(GUI.CH_QLDDD user) {
        GuiQLCH = user;
        ProQLCH = new PROCESSDATA.P_Users();

        LoadUsers();
    }

    public void LoadUsers() {
        GuiQLCH.jTable2.setModel(new B_Users_ModelData(this.ProQLCH.DanhSachKhachHang()));
    }

 

    public int InsertUS() {
        int k = this.ProQLCH.ThemUS(GuiQLCH.jTextField8.getText(),GuiQLCH.jTextField9.getText(),GuiQLCH.jTextField10.getText(),GuiQLCH.jTextField10.getText(),GuiQLCH.jTextField11.getText(),GuiQLCH.jTextField12.getText());
        return k;
    }

    public int DeleteUS() {
        int k = this.ProQLCH.XoaUS(GuiQLCH.jTextField7.getText());
        return k;
    }

    public int UpdateUS() {
        int k = this.ProQLCH.SuaUS(GuiQLCH.jTextField7.getText(),GuiQLCH.jTextField8.getText(),GuiQLCH.jTextField9.getText(),GuiQLCH.jTextField10.getText(),GuiQLCH.jTextField10.getText(),GuiQLCH.jTextField11.getText(),GuiQLCH.jTextField12.getText());
        return k;
    }
  
}
