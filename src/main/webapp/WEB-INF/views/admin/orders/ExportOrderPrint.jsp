<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style type="text/css">
body {
	margin-top: 20px;
	background: #eee;
}

.invoice {
	background: #fff;
	padding: 20px
}

.invoice-company {
	font-size: 20px
}

.invoice-header {
	margin: 0 -20px;
	background: #f0f3f4;
	padding: 20px
}

.invoice-date, .invoice-from, .invoice-to {
	display: table-cell;
	width: 1%
}

.invoice-from, .invoice-to {
	padding-right: 20px
}

.invoice-date .date, .invoice-from strong, .invoice-to strong {
	font-size: 16px;
	font-weight: 600
}

.invoice-date {
	text-align: right;
	padding-left: 20px
}

.invoice-price {
	background: #f0f3f4;
	display: table;
	width: 100%
}

.invoice-price .invoice-price-left, .invoice-price .invoice-price-right
	{
	display: table-cell;
	padding: 20px;
	font-size: 20px;
	font-weight: 600;
	width: 75%;
	position: relative;
	vertical-align: middle
}

.invoice-price .invoice-price-left .sub-price {
	display: table-cell;
	vertical-align: middle;
	padding: 0 20px
}

.invoice-price small {
	font-size: 12px;
	font-weight: 400;
	display: block
}

.invoice-price .invoice-price-row {
	display: table;
	float: left
}

.invoice-price .invoice-price-right {
	width: 25%;
	background: #2d353c;
	color: #fff;
	font-size: 28px;
	text-align: right;
	vertical-align: bottom;
	font-weight: 300
}

.invoice-price .invoice-price-right small {
	display: block;
	opacity: .6;
	position: absolute;
	top: 10px;
	left: 10px;
	font-size: 12px
}

.invoice-footer {
	border-top: 1px solid #ddd;
	padding-top: 10px;
	font-size: 10px
}

.invoice-note {
	color: #999;
	margin-top: 80px;
	font-size: 85%
}

.invoice>div:not(.invoice-footer) {
	margin-bottom: 20px
}

.btn.btn-white, .btn.btn-white.disabled, .btn.btn-white.disabled:focus,
	.btn.btn-white.disabled:hover, .btn.btn-white[disabled], .btn.btn-white[disabled]:focus,
	.btn.btn-white[disabled]:hover {
	color: #2d353c;
	background: #fff;
	border-color: #d9dfe3;
}
</style>
</head>
<body>
	<div class="container">
		<div class="container">
			<div class="col-md-12">
				<div class="invoice">
					<!-- begin invoice-company -->
					<div class="invoice-company text-inverse f-w-600">
						<span class="pull-right hidden-print"> <a
							href="javascript:;" class="btn btn-sm btn-white m-b-10 p-l-5"><i
								class="fa fa-file t-plus-1 text-danger fa-fw fa-lg"></i> Export
								as PDF</a> <a href="javascript:;" onclick="window.print()"
							class="btn btn-sm btn-white m-b-10 p-l-5"><i
								class="fa fa-print t-plus-1 fa-fw fa-lg"></i> Print</a>
						</span> <img alt="logo"
							src="${pageContext.servletContext.contextPath }/resources/images/logo.png"
							width="50px;"> Nhasachphuongnam.com
					</div>
					<!-- end invoice-company -->
					<!-- begin invoice-header -->
					<div class="invoice-header">
						<div class="invoice-from">
							<small>Bên bán:</small>
							<address class="m-t-6 m-b-6">
								<strong class="text-inverse">Nhà sách Phương Nam</strong><br>
								Địa chỉ: 97 Man Thiện, p.Hiệp Phú, tp.Thủ Đức<br> Số điện
								thoại: 0123456789<br> Email: contact@nhasachphuongnam.com
							</address>
						</div>
						
						<div class="invoice-to">
							<small>Bên mua:</small>
							<address class="m-t-5 m-b-5">
								<strong class="text-inverse">${khachHang.ten }</strong><br>
								Địa chỉ: ${khachHang.diaChi } <br> Số điện thoại:
								${khachHang.soDienThoai } <br> Email:
							</address>
						</div>
						<div class="invoice-date">
							<small>Thông tin đơn hàng</small>
							<div class="date text-inverse m-t-5">${donHang.thoiGian }</div>
							<div class="invoice-detail">
								<b>Mã hóa đơn: </b>${donHang.maDonHang }<br> <b>Số điện
									thoại:</b> ${donHang.sdt }<br> <b>Địa chỉ nhận hàng:</b>
								${donHang.diaChi }
							</div>
						</div>
					</div>
					<!-- end invoice-header -->
					<!-- begin invoice-content -->
					<div class="invoice-content">
						<!-- begin table-responsive -->
						<br>
						<div class="table-responsive">
							<table class="table table-invoice table-striped">
								<thead>
									<tr>
										<th> Tên mặt hàng</th>
										<th class="text-center" width="10%">Số lượng</th>
										<th class="text-center" width="10%">Giảm giá</th>
										<th class="text-right" width="20%">Giá</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${donHang.chiTiets }">
										<tr>
											<td><span class="text-inverse"><p>${item.tenMatHang }</p></span></td>
											<td class="text-center">${item.soLuong }</td>
											<td class="text-center"><fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${item.giamGia }" type="currency" /></td>
											<td class="text-right"><fmt:formatNumber pattern=" #,###.## VND; -#,###.## VND" value="${item.gia }" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<br>
						<!-- end table-responsive -->
						<!-- begin invoice-price -->
						<div class="invoice-price">
							<div class="invoice-price-left">
								<div class="invoice-price-row">
									<div class="sub-price">
										<small>Tạm tính</small> <span class="text-inverse"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien }" type="currency"/></span>
									</div>
									<div class="sub-price">
										<i class="fa fa-plus text-muted"></i>
									</div>
									<div class="sub-price">
										<small>Giảm giá</small> <span class="text-inverse"><fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${donHang.giamGia }" type="currency" /></span>
									</div>
								</div>
							</div>
							<div class="invoice-price-right">
								<small>Tổng tiền</small> <span class="f-w-600"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien * ( 1 - donHang.giamGia) }" type="currency"/></span>
							</div>
						</div>
						<!-- end invoice-price -->
					</div>
					<!-- end invoice-content -->
					<!-- begin invoice-footer -->
					<div class="invoice-footer">
						<p class="text-center m-b-5 f-w-600"> Cảm ơn đã mua hàng của chúng tôi</p>
						<p class="text-center">
							<span class="m-r-10"><i class="fa fa-fw fa-lg fa-globe"></i>
								nhasachphuongnam.com</span> <span class="m-r-10"><i
								class="fa fa-fw fa-lg fa-phone-volume"></i> T:0123456789</span> <span
								class="m-r-10"><i class="fa fa-fw fa-lg fa-envelope"></i>
								 contact@nhasachphuongnam.com</span>
						</p>
					</div>
					<!-- end invoice-footer -->
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>