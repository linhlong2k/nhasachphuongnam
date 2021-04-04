<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f_rt"%>
<%@ include file="/common/admin/header.jsp" %>
<%@ include file="/common/admin/navigation.jsp" %>
		            <div class="container">
                <h1 class="text-center">DANH SÁCH MẶT HÀNG</h1>
                <div>
                    <button onclick="createProduct();" style="float: right;">Create</button>
                    <div class="createForm">
                        <ul style="list-style: none;">
                            <li style="font-size: 30px; font-weight: 500;">
                                TẠO MẶT HÀNG
                            </li>
                            <br>
                            <li>
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="basic-addon1">Tên mặt hàng</span>
                                    <input type="text" class="form-control" placeholder="Tên mặt hàng" aria-label="tenmathang"
                                        aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="basic-addon1">số lượng</span>
                                    <input type="text" class="form-control" placeholder="0" aria-label="Username"
                                        aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-text" id="basic-addon1">Giá tiền</span>
                                    <input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
                                    <span class="input-group-text">vnd</span>
                                    <span class="input-group-text">0.00</span>
                                </div>
                                <br>
                                <div class="input-group input-group-sm">
                                    <span class="input-group-text">Mô tả ngắn</span>
                                    <textarea class="form-control" aria-label="With textarea"></textarea>
                                </div>
                                <br>
                                <div class="input-group input-group-lg">
                                    <span class="input-group-text">Mô tả</span>
                                    <textarea class="form-control" aria-label="With textarea" ></textarea>
                                </div>
                                <br>
                                <div class="input-group mb-3">
                                    <label class="input-group-text" for="inputGroupSelect01">Loại sản phẩm</label>
                                    <select class="form-select" id="inputGroupSelect01">
                                      <option selected>Choose...</option>
                                      <option value="1">One</option>
                                      <option value="2">Two</option>
                                      <option value="3">Three</option>
                                    </select>
                                </div>
                                <label>Hình ảnh</label>
                                <div class="input-group mb-3">
                                    <input type="file" class="form-control" id="inputGroupFile02">
                                    <label class="input-group-text" for="inputGroupFile02">Upload</label>
                                  </div>
                            </li>
                            <li >
                            	<button style="margin: 0 auto; padding: 10px; width: 50px; border: 0;margin: 5px;">tạo</button>
                            	<button onclick="exitCreateProduct();" style="margin: 0 auto; padding: 10px; width: 50px; border: 0;margin: 5px;">hủy</button>
                            </li>
                        </ul>
                    </div>
                </div>
               	<br>
                <hr>
                <br>
                <div class="row" style="margin: 0 auto;">
                    <div class="col-sm" style="width: 80%; margin: 0 auto;">
                        <ul class="event-list">
							<c_rt:forEach var="prod" items="${prods }" step="2" varStatus="i">
								<li>
									<img alt="Hình ảnh mặt hàng" src="https://farm4.staticflickr.com/3100/2693171833_3545fb852c_q.jpg" />
									<div class="info">
										<h2 class="title">${prod.maMH } 	 ${prod.tenMH }</h2>
										<p class="desc">${prod.moTaNgan }</p>
										<ul>
											<li style="width: 50%;"><span class="fa fa-globe"></span>${prod.soLuong }</li>
											<li style="width: 50%;"><span class="fa fa-money"></span>$39.99</li>
										</ul>
									</div>
									<div class="social">
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
									</div>
								</li>
							</c_rt:forEach>
						</ul>
					</div>
					<div class="col-sm" style="width: 80%; margin: 0 auto;">
                        <ul class="event-list">
							<c_rt:forEach var="prod" items="${prods }" begin="1" step="2" varStatus="i">
								<li>
									<img alt="Hình ảnh mặt hàng" src="https://farm4.staticflickr.com/3100/2693171833_3545fb852c_q.jpg" />
									<div class="info">
										<h2 class="title">${prod.maMH } 	 ${prod.tenMH }</h2>
										<p class="desc">${prod.moTaNgan }</p>
										<ul>
											<li style="width: 50%;"><span class="fa fa-globe"></span>${prod.soLuong }</li>
											<li style="width: 50%;"><span class="fa fa-money"></span>$39.99</li>
										</ul>
									</div>
									<div class="social">
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
									</div>
								</li>
							</c_rt:forEach>
						</ul>
					</div>
				</div>

				
            <style>
                .createForm{
                    border: groove 5px;
                    border-radius: 10px;
                    width: 700px; 
                    height: 0px; 
                    background-color: whitesmoke; 
                    visibility: hidden; 
                    position: absolute; 
                    z-index: 2; 
                    left: 30%;
                    padding: 10px 40px;
                }
            </style>
            <script>
                function createProduct() {
                    document.getElementsByClassName("createForm")[0].style.visibility = "visible";
                    document.getElementsByClassName("createForm")[0].style.height = "650px";
                };
                function exitCreateProduct() {
                    document.getElementsByClassName("createForm")[0].style.visibility = "hidden";
                    document.getElementsByClassName("createForm")[0].style.height = "0px";
                }
            </script>
	<link rel="stylesheet" href="template/admin/css/product.css">
<%@ include file="/common/admin/footer.jsp" %>