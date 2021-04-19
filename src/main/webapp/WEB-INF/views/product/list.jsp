<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/taglib.jsp"%>
<%@ include file="/common/admin/header.jsp"%>
<%@ include file="/common/admin/verticalMenu.jsp"%>
<%@ include file="/common/admin/navigation.jsp"%>
<div class="container">
	<h1 class="text-center">DANH SÁCH MẶT HÀNG</h1>
	<div>
		<button name="btnCreate" class="btn btn-outline-success" type="submit"
			onclick="createProduct();" style="float: right;">Create</button>
		<!-- ---------------------------------------------------------------------------------------
                    -----------------------------------CREATE FORM-----------------------------------------
                    --------------------------------------------------------------------------------------- -->
		<div class="createForm">
			<ul style="list-style: none;">
				<li style="font-size: 30px; font-weight: 500;">
					<h2>${label }</h2>
				</li>
				<br>
				<li>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Tên mặt
							hàng</span> <input type="text" class="form-control"
							placeholder="Tên mặt hàng" aria-label="tenmathang"
							aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">số lượng</span> <input
							type="text" class="form-control" placeholder="0"
							aria-label="Username" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
						<span class="input-group-text" id="basic-addon1">Giá tiền</span> <input
							type="text" class="form-control" aria-label=""> <span
							class="input-group-text">vnd</span> <span
							class="input-group-text">0.00</span>
					</div> <br>
					<div class="input-group input-group-sm">
						<span class="input-group-text">Mô tả ngắn</span>
						<textarea class="form-control" aria-label="With textarea" cols=""
							rows=""></textarea>
					</div> <br>
					<div class="input-group input-group-lg">
						<span class="input-group-text">Mô tả</span>
						<textarea class="form-control" aria-label="With textarea" cols=""
							rows=""></textarea>
					</div> <br>
					<div class="input-group mb-3">
						<label class="input-group-text" for="inputGroupSelect01">Loại
							sản phẩm</label> <select class="form-select" id="inputGroupSelect01">
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
					<button class="btn btn-outline-success" type="submit"
						onclick="exitCreateProduct();">hủy</button>
				</li>
			</ul>
		</div>
	</div>
	<br>
	<hr>
	<br>
	<!-- -------------------------------------------------------------------------------------------------------------
                ---------------------------------------------LIST FORM-------------------------------------------------------
                ------------------------------------------------------------------------------------------------------------- -->
	<div class="row" style="margin: 0 auto;">
		<div class="col-sm" style="width: 80%; margin: 0 auto;">
			<ul class="event-list">
				<c_rt:forEach var="prod" items="${prods }" step="2" varStatus="i">
					<li><img alt="Hình ảnh mặt hàng"
						src="template/admin/assets/images/no-image.png" />
						<div class="info">
							<h2 class="title">${prod.maMH }&nbsp;${prod.tenMH }</h2>
							<p class="desc">${prod.moTaNgan }</p>
							<ul>
								<li style="width: 50%;"><span class="fa fa-globe"></span>${prod.soLuong }</li>
								<li style="width: 50%;"><span class="fa fa-money"></span>${prod.gia }</li>
							</ul>
						</div>
						<div class="tools">
							<ul>
								<li class="edit-btn" style="width: 33%;">
									<button name="lnkEdit">
										<i class="fas fa-edit"></i>
									</button>
								</li>
								<li class="delete-btn" style="width: 34%;">
									<button name="lnkDelete">
										<i class="fas fa-trash"></i>
									</button>
								</li>
							</ul>
						</div></li>
				</c_rt:forEach>
			</ul>
		</div>
		<div class="col-sm" style="width: 80%; margin: 0 auto;">
			<ul class="event-list">
				<c_rt:forEach var="prod" items="${prods }" begin="1" step="2"
					varStatus="i">
					<li><img alt="Hình ảnh mặt hàng"
						src="template/admin/assets/images/no-image.png" />
						<div class="info">
							<h2 class="title">${prod.maMH }&nbsp;${prod.tenMH }</h2>
							<p class="desc">${prod.moTaNgan }</p>
							<ul>
								<li style="width: 50%;"><span class="fa fa-globe"></span>${prod.soLuong }</li>
								<li style="width: 50%;"><span class="fa fa-money"></span>${prod.gia }
								</li>
							</ul>
						</div>
						<div class="tools">
							<ul>
								<li class="edit-btn" style="width: 33%;">
									<button name="lnkEdit">
										<i class="fas fa-edit"></i>
									</button>
								</li>
								<li class="delete-btn" style="width: 34%;">
									<button name="lnkDelete">
										<i class="fas fa-trash"></i>
									</button>
								</li>
							</ul>
						</div></li>
				</c_rt:forEach>
			</ul>
		</div>
	</div>


	<link rel="stylesheet" href="template/admin/css/product.css">
	<script type="text/javascript"
		src='<c:url value="template/admin/js/product.js"/>'></script>
	<%@ include file="/common/admin/footer.jsp"%></div>