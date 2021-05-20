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
<!-- 		========================================================================================================================================== -->
   		<div class="card mt-3">
        	<div class="card-content">
            	<div class="row row-group m-0 justify-content-center">
           			<div class="col-12 col-lg-6 col-xl-3 border-light">
               			<div class="card-body">
            				<h5 class="text-white"> <span><i class="fa fa-shopping-cart">Mặt hàng abc</i></span></h5>
                 		</div>
                  	</div>
               	</div>
       		</div>
      	</div>

     	<div class="row">
			<div class="col-12 col-lg-4 col-xl-4">
				<div class="card">
					<div class="card-header">
						<img src="./assets/images/products/03.png" class="card-img-top"
							alt="...">
					</div>
					<div class="table-responsive">
						<table class="table align-items-center">
							<tbody>
								<tr>
									<td><i class="fa fa-circle text-white mr-2"></i>Mã mặt hàng</td>
									<td>abc</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-1 mr-2"></i>Tên mặt hàng</td>
									<td>abc</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-2 mr-2"></i>Giá</td>
									<td>abc</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-3 mr-2"></i>số lượng</td>
									<td>abc</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-3 mr-2"></i>loại</td>
									<td>abc</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-3 mr-2"></i>Mô tả
										ngắn</td>
									<td>abc</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-3 mr-2"></i>Mô tả</td>
									<td>abc</td>
								</tr>
								<tr>
									<button type="submit" class="btn btn-light btn-round px-5 float-right">Chỉnh sửa</button>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-12 col-lg-8 col-xl-8">
                    <div class="card">
                        <div class="card-body">
                            <div>
                                <h5 class="card-title" style="float: left;"><strong>Đơn hàng</strong></h5>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">Mã đơn hàng</th>
                                            <th scope="col">Thời gian</th>
                                            <th scope="col">số lượng</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="prod" items="${product}">
                                            <tr>
                                                <th scope="row">${prod.maMH }</th>
                                                <td>${prod.hinhAnh }</td>
                                                <td>${prod.tenMH }</td>
                                                <td>
                                                    <form:form action="order/update/${prod.maMH }.htm" method="GET">
                                                        <button type="submit" class="btn btn-light btn-round px-3">Chỉnh
                                                            sửa</button>
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
        </div>
        <!--End Row-->
        <!--End Dashboard Content-->

        <!--start overlay-->
        <div class="overlay toggle-menu"></div>
        <!--end overlay-->
	
	</div><!-- End container-fluid-->
	</div><!--End content-wrapper-->
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/resources/admin/template/footer.jsp" %>