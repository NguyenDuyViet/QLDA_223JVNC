/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package shopbandogiadung.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import static shopbandogiadung.Service.SanPhamService.carts;
import shopbandogiadung.model.SanPhamDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/addProduce"})
public class addProduce extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("maSP");
        HttpSession session = req.getSession();
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        
        for (SanPhamDTO object : carts) {
            if(object.getMaSanPham().equals(maSP)) {
                object.setSoLuongCart(object.getSoLuongCart()+1);
                object.setTongTienCart(object.getSoLuongCart()*object.getGiaBan());
                sanPhamDTO = object;
            }
        }
        resp.sendRedirect("cart.jsp");
    }
}
