<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
<!--  content -->
 <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
  <img style="height: 305px; width: 100%; object-fit: cover;" src="${pageContext.request.contextPath}/view/client/assets/images/banner-website.jpg" alt="banner sản phẩm">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Đăng nhập</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>                   
          <li style="color:#fff">Đăng nhập</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-8 col-md-push-2">
                <div class="aa-myaccount-login">
                <h4>Đăng nhập</h4>
                 <form class="aa-login-form login-form" name="loginform" onsubmit="validate();" action="${pageContext.request.contextPath}/view/client/login" method="post">
                 <!-- <label for="">Username<span>*</span></label>
                   <input type="text" placeholder="Username" name="username">
                   <label for="">Mật khẩu<span>*</span></label>
                    <input type="password" placeholder="Password" name="password"> -->
                    <input class="input-login" type="text" name="username" placeholder="Username" />
					  <div class="input-icon">
					    <input class="input-login" type="password" name="password" placeholder="Password" />
					    <i class="fa fa-eye show-password"></i>
					  </div>
                    <p class="rememberme" style="display: block"><input type="checkbox" id="rememberme"> Ghi nhớ </p> 
     
                    <p style="color:red; display:block">
		                ${errorMsg}
		            </p>
		             <button type="submit" class="aa-browse-btn">Đăng nhập</button>
		                
                  </form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

<!--  end content-->
   <script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
</script>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
  
  
