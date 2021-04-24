<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/admin/header.jsp" %>
<%@ include file="/common/admin/sidebar.jsp" %>
<%@ include file="/common/admin/topbar.jsp" %>

<!-- 	========================================================start content======================================================================= -->
	<div class="content-wrapper">
    <div class="container-fluid">
<!--     	================================================================= message =========================================================== -->
		<c:if test="${message != null}">
			<c:choose>
				<c:when test="${fn:contains(message, 'thành công')}">
					<div class="alert alert-success" role="alert">${message }</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-danger" role="alert">${message }</div>
				</c:otherwise>
			</c:choose>
		</c:if>
<!-- 		================================================================ create button ===================================================== -->
		
<!--     	=================================================================== table ==================================================================== -->
		<div class="card">
            <div class="card-body">
	            <div>
	            	<h5 class="card-title" style="float: left;"><strong>Danh sách sản phẩm</strong></h5>
	            	<form:form action="create.htm" style="float: right; margin: 5px;">
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
                	<c:forEach var="prod" items="${product}">
	                	<tr>
	                    	<th scope="row">${prod.maMH }</th>
	                    	<td>${prod.hinhAnh }</td>
	                    	<td>${prod.tenMH }</td>
	                    	<td>${prod.gia }</td>
	                    	<td>${prod.soLuong }</td>
	                    	<td>${prod.maLoai }</td>
	                    	<td>
	                    		<form:form action="update/${prod.maMH }.htm">
	                    			<button type="submit" class="btn btn-light btn-round px-3">Chỉnh sửa</button>
	                    		</form:form>
	                    	</td>
	                    	<td>
	                    		<form:form action="delete/${prod.maMH }.htm">
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
<%@ include file="/common/admin/footer.jsp" %>