<%-- 
    Document   : cart
    Created on : May 11, 2024, 9:11:37 PM
    Author     : ADMIN
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/includes/header.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container px-0">
    <nav class="navbar navbar-light bg-white navbar-expand-xl">
        <a href="index.jsp" class="navbar-brand"><h1 class="text-primary display-6">Shop Real</h1></a>
        <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="fa fa-bars text-primary"></span>
        </button>
        <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
            <div class="navbar-nav mx-auto">
                <a href="index.jsp" class="nav-item nav-link">Trang chủ</a>
                <a href="shop.jsp" class="nav-item nav-link">Cửa hàng</a>
                <a href="shop-detail.jsp" class="nav-item nav-link">Chi tiết</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown">Trang</a>
                    <div class="dropdown-menu m-0 bg-secondary rounded-0">
                        <a href="cart.jsp" class="dropdown-item active">Giỏ hàng</a>
                        <a href="chackout.jsp" class="dropdown-item">Thủ tục thanh toán</a>
                        <a href="testimonial.jsp" class="dropdown-item">Cam kết</a>
                    </div>
                </div>
                <a href="contact.jsp" class="nav-item nav-link">Liên hệ</a>
            </div>
            <%@include file="/includes/Icon.jsp" %>


            <!-- Modal Search Start -->
            <div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-fullscreen">
                    <div class="modal-content rounded-0">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Nhập tên sản phẩm</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body d-flex align-items-center">
                            <div class="input-group w-75 mx-auto d-flex">
                                <input type="search" class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                                <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal Search End -->


            <!-- Single Page Header start -->
            <div class="container-fluid page-header py-5">
                <h1 class="text-center text-white display-6">Giỏ hàng</h1>
                <ol class="breadcrumb justify-content-center mb-0">
                    <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="#">Trang</a></li>
                    <li class="breadcrumb-item active text-white">Giỏ hàng</li>
                </ol>
            </div>
            <!-- Single Page Header End -->


            <!-- Cart Page Start -->
            <div class="container-fluid py-5">
                <div class="container py-5">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Sản phẩm</th>
                                    <th scope="col">Tên</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Tổng</th>
                                    <th scope="col">Xử lý</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.carts}" var="cart">
                                <tr>
                                <th scope="row">
                                    <div class="d-flex align-items-center">
                                        <img src="<c:out value="${cart.getImageProduct()}"/>" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="">
                                    </div>
                                </th>
                                <td>
                                    <p class="mb-0 mt-4"><c:out value="${cart.getTenSanPham()}"/></p>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4"><c:out value="${cart.getGiaBan()}"/>đ</p>
                                </td>
                                <td>
                                    <div class="input-group quantity mt-4" style="width: 100px;">
                                        <div class="input-group-btn">
                                            <a href="/SHOPBANDOGIADUNG/removeProduce?maSP=<c:out value="${cart.getMaSanPham()}"/>" class="btn btn-sm btn-minus rounded-circle bg-light border" >
                                                <i class="fa fa-minus"></i>
                                            </a>
                                        </div>
                                        <input type="text" class="form-control form-control-sm text-center border-0" value="<c:out value="${cart.getSoLuongCart()}"/>">
                                        <div class="input-group-btn">
                                            <a href="/SHOPBANDOGIADUNG/addProduce?maSP=<c:out value="${cart.getMaSanPham()}"/>" class="btn btn-sm btn-plus rounded-circle bg-light border">
                                                <i class="fa fa-plus"></i>
                                            </a>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4"><c:out value="${cart.getTongTienCart()}"/></p>
                                </td>
                                <td>
                                    <a href="/SHOPBANDOGIADUNG/deleteProduce?maSP=<c:out value="${cart.getMaSanPham()}"/>" class="btn btn-md rounded-circle bg-light border mt-4" >
                                        <i class="fa fa-times text-danger"></i>
                                    </a>
                                </td>

                            </tr>
                            </c:forEach>  

                            </tbody>
                        </table>
                    </div>
                    <div class="mt-5">
                        <input type="text" class="border-0 border-bottom rounded me-5 py-3 mb-4" placeholder="Coupon Code">
                        <button class="btn border-secondary rounded-pill px-4 py-3 text-primary" type="button">Mã giảm giá</button>
                    </div>
                    <div class="row g-4 justify-content-end">
                        <div class="col-8"></div>
                        <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
                            <div class="bg-light rounded">
                                <div class="p-4">
                                    <h1 class="display-6 mb-4">Giỏ hàng <span class="fw-normal">Tổng tiền</span></h1>
                                    <div class="d-flex justify-content-between mb-4">
                                        <h5 class="mb-0 me-4">Tổng phụ:</h5>
                                        <p class="mb-0">90.000đ</p>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <h5 class="mb-0 me-4">Đang vận chuyển</h5>
                                        <div class="">
                                            <p class="mb-0">Giá cố định: 28.331.000đ</p>
                                        </div>
                                    </div>
                                    <p class="mb-0 text-end">Vận chuyển đến Đà Nẵng</p>
                                </div>
                                <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                                    <h5 class="mb-0 ps-4 me-4">Tổng tiền</h5>
                                    <p class="mb-0 pe-4">28.421.000đ</p>
                                </div>
                                <button class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4" type="button">Thanh toán</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Cart Page End -->


            <%@include file="/includes/footer.jsp" %>
