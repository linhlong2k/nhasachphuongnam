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
					<div class="alert alert-danger" role="alert" style="padding: 5px;"><i class="zmdi zmdi-case-check"></i>${message }</div>
					<!-- <script type="text/javascript">
						alert("${message}");
					</script> -->
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" role="alert" style="padding: 5px;"><i class="zmdi zmdi-alert-triangle"></i>${message }</div>
				</c:otherwise>
			</c:choose>
		</c:if>
	<!-- =========================================================================================================================================== -->
<div class="row">
    <div class="col-12 col-lg-6 col-xl-6">
        <div class="card">
            <!-- <div class="card-header">
                <h3><strong>Loại mặt hàng</strong></h3>
            </div> -->
            <div class="table-responsive">
                <table class="table align-items-center" id="table">
                    <tbody>
                        <tr>
                            <th><i class="text-white mr-2"></i>Mã</th>
                            <th>Tên</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="t" items="${danhSachLoaiMatHang }">
                        <tr>
							<form:form action="admin/loai-mat-hang/chinh-sua-loai-mat-hang/${t.maLoai }.htm" modelAttribute="loaiMatHangChinhSua" method="post">
	                       		<td>
	                       			${t.maLoai }
	                       			<form:input path="maLoai" value="${t.maLoai }" class="form-control" readonly="true" hidden="hidden" />
	                       		</td>
	                       		<td hidden="hidden">
	                       			${t.tenLoai }
	                       		</td>
		                        <td><form:input path="tenLoai" value="${t.tenLoai }" class="form-control" /></td>
		                        <td style="padding: 0;">
		                         	<button type="submit" class="btn btn-light btn-round px-3">
		                          		<i class="zmdi zmdi-save"></i>
		                         	</button>
		                      	</td>
	                       	</form:form>
	                       	<td style="padding: 0;">
	                       		<form:form action="admin/loai-mat-hang/xoa-loai-mat-hang/${t.maLoai }.htm" method="post">
		                            <button type="submit" class="btn btn-light btn-round px-3">
			                        	<i class="zmdi zmdi-delete"></i>
			                      	</button>
		                     	</form:form>
	                    	</td>
	                     	<td style="padding: 0;">
	                     		<form:form action="admin/loai-mat-hang/chi-tiet-loai-mat-hang/${t.maLoai }.htm" method="post">
		                            <button type="submit" class="btn btn-light btn-round px-3">
			                        	<i class="zmdi zmdi-info-outline"></i>
			                      	</button>
		                     	</form:form>
	                      	</td>
	                    </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-12 col-lg-6 col-xl-6">
    	<div class="card">
            <div class="card-header">Thêm loại mặt hàng</div>
            <form:form action="admin/loai-mat-hang/tao-loai-mat-hang-moi.htm" modelAttribute="loaiMatHangMoi" method="post">
            	<div class="card-body">
                	<%-- <div class="form-group row">
                        <label class="col-lg-3 col-form-label form-control-label">Mã Loại</label>
                        <div class="col-lg-9">
                            <form:input path="maLoai" class="form-control" type="text" placeholder="Nhập mã loại" />
                            <form:errors path="maLoai" class="text-danger" />
                        </div>
                    </div> --%>
                    <div class="form-group row">
                        <label class="col-lg-3 col-form-label form-control-label">Tên Loại</label>
                        <div class="col-lg-9">
                            <form:input path="tenLoai" class="form-control" type="text" placeholder="Nhập tên loại" />
                        	<form:errors path="tenLoai" class="text-danger" />
                        </div>
                    </div>
                </div>
	            <div class="card-footer">
	                <button type="submit" class="btn btn-light btn-round px-5 float-right">
	                    Thêm
	                </button>
	            </div>
			</form:form>
        </div>
        <div class="card">
            <div class="card-body">
                <div>
                    <h5 class="card-title float-left"><strong>Danh sách mặt hàng</strong></h5>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Mã mặt hàng</th>
                                <th scope="col">Tên mặt hàng</th>
                                <th scope="col">số lượng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="prod" items="${danhSachMatHang}">
                                <tr>
                                    <th scope="row">${prod.maMatHang }</th>
                                    <td>${prod.tenMatHang }</td>
                                    <td>${prod.soLuong }</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
	
	</div><!-- End container-fluid-->
	</div><!--End content-wrapper-->
<!-- 	============================================<script>============================================= -->
	<script>
	document.getElementById('mainLabel').innerHTML = 'Danh sách loại mặt hàng';
	function myFunction() {
		var input, filter, table, tr, i, txtValue, txtValue2, firstCol, secondCol;
		input = document.getElementById("search");
		filter = input.value.toUpperCase();
		table = document.getElementById("table");
		tr = table.getElementsByTagName("tr");
	    for (i = 0; i < tr.length; i++) {
	        firstCol = tr[i].getElementsByTagName("td")[0];
	        secondCol = tr[i].getElementsByTagName("td")[1];
	        if (firstCol) {
				txtValue = firstCol.textContent || firstCol.innerText;
				txtValue2 = secondCol.textContent || secondCol.innerText;
				if (txtValue.toUpperCase().indexOf(filter) > -1 || txtValue2.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}   
	    }
	}
	</script>
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>