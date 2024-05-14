
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSINESSLOGIC;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ZEQ
 */
public class B_DonHang {

    GUI.CH_QLDDD GuiQLCH;
    PROCESSDATA.P_DonHang ProQLCH;

    public B_DonHang(GUI.CH_QLDDD donhang) {
        GuiQLCH = donhang;
        ProQLCH = new PROCESSDATA.P_DonHang();

        LoadDonHang();
    }

    public class DateCellRenderer extends DefaultTableCellRenderer {

        private SimpleDateFormat dateFormat;

        public DateCellRenderer(String dateFormatPattern) {
            this.dateFormat = new SimpleDateFormat(dateFormatPattern);
        }

        public void setValue(Object value) {
            if (value instanceof Date) {
                value = dateFormat.format(value);
            }
            super.setValue(value);
        }
    }

    public void LoadDonHang() {
        GuiQLCH.jTable3.setModel(new B_DonHang_ModelData(this.ProQLCH.DanhSachHoaDon()));
        GuiQLCH.jTable3.getColumnModel().getColumn(2).setCellRenderer(new DateCellRenderer("yyyy-MM-dd"));
        GuiQLCH.jTable3.getColumnModel().getColumn(3).setCellRenderer(new DateCellRenderer("yyyy-MM-dd"));

    }

    public int InsertDH() {
        try {
            String TTDH = GuiQLCH.jComboBox3.getSelectedItem().toString();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String NDH = dateFormat.format(GuiQLCH.jDateChooser1.getDate());
            String NGH = dateFormat.format(GuiQLCH.jDateChooser2.getDate());

            int SoLuongDat = (Integer) GuiQLCH.jSpinner1.getValue();
            String Giamua = GuiQLCH.jTextField5.getText();
            int MaKH = Integer.parseInt(GuiQLCH.jTextField15.getText());
            String MSP = GuiQLCH.jTextField31.getText();

            int k = this.ProQLCH.ThemHoaDon(TTDH, NDH, NGH, SoLuongDat, Giamua, MaKH, MSP);
            return k;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }

//      int  k = this.ProQLCH.ThemHoaDon(GuiQLCH.jComboBox3.getSelectedItem().toString(),GuiQLCH.jDateChooser1.getDate().toString(),GuiQLCH.jDateChooser2.getDate().toString(),(Integer)GuiQLCH.jSpinner1.getValue(),GuiQLCH.jTextField5.getText(),Integer.parseInt(GuiQLCH.jTextField15.getText()), GuiQLCH.jTextField31.getText()      );
//                return k;
    }

    public int DeleteDH() {
        int k = this.ProQLCH.XoaHoaDon(GuiQLCH.jTextField14.getText());
        return k;
    }

    public int UpdateDH() {
        String TTDH = GuiQLCH.jComboBox3.getSelectedItem().toString();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String NDH = dateFormat.format(GuiQLCH.jDateChooser1.getDate());
        String NGH = dateFormat.format(GuiQLCH.jDateChooser2.getDate());

        int SoLuongDat = (Integer) GuiQLCH.jSpinner1.getValue();
        String Giamua = GuiQLCH.jTextField5.getText();
        int MaKH = Integer.parseInt(GuiQLCH.jTextField15.getText());
        String MSP = GuiQLCH.jTextField31.getText();

        int k = this.ProQLCH.SuaHoaDon(Integer.parseInt(GuiQLCH.jTextField14.getText()), TTDH, NDH, NGH, SoLuongDat, Giamua, MaKH, MSP);
        return k;
    }
}
