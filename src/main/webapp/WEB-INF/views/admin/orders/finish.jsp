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
					<div class="alert alert-danger" role="alert">
						<i class="zmdi zmdi-case-check"></i>${message }</div>
					<!-- <script type="text/javascript">
						alert("${message}");
					</script> -->
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" role="alert">
						<i class="zmdi zmdi-alert-triangle"></i>${message }</div>
				</c:otherwise>
			</c:choose>
		</c:if>
		<!-- 		================================================================ create button ===================================================== -->

		<!--     	=================================================================== table ==================================================================== -->
		<div class="card">
			<div class="card-body">
				<div>
					<h3 class="card-title" style="float: left;">
						<strong>Danh sách đơn hàng</strong>
					</h3>
					<br>
					<br>
				</div>
				<div class="table-responsive">
					<table class="table table-hover" id="table">
						<thead>
							<tr>
								<th scope="col">Mã đơn hàng</th>
								<th scope="col">Mã nhân viên</th>
								<th scope="col">Mã khách hàng</th>
								<th scope="col">Thời gian</th>
								<th scope="col"></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${danhSachDonHang}">
							<form action="admin/xac-nhan-nhan-hang.htm" method="post" >
								<tr>
									<td scope="row"><input name="id" value="${item.maDonHang }" readonly="readonly" class="form-control" /></td>
									<td>${item.maNhanVien }</td>
									<td>${item.maKhachHang }</td>
									<td>${item.thoiGian }</td>
									<td>
										<button type="submit" name="ok" class="btn btn-light btn-round px-3"> Xác nhận</button>
									</td>
									<td>
										 <button type="submit" name="cancel" class="btn btn-light btn-round px-3"> Xóa đơn hàng</button>
									</td>
								</tr>
							</form>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- End container-fluid-->
    </div><!--End content-wrapper-->
<%@ include file="/resources/admin/template/footer.jsp" %>