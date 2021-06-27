<%@page pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/user/template/header.jsp"%>
<!-- / header section -->
<!--  content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
	<!--     	=================================================================== table ==================================================================== -->
	<img src="resources/images/users/banner/thongtincanhnabanner.png" style="width: 100%;" alt="banner thông tin cá nhân">
	<div class="aa-catg-head-banner-area">
		<div class="container">
			<div class="aa-catg-head-banner-content">
				<h2>Thông tin tài khoản</h2>
				<ol class="breadcrumb">
					<li><a href="index.htm">Trang chủ</a></li>
					<li style="color: #fff">Thông tin tài khoản</li>
				</ol>
			</div>
		</div>
	</div>
</section>
<style>
	.nav-link {
		padding: 10px;
		margin: 15px;
		display: block;
		border-radius: 2%;
	}
	.nav-item:hover {
		background-color: #d1e0e0;
		color: blue;
	}
	.nav-item	.active {
		background-color: #42a5f5;
		color: #fff;
	}
	.card {
		background-color: #fff;
		margin: 20px;
	}
	.card-header {
		background-color: #ced4da;
		padding: 0;
		margin: 0px;
	}
	.card-header-main {
		 background-color: #ced4da;
		 margin: 0px;
		 padding: 10px;"
	}
	table th, table td {
		margin: 0;
		padding: 10px 10px;
	}
</style>
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-lg-3">
				<div class="card">
					<div class="card-header" >
						<h3 class="card-header-main" >
							<i class="fas fa-cog fa-fw"></i>&nbsp;&nbsp; Cài đặt
						</h3>
					</div>
					<br>
					<div class="" style="display: block; margin-left: 10px;">
						<ul class="">
							<li class="nav-item">
								<a class="nav-link d-flex align-items-center justify-content-between" id="u-vnav-edit" href="thong-tin-ca-nhan.htm" >
								<span><i class="far fa-fw fa-address-card mr-5"></i> Hồ sơ</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link d-flex align-items-center justify-content-between active" id="u-vnav-email" href="thong-tin-don-hang.htm">
								<span><i class="fas fa-shopping-cart mr-5"></i> Đơn hàng</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link d-flex align-items-center justify-content-between" id="u-vnav-password" href="thay-doi-mat-khau.htm">
								<span><i class="fa fa-fw fa-key mr-5"></i> Mật khẩu</span></a>
							</li>
							<br>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-7 col-lg-9">
				<div class="panel panel-info card" >
					<div class="block-header block-header-default card-header" >
						<h3 class="block-title font-w600 card-header-main"> DANH SÁCH ĐƠN HÀNG</h3>
					</div>
					<div class="panel-body" >
						<div class="row" style="padding: 10px;">
							<div class="card">
					            <div class="card-header">
					                <div>
					                	<form class="search">
											<input type="text" class="form-control" placeholder="Tìm kiếm theo mã đơn hàng" id="search-hoa-don" onkeyup="hoaDonSearch()">
										</form>
					                </div>
					            </div>
					            <hr>
					            <div class="table-responsive">
					                <table class="table table-striped align-items-center" id="table-hoa-don">
					                	<thead>
					                		<tr>
					                            <th rowspan="2" ><i class="text-white mr-2"></i>Mã đơn hàng</th>
					                            <th rowspan="2" >Thời gian</th>
					                            <th rowspan="2" >Giảm giá</th>
					                            <th rowspan="2" >Tình trạng</th>
					                            <!-- <th rowspan="2" style="margin: 0; padding: 10px 10px;">Địa chỉ nhận hàng</th> -->
					                            <th colspan="3" >Chi tiết đơn hàng</th>
					                        </tr>
					                        <tr>
					                        	<th>Mã mặt hàng</th>
					                        	<th>Số lượng</th>
					                        	<th>Giá tiền</th>
					                        </tr>
					                	</thead>
					                    <tbody>
					                        <c:forEach var="eo" items="${danhSachDonHang }">
					                        <tr>
												<td scope="row" ><a href="chi-tiet-don-hang/${eo.maDonHang }.htm">${eo.maDonHang }</a></td>
						                    	<td >${eo.thoiGian }</td>
						                    	<td ><fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${eo.giamGia }" type="currency" /></td>
						                    	<td >
						                    		<c:choose>
						                    			<c:when test="${eo.tinhTrang eq '1' }">
						                    				Đang chờ xác nhận
						                    			</c:when>
						                    			<c:when test="${eo.tinhTrang eq '2' }">
						                    				Đang vận chuyển
						                    			</c:when>
						                    			<c:when test="${eo.tinhTrang eq '3' }">
						                    				Đã nhận hàng
						                    			</c:when>
						                    			<c:otherwise>
						                    				Không xác định
						                    			</c:otherwise>
						                    		</c:choose>
						                    	</td>
						                    	<%-- <td style="margin: 0; padding: 10px;">${eo.diaChi }</td> --%>
						                    	<td colspan="3" >
						                    	<table>
						                    		<c:forEach var="item" items="${eo.chiTiets }">
							                    		<tr>
							                    			<td >${item.maMatHang }</td>
							                    			<td >${item.soLuong }</td>
							                    			<td ><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.gia }" type="currency" /></td>
							                    		</tr>
						                    		</c:forEach>
						                    	</table>
						                    	</td>
						                    </tr>
					                        </c:forEach>
					                    </tbody>
					                </table>
					            </div>
					        </div>
						</div>
						<br><br><br>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- / product category -->
<!--  end content-->
<script>
		function hoaDonSearch() {
			var input, filter, table, tr, i, txtValue, firstCol;
			input = document.getElementById("search-hoa-don");
			filter = input.value.toUpperCase();
			table = document.getElementById("table-hoa-don");
			tr = table.getElementsByTagName("tr");
		    for (i = 0; i < tr.length; i++) {
		        firstCol = tr[i].getElementsByTagName("td")[0];
		        if (firstCol) {
					txtValue = firstCol.textContent || firstCol.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}   
		    }
		}
	</script>
<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->