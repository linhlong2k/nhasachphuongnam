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
								<img data-seq src="resources/user/assets/images/slide-1.jpg" alt="Ảnh Banner BALO" />
							</div>
							<div class="seq-title">
								<span data-seq>Giảm giá lên đến 50%</span>
								<h2 data-seq>Balo Thời Trang Cho Học Sinh</h2>
								<a data-seq href="san-pham.htm"
									class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div>
						</li>
						<!-- single slide item -->
						<li>
							<div class="seq-model">
								<img data-seq src="resources/user/assets/images/slide-2.jpg"
									alt="Ảnh Banner BALO" />
							</div>
							<div class="seq-title">
								<span data-seq>Giảm giá lên đến 20%</span>
								<h2 data-seq>Balo du lịch cho tín đồ phượt</h2>
								<a data-seq
									href="${pageContext.request.contextPath}/view/client/product"
									class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div>
						</li>
						<!-- single slide item -->
						<li>
							<div class="seq-model">
								<img data-seq src="resources/user/assets/images/slide-3.jpg"
									alt="Ảnh Banner BALO" />
							</div>
							<div class="seq-title">
								<span data-seq>Giảm giá lên đến 33%</span>
								<h2 data-seq>Balo dây rút thời trang</h2>
								<a data-seq
									href="${pageContext.request.contextPath}/view/client/product"
									class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div>
						</li>
						<!-- single slide item -->
						<li>
							<div class="seq-model">
								<img data-seq src="resources/user/assets/images/slide-4.jpg"
									alt="Ảnh Banner BALO" />
							</div>
							<div class="seq-title">
								<span data-seq>Giảm giá lên đến 25%</span>
								<h2 data-seq>Balo chống nước</h2>
								<a data-seq
									href="${pageContext.request.contextPath}/view/client/product"
									class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
							</div>
						</li>
					</ul>
				</div>
				<!-- slider navigation btn -->
				<fieldset class="seq-nav" aria-controls="sequence"
					aria-label="Slider buttons">
					<a type="button" class="seq-prev" aria-label="Previous"><span
						class="fa fa-angle-left"></span></a> <a type="button" class="seq-next"
						aria-label="Next"><span class="fa fa-angle-right"></span></a>
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
										<img src="resources/user/assets/images/balo-intro-1.jpg" alt="ảnh balo">
										<div class="aa-prom-content">
											<span>Giảm giá 35%</span>
											<h4>Balo Thời Trang</h4>
										</div>
									</div>
								</div>
							</div>
							<!-- promo right -->
							<div class="col-md-7 no-padding">
								<div class="aa-promo-right">
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/user/assets/images/balo-intro-2.jpg"
												alt="Balo chính hãng">
											<div class="aa-prom-content">
												<span>Sản Phẩm độc quyền</span>
												<h4>Balo chính hãng</h4>
											</div>
										</div>
									</div>
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/user/assets/images/balo-intro-3.jpg" alt="Balo Adidas">
											<div class="aa-prom-content">
												<span>Balo nhập khẩu</span>
												<h4>Balo Adidas</h4>
											</div>
										</div>
									</div>
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/user/assets/images/balo-intro-4.jpg" alt="Balo Học Sinh">
											<div class="aa-prom-content">
												<span>Giảm giá 25%</span>
												<h4>Balo Học Sinh</h4>
											</div>
										</div>
									</div>
									<div class="aa-single-promo-right">
										<div class="aa-promo-banner">
											<img src="resources/user/assets/images/balo-intro-5.jpg" alt="Balo Nike">
											<div class="aa-prom-content">
												<span>Balo Nhập Khẩu</span>
												<h4>Balo Nike</h4>
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
								<ul class="nav nav-tabs aa-products-tab">
									<li class="active"><a href="#thoitrang" data-toggle="tab">Balo
											Thời Trang</a></li>
									<li><a href="#nhapkhau" data-toggle="tab">Balo Nhập
											Khẩu</a></li>
									<li><a href="#hocsinh" data-toggle="tab">Balo Học Sinh</a></li>
									<li><a href="#khac" data-toggle="tab">Khác</a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<!-- Start men product category -->
									<div class="tab-pane fade in active" id="thoitrang">
										<ul class="aa-product-catg">
											<!-- start single product item -->
											<c:forEach items="${danhSachMatHang}" var="prod" end="7">
												<li>
													<figure>
														<a class="aa-product-img"
															href="${pageContext.request.contextPath}/view/client/product-detail?id=${prod.maMatHang}">
															<img
															src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}"
															alt="img">
														</a>
														<a class="aa-add-card-btn"
															href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${prod.maMatHang}">
															<span class="fa fa-shopping-cart"></span>Thêm vào giỏ
															hàng
														</a>
														<figcaption>
															<h4 class="aa-product-title">
																<a
																	href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a>
															</h4>

															<c:choose>
																<c:when test="${product.discount == 0}">
																	<span class="aa-product-price">${product.price}
																		VNĐ</span>
																	<span class="aa-product-price"></span>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${productlist1}" var="product1">
																		<c:if test="${product1.id == product.id}">
																			<span class="aa-product-price">${product1.price}
																				VNĐ</span>
																			<span class="aa-product-price"><del>${product.price}
																					VNĐ</del></span>
																		</c:if>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														</figcaption>
													</figure> <c:if test="${product.discount != 0}">
														<!-- product badge -->
														<span class="aa-badge aa-sale">-
															${product.discount}%</span>
													</c:if>
												</li>
											</c:forEach>
											<!-- start single product item -->

										</ul>

									</div>
									<!-- / men product category -->
									<!-- start women product category -->
									<div class="tab-pane fade" id="nhapkhau">
										<%-- <ul class="aa-product-catg">
                        <!-- start single product item -->
                         <c:forEach items="${product_nhapkhau}" var="product" end="7">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">
                            	<img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}" alt="polo shirt img">
                            </a>
                            <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${product.id}">
                            	<span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng
                            </a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                             	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} VNĐ</span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">${product1.price} VNĐ</span>
		                      <span class="aa-product-price"><del>${product.price} VNĐ</del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                            </figcaption>
                          </figure>                        
                        
                        <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
                        </li>
                        </c:forEach>
                        <!-- start single product item -->
                         
                      </ul> --%>

									</div>
									<!-- / women product category -->
									<!-- start sports product category -->
									<div class="tab-pane fade" id="hocsinh">
										<%-- <ul class="aa-product-catg">
                        <!-- start single product item -->
                         <c:forEach items="${product_hocsinh}" var="product" end="7">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">
                           		<img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}" alt="polo shirt img">
                           	</a>
                            <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${product.id}">
                            	<span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng
                            </a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                            	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} VNĐ</span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">${product1.price} VNĐ</span>
		                      <span class="aa-product-price"><del>${product.price} VNĐ</del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                            </figcaption>
                          </figure>                        
                        
                       <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
                        </li>
                        </c:forEach>
                        <!-- start single product item -->
                         
                      </ul> --%>

									</div>
									<!-- / sports product category -->
									<!-- start electronic product category -->
									<div class="tab-pane fade" id="khac">
										<%-- <ul class="aa-product-catg">
                        <!-- start single product item -->
                         <c:forEach items="${product_khac}" var="product" end="7">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">
                            	<img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}" alt="polo shirt img">
                            </a>
                            <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${product.id}">
                            	<span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng
                            </a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                            	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} VNĐ</span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">${product1.price} VNĐ</span>
		                      <span class="aa-product-price"><del>${product.price} VNĐ</del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                            </figcaption>
                          </figure>                        
                        
                            <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
                        </li>
                        </c:forEach>
                        <!-- start single product item -->
                         
                      </ul> --%>

									</div>
									<!-- / electronic product category -->
								</div>
								<div class="more-product">
									<a class="aa-browse-btn btn btn-light"
										href="${pageContext.request.contextPath}/view/client/product">Xem
										Tất Cả Sản Phẩm <span class="fa fa-long-arrow-right"></span>
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
							<a href="#"><img src="resources/user/assets/images/banner-home.jpg"
								alt="banner trang chủ"></a>
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
								<li class="active"><a href="#sanphammoi" data-toggle="tab">Sản
										Phẩm Mới</a></li>
								<li><a href="#sanphambanchay" data-toggle="tab">Sản
										Phẩm Bán Chạy</a></li>
								<li><a href="#sanphamgiamgia" data-toggle="tab">Sản
										Phẩm Giảm Giá</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
								<!-- Start men popular category -->
								<div class="tab-pane fade in active" id="sanphammoi">
									<ul class="aa-product-catg aa-popular-slider">
										<!-- start single product item -->
										<%-- <c:forEach items="${product_new}" var="product">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">
                            	<img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}" alt="polo shirt img">
                            </a>
                            <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${product.id}">
                           		<span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng
                           	</a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                            	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} VNĐ</span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">${product1.price} VNĐ</span>
		                      <span class="aa-product-price"><del>${product.price} VNĐ</del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                            </figcaption>
                          </figure>                        
                        
                             <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
                        </li>
                        </c:forEach> --%>
										<!-- start single product item -->
										<!-- start single product item -->

									</ul>

								</div>
								<!-- / popular product category -->

								<!-- start featured product category -->
								<div class="tab-pane fade" id="sanphambanchay">
									<ul class="aa-product-catg aa-popular-slider">
										<!-- start single product item -->
										<%-- <c:forEach items="${product_banchay}" var="product">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}" alt="polo shirt img"></a>
                            <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${product.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                            	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} VNĐ</span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">${product1.price} VNĐ</span>
		                      <span class="aa-product-price"><del>${product.price} VNĐ</del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                            </figcaption>
                          </figure>                        
                         
                           <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
                        </li>
                        </c:forEach> --%>
										<!-- start single product item -->
										<!-- start single product item -->

									</ul>

								</div>
								<!-- / featured product category -->

								<!-- start latest product category -->
								<div class="tab-pane fade" id="sanphamgiamgia">

									<ul class="aa-product-catg aa-popular-slider">
										<!-- start single product item -->
										<%-- <c:forEach items="${product_sale}" var="product">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}" alt="polo shirt img"></a>
                            <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${product.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                             	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} VNĐ</span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">${product1.price} VNĐ</span>
		                      <span class="aa-product-price"><del>${product.price} VNĐ</del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                            </figcaption>
                          </figure>                        
                        
                             <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
                        </li>
                        </c:forEach> --%>
										<!-- start single product item -->
										<!-- start single product item -->

									</ul>
								</div>
								<!-- / latest product category -->
							</div>
							<div class="more-product">
								<a class="aa-browse-btn btn btn-light"
									href="${pageContext.request.contextPath}/view/client/product">Xem
									Tất Cả Sản Phẩm <span class="fa fa-long-arrow-right"></span>
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
	<!-- Testimonial -->
	<section id="aa-testimonial">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-testimonial-area">
						<ul class="aa-testimonial-slider">
							<!-- single slide -->
							<li>
								<div class="aa-testimonial-single">
									<img class="aa-testimonial-img" src="resources/user/assets/images/tes-1.jpg"
										alt="avatar 1"> <span
										class="fa fa-quote-left aa-testimonial-quote"></span>
									<p>Chuyến đi công tác vừa rồi tôi muốn mua 1 chiếc Vali
										Kéo. Sau khi cân nhắc thì tôi chọn cách đặt hàng Online tại
										BigBag. Tôi rất hài lòng về chất lượng sản phẩm Shop cung cấp,
										vì sản phẩm thực tế rất giống với hình ảnh trên Website
										BigBag.vn mô tả. Đặc biệt là mỗi chuyến đi gấp, khi tôi đặt
										hàng thì BigBag ship rất nhanh mà lại hoàn toàn miễn phí!</p>
									<div class="aa-testimonial-info">
										<p>
											Anh <strong>Nguyễn Văn A</strong>,
										</p>
										<span>Founder & CEO LEATERMAN Jsc</span>
									</div>
								</div>
							</li>
							<!-- single slide -->
							<li>
								<div class="aa-testimonial-single">
									<img class="aa-testimonial-img"
										src="resources/user/assets/images/chi-emily-nguyen-sales-cty-bao-hiem-dai-ichi-life.jpg"
										alt="avatar 2"> <span
										class="fa fa-quote-left aa-testimonial-quote"></span>
									<p>Cách đây 3 tháng mình có mua 1 chiếc Vali Du Lịch tại
										BigBag, dùng chưa tới 5 ngày thì trong chuyến công tác ra Hà
										Nội chiếc Vali bị rớt bánh xe và gẫy luôn Cần kéo (Bị nhân
										viên sân bay nén ko thương tiếc các bạn ạ!) Sau đó mình liên
										hệ thì được Shop thay tất cả hoàn toàn Free! Khi mình thắc mắc
										thì được Shop giải thích là Bảo Hành Trọn Đời tất cả Sản Phẩm.
										Lúc đó mình rất bất ngờ và vô cùng ngạc nhiên, vì lúc mua mình
										hơi vội nên ko để ý chính sách Bảo hành của Shop.
									<p>
									<div class="aa-testimonial-info">
										<p>
											Chị <strong>Emily Nguyen</strong>,
										</p>
										<span>Sales Cty Bảo Hiểm Dai-ichi Life</span>
									</div>
								</div>
							</li>
							<!-- single slide -->
							<li>
								<div class="aa-testimonial-single">
									<img class="aa-testimonial-img"
										src="resources/user/assets/images/anh-tran-phong-sang-lap-openhomestay-com.jpg"
										alt="avatar 3"> <span
										class="fa fa-quote-left aa-testimonial-quote"></span>
									<p>Từ khi biết đến shop, mình hầu như không mua đồ Du Lịch
										tại các shop khác vì tại đây có đầy đủ những thứ mình cần như
										Balo Laptop để đi học, các loại Cặp xách để mình đi làm thêm,
										Vali cho các Chuyến du lịch xa cùng Gia đình,...Ưu điểm nữa là
										Nhân viên của shop khá thân thiện, tư vấn cho khách rất nhiệt
										tình.</p>
									<div class="aa-testimonial-info">
										<p>
											Anh <strong>Trần Phong</strong>,
										</p>
										<span>Sáng Lập OpenHomestay.com</span>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Testimonial -->

	<!-- Latest Blog -->
	<section id="aa-latest-blog">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-latest-blog-area">
						<h2>TIN TỨC</h2>
						<div class="row">
							<!-- single latest blog -->
							<%-- <c:forEach items="${boardnewlist}" var="boardnew" end="2">
              <div class="col-md-4 col-sm-4">
                <div class="aa-latest-blog-single">
                  <figure class="aa-blog-img">                    
                    <a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/news/${boardnew.image_link}" alt="Tin tức ${boardnew.title}"></a>  
                      <figcaption class="aa-blog-img-caption">
                      <span href="#"><i class="fa fa-clock-o"></i>${boardnew.created}</span>
                    </figcaption>                          
                  </figure>
                  <div class="aa-blog-info">
                    <h3 class="aa-blog-title"><a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}">${boardnew.title}</a></h3>
                    <p class="desc-boardnews">${boardnew.content}</p> 
                    <a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}" class="aa-read-mor-btn">Xem thêm<span class="fa fa-long-arrow-right"></span></a>
                  </div>
                </div>
              </div>
              </c:forEach> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp" %>
<!-- end footer-->