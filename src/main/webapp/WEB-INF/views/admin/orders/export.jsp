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
            <!-- <div class="card-header">
                <h3><strong>DANH SÁCH ĐƠN HÀNG XUẤT</strong></h3>
            </div> -->
            <div class="table-responsive">
                <table class="table align-items-center" id="table-hoa-don">
                	<thead>
                		<tr>
                            <th rowspan="2"> Mã đơn hàng
                            	<button onclick="sortMaDonHang()" style="background-color: transparent; border: hidden;" >
		             				<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		             			</button>
                            </th>
					        <th rowspan="2"> Thời gian
					        	<button onclick="sortThoiGian()" style="background-color: transparent; border: hidden;" >
		             				<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		             			</button>
					        </th>
					        <th rowspan="2"> Mã nhân viên
					        	<button onclick="sortMaNhanVien()" style="background-color: transparent; border: hidden;" >
		             				<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		             			</button>
					        </th>
					        <th rowspan="2"> Mã khách hàng
					        	<button onclick="sortMaKhachHang()" style="background-color: transparent; border: hidden;" >
		             				<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		             			</button>
					        </th>
					        <th rowspan="2"> Giảm giá</th>
					        <th rowspan="2"> Tình trạng
					        	<button onclick="sortTinhTrang()" style="background-color: transparent; border: hidden;" >
		             				<i class="zmdi zmdi-swap-vertical-circle" style="margin-left: 2px;color: white; font-size: 15px;"></i>
		             			</button>
					        </th>
					        <th colspan="3"> Chi tiết đơn hàng</th>
                            <th rowspan="2"></th>
                        </tr>
                        <tr>
					    	<th>Mã mặt hàng</th>
					    	<th>Số lượng</th>
					    	<th>Giá tiền</th>
					    </tr>
                	</thead>
                    <tbody id="table-body">
                        <c:forEach var="eo" items="${danhSachHoaDon }">
                        <tr>
							<td scope="row"><a href="admin/chi-tiet-hoa-don/${eo.maDonHang }.htm">${eo.maDonHang }</a></td>
	                    	<td>${eo.thoiGian }</td>
	                    	<td>${eo.maNhanVien }</td>
	                    	<td>${eo.maKhachHang }</td>
	                    	<td ><fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${eo.giamGia }" type="currency" /></td>
						    <td >
						    	<c:choose>
						    		<c:when test="${eo.tinhTrang eq '1' }">
						    			Đang chờ xác nhận
						    		</c:when>
						    		<c:when test="${eo.tinhTrang eq '2' }">
						    			Đang vận chuyển
						    		</c:when>
						    		<c:when test="${eo.tinhTrang eq '3' }">
						    			Đã nhận hàng
						    		</c:when>
						    		<c:otherwise>
						    			Không xác định
						    		</c:otherwise>
						    	</c:choose>
						 	</td>
						    <%-- <td style="margin: 0; padding: 10px;">${eo.diaChi }</td> --%>
						    <td colspan="3" >
						    	<c:forEach var="item" items="${eo.chiTiets }">
							    	${item.maMatHang } &nbsp;&nbsp; | &nbsp;&nbsp;
							    	${item.soLuong } &nbsp;&nbsp; | &nbsp;&nbsp;
							    	<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.gia }" type="currency" /><hr>
							    </c:forEach>
							    <%-- <table id="abc">
						    		<c:forEach var="item" items="${eo.chiTiets }">
							          	<tr>
						              		<td >${item.maMatHang }</td>
					                		<td >${item.soLuong }</td>
					                		<td ><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.gia }" type="currency" /></td>
					                	</tr>
				                    </c:forEach>
				             	</table> --%>
				          	</td>
	                    	<td>
	                    		<form:form action="admin/don-hang-xuat.htm">
	                    			<button name="deleteOrderId" value="${eo.maDonHang }" type="submit" class="btn btn-light btn-round px-3">Xóa</button>
	                    		</form:form>
	                    	</td>
	                    </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<!-- 	=======================================================script==================================== -->
	<script>
	    /* var activeItem = document.querySelector("a[href='mat-hang/index.htm']").class += ' active'; */
	    document.getElementById('mainLabel').innerHTML = 'danh sách đơn hàng xuất';
	    function myFunction() {
			var input, filter, table, tr, i, txtValue, txtValue2, txtValue3, firstCol, secondCol, thirdCol;
			input = document.getElementById("search");
			filter = input.value.toUpperCase();
			table = document.getElementById("table-hoa-don");
			tr = table.getElementsByTagName("tr");
		    for (i = 0; i < tr.length; i++) {
		        firstCol = tr[i].getElementsByTagName("td")[0];
		        secondCol = tr[i].getElementsByTagName("td")[2];
		        thirdCol = tr[i].getElementsByTagName("td")[3];
		        if (firstCol || secondCol || thirdCol) {
					txtValue = firstCol.textContent || firstCol.innerText;
					txtValue2 = secondCol.textContent || secondCol.innerText;
					txtValue3 = thirdCol.textContent || thirdCol.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1 || txtValue2.toUpperCase().indexOf(filter) > -1 || txtValue3.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}   
		    }
		}
	    function sortMaDonHang() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table-body");
			switching = true;
			if (table.rows[0].getElementsByTagName("td")[0].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[0].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[0];
						y = rows[i + 1].getElementsByTagName("td")[0];
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
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[0];
						y = rows[i + 1].getElementsByTagName("td")[0];
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
	    function sortThoiGian() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table-body");
			switching = true;
			if (table.rows[0].getElementsByTagName("td")[1].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[1].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[1];
						y = rows[i + 1].getElementsByTagName("td")[1];
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
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[1];
						y = rows[i + 1].getElementsByTagName("td")[1];
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
	    function sortMaNhanVien() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table-body");
			switching = true;
			if (table.rows[0].getElementsByTagName("td")[2].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[2].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[2];
						y = rows[i + 1].getElementsByTagName("td")[2];
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
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[2];
						y = rows[i + 1].getElementsByTagName("td")[2];
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
	    function sortMaKhachHang() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table-body");
			switching = true;
			if (table.rows[0].getElementsByTagName("td")[3].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[3].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[3];
						y = rows[i + 1].getElementsByTagName("td")[3];
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
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[3];
						y = rows[i + 1].getElementsByTagName("td")[3];
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
	    function sortTinhTrang() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("table-body");
			switching = true;
			if (table.rows[0].getElementsByTagName("td")[5].innerHTML.toLowerCase() > table.rows[table.rows.length - 1].getElementsByTagName("TD")[5].innerHTML.toLowerCase()) {
				while (switching) {
					switching = false;
					rows = table.rows;
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[5];
						y = rows[i + 1].getElementsByTagName("td")[5];
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
					for (i = 0; i < (rows.length - 1); i++) {
						shouldSwitch = false;
						x = rows[i].getElementsByTagName("td")[5];
						y = rows[i + 1].getElementsByTagName("td")[5];
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