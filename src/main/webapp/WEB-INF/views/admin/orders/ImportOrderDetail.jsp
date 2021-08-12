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
			<div class="card-header"><h2> Đơn hàng ${donHang.maDonHang }</h2></div>
			<div class="card-body">
				<ul style="list-style-type: none;" >
					<li><label style="font-size: 20px;"><strong> Thông tin nhà cung cấp: </strong></label></li>
					<li><label><strong> Tên: </strong>${nhaCungCap.tenNhaCungCap }</label></li>
					<li><label><strong> Số điện thoại: </strong>${nhaCungCap.soDienThoai }</label></li>
					<li><label><strong> Địa chỉ: </strong>${nhaCungCap.diaChi }</label></li>
					<li><label style="font-size: 20px;"><strong> Thông tin đơn hàng: </strong></label></li>
					<li><label><strong> Ngày đặt hàng: </strong> ${donHang.thoiGian }</label></li>
					<li>
						<div class="table-responsive">
			                <table class="table align-items-center" id="table-hoa-don">
			                	<thead>
			                		<tr>
			                            <th><i class="text-white mr-2"></i>STT</th>
			                            <th>Mã mặt hàng</th>
			                            <th>Tên mặt hàng</th>
			                            <th>Số lượng</th>
			                            <th>Giá</th>
			                            <th>Giảm giá</th>
			                        </tr>
			                	</thead>
			                    <tbody>
			                    <% int STT = 1; %>
			                        <c:forEach var="item" items="${donHang.chiTiets }">
				                        <tr>
				                        	<td scope="row"><%=STT++ %></td>
											<td>${item.maMatHang }</td>
					                    	<td>${item.tenMatHang }</td>
					                    	<td>${item.soLuong }</td>
					                    	<td><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${item.gia }" type="currency"/></td>
					                    	<td><fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${item.giamGia }" type="currency" /></td>
					                    </tr>
			                        </c:forEach>
			                    </tbody>
			                </table>
			            </div>
	            	</li>
					<li><hr></li>
					<li><label><strong> Tổng tiền:</strong> <fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien}" type="currency"/></label></li>
					<li></li>
					<li style="float: right;">
						<form method="post">
							<button type="submit" class="btn btn-light btn-round px-3" formtarget="_blank" >
								Xuất PDF <i class="icon icon-arrow-right" style="color: white; font-size: 20px;"></i>
							</button>
						</form>
					</li><!--  -->
				</ul>
			</div>
		</div>
	</div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<!-- 	=======================================================script==================================== -->
<script type="text/javascript">
	document.getElementById('mainLabel').innerHTML = 'Chi tiết phiếu nhập';
	document.getElementById("search").style.visibility = "hidden";
</script>
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>