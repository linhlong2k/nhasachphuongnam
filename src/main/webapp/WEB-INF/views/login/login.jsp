<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp" %>
<%@ include file="/resources/admin/template/header.jsp" %>

    <!-- Start wrapper-->
	<div id="wrapper" style="margin-top: 100px;">
		<div class="loader-wrapper">
			<div class="lds-ring">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
		</div>
		<div class="row" >
			<div class="col-2"></div>
			<div class="col-5" style="padding: 50px; margin-top: 30px; border-radius: 5px;" >
				<div class="text-center card-header" style="background-color: rgb(255, 255, 255, 0.9);">
					<img alt="logo icon" src="resources/images/Logonhasachphuongnam.png" width="100%">
				</div>
				<br><br>
				<div>
					<p style="font-size: 20px;">Nhasachphuongnam.com là trang thương mại điện tử của Nhà Sách Phương Nam, hệ thống nhà sách thân thuộc của nhiều gia đình Việt kể từ nhà sách đầu tiên ra đời năm 1982 đến nay.  </p>
				</div>
			</div>
			<div class="col-3">
				<div class="card mx-auto my-5" style="margin-left: 0 !important;">
					<div class="card-body" >
						<div class="card-content p-2">
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
							Bạn chưa có tài khoản? <a href="dang-ky.htm">Đăng ký tại đây</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-2"></div>
		</div>
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