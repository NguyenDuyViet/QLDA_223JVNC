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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import shopbandogiadung.Service.UserService;
import shopbandogiadung.model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/Singup"})
public class SingupServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Ho = req.getParameter("ho");
        String Ten = req.getParameter("ten");
        String SDT = req.getParameter("sdt");
        String email = req.getParameter("email");
        String diachi = req.getParameter("diachi");
        String matkhau = req.getParameter("matkhau");
        
        User user = new User();
        UserService userService = new UserService();
        
        user.setHo(Ho);
        user.setTen(Ten);
        user.setSDT(SDT);
        user.setEmail(email);
        user.setDiaChi(diachi);
        user.setMatKhau(matkhau);
        if(!userService.checkSignup(email, SDT)){
            userService.addUser(user);
        
            resp.sendRedirect("Login-Signup.jsp?signupSuccess=true");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("exist", "false");
            resp.sendRedirect("Login-Signup.jsp?signupSuccess=false");
        }
    }
    
}
