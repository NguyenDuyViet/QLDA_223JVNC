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
import java.io.IOException;
import java.util.List;
import shopbandogiadung.Service.SanPhamService;
import static shopbandogiadung.Service.SanPhamService.carts;
import shopbandogiadung.Service.UserService;
import shopbandogiadung.model.SanPham;
import shopbandogiadung.model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("result", "no");
        req.getSession().setAttribute("User", null);
        carts.clear();
        SanPhamService sanPhamService = new SanPhamService();
        List<SanPham> sanphams = sanPhamService.getAllProduce();
        sanphams.clear();
        req.getSession().setAttribute("products", sanphams);
        req.getSession().setAttribute("carts", carts);
        req.getSession().setAttribute("userLoggedIn", null);
        
        resp.sendRedirect("index.jsp");
    }
    
}
