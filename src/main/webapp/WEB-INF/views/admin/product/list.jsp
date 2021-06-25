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
	           <%--  <div>
	            	<h2 class="card-title" ><strong>Danh sách mặt hàng</strong></h2>
	            	<form:form action="admin/tao-mat-hang-moi.htm" method="GET" style="float: right; margin: 5px;" >
	            		<button type="submit" class="btn btn-light btn-round px-3">Tạo mặt hàngm mới</button>
	            	</form:form>
	            	<br><br>
	            </div> --%>
			  	<div class="table-responsive">
              	<table class="table table-hover" id="table">
                	<thead>
	        			<tr>
		             		<th scope="col">Mã mặt hàng
		             			<button onclick="sortMaMatHang()" style="background-color: transparent; border: hidden;" >
		             				<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		             			</button>
		             		</th>
		                    <th scope="col">Hình ảnh</th>
		                    <th scope="col">Tên mặt hàng
		                    	<button onclick="sortTenMatHang()" style="background-color: transparent; border: hidden;" >
		                    		<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		                    	</button>
		                    </th>
		                    <th scope="col">Giá</th>
		                    <th scope="col">Số lượng
		                    	<!-- <button onclick="sortSoLuong()" style="background-color: transparent; border: hidden;" >
		                    		<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		                    	</button> -->
		                    </th>
		                    <th scope="col">Mã loại
		                    	<button onclick="sortMaLoai()" style="background-color: transparent; border: hidden;" >
		                    		<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		                    	</button>
		                    </th>
		                    <th scope="col">Giảm giá</th>
		                    <th scope="col"></th>
		                    <th scope="col"></th>
	                  	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="prod" items="${danhSachMatHang}">
                		<tr>
	                		<form action="admin/mat-hang.htm" method="post">
		                    	<td scope="row">${prod.maMatHang }</td>
		                    	<c:choose>
		                    		<c:when test="${empty prod.hinhAnh}">
		                    			<td>
								    		<p><img alt="image" src="resources/images/products/defaultProduct.png" style="max-height: 100px; max-width: 100px;"/></p>
								    	</td>
									</c:when>
									<%-- test="${not empty prod.hinhAnh }" --%>
									<c:otherwise>
										<td>
											<p><img alt="image" src="data:image/jpeg;base64,${prod.getBase64Photo() }" style="max-height: 100px; max-width: 100px;"/></p>	
										</td>
									</c:otherwise>
								</c:choose>
		                    	<td><p style="max-width: 250px; overflow: hidden; text-overflow: ellipsis;">${prod.tenMatHang }</p></td>
		                    	<td><p><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value = "${prod.gia }" type = "currency"/></p></td>
		                    	<td><p>${prod.soLuong }</p></td>
		                    	<td><p>${prod.maLoai }</p></td>
		                    	<td style="width: 50px;">
			                    		<input name="giamGia" value="${prod.giamGia }" class="form-control" />
			                    		<br>
			                    		<button type="submit" name="btnDiscountId" value="${prod.maMatHang }" class="btn btn-light btn-round px-3">Cập nhật giảm giá</button>
		                    	</td>
		                    	<td>
		                    		<button type="submit" name="btnDetailId" value="${prod.maMatHang }" class="btn btn-light btn-round px-3"><i class="zmdi zmdi-info-outline" style="font-size: 20px;"></i></button>
		                    	</td>
		                    	<td>
		                    		<button type="submit" name="btnDeleteId" value="${prod.maMatHang }" class="btn btn-light btn-round px-3"><i class="zmdi zmdi-minus" style="color: red; font-size: 20px;"></i></button>
		                    	</td>
		                  	</form>
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
	    /* var activeItem = document.querySelector("a[href='mat-hang/index.htm']").class += ' active'; */
	    document.getElementById('mainLabel').innerHTML = 'Danh sách mặt hàng';
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
		function sortMaMatHang() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table");
			switching = true;
			if (table.rows[1].getElementsByTagName("TD")[0].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[0].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 1; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("TD")[0];
						y = rows[i + 1].getElementsByTagName("TD")[0];
						if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
					if (shouldSwitch) {
						rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
						switching = true;
					}
				}
			} else {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 1; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("TD")[0];
						y = rows[i + 1].getElementsByTagName("TD")[0];
						if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
					if (shouldSwitch) {
						rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
						switching = true;
					}
				}

			}
		}
		function sortTenMatHang() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table");
			switching = true;
			if (table.rows[1].getElementsByTagName("TD")[2].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[2].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 1; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("TD")[2];
						y = rows[i + 1].getElementsByTagName("TD")[2];
						if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
					if (shouldSwitch) {
						rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
						switching = true;
					}
				}
			} else {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 1; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("TD")[2];
						y = rows[i + 1].getElementsByTagName("TD")[2];
						if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
					if (shouldSwitch) {
						rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
						switching = true;
					}
				}

			}
		}
		function sortMaLoai() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table");
			switching = true;
			if (table.rows[1].getElementsByTagName("TD")[5].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[5].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 1; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("TD")[5];
						y = rows[i + 1].getElementsByTagName("TD")[5];
						if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
					if (shouldSwitch) {
						rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
						switching = true;
					}
				}
			} else {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 1; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("TD")[5];
						y = rows[i + 1].getElementsByTagName("TD")[5];
						if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
					if (shouldSwitch) {
						rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
						switching = true;
					}
				}

			}
		}
	</script>
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>