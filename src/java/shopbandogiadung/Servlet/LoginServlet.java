/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import shopbandogiadung.Service.UserService;
import shopbandogiadung.model.TKUser;

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
        
        // Kiểm tra thông tin đăng nhập (đây chỉ là ví dụ đơn giản)
        boolean loginSuccess = checkLogin(username, password);
        
        if (loginSuccess) {
            // Tạo cookie khi đăng nhập thành công
            Cookie loginCookie = new Cookie("userLoggedIn", "true");
            loginCookie.setMaxAge(24 * 60 * 60); // Thời gian sống của cookie: 1 ngày
            resp.addCookie(loginCookie);
        }
        
        // Chuyển hướng người dùng sau khi đăng nhập (ví dụ: về trang chủ)
        resp.sendRedirect("index.jsp");
    }
    private boolean checkLogin(String username, String password) {
        UserService userService = new UserService();
        ArrayList<TKUser> tkUsers = userService.getAllTKUser();
        for(TKUser tkuser : tkUsers){
            if(tkuser.getSdt().equals(username)){
                if(tkuser.getPassword().equals(password)){
                    return true;
                }
            }else if(tkuser.getEmail().equals(username)){
                if(tkuser.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
}
