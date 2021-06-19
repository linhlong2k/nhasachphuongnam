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
				<div class="" style="background-color: #fff; margin: 20px;">
					<div class="" style="background-color: #ced4da; padding: 0; margin: 0px;">
						<h3 class="" style="background-color: #ced4da; margin: 0px; padding: 10px;">
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
								<a class="nav-link d-flex align-items-center justify-content-between" id="u-vnav-email" href="thong-tin-don-hang.htm">
								<span><i class="fas fa-shopping-cart mr-5"></i> Đơn hàng</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link d-flex align-items-center justify-content-between active" id="u-vnav-password" href="thay-doi-mat-khau.htm">
								<span><i class="fa fa-fw fa-key mr-5"></i> Mật khẩu</span></a>
							</li>
							<br>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-7 col-lg-9">
				<div class="panel panel-info" style="background-color: #fff; margin-top: 20px;">
					<div class="block-header block-header-default" style="background-color: #ced4da; padding: 0; margin: 0px;">
						<h3 class="block-title font-w600" style="background-color: #ced4da; margin: 0px; padding: 10px;"> Thay đổi mật khẩu</h3>
					</div>
						<div class="panel-body">
						<c:if test="${not empty notification }">
							<label id="notification" class="form-text text-muted" style="color: blue; background-color: #d1e0e0; width: 100%; padding: 5px;">${notification }<br></label>
						</c:if>
							<div class="row" style="padding: 10px 100px;">
								<div class="card">
									<form action="thay-doi-mat-khau.htm" method="post">
										<div class="form-group">
											<label for="input-password-old">Mật khẫu cũ</label>
											<input name="passwordOld" type="text" class="form-control" id="input-password-old" aria-describedby="emailHelp" placeholder="Nhập mật khẩu cũ" required="required" />
										</div>
										<div class="form-group">
											<label for="input-password-new">Mật khẩu mới</label>
											<input name="password" type="password" class="form-control" id="input-password-new" placeholder="Nhập mật khẩu mới" required="required" />
										</div>
										<div class="form-group">
											<label for="input-password-confirm">Mật khẩu xác nhận</label>
											<input name="passwordConfirm" type="password" class="form-control" id="input-password-confirm" placeholder="Nhập mật khẩu xác nhận" required="required" />
										</div>
										<c:if test="${not empty message }">
											<small id="message" class="form-text text-muted" style="color: red; background-color: #d1e0e0; width: 100%; padding: 5px;">${message }<br></small>
										</c:if>
										<button type="submit" class="btn btn-light btn-round px-5" >
							               	Cập nhật
							            </button>
									</form>
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

<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp"%>
<!-- end footer-->