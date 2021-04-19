<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.nhasachphuongnam.bean.Product" %>
<%@ include file="../../../common/taglib.jsp" %>
<%@ include file="/common/admin/header.jsp" %>
<%@ include file="/common/admin/verticalMenu.jsp" %>
<%@ include file="/common/admin/navigation.jsp" %>
		<div class="createForm">
			<ul style="list-style: none;">
				<form:form action="" modelAttribute="product">
					<li style="font-size: 30px; font-weight: 500;">CHỈNH SỬA MẶT HÀNG</li>
				<br>
				<div class="mb-3">
					<label for="formGroupExampleInput" class="form-label">Mã mặt hàng</label> 
					<form:input path="maMH" type="text" class="form-control" id="formGroupExampleInput" readonly />
				</div>
				<div class="mb-3">
					<label for="formGroupExampleInput2" class="form-label">Tên mặt hàng</label>
					<form:input path="tenMH" type="text" class="form-control" id="formGroupExampleInput2" />
				</div>
				<div class="mb-3">
					<label for="formGroupExampleInput3" class="form-label">Số lượng</label>
					<form:input path="soLuong" type="text" class="form-control" id="formGroupExampleInput3" />
				</div>
				<div class="mb-3">
					<label for="formGroupExampleInput4" class="form-label">Giá tiền</label>
					<form:input path="gia" type="text" class="form-control" id="formGroupExampleInput4" />
				</div>
				<div class="mb-3">
					<label for="formGroupExampleInput5" class="form-label">Mô tả ngắn</label>
					<form:input path="moTaNgan" type="text" class="form-control" id="formGroupExampleInput5" />
				</div>
				<div class="mb-3">
					<label for="formGroupExampleInput6" class="form-label">Mô tả</label>
					<form:input path="moTa" type="text" class="form-control" id="formGroupExampleInput6" />
				</div>
				<div class="input-group mb-3">
					<label class="input-group-text" for="inputGroupSelect01">Loại sản phẩm</label>
					<form:select path="maLoai" class="form-select" id="inputGroupSelect01">
						<form:option value="0" label="Zero" selected></form:option>
						<form:option value="1" label="One"></form:option>
						<form:option value="2" label="Two"></form:option>
						<form:option value="3" label="Three"></form:option>
					</form:select>
				</div>
				<label>Hình ảnh</label>
				<div class="input-group mb-3">
					<form:input path="hinhAnh" type="file" class="form-control" id="inputGroupFile02" />
					<label class="input-group-text" for="inputGroupFile02">Upload</label>
				</div>
				<button class="btn btn-outline-primary" type="submit" value="Submit">tạo</button>
				<button class="btn btn-outline-primary" type="submit" onclick="exitCreateProduct();">hủy</button>
				</form:form>
				
			</ul>
		</div>
	</div>
<%@ include file="/common/admin/footer.jsp" %>