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
		<div class="card" style="width: 500px; margin: 0 auto;">
			<!-- <div class="card-header">
				<strong>Nhà cung cấp</strong>
			</div> -->
            <div class="card-body">
			  	<form:form action="admin/nha-cung-cap/cap-nhat-nha-cung-cap.htm" method="post" modelAttribute="nhaCungCapNew">
					<div class="form-group row">
						<label class="col-lg-5 col-form-label form-control-label">Mã nhà cung cấp</label>
						<div class="col-lg-7">
							<form:input path="maNhaCungCap" class="form-control form-control-rounded" readonly="true"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-5 col-form-label form-control-label">Tên nhà cung cấp</label>
						<div class="col-lg-7">
							<form:input path="tenNhaCungCap" class="form-control form-control-rounded" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-5 col-form-label form-control-label">Địa chỉ</label>
						<div class="col-lg-7">
							<form:input path="diaChi" class="form-control form-control-rounded" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-5 col-form-label form-control-label">Số điện thoại</label>
						<div class="col-lg-7">
							<form:input path="soDienThoai" class="form-control form-control-rounded" pattern="[0-9]{10}" />
						</div>
					</div>
					<div class="form-group row">
						<button type="submit" class="btn btn-light btn-round px-5 col-lg-5">
							<i class="icon-lock"></i> Cập nhật
						</button>
						<div class="col-lg-2"></div>
						<button type="submit" class="btn btn-light btn-round px-5 col-lg-5" name="reset" >
							<i class="icon-lock"></i> Reset
						</button>
					</div>
				</form:form>           
            </div>
        </div>
       	<br>
		<div class="card" style="height: 650px;">
            <div class="card-body">
	            <!-- <div>
	            	<h3 class="card-title" style="float: left;"><strong>Danh sách nhà cung cấp</strong></h3>
	            	<br><br>
	            </div> -->
			  	<div class="table-responsive">
              	<table class="table table-hover" id="table">
                	<thead>
	        			<tr>
		             		<th scope="col">Mã nhà cung cấp</th>
		                    <th scope="col">Tên nhà cung cấp</th>
		                    <th scope="col">Địa chỉ</th>
		                    <th scope="col">Số điện thoại</th>
		                    <th scope="col"></th>
		                    <th scope="col"></th>
	                  	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="ncc" items="${danhSachNhaCungCap}">
	                	<tr>
	                    	<form:form action="admin/nha-cung-cap/index.htm" method="post" modelAttribute="nhaCungCapIndex">
		                    	<td scope="row">
		                    		${ncc.maNhaCungCap }
		                    		<form:input path="maNhaCungCap" value="${ncc.maNhaCungCap }" class="form-control" readonly="true" hidden="hidden" />
		                    	</td>
		                    	<td>${ncc.tenNhaCungCap }</td>
		                    	<td>${ncc.diaChi }</td>
		                    	<td>${ncc.soDienThoai }</td>
		                    	<td>
		                    		<button type="submit" class="btn btn-light btn-round px-3" name="chinh-sua-nha-cung-cap">Chỉnh sửa</button>
		                    	</td>
		                    	<td>
		                    		<button type="submit" class="btn btn-light btn-round px-3" name="xoa-nha-cung-cap">Xóa</button>
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
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<!-- 	=======================================================script==================================== -->
	<script>
	    document.getElementById('mainLabel').innerHTML = 'Danh sách nhà cung cấp';
		function myFunction() {
			var input, filter, table, tr, i, txtValue, txtValue2, firstCol, secondCol;
			input = document.getElementById("search");
			filter = input.value.toUpperCase();
			table = document.getElementById("table");
			tr = table.getElementsByTagName("tr");
		    for (i = 0; i < tr.length; i++) {
		        firstCol = tr[i].getElementsByTagName("td")[0];
		        secondCol = tr[i].getElementsByTagName("td")[1];
		        if (firstCol || secondCol) {
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