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

public class B_KhoHang_ModelData extends AbstractTableModel{
    
        Vector<ENTITY.E_KhoHang> data=new Vector<>();
    String colNames[] = {"Mã loại", "Tên loại"};
    Class<?> colClasses[] = {String.class, String.class};

   B_KhoHang_ModelData(Vector<ENTITY.E_KhoHang> list) {
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
            return data.get(rowIndex).getMaLoai();
        }
        if (columnIndex == 1) {
            return data.get(rowIndex).getTenLoai();
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
