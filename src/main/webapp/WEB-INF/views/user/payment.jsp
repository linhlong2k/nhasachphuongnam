<%@page pageEncoding="UTF-8"%>
<%@ page import="com.nhasachphuongnam.bean.GioHang" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.Iterable" %>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/user/template/header.jsp"%>
<!-- / header section -->
<!--  content -->
<!-- catg header banner section -->
<!--  content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
	<img src="resources/user/assets/images/checkout.jpg" alt="banner thanh toán">
	<div class="aa-catg-head-banner-area">
		<div class="container">
			<div class="aa-catg-head-banner-content">
				<h2>Thanh toán</h2>
				<ol class="breadcrumb">
					<li><a href="index.htm">Trang chủ</a></li>
					<li style="color: #fff">Thông tin thanh toán</li>
				</ol>
			</div>
		</div>
	</div>
</section>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="checkout">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="checkout-area">
					<form action="thanh-toan.htm" method="post">
						<div class="row">
							<div class="col-md-8">
								<div class="checkout-left">
									<div class="panel-group">
										<!-- Shipping Address -->
										<div class="panel panel-default aa-checkout-billaddress">
											<div class="panel-heading">
												<h4 class="panel-title" style="color: #754110">Thông tin giao hàng</h4>
											</div>
											<div id="collapseFour">
												<div class="panel-body">
													<div class="row">
														<div class="col-md-12">
															<div class="aa-checkout-single-bill">
																<input name="tenKhachHang" type="text" value="${user.ten }" placeholder="Nhập tên" />
															</div>
														</div>

													</div>

													<div class="row">
														<div class="col-md-12">
															<div class="aa-checkout-single-bill">
																<input name="soDienThoai" type="tel" value="${user.soDienThoai }" placeholder="Nhập số điện thoại" required="required" pattern="[0-9]{10}" >
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-12">
															<div class="aa-checkout-single-bill">
																<textarea cols="8" rows="3" name="diaChi" type="text" required="required" pattern="[A-Za-z]" placeholder="Nhập địa chỉ">${user.diaChi }</textarea>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-12">
															<div class="aa-checkout-single-bill">
																<textarea cols="8" rows="3" placeholder="Ghi chú" name="ghiChu"></textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="checkout-right">
									<h4>Thông tin đơn hàng</h4>
									<div class="aa-order-summary-area">
										<table class="table table-responsive">
											<thead>
												<tr>
													<th>Sản phẩm</th>
													<th>Số Lượng</th>
													<th>Giá</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${danhSachSanPham }" var="item">
													<tr>
														<td>${item.tenMatHang }</td>
														<td>${item.soLuong }</td>
														<td><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.gia * (1 - item.giamGia)}" type="currency" /></td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
												</tr>
												<tr>
													<th>Tạm tính</th>
													<td colspan="2"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien}" type="currency" /></td>
												</tr>
												<tr>
													<th>Thuế</th>
													<td colspan="2">0 VNĐ</td>
												</tr>
												<tr>
													<th>Tổng cộng</th>
													<td colspan="2"><strong><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien}" type="currency" /></strong></td>
												</tr>
											</tfoot>
										</table>
									</div>
									<h4>Hình thức thanh toán</h4>
									<div class="aa-payment-method">
										<label for="cashdelivery">
											<input type="radio" id="cashdelivery" name="transaction_payment" checked value="0">
												Thanh toán khi nhận hàng (COD) 
										</label>
										<label for="paypal">
											<input type="radio" id="paypal" name="transaction_payment" value="1">
											Thanh toán bằng thể ngân hàng (ATM) 
										</label>
										<img src="resources/user/assets/img/paypal.jpg" border="0" alt="PayPal Acceptance Mark">
										<input type="submit" value="Đặt hàng" class="aa-browse-btn">
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- / Cart view section -->
<!--  end content-->

<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->