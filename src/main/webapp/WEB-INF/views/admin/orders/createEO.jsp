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
					<div class="alert alert-danger" role="alert">
						<i class="zmdi zmdi-case-check"></i>${message }</div>
					<!-- <script type="text/javascript">
						alert("${message}");
					</script> -->
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" role="alert">
						<i class="zmdi zmdi-alert-triangle"></i>${message }</div>
				</c:otherwise>
			</c:choose>
		</c:if>
		<!-- 		================================================================ create button ===================================================== -->

		<!--     	=================================================================== table ==================================================================== -->
		<div class="card" style="margin: 0 200px;">
			<div class="card-body">
				<div>
					<label>Mặt hàng đã chọn</label>
					<div class="form-group">
						<table class="table table-hover" id="table">
							<thead>
								<tr>
									<th>Mã mặt hàng</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="s" items="${danhSachMatHangDaChon}">
									<tr>
										<td scope="row">${s.maMatHang }</td>
										<td><fmt:formatNumber
												pattern="#,###.## VND; -#,###.## VND" value="${s.gia }"
												type="currency" /></td>
										<td>${s.soLuong }</td>
										<form action="admin/tao-don-hang-xuat.htm" method="post">
											<td>
												<button name="removeProductId" value="${s.maMatHang }"
													type="submit" class="btn btn-light btn-round px-3">
													<i class="icon icon-minus" style="color: red;"></i>
												</button>
											</td>
										</form>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<hr>
				<form action="admin/tao-don-hang-xuat.htm" method="post" >
					<div class="row">
						<div class="col-3"></div>
						<label class="col-2">Giảm giá </label>
						<input name="giamGia" class="form-control col-4" required="required" value="0" />
						<div class="col-3" ></div>
					</div>
					<br>
					<div style="float: left;">
						<button name="save" type="submit" class="btn btn-light btn-round px-5">
							<i class="icon icon-saves"></i>
							<!-- chưa thêm icon vào đoạn này -->
							Lưu
						</button>
					</div>
					<div style="float: right;">
						<button name="reset" type="submit"
							class="btn btn-light btn-round px-3">
							<i class="icon icon-reset"></i>
							<!-- chưa thêm icon vào đoạn này -->
							Xóa mặt hàng đã chọn
						</button>
					</div>
				</form>
			</div>
		</div>
		<br>
		<div class="card" style="height: 650px; background-color: transparent; border: hidden;">
			<div class="card-header text-center">
				<h3>
					<strong>Danh sách mặt hàng</strong>
				</h3>
			</div>
			<div class="card-header" style="margin: 0 200px;" >
				<input type="text" class="form-control" placeholder="Tìm kiếm mặt hàng" id="search-mat-hang" onkeyup="searchMatHang()">
			</div>
			<div class="row" id="danh-sach-mat-hang">
				<c:forEach items="${danhSachMatHang }" var="prod">
					<div class="col-lg-6 col-xl-3 icon" >
						<figure>
							<a hidden="hidden">${prod.maMatHang }</a>
							<a hidden="hidden">${prod.tenMatHang }</a>
							<a class="aa-product-img">
								<c:choose>
									<c:when test="${empty prod.hinhAnh}">
										<img alt="${prod.tenMatHang }" src="resources/images/products/defaultProduct.png" width="100%" />
									</c:when>
									<c:otherwise>
										<img alt="${prod.tenMatHang }" src="data:image/jpeg;base64,${prod.getBase64Photo() }" width="100%" />
									</c:otherwise>
								</c:choose>
							</a>
							<figcaption>
								<h4 class="aa-product-title">
									<a href="admin/chi-tiet-mat-hang.htm?id=${prod.maMatHang}">${prod.tenMatHang}</a>
								</h4>
								<span class="aa-product-price" style="display: block;">
									<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia * (1 - prod.giamGia)}" type="currency" />
									<span class="aa-badge aa-sale" style="float: right" > Giảm <fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${prod.giamGia}" type="currency" /></span>
								</span>
							</figcaption>
							<form:form class="aa-add-card-btn row" action="admin/tao-don-hang-xuat.htm?addProductId=${prod.maMatHang }" method="POST">
								<input name="soLuong" class="form-control col-6" required="required" pattern="[0-9]{0-8}"/>
								&nbsp;&nbsp;
								<button class="btn btn-light btn-round px-3" style="float: right;" ><i class="zmdi zmdi-plus"></i>Thêm</button>
							</form:form>
						</figure>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<!-- 	=======================================================script==================================== -->
	<script>
	    document.getElementById('mainLabel').innerHTML = 'Thêm đơn hàng xuất';
	    document.getElementById("search").style.visibility = "hidden";
		function searchMatHang() {
			var input, filter, table, tr, i, txtValue, txtValue2, firstCol, secondCol;
			input = document.getElementById("search-mat-hang");
			filter = input.value.toUpperCase();
			table = document.getElementById("danh-sach-mat-hang");
			tr = table.getElementsByTagName("div");
		    for (i = 0; i < tr.length; i++) {
		        firstCol = tr[i].getElementsByTagName("a")[0];
		        secondCol = tr[i].getElementsByTagName("a")[1];
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