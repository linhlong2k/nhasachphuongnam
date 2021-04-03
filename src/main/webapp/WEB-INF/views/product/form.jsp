<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f_rt"%>
<%@ include file="/common/admin/header.jsp" %>
<%@ include file="/common/admin/navigation.jsp" %>
		<h1>Danh sách sản phẩm</h1>
		<br>
		<hr>
		<h2>${message }</h2>
		<hr>
		<br>
		<form action="list.htm" method="post" >
			<table class="table" border="1">
				<thead class="table-dark">
					<tr>
						<th scope="col">Mã mặt hàng</th>
						<th scope="col">Tên mặt hàng</th>
						<th scope="col">Mô tả ngắn</th>
						<th scope="col">Mô tả</th>
						<th scope="col">Hình ảnh</th>
						<th scope="col">Mã loại</th>
						<th scope="col">Tùy chọn</th>
					</tr>
				</thead>
				<tbody>
					<c_rt:forEach var="product" items="${prods }" varStatus="i">
						<jsp:useBean id="i" type="javax.servlet.jsp.jstl.core.LoopTagStatus" />
						<c_rt:choose>
				          	<c_rt:when test="<%=i.getCount()%2==0%>">
				            	<tr class="table-success">
									<th scope="row">${product.maMH }</th>
									<th scope="row">${product.tenMH }</th>
									<th scope="row">${product.moTaNgan }</th>
									<th scope="row">${product.moTa }</th>
									<th scope="row">${product.hinhAnh }</th>
									<th scope="row">${product.maLoai }</th>
									<th scope="row">
										<button name="lnkEdit">Edit</button>
										|
										<button name="lnkDelete">Delete</button>
									</th>
									<%-- <th scope="row"><f_rt:formatNumber value="${ }" type="currency" />Giá tiền</th> --%>
								</tr>
				          	</c_rt:when>
				
				        	<c_rt:otherwise>
					            <tr>
									<th scope="row">${product.maMH }</th>
									<th scope="row">${product.tenMH }</th>
									<th scope="row">${product.moTaNgan }</th>
									<th scope="row">${product.moTa }</th>
									<th scope="row">${product.hinhAnh }</th>
									<th scope="row">${product.maLoai }</th>
									<th scope="row">
										<button name="lnkEdit">Edit</button>
										|
										<button name="linkDelete">Delete</button>
									</th>
									<%-- <th scope="row"><f_rt:formatNumber value="${ }" type="currency" />Giá tiền</th> --%>
								</tr>
				        	</c_rt:otherwise>
				        </c_rt:choose>
					</c_rt:forEach>
				</tbody>
			</table>
		</form>
	</div>
<%@ include file="/common/admin/footer.jsp" %>