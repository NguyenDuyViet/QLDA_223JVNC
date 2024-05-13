/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import shopbandogiadung.Service.SanPhamService;
import shopbandogiadung.Service.UserService;
import shopbandogiadung.model.SanPham;
import shopbandogiadung.model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        

        if (userService.checkLogin(username, password)) {
            SanPhamService sanPhamService = new SanPhamService();
            List<SanPham> sanphams = sanPhamService.getAllProduce();
            
            req.getSession().setAttribute("userLoggedIn", username);
            req.getSession().setAttribute("products", sanphams);
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("login_register_form.html?error=true");
        }
    }
}
