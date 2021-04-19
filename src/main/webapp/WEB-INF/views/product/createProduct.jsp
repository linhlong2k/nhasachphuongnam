<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/taglib.jsp" %>
<%@ include file="/common/admin/header.jsp" %>
		<div class="createForm">
			<ul style="list-style: none;">
				<li style="font-size: 30px; font-weight: 500;">TẠO MẶT HÀNG</li>
				<br>
				<li>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Tên mặt hàng</span> 
						<input type="text" class="form-control"
							placeholder="Tên mặt hàng" aria-label="tenmathang"
							aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">số lượng</span> 
						<input
							type="text" class="form-control" placeholder="0"
							aria-label="Username" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
						<span class="input-group-text" id="basic-addon1">Giá tiền</span> 
						<input
							type="text" class="form-control"
							aria-label="Dollar amount (with dot and two decimal places)">
						<span class="input-group-text">vnd</span> 
						<span class="input-group-text">0.00</span>
					</div> <br>
					<div class="input-group input-group-sm">
						<span class="input-group-text">Mô tả ngắn</span>
						<textarea class="form-control" aria-label="With textarea"></textarea>
					</div> <br>
					<div class="input-group input-group-lg">
						<span class="input-group-text">Mô tả</span>
						<textarea class="form-control" aria-label="With textarea"></textarea>
					</div> <br>
					<div class="input-group mb-3">
						<label class="input-group-text" for="inputGroupSelect01">Loại sản phẩm</label> 
						<select class="form-select" id="inputGroupSelect01">
							<option selected>Choose...</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select>
					</div> <label>Hình ảnh</label>
					<div class="input-group mb-3">
						<input type="file" class="form-control" id="inputGroupFile02">
						<label class="input-group-text" for="inputGroupFile02">Upload</label>
					</div>
				</li>
				<li>
					<button class="btn btn-outline-success" type="submit">tạo</button>
					<button class="btn btn-outline-success" type="submit" onclick="exitCreateProduct();">hủy</button>
				</li>
			</ul>
		</div>
	</div>
<%@ include file="/common/admin/footer.jsp" %>