/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Service;

import java.util.ArrayList;
import shopbandogiadung.Dao.SanPhamDao;
import shopbandogiadung.model.SanPham;

/**
 *
 * @author ADMIN
 */
public class SanPhamService {
    private SanPhamDao sanphamdao;

    public SanPhamService() {
        sanphamdao = new SanPhamDao();
    }
    
    public ArrayList<SanPham> getAllProduce(){
        return sanphamdao.getAllProduce();
    }
}
