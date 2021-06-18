<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/admin/template/header.jsp"%>
<!-- Start wrapper-->
<div id="wrapper">
	<!--     	================================================================= message =========================================================== -->
		<c:if test="${message != null}">
			<c:choose>
				<c:when test="${fn:contains(message, 'không')}">
					<div class="alert alert-danger" role="alert"><i class="zmdi zmdi-case-check"></i>${message }</div>
					<!-- <script type="text/javascript">
						alert("${message}");
					</script> -->
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" role="alert"><i class="zmdi zmdi-alert-triangle"></i>${message }</div>
				</c:otherwise>
			</c:choose>
		</c:if>
<!-- 		================================================================== -->
	<div class="card card-authentication1 mx-auto my-4">
		<div class="card-body">
			<div class="card-content p-2">
				<div class="text-center">
					<img alt="logo icon" src="resources/images/Logonhasachphuongnam.png" width="100%">
				</div>
				<form:form aciton="dang-ky.htm" method="post" modelAttribute="khachHangMoi">
					<div class="form-group">
						<label for="input-ten" class="sr-only">Họ và tên</label>
						<div class="position-relative has-icon-right">
							<form:input path="ten" type="text" id="input-ten" class="form-control input-shadow" placeholder="Nhập tên" required="required" pattern="[A-Za-z0-9]{0-50}" />
							<div class="form-control-position">
								<i class="icon-user"></i>
							</div>
							<form:errors path="ten" class="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="input-sdt" class="sr-only">Số điện thoại</label>
						<div class="position-relative has-icon-right">
							<form:input path="soDienThoai" type="text" id="input-sdt" class="form-control input-shadow" placeholder="Nhập số điện thoại" required="required" pattern="[0-9]{10}" />
							<div class="form-control-position">
								<i class="icon-phone"></i>
							</div>
							<form:errors path="soDienThoai" class="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="input-dia- chi" class="sr-only">Địa chỉ</label>
						<div class="position-relative has-icon-right">
							<form:input path="diaChi" type="text" id="input-dia-chi" class="form-control input-shadow" placeholder="Nhập địa chỉ" required="required" />
							<div class="form-control-position">
								<i class="icon-direction"></i>
							</div>
							<form:errors path="diaChi" class="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="input-ngay-sinh" class="sr-only">Ngày sinh</label>
						<div class="position-relative">
							<form:input path="ngaySinh" type="date" id="input-ngay-sinh" class="form-control input-shadow" required="required" />
						</div>
						<form:errors path="ngaySinh" class="text-danger" />
					</div>
					<div class="form-group">
						<label for="input-username" class="sr-only">Tên đăng nhập</label>
						<div class="position-relative has-icon-right">
							<form:input path="username" type="text" id="input-username" class="form-control input-shadow" placeholder="Nhập tên đăng nhập" required="required" pattern="[A-Za-z0-9]{0-25}" />
							<div class="form-control-position">
								<i class="icon-user"></i>
							</div>
							<form:errors path="username" class="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="input-password" class="sr-only">Mật khẩu</label>
						<div class="position-relative has-icon-right">
							<input name="password" type="text" id="input-password" class="form-control input-shadow" placeholder="Nhập mật khẩu" required="required" pattern="[A-Za-z0-9]{0-50}" />
							<div class="form-control-position">
								<i class="icon-lock"></i>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="input-password-confirm" class="sr-only">Password</label>
						<div class="position-relative has-icon-right">
							<input name="passwordconfirm" type="text" id="input-password-confirm" class="form-control input-shadow" placeholder="Xác nhận mật khẩu" required="required" pattern="[A-Za-z0-9]{0-50}" />
							<div class="form-control-position">
								<i class="icon-lock"></i>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="icheck-material-white">
							<label for="user-checkbox" style="font-size: 10px;">KHI ĐĂNG KÝ, BẠN ĐÃ ĐỒNG Ý VỚI ĐIỀU KHOẢN SỬ DỤNG VÀ CHÍNH SÁCH BẢO MẬT CỦA CHÚNG TÔI.</label>
						</div>
					</div>
					<button type="submit" class="btn btn-light btn-block waves-effect waves-light">Đăng ký</button>
				</form:form>
			</div>
		</div>
		<div class="card-footer text-center py-3">
			<p class="text-warning mb-0">
				Bạn đã có tài khoản? <a href="dang-nhap.htm"> Đăng nhập tại đây</a>
			</p>
		</div>
	</div>

	<!--Start Back To Top Button-->
	<a href="javaScript:void();" class="back-to-top"><i
		class="fa fa-angle-double-up"></i> </a>
	<!--End Back To Top Button-->

</div>
<!--wrapper-->
<%@ include file="/resources/admin/template/footer.jsp"%>