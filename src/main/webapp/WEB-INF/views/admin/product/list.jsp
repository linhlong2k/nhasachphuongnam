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
	            	<h3 class="card-title" style="float: left;"><strong>Danh sách sản phẩm</strong></h3>
	            	<form:form action="admin/mat-hang/tao-mat-hang-moi.htm" method="GET" style="float: right; margin: 5px;" >
	            		<button type="submit" class="btn btn-light btn-round px-3">Tạo sản phẩm mới</button>
	            	</form:form>
	            	<br><br>
	            </div>
			  	<div class="table-responsive">
              	<table class="table table-hover" id="table">
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
	                    	<td scope="row">${prod.maMatHang }</td>
	                    	<c:choose>
	                    		<c:when test="${empty prod.hinhAnh}">
	                    			<td>
							    		<p><img alt="image" src="resources/images/products/defaultProduct.png" style="max-height: 100px; max-width: 100px;"/></p>
							    		<a href="admin/mat-hang/cap-nhat-hinh-anh/${prod.maMatHang}.htm">Cập nhập ảnh</a>
							    	</td>
								</c:when>
								<%-- test="${not empty prod.hinhAnh }" --%>
								<c:otherwise>
									<td>
										<p><img alt="image" src="data:image/jpeg;base64,${prod.getBase64Photo() }" style="max-height: 100px; max-width: 100px;"/></p>	
										<a href="admin/mat-hang/cap-nhat-hinh-anh/${prod.maMatHang}.htm">Thay đổi ảnh</a>
									</td>
								</c:otherwise>
							</c:choose>
	                    	<td>${prod.tenMatHang }</td>
	                    	<td>${prod.gia }</td>
	                    	<td>${prod.soLuong }</td>
	                    	<td>${prod.maLoai }</td>
	                    	<td>
	                    		<form:form action="admin/mat-hang/chinh-sua-mat-hang/${prod.maMatHang }.htm" method="GET">
	                    			<button type="submit" class="btn btn-light btn-round px-3">Chỉnh sửa</button>
	                    		</form:form>
	                    	</td>
	                    	<td>
	                    		<form:form action="admin/mat-hang/xoa-mat-hang/${prod.maMatHang }.htm" method="GET">
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
	<script>
	    /* var activeItem = document.querySelector("a[href='mat-hang/index.htm']").class += ' active'; */
		function myFunction() {
			var input, filter, table, tr, i, txtValue, txtValue2, firstCol, secondCol;
			input = document.getElementById("search");
			filter = input.value.toUpperCase();
			table = document.getElementById("table");
			tr = table.getElementsByTagName("tr");
		    for (i = 0; i < tr.length; i++) {
		        firstCol = tr[i].getElementsByTagName("td")[0];
		        secondCol = tr[i].getElementsByTagName("td")[2];
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