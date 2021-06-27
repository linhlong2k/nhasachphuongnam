<%@page pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/user/template/header.jsp"%>
<!-- / header section -->

<!--  content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">		
<!--     	=================================================================== table ==================================================================== -->
	<section class="content content_content" style="width: 70%; margin: auto;">
		<section class="invoice">
			<!-- title row -->
			<div class="row">
				<div class="col-xs-12">
					<h2 class="page-header">
						<img alt="logo" src="resources/images/logo.png" width="50px;"> Nhasachphuongnam.com<small
							class="pull-right">Date: <%= (new java.util.Date()).toLocaleString() %></small>
					</h2>
				</div>
			</div>
			<!-- info row -->
			<div class="row invoice-info">
				<div class="col-sm-4 invoice-col">
					Bên bán:
					<address>
						<strong>Nhà sách Phương Nam</strong><br>
						Address: 97 Man Thiện, p.Hiệp Phú, tp.Thủ Đức<br>
						Phone: 0123456789<br>
						Email: contact@nhasachphuongnam.com
					</address>
				</div>
				<!-- /.col -->
				<div class="col-sm-4 invoice-col">
					Bên mua
					<address>
						<strong> ${khachHang.ten } </strong> <br> 
						Address: ${khachHang.diaChi } <br>
						Phone: ${khachHang.soDienThoai } <br>
						Email:
					</address>
				</div>
				<!-- /.col -->
				<div class="col-sm-4 invoice-col">
					<b>Thông tin đơn hàng: </b><br>
					<b>Mã hóa đơn: </b>${donHang.maDonHang }<br>
					<b>Số điện thoại:</b> ${donHang.sdt }<br>
					<b>Ngày đặt hàng:</b> ${donHang.thoiGian }<br> 
					<b>Địa chỉ nhận hàng:</b> ${donHang.diaChi }
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
			<!-- Table row -->
			<div class="row">
				<div class="col-xs-12 table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>STT</th>
								<th>Mã mặt hàng</th>
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
									<td>${item.maMatHang }</td>
									<td>${item.soLuong }</td>
									<td><fmt:formatNumber pattern=" #,###.## VND; -#,###.## VND" value="${item.gia }" /></td>
									<td><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.soLuong * item.gia }" type="currency" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->

			<div class="row">
				<!-- accepted payments column -->
				<div class="col-md-12">
					<p class="lead">Ngày đặt hàng: ${donHang.thoiGian }</p>
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<th>Tạm tính:</th>
									<td><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien }" type="currency" /></td>
								</tr>
								<tr>
									<th>Giảm giá</th>
									<td><fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${donHang.giamGia }" type="currency" /></td>
								</tr>
								<tr>
									<th>Tổng tiền: </th>
									<td><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien * (1 - donHang.giamGia) }" type="currency" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->

			<!-- this row will not appear when printing -->
			<div class="row no-print">
				<div class="col-xs-12">
					<form method="get">
						<button name="printInvoice" class="btn btn-light btn-round px-5 btn-success pull-right" formtarget="_blank" >
							<i class="fa fa-credit-card"></i> Xuất hóa đơn
						</button>
					</form>
				</div>
			</div>
		</section>
	</section>
	<br><br>
<!-- / product category -->
<!--  end content-->

<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->