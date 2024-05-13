<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                        <div class="d-flex m-3 me-0">
                            <button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4" data-bs-toggle="modal" data-bs-target="#searchModal"><i class="fas fa-search text-primary"></i></button>
                            <a href="#" class="position-relative me-4 my-auto">
                                <i class="fa fa-shopping-bag fa-2x"></i>
                                <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">3</span>
                            </a>
                            
                            <c:if test="${sessionScope.userLoggedIn != null}">
                                <a href="" class="my-auto">
                                    <i id="userIcon" class="fas fa-user fa-2x"></i>
                                </a>
                            </c:if>
                                    
                            <c:if test="${sessionScope.userLoggedIn == null}">
                                <a href="login_register_form.html" class="my-auto">
                                    <i id="plusIcon" class="fas fa-plus fa-2x"></i>
                                </a>
                                </c:if>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Navbar End -->