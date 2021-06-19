<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp" %>
<%@ include file="/resources/user/template/header.jsp" %>
  <!-- / header section -->
  
<!--  content -->
<!-- catg header banner section -->
  <section id="aa-catg-head-banner">
   <img src="resources/user/assets/images/mua-hang.jpg" alt="banner giỏ hàng">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Giỏ hàng</h2>
        <ol class="breadcrumb">
          <li><a href="index.htm">Trang chủ </a></li>
          <li style="color:#fff">Thông tin giỏ hàng</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->
<c:if test="${not empty notification }">
	<label id="notification" class="form-text text-muted" style="color: blue; background-color: #d1e0e0; width: 100%; padding: 5px;">${notification }<br></label>
</c:if>
<c:if test="${not empty message }">
	<small id="message" class="form-text text-muted" style="color: red; background-color: #d1e0e0; width: 100%; padding: 5px;">${message }<br></small>
</c:if>
 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
             <form action="gio-hang.htm" method="post">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Bỏ chọn</th>
                        <th>Hình ảnh</th>
                        <th>Sản phẩm</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Giảm giá</th>
                        <th>Thành Tiền</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${danhSachSanPham}" var="prod">
											<tr>
											<form action="gio-hang.htm" method="POST">
												<td>
													<input name="productId" value="${prod.maMatHang }" hidden="true" />
													<button class="remove" name="btnDelete" >
														<fa class="fa fa-close"></fa>
													</button>
												</td>
												<td>
													<a href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">
														<c:choose>
															<c:when test="${empty prod.hinhAnh}">
																<img alt="${prod.tenMatHang }" src="resources/images/products/defaultProduct.png" />
															</c:when>
															<c:otherwise>
																<img alt="${prod.tenMatHang }" src="data:image/jpeg;base64,${prod.getBase64Photo() }" />
															</c:otherwise>
														</c:choose>
													</a>
												</td>
												<td>
													<a class="aa-cart-title" href="chi-tiet-san-pham.htm?id=${prod.maMatHang}">${prod.tenMatHang }</a>
												</td>
												<td>
													<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia }" type="currency" />
												</td>
												<td>
													<input class="aa-cart-quantity" type="number" name="soLuong" value="${prod.soLuong}" min=1>
												</td>
												<td><fmt:formatNumber pattern="#,###.# %; -#,###.# %" value="${prod.giamGia}" /></td>
												<td>
													<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${prod.gia * (1 - prod.giamGia) * prod.soLuong }" type="currency" />
												</td>
												<td>
													<button class="save" name="btnSave" >
														<fa class="fa fa-save"></fa>
													</button>
												</td>
											</form>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="6" class=""><strong>TỔNG TIỀN</strong></td>
											<td><strong>
												<fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value="${tongTien }" type="currency" />
											</strong></td>
										</tr>
										<!-- <tr>
                        <td colspan="7" class="aa-cart-view-bottom">
                          <input class="aa-cart-view-btn" type="submit" value="Cập nhật giỏ hàng">
                        </td>
                      </tr> -->
                     
                      </tbody>
                  </table>
                  </div>
             </form>
             <!-- Cart Total view -->
             <div class="cart-view-total">
               <h4>Thông tin giỏ hàng</h4>
               <table class="aa-totals-table">
                 <tbody>
                   <tr>
                     <th>Tạm tính</th>
                     <td>${tongTien} VNĐ</td>
                   </tr>
                   <tr>
                     <th>VAT</th>
                     <td>0 VNĐ</td>
                   </tr>
                   <tr>
                     <th>Tổng cộng</th>
                     <td><strong>${tongTien} VNĐ</strong></td>
                   </tr>
                 </tbody>
               </table>
               <a href="thanh-toan.htm" class="aa-cart-view-btn">Thanh toán</a>
             </div>
           </div>
         </div>
       </div>
     </div>
    </div>
 </section>
 <!-- / Cart view section -->

<!--  end content-->
  
<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp" %>
<!-- end footer-->
