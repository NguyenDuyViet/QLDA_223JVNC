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
import shopbandogiadung.Service.UserService;
import shopbandogiadung.model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  String.valueOf(req.getParameter("username"));
        String password = req.getParameter("password");
        
        UserService userService = new UserService();
        User user = userService.findUser(username, password);
        if (user != null) {
            // Tạo cookie khi đăng nhập thành công
            req.getSession().setAttribute("userLoggedIn", user);
        }
        
        // Chuyển hướng người dùng sau khi đăng nhập (ví dụ: về trang chủ)
        resp.sendRedirect("Home.jsp");
    }
    
}
