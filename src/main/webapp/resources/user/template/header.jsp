<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="Trang Client" />
	<meta name="author" content="Nhóm 33" />
	<title>Nhà sách Phương Nam</title>
	<!-- base -->
	<base href="${pageContext.servletContext.contextPath }/">
	<base href="${pageContext.request.contextPath }/">
	<!-- set Icon browser -->
	<link rel="icon" href="resources/images/logo.png">
	<!-- Font awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css" >
	<link href="resources/user/assets/css/font-awesome.css" rel="stylesheet">
	<!-- Bootstrap -->
	<link href="resources/user/assets/css/bootstrap.css" rel="stylesheet">
	<link rel="icon" href="resources/images/logo.png">
	<!-- SmartMenus jQuery Bootstrap Addon CSS -->
	<link href="resources/user/assets/css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
	<!-- Product view slider -->
	<link rel="stylesheet" type="text/css" href="resources/user/assets/css/jquery.simpleLens.css">
	<!-- slick slider -->
	<link rel="stylesheet" type="text/css" href="resources/user/assets/css/slick.css">
	<!-- price picker slider -->
	<link rel="stylesheet" type="text/css" href="resources/user/assets/css/nouislider.css">
	<!-- Theme color -->
	<link id="switcher" href="resources/user/assets/css/theme-color/default-theme.css" rel="stylesheet">
	<!-- Top Slider CSS -->
	<link href="resources/user/assets/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
	<!-- Main style sheet -->
	<link href="resources/user/assets/css/style.css" rel="stylesheet">
	<!-- Google Font -->
	<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
	<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body style="background-color: #f5f5f0">
<!-- ========================chưa biết tác dụng =================== -->
	<!--Start of Tawk.to Script-->
	<!--Start of Tawk.to Script-->
	<!-- <script type="text/javascript">
		var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
		(function() {
			var s1 = document.createElement("script"), s0 = document
					.getElementsByTagName("script")[0];
			s1.async = true;
			s1.src = 'https://embed.tawk.to/5ffbb9f4a9a34e36b96aff55/1ernksp6m';
			s1.charset = 'UTF-8';
			s1.setAttribute('crossorigin', '*');
			s0.parentNode.insertBefore(s1, s0);
		})();
	</script> -->
	<!--End of Tawk.to Script-->
	<!--End of Tawk.to Script-->
<!-- ================================================================ -->
	<header id="aa-header">
		<!-- start header top  -->
		<div class="aa-header-top">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-header-top-area">
							<!-- start header top left -->
							<div class="aa-header-top-left">
								<div class="cellphone hidden-xs">
									<p>
										<span class="fas fa-home"></span>Nhà sách Phương Nam
									</p>
								</div>
								<!-- start language -->
								<div class="aa-language">
									<div class="dropdown">
										<a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
											<img src="resources/user/assets/img/flag/vietnam.png" alt="lá cờ Việt Nam">
											Việt Nam
										</a>
									</div>
								</div>
								<!-- / language -->

								<!-- start cellphone -->
								<div class="cellphone hidden-xs">
									<p>
										<span class="fa fa-phone"></span>0123456789
									</p>
								</div>
								<!-- / cellphone -->
							</div>
							<!-- / header top left -->
