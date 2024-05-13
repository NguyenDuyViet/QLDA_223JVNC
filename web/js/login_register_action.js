const forms = document.querySelector(".forms"),
pwShowHide = document.querySelectorAll(".eye-icon"),
links = document.querySelectorAll(".link");

pwShowHide.forEach(eyeIcon => {
eyeIcon.addEventListener("click", () => {
  let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll(".password");
  
  pwFields.forEach(password => {
      if(password.type === "password"){
          password.type = "text";
          eyeIcon.classList.replace("bx-hide", "bx-show");
          return;
      }
      password.type = "password";
      eyeIcon.classList.replace("bx-show", "bx-hide");
  })
  
})
})      

links.forEach(link => {
link.addEventListener("click", e => {
 e.preventDefault(); //preventing form submit
 forms.classList.toggle("show-signup");
})
})

document.addEventListener('DOMContentLoaded', function() {
  const closeButton = document.querySelectorAll('.close-icon');

  // Lặp qua từng nút đóng và gắn sự kiện click
  closeButton.forEach(function(icon) {
      icon.addEventListener('click', function() {
          // Tìm phần tử cha của biểu tượng đóng (.close-icon)
          const parentForm = icon.closest('.form');
          const parentForm2 = icon.closest('.form2');
          // Ẩn form hiện tại bằng cách thay đổi thuộc tính display thành "none"

          const confirmClose = confirm("Bạn có muốn thoát không?");
          const reff = document.referrer;

          if(confirmClose){
            if (parentForm || parentForm2) {
              // window.location.href = targetPage;
              if(reff.includes('index.jsp')){
                window.location.href = 'index.jsp'; // Đang ở trang index.html
              } else if (reff.includes('shop.jsp')) {
                  window.location.href = 'shop.jsp'; // Đang ở trang shop.html
                } else if (reff.includes('cart.jsp')){
                    window.location.href = 'cart.jsp'; //Đang ở trang cart.html
                  } else if (reff.includes('chackout.jsp')){
                      window.location.href = 'chackout.jsp'; //Đang ở trang chackout.html
                    } else if (reff.includes('contact.jsp')){
                        window.location.href = 'contact.jsp'; //Đang ở trang contact.html
                      } else if (reff.includes('shop-detail.jsp')){
                          window.location.href = 'shop-detail.jsp'; //Đang ở trang shop-detail.html
                        } else if (reff.includes('testimonial.jsp')){
                            window.location.href = 'testimonial.jsp'; //Đang ở trang testimonial.html
                          }
              else {
                  window.location.href = 'index.jsp'; // Mặc định sẽ điều hướng về index.html nếu không xác định được trang hiện tại
              }
            }
          }
          else{
            event.preventDefault();
          }
        
      });
    
  });

  // Xử lý chuyển đổi giữa form đăng nhập và đăng ký khi nhấp vào các liên kết tương ứng
  const loginLink = document.querySelector('.login-link');
  const signupLink = document.querySelector('.signup-link');
  const loginForm = document.querySelector('.login');
  const signupForm = document.querySelector('.signup');

  if (loginLink && signupLink && loginForm && signupForm) {
      // Chuyển sang form đăng ký khi nhấp vào liên kết Đăng ký
      signupLink.addEventListener('click', function(event) {
          event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
          loginForm.style.display = 'none';
          signupForm.style.display = 'block';
      });

      // Chuyển sang form đăng nhập khi nhấp vào liên kết Đăng nhập
      loginLink.addEventListener('click', function(event) {
          event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
          signupForm.style.display = 'none';
          loginForm.style.display = 'block';
      });
  }
});