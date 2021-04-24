<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../common/taglib.jsp" %>
<%@ include file="/common/admin/header.jsp" %>
<%@ include file="/common/admin/sidebar.jsp" %>
<%@ include file="/common/admin/topbar.jsp" %>
<!-- 	========================================================start content======================================================================= -->
		<div class="createForm">
			<!-- ------------------------------------------------------------------------form chưa qua xu ly----------------------------------------------- -->
			<form>
				<div class="row mb-3">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3" />
					</div>
				</div>
				<div class="row mb-3">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" />
					</div>
				</div>
				<fieldset class="row mb-3">
					<legend class="col-form-label col-sm-2 pt-0">Radios</legend>
					<div class="col-sm-10">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked />
							<label class="form-check-label" for="gridRadios1"> First radio </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2" />
							<label class="form-check-label" for="gridRadios2"> Second radio </label>
						</div>
						<div class="form-check disabled">
							<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled />
							<label class="form-check-label" for="gridRadios3"> Third disabled radio </label>
						</div>
					</div>
				</fieldset>
				<div class="row mb-3">
					<div class="col-sm-10 offset-sm-2">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="gridCheck1" />
							<label class="form-check-label" for="gridCheck1"> Example checkbox </label>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Sign in</button>
			</form>
			<!-- --------------------------------------------------------------form cũ----------------------------------------------------------------- -->
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
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/common/admin/footer.jsp" %>