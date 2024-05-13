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
import java.util.Iterator;
import static shopbandogiadung.Service.SanPhamService.carts;
import shopbandogiadung.model.SanPhamDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/removeProduce"})
public class removeProduce extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("maSP");
        Iterator<SanPhamDTO> iterator = carts.iterator();
        while (iterator.hasNext()) {
            SanPhamDTO sanPhamDTO = iterator.next();
            if (sanPhamDTO.getMaSanPham().equals(maSP)) {
                if (sanPhamDTO.getSoLuongCart() == 1) {
                    iterator.remove();
                } else {
                    sanPhamDTO.setSoLuongCart(sanPhamDTO.getSoLuongCart() - 1);
                    sanPhamDTO.setTongTienCart(sanPhamDTO.getSoLuongCart() * sanPhamDTO.getGiaBan());
                }
                break;
            }
        }
        resp.sendRedirect("cart.jsp");
    }
    
}
