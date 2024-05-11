/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSINESSLOGIC;

/**
 *
 * @author ZEQ
 */
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class B_SanPham_ModelData extends AbstractTableModel {

    Vector<ENTITY.E_SanPham> data = new Vector<>();
    String colNames[] = {"Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Số lượng", "Mã loại"};
    Class<?> colClasses[] = {String.class, String.class, String.class, int.class, String.class};

    B_SanPham_ModelData(Vector<ENTITY.E_SanPham> list) {
        data = list;
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
            return data.get(rowIndex).getMaSanPham();
        }
        if (columnIndex == 1) {
            return data.get(rowIndex).getTenSanPham();
        }
        if (columnIndex == 2) {
            return data.get(rowIndex).getGiaBan();
        }
        if (columnIndex == 3) {
            return data.get(rowIndex).getSoLuong();
        }
        if (columnIndex == 4) {
            return data.get(rowIndex).getMaLoai();
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
