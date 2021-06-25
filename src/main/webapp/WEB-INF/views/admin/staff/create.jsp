<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp" %>
<%@ include file="/resources/admin/template/header.jsp" %>
<%@ include file="/resources/admin/template/sidebar.jsp" %>
<%@ include file="/resources/admin/template/topbar.jsp" %>

<!-- 	========================================================start content======================================================================= -->
	<div class="content-wrapper">
    <div class="container-fluid">
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
		
<!--     	=================================================================== table ==================================================================== -->
		<div class="card">
			<div class="card-header text-center">
				Nhân viên mới
			</div>
			<form:form action="admin/them-nhan-vien.htm" method="post" modelAttribute="nhanVienMoi">
				<div class="card-body" >
					<div class="row">
						<div class="col-12 col-lg-6 col-xl-6">
							<label>Thông tin cá nhân</label>
							<div class="form-group">
								<label for="input-1">Tên</label>
								<form:input path="ten" type="text"
									class="form-control form-control-rounded" id="input-1"
									placeholder="Nhập họ và tên nhân viên" required="required" />
								<form:errors path="ten" class="text-danger" />
							</div>
							<div class="form-group">
								<label for="input-2">Số điện thoại</label>
								<form:input path="soDienThoai" type="text"
									class="form-control form-control-rounded" id="input-2"
									placeholder="Nhập số điện thoại" required="required" pattern="[0-9]{10}" />
								<form:errors path="soDienThoai" class="text-danger" />
							</div>
							<div class="form-group">
								<label for="input-3">Địa chỉ</label>
								<form:input path="diaChi" type="text"
									class="form-control form-control-rounded" id="input-3"
									placeholder="Nhập địa chỉ" required="required" />
								<form:errors path="diaChi" class="text-danger" />
							</div>
							<div class="form-group">
								<label for="input-4">Ngày sinh</label>
								<form:input path="ngaySinh" type="date"
									class="form-control form-control-rounded" id="input-4" />
								<form:errors path="ngaySinh" class="text-danger" />
							</div>
						</div>
						<div class="col-12 col-lg-6 col-xl-6">
							<label>Thông tin đăng nhập</label>
							<br><br><br>
							<div class="form-group">
								<label for="input-5">Tên đăng nhập</label>
								<form:input path="username" type="text"
									class="form-control form-control-rounded" id="input-5"
									placeholder="Nhập tên đăng nhập" required="required" />
							</div>
							<div class="form-group">
								<label for="input-6">Mật khẩu</label> <input name="password"
									type="password" class="form-control form-control-rounded"
									id="input-6" placeholder="Nhập mật khẩu" required="required" >
							</div>
							<div class="form-group">
								<label for="input-7">Mật khẩu xác nhận</label> <input
									name="passwordconfirm" type="password"
									class="form-control form-control-rounded" id="input-7"
									placeholder="Nhập mật khẩu xác nhận" required="required" >
							</div>
							
						</div>
					</div>
				</div>
				<div class="card-footer">
					<div class="form-group" style="float: right;" >
						<button type="submit" class="btn btn-light btn-round px-5">
							<i class="icon-plus"></i> Tạo nhân viên mới
						</button>
					</div>
				</div>
			</form:form>
		</div>
        <!--End Row-->
    </div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<!-- 	=======================================================script==================================== -->
	<script>
		document.getElementById('mainLabel').innerHTML = 'Thêm nhân viên';
		document.getElementById("search").style.visibility = "hidden";
	</script>
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>