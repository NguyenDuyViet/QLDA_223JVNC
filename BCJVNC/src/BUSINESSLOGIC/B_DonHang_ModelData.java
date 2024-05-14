/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSINESSLOGIC;

import java.util.Date;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ZEQ
 */

public class B_DonHang_ModelData extends AbstractTableModel{
    
        Vector<ENTITY.E_HoaDonDatHang> data=new Vector<>();
    String colNames[] = {"Mã hoá đơn", "Trạng thái giao hàng", "Ngày đặt hàng", "Ngày giao hàng","Số lượng đặt","Giá mua",  "Mã khách hàng","Mã sản phẩm"};
    Class<?> colClasses[] = {int.class, String.class, Date.class, Date.class, Integer.class, String.class, int.class, String.class};

   B_DonHang_ModelData(Vector<ENTITY.E_HoaDonDatHang> list) {
        data=list;        
    }
    

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return data.get(rowIndex).getMaHoaDon();
               }
        if (columnIndex == 1) {
            return data.get(rowIndex).getTrangThaiGiaoHang();
        }
        if (columnIndex == 2) {
            return data.get(rowIndex).getNgayDatHang();
        }
        if (columnIndex == 3) {
            return data.get(rowIndex).getNgayGiaoHang();
        }
        if (columnIndex == 4) {
            return data.get(rowIndex).getSoLuongDat();
        }
        if (columnIndex == 5) {
            return data.get(rowIndex).getGiaMua();
        }
        if (columnIndex == 6) {
            return data.get(rowIndex).getMaKH();
        }
        if (columnIndex == 7) {
            return data.get(rowIndex).getMaSanPham();
        }
        
        return null;
    }
    
    
    @Override
    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return colClasses[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
