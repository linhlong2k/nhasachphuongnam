<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/user/template/header.jsp" %>

<!-- 	=======================================================slide ngang==================================================== -->
	<section id="aa-slider">
		<div class="aa-slider-area">
			<div id="sequence" class="seq">
				<div class="seq-screen">
					<ul class="seq-canvas">
						<!-- single slide item -->
						<li>
							<div class="seq-model">
								<img data-seq src="resources/images/users/banner/bannerIndex1.jpg" alt="Ảnh Banner" />
							</div>
							<!-- <div class="seq-title">
								<span data-seq style="background: transparent;"></span> Thẻ giảm giá
								<h2 data-seq style="background: transparent;"></h2>	Thẻ title
								<h2 data-seq style="background: transparent;"></h2>	Thẻ title
								<a data-seq href="san-pham.htm" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div> -->
						</li>
						<!-- single slide item -->
						<li>
							<div class="seq-model">
								<img data-seq src="resources/images/users/banner/bannerIndex2.jpg"
									alt="Ảnh Banner" />
							</div>
							<!-- <div class="seq-title">
								<span data-seq style="background: transparent;"></span>
								<h2 data-seq style="background: transparent;"></h2>
								<h2 data-seq style="background: transparent;"></h2>
								<a data-seq href="san-pham.htm" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div> -->
						</li>
						<!-- single slide item -->
						<li>
							<div class="seq-model">
								<img data-seq src="resources/images/users/banner/bannerIndex4.jpg" alt="Ảnh Banner" />
							</div>
							<!-- <div class="seq-title">
								<span data-seq style="background: transparent;"></span>
								<h2 data-seq style="background: transparent;"></h2>
								<h2 data-seq style="background: transparent;"></h2>
								<a data-seq href="san-pham.htm" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div> -->
						</li>
						<!-- single slide item -->
						<li>
							<div class="seq-model">
								<img data-seq src="resources/images/users/banner/bannerIndex5.jpg" alt="Ảnh Banner" />
							</div>
							<!-- <div class="seq-title">
								<span data-seq style="background: transparent;"></span>
								<h2 data-seq style="background: transparent;"></h2>
								<h2 data-seq style="background: transparent;"></h2>
								<a data-seq href="san-pham.htm" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div> -->
						</li>
					</ul>
				</div>
				<!-- slider navigation btn -->
				<fieldset class="seq-nav" aria-controls="sequence" aria-label="Slider buttons">
					<a type="button" class="seq-prev" aria-label="Previous">
						<span class="fa fa-angle-left"></span>
					</a>
					<a type="button" class="seq-next" aria-label="Next">
						<span class="fa fa-angle-right"></span>
					</a>
				</fieldset>
			</div>
		</div>
	</section>
