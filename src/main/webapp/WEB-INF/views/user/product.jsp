<%@page pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/user/template/header.jsp"%>
<!-- / header section -->

<!--  content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
	<img style="height: 305px; width: 100%; object-fit: cover;" src="resources/images/users/banner/sanpham.jpg" alt="banner sản phẩm">
	<div class="aa-catg-head-banner-area">
		<div class="container">
			<div class="aa-catg-head-banner-content">
				<h2>Sản phẩm</h2>
				<ol class="breadcrumb">
					<li><a href="/index.htm">Trang chủ</a></li>
					<li style="color: #fff">Danh sách sản phẩm</li>
				</ol>
			</div>
		</div>
	</div>
</section>
<!-- / catg header banner section -->

<!-- product category -->
<section id="aa-product-category">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
				<div class="aa-product-catg-content">
					<div class="aa-product-catg-body">
						<div>
							<ul style="list-style-type: none; display: inline;">
								<li style="display: inline; margin-left: 50px;">
									<input type="text" placeholder="Tìm kiếm sản phẩm " id="search-san-pham" onkeyup="searchSanPham()" style="width: 300px;">
								</li>
								<li style="display: inline; float: right;"><a href="san-pham.htm" >Bỏ lọc</a></li>
								<li style="display: inline; float: right; margin-right: 20px;"></li>
								<li style="display: inline; float: right; margin-right: 100px;"><a href="san-pham.htm?sortGia" >Giá |</a></li>
								<li style="display: inline; float: right; margin-right: 10px;"><a href="san-pham.htm?sortTen" >Tên |</a></li>
								<li style="display: inline; float: right; margin-right: 10px;"><a href="san-pham.htm?sortMa" >Mã |</a></li>
								<li style="display: inline; float: right; margin-right: 10px;">Sắp xếp theo: </li>
							</ul>
						</div>
						<br>
						<ul class="aa-product-catg"  id="danh-sach-san-pham">
							<!-- start single product item -->
							<c:if test="${empty danhSachSanPham}">
								<p style="margin-left: 30px">Chưa có sản phẩm!</p>
							</c:if>
							<c:forEach items="${danhSachSanPham}" var="prod">
								<li>
									<a hidden="hidden">${prod.maMatHang }</a>
									<a hidden="hidden">${prod.tenMatHang }</a>
									<figure>
										<a class="aa-product-img" href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">
											<c:choose>
												<c:when test="${empty prod.hinhAnh}">
													<img alt="${prod.tenMatHang }" src="resources/images/products/defaultProduct.png" />
												</c:when>
												<c:otherwise>
													<img alt="${prod.tenMatHang }" src="data:image/jpeg;base64,${prod.getBase64Photo() }" />
												</c:otherwise>
											</c:choose>
										</a>
										<form:form class="aa-add-card-btn" action="san-pham.htm?id=${prod.maMatHang }" method="POST">
											<span class="fa fa-shopping-cart"></span><button style="background-color: transparent; border-style: hidden;">Thêm vào giỏ hàng</button>
										</form:form>
										<%-- <a class="aa-add-card-btn" href="san-pham.htm?add-product-cart=${prod.maMatHang}" >
											<span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng
										</a> --%>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">${prod.tenMatHang}</a>
											</h4>
											<c:choose>
												<c:when test="${prod.giamGia.equals(0.0)}">
													<span class="aa-product-price">
														<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" />
													</span>
													<span class="aa-product-price"></span>
												</c:when>
												<c:otherwise>
													<span class="aa-product-price" style="display: block;">
														<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia * (1 - prod.giamGia)}" type="currency" />
													</span>
													<span class="aa-product-price">
														<del>
															<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" />
														</del>
													</span>
												</c:otherwise>
											</c:choose>
										</figcaption>
									</figure> 
									<c:if test="${not empty prod.giamGia}">
										<!-- product badge -->
										<span class="aa-badge aa-sale"> Giảm <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${prod.giamGia}" type="currency" /></span>
									</c:if>
								</li>
							</c:forEach>
						</ul>
						<!-- / quick view modal -->
					</div>

				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
				<aside class="aa-sidebar">
					<!-- single sidebar -->
					<div class="aa-sidebar-widget">
						<h3>Danh mục</h3>
						<ul class="aa-catg-nav">
							<c:forEach items="${danhSachLoaiSanPham}" var="loai">
								<li style="border-bottom: 1px solid #999966;">
									<a href="san-pham.htm?product-type=${loai.maLoai}">${loai.tenLoai}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
					<!-- single sidebar -->

					<!-- single sidebar -->
					<div class="aa-sidebar-widget">
						<h3>Sản phẩm gần đây</h3>
						<div class="aa-recently-views">
							<ul>
								<c:forEach items="${danhSachSanPham}" var="prod" end="9">
									<li>
										<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}" class="aa-cartbox-img">
											<c:choose>
												<c:when test="${empty prod.hinhAnh}">
													<img alt="${prod.tenMatHang }" src="resources/images/products/defaultProduct.png" />
												</c:when>
												<c:otherwise>
													<img alt="${prod.tenMatHang }" src="data:image/jpeg;base64,${prod.getBase64Photo() }" />
												</c:otherwise>
											</c:choose>
										</a>
										<div class="aa-cartbox-info">
											<h4>
												<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}"><p>${prod.tenMatHang}</p></a>
											</h4>
											<c:choose>
												<c:when test="${empty prod.giamGia}">
													<p>
														<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" />
													</p>
												</c:when>
												<c:otherwise>
													<p>
														<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia * (1 - prod.giamGia)}" type="currency" />
													</p>
													<p><del>
														<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" />
													</del></p>
												</c:otherwise>
											</c:choose>
										</div></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- single sidebar -->

				</aside>
			</div>

		</div>
	</div>
</section>
<!-- / product category -->
<!--  end content-->
<script>
	function searchSanPham() {
		var input, filter, ul, li, a, a2, i, txtValue, txtValue2;
		input = document.getElementById('search-san-pham');
		filter = input.value.toUpperCase();
		ul = document.getElementById("danh-sach-san-pham");
		li = ul.getElementsByTagName('li');
		for (i = 0; i < li.length; i++) {
			a = li[i].getElementsByTagName("a")[0];
			a2 = li[i].getElementsByTagName("a")[1];
			txtValue = a.textContent || a.innerText;
			txtValue2 = a2.textContent || a2.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1
					|| txtValue2.toUpperCase().indexOf(filter) > -1) {
				li[i].style.display = "";
			} else {
				li[i].style.display = "none";
			}
		}
	}
</script>
<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->