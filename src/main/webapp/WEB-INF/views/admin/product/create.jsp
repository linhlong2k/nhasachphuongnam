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
		
<!--     	=================================================================== form ==================================================================== -->
		<div class="card mt-3">
			<div class="card-content">
				<div class="card-body">
					<h3 class="text-white text-center">
						<span>&nbsp;Tạo mặt hàng mới</span>
					</h3>
				</div>
				<form:form action="admin/them-mat-hang.htm" method="post" modelAttribute="matHang" enctype="multipart/form-data" style="width: 100%;">
				<div class="card-body row">
					<div class="col-12 col-lg-6 col-xl-6">
						<div class="table-responsive">
							<table class="table align-items-center">
								<tbody>
									<tr>
										<td>Mã mặt hàng</td>
										<td>
											<form:input path="maMatHang" class="form-control" id="input-1" readonly="true" />
											<form:errors path="maMatHang" class="invalid-feedback" />
										</td>
									</tr>
									<tr>
										<td>Tên mặt hàng</td>
										<td colspan="3">
											<form:input path="tenMatHang" class="form-control" id="input-2" required="true" />
											<form:errors path="tenMatHang" class="text-danger" />
										</td>
									</tr>
									<tr>
										<td>Hình ảnh</td>
										<td>
											<input class="form-control" type="file" id="formFile" name="photo">
										</td>
									</tr>
									<tr>
										<td>Giá</td>
										<td>
											<form:input path="gia" type="number" class="form-control" id="input-4" />
											<form:errors path="gia" class="text-danger" />
										</td>
									</tr>
									<tr>
										<td>số lượng</td>
										<td>
											<form:input path="soLuong" type="number" class="form-control" id="input-5" />
											<form:errors path="soLuong" class="text-danger" />
										</td>
									</tr>
									<tr>
										<td>loại</td>
										<td>
											<form:select path="maLoai" items="${danhSachLoaiMatHang }" itemValue="maLoai" itemLabel="tenLoai" selected="true" class="form-control"></form:select>
											<form:errors path="maLoai" class="text-danger" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-6">
						<div class="table-responsive">
							<table class="table align-items-center">
								<tbody>
										<tr>
											<td>Mô tả ngắn</td>
											<td colspan="5">
												<form:textarea path="moTaNgan" class="form-control" rows="5" id="input-7" />
												<form:errors path="moTaNgan" class="text-danger" /></td>
										</tr>
										<tr>
											<td>Mô tả</td>
											<td colspan="6">
												<form:textarea path="moTa" class="form-control" rows="8" id="input-8" />
												<form:errors path="moTa" class="text-danger" />
											</td>
										</tr>
										<tr>
											<td colspan="6">
												<button name="btnCreate" type="submit" class="btn btn-light btn-round px-5 float-right">Lưu</button>
											</td>
										</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				</form:form>
			</div>
		</div>
		<%-- 
		<div class="col-lg-8" style="margin: 0 auto;">
            <div class="card">
              	<div class="card-body">
                	<div class="card-title">MẶT HÀNG</div>
                	<hr>
                	<form:form action="admin/mat-hang/tao-mat-hang-moi.htm" modelAttribute="matHangMoi">
               			<div class="form-group">
                    		<label for="input-1">Mã mặt hàng</label>
                    		<form:input path="maMatHang" type="text" class="form-control" id="input-1" readonly="true" />
                    		<form:errors path="maMatHang" class="invalid-feedback" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-2">Tên mặt hàng</label>
                    		<form:input path="tenMatHang" type="text" class="form-control" id="input-2" required="true" />
                    		<form:errors path="tenMatHang" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-3">Hình ảnh</label>
                    		<form:input path="hinhAnh" type="text" class="form-control form-control-rounded" id="input-3" />
                    		<form:errors path="hinhAnh" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-4">Giá</label>
                    		<form:input path="gia" type="text" class="form-control" id="input-4" />
                    		<form:errors path="gia" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-5">Số lượng</label>
                    		<form:input path="soLuong" type="text" class="form-control" id="input-5" />
                    		<form:errors path="soLuong" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-6">Loại</label>
                    		<form:input path="maLoai" type="text" class="form-control" id="input-6" />
                    		<form:select path="maLoai" items="${danhSachLoaiMatHang }" itemValue="maLoai" itemLabel="tenLoai" class="form-control"/>
                    		<form:errors path="maLoai" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-7">Mô tả ngắn</label>
                    		<form:textarea path="moTaNgan" class="form-control" rows="5" id="input-7" />
                    		<form:errors path="moTaNgan" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-8">Mô tả</label>
                    		<form:textarea path="moTa" class="form-control" rows="10" id="input-8" />
                    		<form:errors path="moTa" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<button type="submit" class="btn btn-light btn-round px-5">
                    			<!-- <i class="icon-lock"></i> -->
                      			Cập nhập
                      		</button>
                  		</div>
                	</form:form>
              	</div>
            </div>
		</div> --%>
		
    </div><!-- End container-fluid-->
	</div><!--End content-wrapper-->
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>