<!-- 	=================================================================ô quảng cáo===================================================== -->
	<!-- Start Promo section -->
	<section id="aa-promo">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-promo-area">
						<div class="row">
							<!-- promo left -->
							<div class="col-md-5 no-padding">
								<div class="aa-promo-left">
									<div class="aa-promo-banner">
										<img src="resources/images/users/banner/Sach_hay_PN__2__cs.png" alt="ảnh chính">
										<div class="aa-prom-content">
											<span style="font-size: 24px;">Sách hay Phương Nam<br>-<br>Giảm giá lên đến 50%</span>
											<h4></h4>
										</div>
									</div>
								</div>
							</div>
							<!-- promo right -->
							<div class="col-md-7 no-padding">
								<div class="aa-promo-right">
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/images/users/banner/1.Vui_Hè_Qua_Thế_Giới_Muôn_Màu.png" alt="ảnh phụ 1">
											<div class="aa-prom-content">
												<span style="font-size: 24px;">Vui hè qua thế giới muôn màu</span>
												<h4></h4>
											</div>
										</div>
									</div>
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/images/users/banner/2.Đọc_Cả_Mùa_Hè.png" alt="ảnh phụ 2">
											<div class="aa-prom-content">
												<span style="font-size: 24px;">Đọc cả mùa hè</span>
												<h4></h4>
											</div>
										</div>
									</div>
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/images/users/banner/3.Ghép_Hình_Cho_Cả_Nhà_Cùng_Vui.png" alt="ảnh phụ 3">
											<div class="aa-prom-content">
												<span style="font-size: 24px;">Đồ chơi cho bé</span>
												<h4></h4>
											</div>	
										</div>
									</div>
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/images/users/banner/4.Chơi_Hè_Bổ_Ích.png" alt="ảnh phụ 4">
											<div class="aa-prom-content">
												<span style="font-size: 24px;">Chơi hè bổ ích</span>
												<h4></h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Promo section -->
	<!-- Products section -->
	<section id="aa-product">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="aa-product-area">
							<div class="aa-product-inner">
								<!-- start prduct navigation -->
								<div class="more-product">
									<a class="aa-browse-btn btn btn-light"
										href="san-pham.htm">Xem Tất Cả Sản Phẩm <span class="fa fa-long-arrow-right"></span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Products section -->
	<!-- banner section -->
	<section id="aa-banner">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="aa-banner-area">
							<a href="san-pham.htm"><img src="resources/images/users/banner/bannerVanPhongPham.jpg" alt="banner văn phong phẩm"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- popular section -->
	<section id="aa-popular-category">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="aa-popular-category-area">
							<!-- start prduct navigation -->
							<ul class="nav nav-tabs aa-products-tab">
								<li class="active"><a href="#sanphammoi" data-toggle="tab">Sản Phẩm Mới</a></li>
								<li><a href="#sanphambanchay" data-toggle="tab">Sản Phẩm Bán Chạy</a></li>
								<li><a href="#sanphamgiamgia" data-toggle="tab">Sản Phẩm Giảm Giá</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
								<!-- Start men popular category -->
								<div class="tab-pane fade in active" id="sanphammoi">
									<ul class="aa-product-catg aa-popular-slider">
										<!-- start single product item -->
										<c:forEach items="${danhSachSanPham}" var="prod" end="12">
                        					<li>
												<figure>
													<a class="aa-product-img" href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">
														<%-- <img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}"
														 alt="polo shirt img"> --%>
														<c:choose>
															<c:when test="${empty prod.hinhAnh}">
																<img alt="${prod.tenMatHang }" src="resources/images/products/defaultProduct.png" />
															</c:when>
															<c:otherwise>
																<img alt="${prod.tenMatHang }" src="data:image/jpeg;base64,${prod.getBase64Photo() }" />
															</c:otherwise>
														</c:choose>
													</a>
													<figcaption>
														<h4 class="aa-product-title">
															<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">${prod.tenMatHang }</a>
														</h4>
														<c:choose>
															<c:when test="${prod.giamGia == 0}">
																<span class="aa-product-price"> <fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" /></span>
																<span class="aa-product-price"></span>
															</c:when>
															<c:otherwise>
																<span class="aa-product-price"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia * (1 - prod.giamGia) }" type="currency" /></span>
																<span class="aa-product-price"><del><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" /></del></span>
															</c:otherwise>
														</c:choose>
													</figcaption>
												</figure>
												<c:if test="${prod.giamGia != 0}">
								                  	<!-- product badge -->
								                  	<span class="aa-badge aa-sale"> Giảm <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${prod.giamGia}" type="currency" /></span>
								                </c:if>
							            	</li>
							            </c:forEach>
										<!-- start single product item -->
										<!-- start single product item -->
									</ul>

								</div>
									<!-- / popular product category -->
									<!-- start featured product category -->
								<div class="tab-pane fade" id="sanphambanchay">
									<ul class="aa-product-catg aa-popular-slider">
										<!-- start single product item -->
										<!-- start single product item -->
										<c:forEach items="${danhSachSanPham}" var="prod" begin="5" end="17">
                        					<li>
												<figure>
													<a class="aa-product-img" href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">
														<%-- <img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}"
														 alt="polo shirt img"> --%>
														<c:choose>
															<c:when test="${empty prod.hinhAnh}">
																<img alt="${prod.tenMatHang }" src="resources/images/products/defaultProduct.png" />
															</c:when>
															<c:otherwise>
																<img alt="${prod.tenMatHang }" src="data:image/jpeg;base64,${prod.getBase64Photo() }" />
															</c:otherwise>
														</c:choose>
													</a>
													<figcaption>
														<h4 class="aa-product-title">
															<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">${prod.tenMatHang }</a>
														</h4>
														<c:choose>
															<c:when test="${prod.giamGia == 0}">
																<span class="aa-product-price"> <fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" /></span>
																<span class="aa-product-price"></span>
															</c:when>
															<c:otherwise>
																<span class="aa-product-price"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia * (1 - prod.giamGia) }" type="currency" /></span>
																<span class="aa-product-price"><del><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" /></del></span>
															</c:otherwise>
														</c:choose>
													</figcaption>
												</figure>
												<c:if test="${prod.giamGia != 0}">
								                  	<!-- product badge -->
								                  	<span class="aa-badge aa-sale"> Giảm <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${prod.giamGia}" type="currency" /></span>
								                </c:if>
							            	</li>
							            </c:forEach>
										<!-- start single product item -->
										<!-- start single product item -->
									</ul>

								</div>
								<!-- / featured product category -->

								<!-- start latest product category -->
								<div class="tab-pane fade" id="sanphamgiamgia">

									<ul class="aa-product-catg aa-popular-slider">
										<!-- start single product item -->
										<!-- start single product item -->
										<c:forEach items="${danhSachSanPham}" var="prod" end="30">
											<c:if test="${prod.giamGia != 0}">
												<li>
													<figure>
														<a class="aa-product-img" href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">
															<%-- <img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}"
															 alt="polo shirt img"> --%>
															<c:choose>
																<c:when test="${empty prod.hinhAnh}">
																	<img alt="${prod.tenMatHang }" src="resources/images/products/defaultProduct.png" />
																</c:when>
																<c:otherwise>
																	<img alt="${prod.tenMatHang }" src="data:image/jpeg;base64,${prod.getBase64Photo() }" />
																</c:otherwise>
															</c:choose>
														</a>
														<figcaption>
															<h4 class="aa-product-title">
																<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">${prod.tenMatHang }</a>
															</h4>
															<span class="aa-product-price"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia * (1 - prod.giamGia) }" type="currency" /></span>
															<span class="aa-product-price"><del><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" /></del></span>
														</figcaption>
													</figure>
													<c:if test="${prod.giamGia != 0}">
									                  	<!-- product badge -->
									                  	<span class="aa-badge aa-sale"> Giảm <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${prod.giamGia}" type="currency" /></span>
									                </c:if>
								            	</li>
											</c:if>
							            </c:forEach>
										<!-- start single product item -->
										<!-- start single product item -->
									</ul>
								</div>
								<!-- / latest product category -->
							</div>
							<div class="more-product">
								<a class="aa-browse-btn btn btn-light" href="san-pham.htm">Xem Tất Cả Sản Phẩm 
									<span class="fa fa-long-arrow-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / popular section -->
	<!-- Support section -->
	<section id="aa-support">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-support-area">
						<!-- single support -->
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="aa-support-single">
								<span class="fa fa-truck"></span>
								<h4>MIỄN PHÍ VẬN CHUYỂN</h4>
								<P>Chúng tôi đã áp dụng gói miễn phí vận chuyển cho đơn hàng
									trên 280.000VNĐ.</P>
							</div>
						</div>
						<!-- single support -->
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="aa-support-single">
								<span class="fa fa-clock-o"></span>
								<h4>GIAO HÀNG NHANH</h4>
								<P>Chúng tôi đảm bảo hàng đến tay khách hàng nhanh và đảm
									bảo sản phẩm an toàn.</P>
							</div>
						</div>
						<!-- single support -->
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="aa-support-single">
								<span class="fa fa-phone"></span>
								<h4>HỖ TRỢ 24/7</h4>
								<P>Hỗ trợ tư vấn và đặt hàng mọi lúc mọi nơi, đảm bảo thời
									gian cho khách hàng.</P>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Support section -->
<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp" %>
<!-- end footer-->