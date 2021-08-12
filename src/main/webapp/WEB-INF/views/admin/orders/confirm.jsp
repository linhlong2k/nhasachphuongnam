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
			<div class="col-12 col-lg-6 col-xl-6">
				<div class="card">
					<div class="card-header">
						<div class="card-title">Thông tin đơn hàng</div>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-6">
								<h6>Thông tin chi tiết</h6>
								<p>Mã đơn hàng: ${donHang.maDonHang }</p>
								<p>Mã khách hàng: ${donHang.maKhachHang }</p>
								<p>Số điện thoại: ${donHang.sdt }</p>
								<p>Địa chỉ: ${donHang.diaChi }</p>
							</div>
							<div class="col-md-6">
								<h6></h6>
								<br>
								<p>Giảm giá: <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${donHang.giamGia }" type="currency" /></p>
								<p>
									Thời gian đặt hàng:
									<%-- <fmt:formatDate value="${donHang.thoiGian }" pattern="dd-MM-yyyy" /> --%>
									${donHang.thoiGian }
								</p>
							</div>
							<div class="col-md-12">
								<h5 class="mt-2 mb-3">
									<!-- <span class="fa fa-clock-o ion-clock float-right"></span> -->
									Danh sách mặt hàng
								</h5>
								<div class="table-responsive">
									<table class="table table-hover table-striped"
										style="max-height: 500px;">
										<thead>
											<tr>
												<th>Mã mặt hàng</th>
												<th>Tên mặt hàng</th>
												<th>Số lượng</th>
												<th>Giá tiền</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${danhSachMatHang }" var="item">
												<tr>
													<td>${item.maMatHang }</td>
													<td><p style="max-width: 220px; overflow: hidden; text-overflow: ellipsis;">${item.tenMatHang }</p></td>
													<td>${item.soLuong }</td>
													<td><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.gia }" type="currency"/></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<hr>
					<form action="admin/xac-nhan-dat-hang.htm" method="post" >
						<input name="id" value="${donHang.maDonHang }" hidden="hidden">
						<button type="submit" class="btn btn-light btn-round px-3" name="ok" style="float: right; margin: 10px;">
							<i class="icon icon-check" style="color: white; font-size: 20px;"></i>
							Xác nhận
						</button>
						<button type="submit" class="btn btn-light btn-round px-3" name="cancel" style="float: right; margin: 10px;">
							<i class="icon icon-minus" style="color: red; font-size: 20px;"></i>
							Hủy đơn hàng
						</button>
					</form>
				</div>
			</div>
			<div class="col-12 col-lg-6 col-xl-6">
				<label>Đơn hàng</label>
				<hr>
				<input type="text" class="form-control" placeholder="Tìm kiếm đơn hàng" id="search-don-hang" onkeyup="searchDonHang()">
				<div class="form-group">
					<table class="table table-hover" id="table-don-hang"
						style="max-height: 500px; max-length: 500px;">
						<thead>
							<tr>
								<th>Mã đơn hàng</th>
								<th>Thời gian</th>
								<th>Mã khách hàng</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${danhSachDonHang}">
								<form action="admin/xac-nhan-dat-hang.htm" method="post">
									<tr>
										<td scope="row"><a href="admin/chi-tiet-hoa-don/${item.maDonHang }.htm" >${item.maDonHang } </a></td>
										<td>${item.thoiGian }</td>
										<td>${item.maKhachHang }</td>
										<input name="id" value="${item.maDonHang }" class="form-control" hidden="hidden"/>
										<td>
											<button type="submit" class="btn btn-light btn-round px-3" name="linkSelect">
												<i class="icon icon-plus" style="color: white;"></i>
											</button>
										</td>
									</tr>
								</form>
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
	    document.getElementById('mainLabel').innerHTML = 'Xác nhận đơn hàng';
	    document.getElementById("search").style.visibility = "hidden";
		function searchDonHang() {
			var input, filter, table, tr, i, txtValue, txtValue2, firstCol, secondCol;
			input = document.getElementById("search-don-hang");
			filter = input.value.toUpperCase();
			table = document.getElementById("table-don-hang");
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