<!-- 							======================================================================checklogin=============================================================== -->
							<div class="aa-header-top-right">
								<ul class="aa-head-top-nav-right">
									<c:choose>
										<c:when test="${empty user.ma }">
											<li class="hidden-xs">
												<a href="dang-ky.htm">Đăng ký</a>
											</li>
											<li>
												<a href="dang-nhap.htm">Đăng nhập</a>
											</li>
										</c:when>
										<c:otherwise>
											<li><a href="thong-tin-ca-nhan.htm"><strong>Chào</strong> ${user.ten }</a></li>
											<li class="hidden-xs">
												<a href="dang-xuat.htm">Đăng xuất</a>
											</li>
										</c:otherwise>
									</c:choose>
									<!--  data-toggle="modal" data-target="#login-modal" -->
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- / header top  -->
		<!-- start header bottom  -->
		<div class="aa-header-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-header-bottom-area">
							<!-- logo  -->
							<div class="aa-logo">
								<!-- Text based logo -->
								<!-- <a href="index.jsp">
                  					<span class="fa fa-shopping-cart"></span>
                  					<p>daily<strong>Shop</strong> <span>Your Shopping Partner</span></p>
                				</a>-->
								<!-- img based logo -->
								<a href=".htm"><img
									src="resources/images/Logonhasachphuongnam.png" alt="logo img" width="100%"></a>
							</div>
							<!-- / logo  -->
							<!-- Shipping service -->
							<div class="aa-shipping-box">
								<a class="aa-shipping-boxsmall">
									<span class="aa-shipping-boxsmall-icon fas fa-exchange-alt"></span>
									<span class="aa-shipping-box-text">
											<div class="aa-shipping-title">Miễn phí vận chuyển</div>
											<div class="aa-shipping-title-sub">Khu vực TP HCM</div>
									</span>
								</a>
								<a class="aa-shipping-boxsmall">
									<span class="aa-shipping-boxsmall-icon fas fa-phone"></span>
									<span class="aa-shipping-box-text">
										<div class="aa-shipping-title">Hỗ trợ: 0123.456.789</div>
										<div class="aa-shipping-title-sub">Tư vấn 24/7 miễn phí</div>
									</span>
								</a>
								<a class="aa-shipping-boxsmall">
									<span class="aa-shipping-boxsmall-icon fas fa-shipping-fast"></span>
									<span class="aa-shipping-box-text">
										<div class="aa-shipping-title">Giao hàng toàn quốc</div>
										<div class="aa-shipping-title-sub">Đảm bảo uy tín, chất lượng</div>
									</span>
								</a>
							</div>
							<!-- cart box -->
							<div class="aa-cartbox">
								<a class="aa-cart-link" href="gio-hang.htm">
									<span class="fas fa-cart-arrow-down"></span>
									<span class="aa-cart-title">GIỎ HÀNG</span>
									<span class="aa-cart-notify">${gioHang.size() }</span>
									<%-- <c:if test="${length_order != null }">
										<span class="aa-cart-notify">${length_order}</span>
									</c:if> --%>
								</a>
								<%-- <div class="aa-cartbox-summary">
                  <ul class="scroll-product">
                  <c:forEach items="abc" var="item" >
                    <li>
                      <a class="aa-cartbox-img" href="${pageContext.request.contextPath}/view/client/cart">
                      	<img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${item.product.image_link}" alt="img">
                      </a>
                      <div class="aa-cartbox-info">
                        <h4><a href="${pageContext.request.contextPath}/view/client/cart">${item.product.name}</a></h4>
                        <p>${item.qty} x ${item.product.price * (1-((item.product.discount)/100))}00 VNĐ</p>
                      </div>
                    </li>
                   	</c:forEach>               
                  </ul>
                  <div class="total-detailproduct">
                  		<span class="aa-cartbox-total-title">
                        <b>Tổng:</b>
                      </span>
                      <span class="aa-cartbox-total-price">
                        ${sumprice} VNĐ
                      </span>
                  </div>
                  <a class="aa-cartbox-checkout aa-primary-btn" href="${pageContext.request.contextPath}/view/client/cart">Chi tiết</a>
                  <a class="aa-cartbox-checkout aa-primary-btn" href="${pageContext.request.contextPath}/view/client/checkout">Thanh toán</a>
                </div>
              </div> --%>
								<!-- / cart box -->

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

			<!-- / header bottom  -->
	</header>

	<!-- menu -->
	<section id="menu">
		<div class="container">
			<div class="menu-area">
				<!-- Navbar -->
				<div class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
								<span class="icon-bar"></span>
						</button>
					</div>
					<div class="navbar-collapse collapse">
						<!-- Left nav -->
						<ul class="nav navbar-nav">
							<li>
								<a href="index.htm">TRANG CHỦ</a>
							</li>
							<li>
								<a href="gioi-thieu.htm">GIỚI THIỆU</a>
							</li>
							<li>
								<a href="san-pham.htm">SẢN PHẨM </a>
							</li>
							<!-- <li>
								<a href="tin-tuc.htm">TIN TỨC</a>
							</li> -->
							<li>
								<a href="chinh-sach.htm">CHÍNH SÁCH</a>
							</li>
							<li>
								<a href="lien-he.htm">LIÊN HỆ</a>
							</li>
							<!-- <li class="aa-search">
								search box 
								<a class="aa-search-box">
									<form action="tim-kiem.htm" method="GET" >
										<input type="text" name="s" id="" placeholder="Tìm kiếm sản phẩm..">
										<button class="serach-box">
											<span class="fa fa-search"></span>
										</button>
									</form>
								</a>
							</li> -->
						</ul>
					</div>
					<!--/.nav-collapse -->

				</div>
			</div>
		</div>
	</section>

	<!-- / menu -->


	<!-- wpf loader Two
         <div id="wpf-loader-two">          
            <div class="wpf-loader-two-inner">
              <span>Hệ thống đang tải...</span>
            </div>
          </div>  -->
	<!-- / wpf loader Two SCROLL TOP BUTTON
		<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
	END SCROLL TOP BUTTON  -->