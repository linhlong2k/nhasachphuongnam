<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<style type="text/css">
	.invoice {
	    position: relative;
	    background: #fff;
	    border: 1px solid #f4f4f4;
	    padding: 20px;
	    margin: 10px 25px;
	}
	.page-header {
	    margin: 10px 0 20px 0;
	    font-size: 22px;
	}
</style>
</head>
<body>
	
	<!------ Include the above in your HEAD tag ---------->

	<section class="content content_content" style="width: 70%; margin: auto;">
		<section class="invoice">
			<!-- title row -->
			<div class="row">
				<div class="col-xs-12">
					<h2 class="page-header">
						<img alt="logo" src="${pageContext.servletContext.contextPath }/resources/images/logo.png" width="50px;"> Nhasachphuongnam.com
						<small class="pull-right"> - Date: ${donHang.thoiGian }</small>
					</h2>
				</div>
			</div>
			<!-- info row -->
			<div class="row invoice-info">
				<div class="col-sm-4 invoice-col">
					From
					<address>
						<strong>Nhà sách Phương Nam</strong><br>
						Địa chỉ: 97 Man Thiện, p.Hiệp Phú, tp.Thủ Đức<br>
						Số điện thoại: 0123456789<br>
						Email: contact@nhasachphuongnam.com
					</address>
				</div>
				<!-- /.col -->
				<div class="col-sm-4 invoice-col">
					To
					<address>
						<strong> ${user.ten } </strong> <br> 
						Địa chỉ: ${user.diaChi } <br>
						Số điện thoại: ${user.soDienThoai } <br>
						Email:
					</address>
				</div>
				<!-- /.col -->
				<div class="col-sm-4 invoice-col">
					<b>Mã hóa đơn: </b>${donHang.maDonHang }<br>
					<b>Số điện thoại:</b> ${donHang.sdt }<br>
					<b>Ngày đặt hàng:</b> ${donHang.thoiGian }<br> 
					<b>Địa chỉ nhận hàng:</b> ${donHang.diaChi }
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
			<!-- /.row -->
			<br><br>
			<!-- Table row -->
			<div class="row">
				<div class="col-xs-12 table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên mặt hàng</th>
								<th>Số lượng</th>
								<th>Giá</th>
								<th>Tổng tiền</th>
							</tr>
						</thead>
						<tbody>
						<% int i = 1; %>
							<c:forEach var="item" items="${donHang.chiTiets }" >
								<tr>
									<td><% out.print(i++); %></td>
									<td><p>${item.tenMatHang }</p></td>
									<td>${item.soLuong }</td>
									<td><fmt:formatNumber pattern=" #,###.## VND; -#,###.## VND" value="${item.gia }" /></td>
									<td>${item.soLuong * item.gia }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.col -->
			</div>

			<div class="row">
				<!-- accepted payments column -->
				<div class="col-md-12">
					<p class="lead">Ngày đặt hàng: ${donHang.thoiGian }</p>
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<th>Total:</th>
									<td>${tongTien }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->

			<!-- this row will not appear when printing -->
			<div class="no-print float-right">
				<div class="col-xs-12">
					<button class="btn btn-success pull-right" onclick="window.print()" >
						<i class="fa fa-credit-card"></i> in
					</button>
				</div>
			</div>
		</section>
	</section>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>