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
		<div class="row mt-3 justify-content-center">
          <div class="col-lg-6">
            <div class="card">
            	<div class="card-header">
            		<div class="card-title"><strong>Thêm nhân viên</strong>&nbsp;&nbsp;<a href="nhan-vien/index.htm" style="float: right;">Hủy</a></div>
            	</div>
              <div class="card-body">
                <form:form action="nhan-vien/them-nhan-vien-moi.htm" method="post" modelAttribute="nhanVienMoi">
                  <div class="form-group">
                    <label for="input-1">Tên</label>
                    <form:input path="ten" type="text" class="form-control form-control-rounded" id="input-1" placeholder="Nhập họ và tên nhân viên" />
                  	<form:errors path="ten" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="input-2">Số điện thoại</label>
                    <form:input path="soDienThoai" type="text" class="form-control form-control-rounded" id="input-2" placeholder="Nhập số điện thoại" />
                  	<form:errors path="soDienThoai" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="input-3">Địa chỉ</label>
                    <form:input path="diaChi" type="text" class="form-control form-control-rounded" id="input-3" placeholder="Nhập địa chỉ" />
                  	<form:errors path="diaChi" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="input-4">Ngày sinh</label>
                    <form:input path="ngaySinh" type="date" class="form-control form-control-rounded" id="input-4" />
                  	<form:errors path="ngaySinh" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="input-5">Tên đăng nhập</label>
                    <form:input path="username" type="text" class="form-control form-control-rounded" id="input-5" placeholder="Nhập tên đăng nhập" />
                  </div>
                  <div class="form-group">
                    <label for="input-6">Mật khẩu</label>
                    <input name="password" type="password" class="form-control form-control-rounded" id="input-6" placeholder="Nhập mật khẩu">
                  </div>
                  <div class="form-group">
                    <label for="input-7">Mật khẩu xác nhận</label>
                    <input name="passwordconfirm" type="password" class="form-control form-control-rounded" id="input-7" placeholder="Nhập mật khẩu xác nhận">
                  </div>
                  <div class="form-group">
                    <button type="submit" class="btn btn-light btn-round px-5"><i class="icon-plus"></i> Tạo nhân viên mới</button>
                  </div>
                </form:form>
              </div>
            </div>
          </div>
        </div>
        <!--End Row-->
    </div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<%@ include file="/resources/admin/template/footer.jsp" %>