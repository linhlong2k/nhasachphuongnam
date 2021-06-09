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
		<div class="row">
        	<div class="col-12 col-lg-7 col-xl-7">
            	<div class="card">
                	<div class="card-body">
                		<div class="card-title">Đơn hàng nhập</div>
                      	<hr>
                     	<form:form action="admin/tao-don-hang-nhap/thong-tin-don-hang-nhap.htm" modelAttribute="donHangNhapMoi" method="POST">
                        	<div class="form-group">
                             	<label for="input-1">Mã đơn nhập</label>
                               	<form:input path="maDonHang" type="text" class="form-control" id="input-1"
                         			readonly="true" />
                               	<form:errors path="maDonHang" class="invalid-feedback" />
                           	</div>
                          	<div class="form-group">
                      			<label for="input-2">Thời gian</label>
                          	   	<form:input path="thoiGian" type="date" class="form-control" id="input-2" />
                               	<form:errors path="thoiGian" class="text-danger" />
                            </div>
                          	<div class="form-group">
                           		<label for="input-3">Nhà cung cấp</label>
                           		<form:select path="maNhaCungCap" items="${danhSachNhaCungCap }" itemValue="maNhaCungCap" itemLabel="tenNhaCungCap" class="form-control"/>
                    			<form:errors path="maNhaCungCap" class="text-danger" />
                          	</div>
                          	<div class="form-group">
								<button type="submit" class="btn btn-light btn-round px-5">
									<i class="icon icon-pin" ></i>
								</button>
							</div>
                    	</form:form>
                    	<div>
                    		<label>Mặt hàng</label>
                       		<div class="form-group">
	                       		<table class="table table-hover" id="table">
	                       			<thead>
	                       				<tr>
	                       					<th>Mã mặt hàng</th>
	                       					<th>Giá</th>
	                       					<th>Số lượng</th>
	                       					<th>Giảm giá</th>
	                       					<th></th>
	                       				</tr>
	                       			</thead>
	                       			<tbody>
	                       					<c:forEach var="s" items="${danhSachMatHangDaChon}">
				                       			<tr>
				                       				<td scope="row">${s.maMatHang }</td>
				                       				<td>${s.gia }</td>
				                       				<td>${s.soLuong }</td>
				                       				<td>${s.giamGia }</td>
				                       				<td>
				                       					<form:form action="admin/tao-don-hang-nhap/xoa-mat-hang/${s.maMatHang }.htm" method="POST">
				                       						<button type="submit" class="btn btn-light btn-round px-5">
				                       							<i class="icon icon-minus" style="color:red;"></i>
				                       						</button>
				                       					</form:form>
				                       				</td>
												</tr>
				                       		</c:forEach>
		                       		</tbody>
                       			</table>
	                     	</div>		
                    	</div>
                    	<hr>
                  		<div style="float: left;">
							<form:form
								action="admin/tao-don-hang-nhap/save.htm"
								method="POST">
								<button type="submit" class="btn btn-light btn-round px-5">
									<i class="icon icon-saves" ></i><!-- chưa thêm icon vào đoạn này -->
									Lưu
								</button>
							</form:form>
						</div>
						<div style="float: right;">
							<form:form
								action="admin/tao-don-hang-nhap/reset.htm"
								method="POST">
								<button type="submit" class="btn btn-light btn-round px-5">
									<i class="icon icon-reset" ></i><!-- chưa thêm icon vào đoạn này -->
									Xóa mặt hàng đã chọn
								</button>
							</form:form>
						</div>
                  	</div>
            	</div>
          	</div>
       		<div class="col-12 col-lg-5 col-xl-5">
                        <div class="card">
                            <div class="card-header">
                                <h3><strong>Danh sách mặt hàng</strong></h3>
                            </div>
                            <div class="table-responsive">
                                <table class="table align-items-center" id="table">
                                	<thead>
                                		<tr>
                                			<th><i class="text-white mr-2"></i>Mã</td>
                                            <th>Giá</th>
                                            <th>Số lượng</th>
                                            <th>Giảm giá</th>
                                            <th></th>
                                		</tr>
                                	</thead>
                                    <tbody>
                                        <c:forEach var="prod" items="${danhSachMatHang }">
                                            <tr>
                                                <form:form
                                                	action="admin/tao-don-hang-nhap/them-mat-hang.htm"
                                                    modelAttribute="matHangChon" method="POST">
                                                    <td>
                                                        <form:input path="maMatHang" value="${prod.maMatHang }"
                                                            class="form-control" readonly="true" />
                                                    </td>
                                                    <td>
                                                        <form:input path="gia" value="${prod.gia }"
                                                            class="form-control" readonly="true" />
                                                    </td>
                                                    <td>
                                                    	<form:input path="soLuong" class="form-control" />
                                                    </td>
                                                    <td>
                                                    	<form:input path="giamGia" class="form-control" />
                                                    </td>
                                                    <td style="padding: 0;">
                                                        <button type="submit" class="btn btn-light btn-round px-3">
                                                            <i class="zmdi zmdi-plus"></i>
                                                        </button>
                                                    </td>
                                                </form:form>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
    </div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<%@ include file="/resources/admin/template/footer.jsp" %>