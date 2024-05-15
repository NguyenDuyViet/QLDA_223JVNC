/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package shopbandogiadung.Servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import shopbandogiadung.Service.SanPhamService;
import static shopbandogiadung.Service.SanPhamService.carts;
import shopbandogiadung.model.SanPhamDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet( urlPatterns = {"/AddGioHang"})
public class AddGioHang extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        HttpSession session = request.getSession();
        SanPhamService sanPhamService = new SanPhamService();
        
        String maSanPham = request.getParameter("maSanPham");
        
        if(carts.size() == 0) {
            SanPhamDTO sanPhamDTO = sanPhamService.getSanPhambyMaSP(maSanPham);
            sanPhamDTO.setTongTienCart(sanPhamDTO.getGiaBan());
            carts.add(sanPhamDTO);
            
        }  else {
            boolean flag = false;
            for (SanPhamDTO object : carts) {
                if(object.getMaSanPham().equals(maSanPham)) {
                    object.setSoLuongCart(object.getSoLuongCart()+1);
                    object.setTongTienCart(object.getSoLuongCart()*object.getGiaBan());
                    flag = true;
                }
            }
            if(!flag) {
                SanPhamDTO sanPham = sanPhamService.getSanPhambyMaSP(maSanPham);
                sanPham.setSoLuongCart(1);
                sanPham.setTongTienCart(sanPham.getGiaBan());
                carts.add(sanPham);
            }
            
        }
        session.setAttribute("carts", carts);
        
        session.setAttribute("result", "addcartsuccess");
        response.sendRedirect("index.jsp");
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
