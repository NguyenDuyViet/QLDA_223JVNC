<%-- 
    Document   : information
    Created on : May 14, 2024, 11:33:18 PM
    Author     : ADMIN
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User-information</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/information.css">

    <!-- Boxicons CSS -->
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>

</head>
<body style="background-image: url(<%= request.getContextPath() %>/images/household_appliances.jpg);">
<section class="container forms">
    <div class="form login">
        <div class="form-content">
            <div class="avatar">
                <img src="images/mesi.jpg" alt="Avatar">
            </div>
            <span class="close-icon">
                        <div class="bx bx-x"></div>
                    </span>
            <form action="#">
                <h1>Thông tin người dùng</h1>
                <div class="user-info">
                    <p><label><c:out value="${User.getHo()}"/> <c:out value="${User.getTen()}"/></label></p><br>
                    <p><label>Email: <c:out value="${User.getEmail()}"/></label></p><br>
                    <p><label>Số điện thoại: <c:out value="${User.getSDT()}"/></label></p><br>
                    <p><label>Địa chỉ: <c:out value="${User.getDiaChi()}"/></label></p><br>
                    
                </div>
                <div class="field button-field">
                  <a href="/SHOPBANDOGIADUNG/LogoutServlet" id="link" >Đăng xuất</a>
                </div>
                
            </form>

        </div>

        
    </div>

    
    </div>
</section>

<!-- JavaScript -->
<script src="<%= request.getContextPath() %>/js/login_register_action.js"></script>
</body>
</html>
