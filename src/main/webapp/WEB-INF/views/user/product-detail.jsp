<%@page pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/user/template/header.jsp"%>
<!-- / header section -->
<!--  content -->
<c:if test="${empty sanPham }">
	<p>Không tìm thấy sản phẩm</p>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</c:if>
<c:if test="${not empty sanPham }">
	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img style="height: 305px; width: 100%; object-fit: cover;" src="resources/user/assets/images/banner-website.jpg" alt="banner sản phẩm">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>Chi tiết sản phẩm</h2>
					<ol class="breadcrumb">
						<li><a href="index.htm">Trang chủ</a></li>
						<li><a href="san-pham.htm">Sản phẩm</a></li>
						<li style="color: #fff">${sanPham.tenMatHang }</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- / catg header banner section -->

	<!-- product category -->
	<section id="aa-product-details">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-product-details-area">
						<div class="aa-product-details-content">
							<div class="row">
								<!-- Modal view slider -->
								<div class="col-md-5 col-sm-5 col-xs-12">
									<div class="aa-product-view-slider">
										<div id="demo-1" class="simpleLens-gallery-container">
											<div class="simpleLens-container">
												<div class="simpleLens-big-image-container">
													<c:choose>
														<c:when test="${empty sanPham.hinhAnh}">
															<a data-lens-image="resources/images/products/defaultProduct.png"
																class="simpleLens-lens-image">
															<img src="resources/images/products/defaultProduct.png"
																class="simpleLens-big-image"></a>
														</c:when>
														<c:otherwise>
															<a data-lens-image="data:image/jpeg;base64,${sanPham.getBase64Photo() }"
																class="simpleLens-lens-image">
															<img src="data:image/jpeg;base64,${sanPham.getBase64Photo() }"
																class="simpleLens-big-image"></a>
														</c:otherwise>
													</c:choose>
												</div>
											</div>

										</div>
									</div>
								</div>
								<!-- Modal view content -->

								<div class="col-md-7 col-sm-7 col-xs-12">
									<div class="aa-product-view-content">
									<form:form action="chi-tiet-san-pham.htm?id=${sanPham.maMatHang }" method="post">
										<h2>${sanPham.tenMatHang }</h2>
										<div class="aa-price-block">
											<c:choose>
												<c:when test="${empty sanPham.giamGia}">
													<span class="label-item danger">
														<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${sanPham.gia }" type="currency" />
													</span>
													<span class="aa-product-price"></span>
												</c:when>
												<c:otherwise>
													<span class="label-item danger" >
														<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${sanPham.gia }" type="currency" />
													</span>
													<span class="label-item warning">
														Giảm ngay - <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${sanPham.giamGia}" />
													</span>
												</c:otherwise>
											</c:choose>
											<p class="aa-product-avilability">
												Tình trạng:
												<span>
													<c:choose>
														<c:when test="${sanPham.soLuong != 0}">
															<c:out value="Còn hàng" />
														</c:when>
														<c:otherwise>
															<c:out value="Hết hàng" />
														</c:otherwise>
													</c:choose>
												</span>
											</p>
										</div>
										<p>Mô tả ngắn: ${sanPham.moTaNgan}</p>
										<div class="aa-prod-quantity">
											<p class="aa-prod-category">
												<%-- <c:forEach items="${name_cate_of_product}" var="name_cate">
													<strong>Loại sản phẩm:</strong>
													<a href="product.jsp"><span class="label-item info">${name_cate.name }</span></a>
												</c:forEach> --%>
												<strong>Loại sản phẩm:</strong>
												<a href="san-pham.htm?product-type=${sanPham.maLoai }"><span class="label-item info">${sanPham.maLoai }</span></a>
											</p>
										</div>
										<div class="aa-prod-view-bottom">
											<button name="add-cart-id" class="aa-add-to-cart-btn btn btn-light" >
												Thêm vào giỏ hàng
											</button>
											<%-- <a "
												href="gio-hang.htm?product-id=${sanPham.maMatHang}"></a> --%>
										</div>
									</form:form>
									</div>
								</div>
							</div>

						</div>
						<div class="aa-product-details-bottom">
							<ul class="nav nav-tabs aa-products-tab" id="myTab2">
								<li class="active"><a href="#description" data-toggle="tab"
									class="">Mô tả</a></li>
								<li><a href="#review" data-toggle="tab">Đánh giá</a></li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane fade in active" id="description">
									<p>${sanPham.moTa }</p>
								</div>
								<div class="tab-pane fade " id="review">
									<div class="aa-product-review-area">
										<ul class="aa-review-nav">
											<c:forEach items="${reviewbyid}" var="review">
												<li>
													<div class="media">
														<div class="media-body">
															<h4 class="media-heading">
																<strong>${review.name}</strong> - <span>${review.created}</span>
															</h4>
															<div class="aa-product-rating">
																<span class="fa fa-star"></span> <span
																	class="fa fa-star"></span> <span class="fa fa-star"></span>
																<span class="fa fa-star"></span> <span
																	class="fa fa-star"></span>
															</div>
															<p>${review.content}</p>
														</div>
													</div>
												</li>
											</c:forEach>
										</ul>
										<h4>Thêm đánh giá</h4>

										<!-- review form -->
										<form action="danh-gia?id=${sanPham.maMatHang}" method="post" class="aa-review-form">
											<div class="form-group">
												<label for="name">Tên</label>
												<input type="text" class="form-control" id="name" placeholder="Name" name="name">
											</div>
											<div class="form-group">
												<label for="email">Email</label>
												<input type="email" class="form-control" id="email" placeholder="example@gmail.com" name="email">
											</div>
											<div class="form-group">
												<label for="message">Đánh giá của bạn</label>
												<textarea class="form-control" rows="3" id="content" name="content"></textarea>
											</div>

											<button type="submit" class="btn btn-default aa-review-submit">Gửi</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- Related product -->
						<div class="aa-product-related-item">
							<h3>SẢN PHẨM LIÊN QUAN</h3>
							<ul class="aa-product-catg aa-related-item-slider">
								<!-- start single product item -->
								<c:forEach items="${danhSachSanPham}" var="prod" end="10">
									<li>
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
											<%-- <a class="aa-add-card-btn" href="gio-hang.htm?product-id=${prod.maMatHang}">
												<span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng
											</a> --%>
											<figcaption>
												<h4 class="aa-product-title">
													<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">${prod.tenMatHang}</a>
												</h4>
												<c:choose>
													<c:when test="${empty prod.giamGia}">
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
										<c:if test="${not empty prod.giamGia }">
											<!-- product badge -->
											<span class="aa-badge aa-sale"> Giảm <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${prod.giamGia}" type="currency" /></span>
										</c:if>
									</li>
								</c:forEach>
								<!-- start single product item -->
							</ul>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / product category -->
</c:if>
<!--  end content-->
<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->


