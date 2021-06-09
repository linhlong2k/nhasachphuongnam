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
        <h2>Đăng ký</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>                   
          <li style="color:#fff">Đăng ký tài khoản</li>
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
                <div class="aa-myaccount-register">                 
                 <h4>Đăng ký</h4>
                 <form name="formRegister" class="aa-login-form" method="post" action="${pageContext.request.contextPath}/view/client/register" >
                    <label for="">Họ tên<span>*</span></label>
                    <input type="text" placeholder="Name" name="name">
                    <div style="color:red;">${messages.name}</div>   
                     <label for="">Email <span>*</span></label>
                    <input type="email" placeholder="useremail@gmail.com" name="email">
                    <div style="color:red;">${messages.email}</div>
                    <label for="">Số điện thoại<span>*</span></label>
                    <input type="text" placeholder="Số điện thoại" name="phone">
                    <div style="color:red;">${messages.phone}</div>   
                     <label for="">Username<span>*</span></label>
                    <input type="text" placeholder="Username" name="username">
                    <div style="color:red;">${messages.username}</div> 
                    <label for="">Mật khẩu<span>*</span></label>  
                    <input type="password" placeholder="Password" name="password"> 
                    <div style="color:red;">${messages.password}</div>
                    <input type="date" style="display: none" placeholder="Password" name="created" id="the-date">             
                      
                    <p style="color:#00dac3; display: block; font-size: 25px;"><%=(request.getAttribute("errMessage") == null) ? ""
        			: request.getAttribute("errMessage")%></p>
			        <p style="color:#0ede25; display: block; font-size: 25px;"><%=(request.getAttribute("Message") == null) ? ""
			        : request.getAttribute("Message")%></p>      
			         <button type="reset" class="aa-browse-btn" value="Reset">Đặt lại</button>  
                      <button type="submit" class="aa-browse-btn">Đăng ký</button>                         
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
  
  
