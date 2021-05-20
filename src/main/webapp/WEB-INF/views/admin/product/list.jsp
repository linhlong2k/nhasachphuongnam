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
            <div class="card-body">
	            <div>
	            	<h5 class="card-title" style="float: left;"><strong>Danh sách sản phẩm</strong></h5>
	            	<form:form action="mat-hang/tao-mat-hang-moi.htm" method="GET" style="float: right; margin: 5px;" >
	            		<button type="submit" class="btn btn-light btn-round px-3">Create</button>
	            	</form:form>
	            </div>
			  	<div class="table-responsive">
              	<table class="table table-hover">
                	<thead>
	        			<tr>
		             		<th scope="col">Mã mặt hàng</th>
		                    <th scope="col">Hình ảnh</th>
		                    <th scope="col">Tên mặt hàng</th>
		                    <th scope="col">Giá</th>
		                    <th scope="col">Số lượng</th>
		                    <th scope="col">Loại</th>
		                    <th scope="col"></th>
		                    <th scope="col"></th>
	                  	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="prod" items="${danhSachMatHang}">
	                	<tr>
	                    	<th scope="row">${prod.maMatHang }</th>
	                    	<td>abc</td>
	                    	<td>${prod.tenMatHang }</td>
	                    	<td>${prod.gia }</td>
	                    	<td>${prod.soLuong }</td>
	                    	<td>${prod.maLoai }</td>
	                    	<td>
	                    		<form:form action="mat-hang/chinh-sua-mat-hang/${prod.maMatHang }.htm" method="GET">
	                    			<button type="submit" class="btn btn-light btn-round px-3">Chỉnh sửa</button>
	                    		</form:form>
	                    	</td>
	                    	<td>
	                    		<form:form action="mat-hang/xoa-mat-hang/${prod.maMatHang }.htm" method="GET">
	                    			<button type="submit" class="btn btn-light btn-round px-3">Xóa</button>
	                    		</form:form>
	                    	</td>
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
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>