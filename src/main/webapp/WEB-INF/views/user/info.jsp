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
<!-- / catg header banner section -->
<!-- start contact section -->
<section id="aa-contact">
	<div class="container">
	<br>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-2 col-lg-offset-2 toppad">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Thành viên: ${user.ten }</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-4 col-lg-4 " align="center">
								<c:choose>
				                    <c:when test="${empty user.hinhAnh}">
								    	<img class="img-circle img-responsive" alt="image" src="resources/images/users/defaultUser.jpg" />
									</c:when>
									<c:otherwise>
										<img class="img-circle img-responsive" alt="image" src="data:image/jpeg;base64,${user.getBase64Photo() }" />	
									</c:otherwise>
								</c:choose>
								<a href="thong-tin-ca-nhan/cap-nhat-hinh-anh/${user.ma}.htm" >Cập nhập ảnh</a>
								<br><br>
								<a data-original-title="Lưu hình ảnh" data-toggle="tooltip" type="button" class="btn btn-sm btn-round btn-primary" style="color: #19334d">
									<i class="glyphicon glyphicon-floppy-disk"></i>
								</a>
							</div>
							<div class=" col-md-8 col-lg-8 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Loại tài khoản:</td>
											<td>
												<c:forEach var="i" items="${roles }">
					                            	<c:if test="${user.maRole eq i.maRole}">
					                            		<p>${i.tenRole }</p>
					                            	</c:if>
					                            </c:forEach>
											</td>
										</tr>
										<tr>
											<td>Ngày sinh:</td>
											<td>${user.ngaySinh }</td>
										</tr>
										<tr>
											<td>Địa chỉ:</td>
											<td>${user.diaChi }</td>
										</tr>

										<tr>
										<tr>
											<td>Số điện thoại:</td>
											<td>${user.soDienThoai }</td>
										</tr>
										<tr>
											<td>Tên đăng nhập:</td>
											<td>
												${user.username }
												<br>
												<p><a href="thong-tin-ca-nhan.htm?password" style="color: blue;">Đổi mật khẩu</a></p>
											</td>
											
										</tr>
									</tbody>
								</table>
								<a href="thong-tin-ca-nhan.html?edit" data-original-title="Chỉnh sửa thông tin cá nhân" data-toggle="tooltip" type="button" class="btn btn-light btn-round px-3" >
									<i class="glyphicon glyphicon-edit"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="row" style="padding: 10px; border: 3px solid #000080; border-radius: 10px;">
			<div class="card">
	            <div class="card-header">
	                <h3><strong>DANH SÁCH ĐƠN HÀNG</strong></h3>
	                <br>
	                <div>
	                	<form class="search">
							<input type="text" class="form-control" placeholder="Tìm kiếm" id="search-hoa-don" onkeyup="hoaDonSearch()">
						</form>
	                </div>
	            </div>
	            <div class="table-responsive">
	                <table class="table align-items-center" id="table-hoa-don">
	                	<thead>
	                		<tr>
	                            <th style="margin: 0; padding: 10px 10px;"><i class="text-white mr-2"></i>Mã đơn</th>
	                            <th style="margin: 0; padding: 10px 10px;">Thời gian</th>
	                            <th style="margin: 0; padding: 10px 10px;">Giảm giá</th>
	                            <th style="margin: 0; padding: 10px 10px;">Tình trạng</th>
	                            <th style="margin: 0; padding: 10px 10px;">Địa chỉ nhận hàng</th>
	                            <th style="margin: 0; padding: 10px 10px;">Chi tiết đơn hàng</th>
	                        </tr>
	                	</thead>
	                    <tbody>
	                        <c:forEach var="eo" items="${danhSachDonHang }">
	                        <tr>
								<td scope="row" style="margin: 0; padding: 10px;">${eo.maDonHang }</td>
		                    	<td style="margin: 0; padding: 10px;">${eo.thoiGian }</td>
		                    	<td style="margin: 0; padding: 10px;">${eo.giamGia }</td>
		                    	<td style="margin: 0; padding: 10px;">${eo.tinhTrang }</td>
		                    	<td style="margin: 0; padding: 10px;">${eo.diaChi }</td>
		                    	<td style="margin: 0; padding: 10px;">
		                    		<c:forEach var="item" items="${eo.chiTiets }">
		                    			<p>${item.maMatHang }&nbsp;&nbsp;${item.soLuong }&nbsp;&nbsp;<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.gia }" type="currency" /></p>
		                    		</c:forEach>
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
</section>
<!-- / product category -->
<!--  end content-->

<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->