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
    <div class="col-12 col-lg-6 col-xl-6" style="padding: 10px;">
        <div class="card">
            <div class="card-header">
                <h3><strong>DANH SÁCH ĐƠN HÀNG XUẤT</strong></h3>
                <br>
                <div>
                	<form class="search">
						<input type="text" class="form-control" placeholder="Tìm kiếm" id="search-hoa-don" onkeyup="hoaDonSearch()">
					</form>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table align-items-center" id="table-hoa-don">
                	<thead>
                		<tr>
                            <th style="margin: 0; padding: 10px 10px;"><i class="text-white mr-2"></i>Mã đơn</th>
                            <th style="margin: 0; padding: 10px 10px;">Thời gian</th>
                            <th style="margin: 0; padding: 10px 10px;">Nhân viên</th>
                            <th style="margin: 0; padding: 10px 10px;">Khách hàng</th>
                            <th style="margin: 0; padding: 10px 10px;"></th>
                        </tr>
                	</thead>
                    <tbody>
                        <c:forEach var="eo" items="${danhSachHoaDon }">
                        <tr>
							<td scope="row" style="margin: 0; padding: 10px;">${eo.maDonHang }</td>
	                    	<td style="margin: 0; padding: 10px;">${eo.thoiGian }</td>
	                    	<td style="margin: 0; padding: 10px;">${eo.maNhanVien }</td>
	                    	<td style="margin: 0; padding: 10px;">${eo.maKhachHang }</td>
	                    	<td style="margin: 0; padding: 0;">
	                    		<form:form action="admin/don-hang/xoa-don-hang/${eo.maDonHang }.htm">
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
    <div class="col-12 col-lg-6 col-xl-6" style="padding: 10px;">
        <div class="card">
            <div class="card-header">
                <h3><strong>DANH SÁCH ĐƠN HÀNG NHẬP</strong></h3>
                <br>
                <div>
                	<form class="search">
						<input type="text" class="form-control" placeholder="Tìm kiếm" id="search-phieu-nhap" onkeyup="phieuNhapSearch()">
					</form>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table align-items-center" id="table-phieu-nhap">
                	<thead>
                		<tr>
                            <th style="margin: 0; padding: 10px;"><i class="text-white mr-2"></i>Mã đơn</th>
                            <th style="margin: 0; padding: 10px;">Thời gian</th>
                            <th style="margin: 0; padding: 10px;">Nhân viên</th>
                            <th style="margin: 0; padding: 10px;">Nhà cung cấp</th>
                            <th style="margin: 0; padding: 10px;"></th>
                        </tr>
                	</thead>
                    <tbody>
                        <c:forEach var="io" items="${danhSachPhieuNhap }">
                        <tr>
							<td scope="row" style="margin: 0; padding: 10px;" >${io.maDonHang }</td>
	                    	<td style="margin: 0; padding: 10px;">${io.thoiGian }</td>
	                    	<td style="margin: 0; padding: 10px;">${io.maNhanVien }</td>
	                    	<td style="margin: 0; padding: 10px;">${io.maNhaCungCap }</td>
	                    	<td style="margin: 0; padding: 0;">
	                    		<form:form action="admin/don-hang/xoa-don-hang/${io.maDonHang }.htm">
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
    </div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<!--     ===============================================script================= -->
<script type="text/javascript">
	/* 	ẩn thanh tìm kiếm trên topbar */
	document.getElementById("search").style.visibility = "hidden";
	/* =========================== */
	function hoaDonSearch() {
		var input, filter, table, tr, i, txtValue, txtValue2, txtValue3, firstCol, secondCol, thirdCol;
		input = document.getElementById("search-hoa-don");
		filter = input.value.toUpperCase();
		table = document.getElementById("table-hoa-don");
		tr = table.getElementsByTagName("tr");
	    for (i = 0; i < tr.length; i++) {
	        firstCol = tr[i].getElementsByTagName("td")[0];
	        secondCol = tr[i].getElementsByTagName("td")[2];
	        thirdCol = tr[i].getElementsByTagName("td")[3];
	        if (firstCol || secondCol) {
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
	function phieuNhapSearch() {
		var input, filter, table, tr, i, txtValue, txtValue2, txtValue3, firstCol, secondCol, thirdCol;
		input = document.getElementById("search-phieu-nhap");
		filter = input.value.toUpperCase();
		table = document.getElementById("table-phieu-nhap");
		tr = table.getElementsByTagName("tr");
	    for (i = 0; i < tr.length; i++) {
	        firstCol = tr[i].getElementsByTagName("td")[0];
	        secondCol = tr[i].getElementsByTagName("td")[2];
	        thirdCol = tr[i].getElementsByTagName("td")[3];
	        if (firstCol || secondCol) {
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
</script>
<%@ include file="/resources/admin/template/footer.jsp" %>