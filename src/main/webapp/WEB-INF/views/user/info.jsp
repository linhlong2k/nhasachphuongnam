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
</style>
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-lg-3">
				<div class="card">
					<div class="card-header">
						<h3 class="card-header-main">
							<i class="fas fa-cog fa-fw"></i>&nbsp;&nbsp; Cài đặt
						</h3>
					</div>
					<br>
					<div class="">
						<ul class="">
							<li class="nav-item">
								<a class="nav-link d-flex align-items-center justify-content-between active" id="u-vnav-edit" href="thong-tin-ca-nhan.htm" >
								<span><i class="far fa-fw fa-address-card mr-5"></i> Hồ sơ</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link d-flex align-items-center justify-content-between" id="u-vnav-email" href="thong-tin-don-hang.htm">
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
				<div class="panel panel-info card">
					<div class="block-header block-header-default card-header">
						<h3 class="block-title font-w600 card-header-main"> Thành viên: ${user.ten }</h3>
					</div>
					<div class="panel-body">
					<c:if test="${not empty notification }">
						<label id="notification" class="form-text text-muted" style="color: blue; background-color: #d1e0e0; width: 100%; padding: 5px;">${notification }<br></label>
					</c:if>
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
								<form action="thong-tin-ca-nhan.htm?" method="post" enctype="multipart/form-data">
									<br>
									<div class="card-body text-primary">
									   	<div class="mb-3">
										  	<input class="form-control" type="file" id="formFile" name="photo">
										</div>
								 	</div>
								 	<c:if test="${not empty messagePhoto }">
										<small id="messagePhoto" class="form-text text-muted" style="color: red; background-color: #d1e0e0; width: 100%; padding: 5px;">${messagePhoto }<br></small>
									</c:if>
								 	<br>
									<button type="submit" class="btn btn-light btn-round px-5" name="uploadPhotoId" value="${user.ma }" >
						               	Cập nhật ảnh
						            </button>
								</form>
							</div>
							<div class=" col-md-8 col-lg-8 ">
								<table class="table table-user-information">
									<tbody>
									<form:form aciton="thong-tin-ca-nhan.htm" method="post" modelAttribute="user">
										<tr>
											<td>Họ và tên:</td>
											<td><form:input path="ten" required="required" value="${user.ten }" pattern="[A-Za-z0-9]{0-50}" /></td>
										</tr>
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
											<td><form:input path="ngaySinh" type="date" required="required" value="${user.ngaySinh }" /></td>
										</tr>
										<tr>
											<td>Địa chỉ:</td>
											<td><form:input path="diaChi" required="required" value="${user.diaChi }" /></td>
										</tr>

										<tr>
										<tr>
											<td>Số điện thoại:</td>
											<td><form:input path="soDienThoai" required="required" value="${user.soDienThoai }" pattern="[0-9]{10}" /></td>
										</tr>
										<tr>
											<td>Tên đăng nhập:</td>
											<td>
												${user.username }
												<br>
												<p><a href="thay-doi-mat-khau.htm" style="color: blue;">Đổi mật khẩu</a></p>
											</td>
										</tr>
										<tr>
										<td>	
											<c:if test="${not empty message }">
												<small id="message" class="form-text text-muted" style="color: red; background-color: #d1e0e0; width: 100%; padding: 5px;">${message }<br></small>
											</c:if>
										</td>
										<td>
											<button type="submit" class="btn btn-light btn-round" name="editInfo" style="margin: 0 auto;">
								               	<i class="glyphicon glyphicon-edit"></i>
								               	Lưu chỉnh sửa
								            </button>
								        </td>
										</tr>
									</form:form>
									</tbody>
								</table>
								<!-- <a href="thong-tin-ca-nhan.html?edit" data-original-title="Chỉnh sửa thông tin cá nhân" data-toggle="tooltip" type="button" class="btn btn-light btn-round px-3" >
									
								</a> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br><br><br>
<!-- / product category -->
<!--  end content-->

<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->