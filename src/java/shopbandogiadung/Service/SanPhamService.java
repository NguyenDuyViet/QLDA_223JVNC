/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Service;

import java.util.ArrayList;
import java.util.List;
import shopbandogiadung.Dao.SanPhamDao;
import shopbandogiadung.model.SanPham;
import shopbandogiadung.model.SanPhamDTO;

/**
 *
 * @author ADMIN
 */
public class SanPhamService {
    private SanPhamDao sanphamdao;
    
    public static List<SanPhamDTO> carts = new ArrayList<>();

    public SanPhamDao getSanphamdao() {
        return sanphamdao;
    }

    public void setSanphamdao(SanPhamDao sanphamdao) {
        this.sanphamdao = sanphamdao;
    }

    
    
    
    public SanPhamService() {
        sanphamdao = new SanPhamDao();
    }
    
    public ArrayList<SanPham> getAllProduce(){
        return sanphamdao.getAllProduce();
    }
    
    public SanPhamDTO getSanPhambyMaSP(String maSP){
        return sanphamdao.getSanPhambyMaSP(maSP);
    }
}
