<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp" %>
<%@ include file="/resources/admin/template/header.jsp" %>

    <!-- Start wrapper-->
	<div id="wrapper">
		<div class="loader-wrapper">
			<div class="lds-ring">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
		</div>
		<div class="card card-authentication1 mx-auto my-5">
			<div class="card-body">
				<div class="card-content p-2">
					<div class="text-center">
						<img src="resources/admin/assets/images/logo-icon.png" alt="logo icon">
					</div>
					<div class="card-title text-uppercase text-center py-3">Đăng nhập</div>
					<form:form action="dang-nhap.htm" method="post" modelAttribute="thongTinDangNhap">
						<div class="form-group">
							<div class="position-relative has-icon-right">
								<form:input path="username" type="text" class="form-control input-shadow" placeholder="Nhập Username" />
								<form:errors path="username" />
								<div class="form-control-position">
									<i class="icon-user"></i>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="position-relative has-icon-right">
								<form:input path="password" type="password" class="form-control input-shadow" placeholder="Nhập Password" />
								<form:errors path="password" />
								<div class="form-control-position">
									<i class="icon-lock"></i>
								</div>
							</div>
						</div>
						<form:input path="role" value="0" type="hidden" />
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
<!-- 		================================================================ create button ===================================================== -->
						<hr>
						<button type="submit" class="btn btn-light btn-block">Đăng nhập</button>
					</form:form>
				</div>
			</div>
			<div class="card-footer text-center py-3">
				<p class="text-warning mb-0">
					Bạn chưa có tài khoản? <a href="login/dangky.htm">Đăng ký tại đây</a>
				</p>
			</div>
		</div>

		<!--Start Back To Top Button-->
		<a href="javaScript:void();" class="back-to-top"><i
			class="fa fa-angle-double-up"></i> </a>
		<!--End Back To Top Button-->
	</div>
	<!--End wrapper-->


	<!-- Bootstrap core JavaScript-->
	<script src="resources/admin/assets/js/jquery.min.js"></script>
	<script src="resources/admin/assets/js/popper.min.js"></script>
	<script src="resources/admin/assets/js/bootstrap.min.js"></script>

	<!-- sidebar-menu js -->
	<script src="resources/admin/assets/js/sidebar-menu.js"></script>

	<!-- Custom scripts -->
	<script src="resources/admin/assets/js/app-script.js"></script>

</body>
</html>