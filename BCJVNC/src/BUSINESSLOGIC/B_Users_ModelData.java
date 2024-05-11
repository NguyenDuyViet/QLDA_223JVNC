/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSINESSLOGIC;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ZEQ
 */
public class B_Users_ModelData extends AbstractTableModel{

    Vector<ENTITY.E_Users> data = new Vector<>();
    String colNames[] = {"Mã khách hàng", "Họ", "Tên", "Số điện thoại", "Email", "Địa chỉ", "Mật Khẩu"};
    Class<?> colClasses[] = {int.class, String.class, String.class, String.class, String.class, String.class, String.class};

    B_Users_ModelData(Vector<ENTITY.E_Users> list) {
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
            return data.get(rowIndex).getMaKH();
        }
        if (columnIndex == 1) {
            return data.get(rowIndex).getHo();
        }
        if (columnIndex == 2) {
            return data.get(rowIndex).getTen();
        }
        if (columnIndex == 3) {
            return data.get(rowIndex).getSDT();
        }
        if (columnIndex == 4) {
            return data.get(rowIndex).getEmail();
        }
         if (columnIndex == 5) {
            return data.get(rowIndex).getDiaChi();
        }
         if (columnIndex == 6) {
            return data.get(rowIndex).getMatKhau();
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
