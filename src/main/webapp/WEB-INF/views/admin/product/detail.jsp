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
		<!-- 		========================================================================================================================================== -->
		<div class="card mt-3">
			<div class="card-content">
				<div class="card-body">
					<h3 class="text-white text-center">
						<span>&nbsp;${matHang.tenMatHang }</span>
					</h3>
				</div>
				<div class="card-body row">
					<div class="col-12 col-lg-4 col-xl-4">
						<br>
						<div style="border: solid 2px blue; border-radius: 20px;">
							<c:choose>
								<c:when test="${empty matHang.hinhAnh}">
									<p>
										<img alt="image" src="resources/images/products/defaultProduct.png" class="card-img-top" />
									</p>
									<a href="admin/chi-tiet-mat-hang.htm?uploadPhotoId=${matHang.maMatHang}"><h5>&nbsp;&nbsp;Cập nhập ảnh</h5></a>
								</c:when>
								<%-- test="${not empty prod.hinhAnh }" --%>
								<c:otherwise>
									<p>
										<img alt="image" src="data:image/jpeg;base64,${matHang.getBase64Photo() }" class="card-img-top" />
									</p>
									<a href="admin/chi-tiet-mat-hang.htm?uploadPhotoId=${matHang.maMatHang}"><h5>&nbsp;&nbsp;Thay đổi ảnh</h5></a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="col-12 col-lg-8 col-xl-8">
						<div class="table-responsive">
							<table class="table align-items-center">
								<tbody>
									<form:form action="admin/chi-tiet-mat-hang.htm" method="post" modelAttribute="matHang">
										<tr>
											<td>Mã mặt hàng</td>
											<td>
												<form:input path="maMatHang" class="form-control" id="input-1" readonly="true" />
												<form:errors path="maMatHang" class="invalid-feedback" /></td>
											<td>Tên mặt hàng</td>
											<td colspan="3">
												<form:input path="tenMatHang" class="form-control" id="input-2" required="true" />
												<form:errors path="tenMatHang" class="text-danger" /></td>
										</tr>
										<tr>
											<td>Giá</td>
											<td>
												<form:input path="gia" type="number" class="form-control" id="input-4" />
												<form:errors path="gia" class="text-danger" /></td>
											<td>số lượng</td>
											<td>
												<form:input path="soLuong" type="number" class="form-control" id="input-5" />
												<form:errors path="soLuong" class="text-danger" /></td>
											<td>loại</td>
											<td>
												<form:select path="maLoai" items="${danhSachLoaiMatHang }" itemValue="maLoai" itemLabel="tenLoai" selected="true" class="form-control"></form:select>
												<form:errors path="maLoai" class="text-danger" /></td>
										</tr>
										<tr>
											<td>Mô tả ngắn</td>
											<td colspan="5">
												<form:textarea path="moTaNgan" class="form-control" rows="4" id="input-7" />
												<form:errors path="moTaNgan" class="text-danger" /></td>
										</tr>
										<tr>
											<td>Mô tả</td>
											<td colspan="5">
												<form:textarea path="moTa" class="form-control" rows="7" id="input-8" />
												<form:errors path="moTa" class="text-danger" />
											</td>
										</tr>
										<tr>
											<td colspan="6">
												<button name="btnSave" type="submit" class="btn btn-light btn-round px-5 float-right">Lưu</button>
											</td>
										</tr>
									</form:form>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
<!-- 		danh sách đơn hàng -->
		<%-- <div class="card">
			<div class="card-body">
				<div>
					<h5 class="card-title" style="float: left;">
						<strong>Đơn hàng</strong>
					</h5>
				</div>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Mã đơn hàng</th>
								<th scope="col">Thời gian</th>
								<th scope="col"></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${danhSachDonHang}">
								<tr>
									<th scope="row">${item.maDonHang }</th>
									<td>${item.thoiGian }</td>
									<td></td>
									<td><form:form action="order/update/${item.maDonHang}.htm"
											method="GET">
											<button type="submit" class="btn btn-light btn-round px-3">Chỉnh
												sửa</button>
										</form:form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div> --%>

        <!--start overlay-->
        <div class="overlay toggle-menu"></div>
        <!--end overlay-->
	
	</div><!-- End container-fluid-->
	</div><!--End content-wrapper-->
	
<!-- 	=======================================================script================================================================ -->
<script>
	document.getElementById('mainLabel').innerHTML = 'Chi tiết mặt hàng ${matHang.maMatHang }';
</script>
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>