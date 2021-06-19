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
			<div class="row mt-3">
	        <div class="col-lg-4">
	           <div class="card profile-card-2">
	            <div class="card-img-block">
	                <img class="img-fluid" src="resources/images/infomation/anh-bia.jpg" alt="Ảnh bìa">
	            </div>
	            <div class="card-body pt-5">
	                <c:choose>
	                    <c:when test="${empty thongTinCaNhan.hinhAnh}">
					    	<img class="profile" alt="image" src="resources/images/users/defaultUser.jpg" />
						</c:when>
						<c:otherwise>
							<img class="profile" alt="image" src="data:image/jpeg;base64,${thongTinCaNhan.getBase64Photo() }" />	
						</c:otherwise>
					</c:choose>
					<a href="admin/thong-tin-ca-nhan/cap-nhat-hinh-anh/${thongTinCaNhan.ma}.htm" >Cập nhập ảnh</a>
	                <h1>${thongTinCaNhan.ten }</h1>
	                <p class="card-text">Bạn càng đọc nhiều, bạn càng biết nhiều. Bạn càng học nhiều, bạn càng đi nhiều.</p>
	                <p class="card-text" style="float:right;">Dr Seuss</p>
	                <div class="icon-block">
	                  <a href="javascript:void();"><i class="fa fa-facebook bg-facebook text-white"></i></a>
					  <a href="javascript:void();"> <i class="fa fa-twitter bg-twitter text-white"></i></a>
					  <a href="javascript:void();"> <i class="fa fa-google-plus bg-google-plus text-white"></i></a>
	                </div>
	            </div>
	
	            <div class="card-body border-top border-light">
<!-- 	            	Năng suất công việc -->
				<!-- <div class="media align-items-center">
	                   	<div>
	                       <img src="assets/images/timeline/html5.svg" class="skill-img" alt="skill img">
	                   	</div>
	                	<div class="media-body text-left ml-3">
	                   		<div class="progress-wrapper">
	                        	<p>HTML5 <span class="float-right">65%</span></p>
	                         	<div class="progress" style="height: 5px;">
	                          		<div class="progress-bar" style="width:65%"></div>
	                         		</div>
	                        	</div>                   
	                    	</div>
	                  	</div>
	                  	<hr>
	           		</div> -->
					</div>
	        </div>
	
	        </div>
	
	        <div class="col-lg-8">
	           <div class="card">
	            <div class="card-body">
	            <ul class="nav nav-tabs nav-tabs-primary top-icon nav-justified">
	                <li class="nav-item">
	                    <a href="javascript:void();" data-target="#thong-tin" data-toggle="pill" class="nav-link active"><i class="icon-user"></i> <span class="hidden-xs">Thông tin</span></a>
	                </li>
	                <li class="nav-item">
	                    <a href="javascript:void();" data-target="#don-hang" data-toggle="pill" class="nav-link"><i class="zmdi zmdi-shopping-basket"></i> <span class="hidden-xs">Đơn hàng</span></a>
	                </li>
	                <li class="nav-item">
	                    <a href="javascript:void();" data-target="#chinh-sua" data-toggle="pill" class="nav-link"><i class="icon-note"></i> <span class="hidden-xs">Chỉnh sửa</span></a>
	                </li>
	            </ul>
	            <div class="tab-content p-3">
	                <div class="tab-pane active" id="thong-tin">
	                    <h3 class="mb-3">Thông tin cá nhân</h3>
	                    <div class="row">
	                        <div class="col-md-6">
	                            <h6>Thông tin chi tiết</h6>
	                            <p>&nbsp;Tên: ${thongTinCaNhan.ten }</p>
	                            <p>&nbsp;Địa chỉ: ${thongTinCaNhan.diaChi }</p>
	                            <p>&nbsp;Số điện thoại: ${thongTinCaNhan.soDienThoai }</p>
	                            <p>&nbsp;Ngày sinh: ${thongTinCaNhan.ngaySinh }<%-- <fmt:formatDate value="${thongTinCaNhan.ngaySinh }" pattern="dd-MM-yyyy" /> --%></p>
	                        </div>
	                        <div class="col-md-6">
<!-- 	                            chỗ này là bên phải của trang profile -->
								<h6>Chức vụ:</h6>
	                            <c:forEach var="i" items="${roles }">
	                            	<c:if test="${thongTinCaNhan.maRole eq i.maRole}">
	                            		<p>&nbsp;${i.tenRole }</p>
	                            	</c:if>
	                            </c:forEach>
	                            <h6>Thông tin đăng nhập</h6>
	                            <p>&nbsp;Username: ${thongTinCaNhan.username }</p>
	                            <p>&nbsp;<a href="admin/thong-tin-ca-nhan/thay-doi-mat-khau.htm" style="color: blue;">Đổi mật khẩu</a></p>
	                        </div>
	                        <div class="col-md-12">
	                            <h5 class="mt-2 mb-3"><span class="fa fa-clock-o ion-clock float-right"></span> Hoạt động gần đây</h5>
	                             <div class="table-responsive">
	                            <table class="table table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Trang web</strong> chưa phát triển tính năng này <strong>`hehe`</strong>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                          </div>
	                        </div>
	                    </div>
	                    <!--/row-->
	                </div>
	                <div class="tab-pane" id="don-hang">
						<!-- <div class="alert alert-info alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="alert-icon">
								<i class="icon-info"></i>
							</div>
							<div class="alert-message">
								<span><strong>Info!</strong> Lorem Ipsum is simply dummy text.</span>
							</div>
						</div> -->
						<h3>Danh sách đơn hàng</h3>
						<div class="table-responsive">
	                    <table class="table table-hover table-striped">
	                        <tbody>
	                            <tr>
	                                <td>
	                                   <span class="float-right font-weight-bold">Ngày</span> Thông tin đơn hàng 
	                                </td>
	                            </tr>
	                        </tbody> 
	                    </table>
	                  </div>
	                </div>
	                <div class="tab-pane" id="chinh-sua">
	                	<h3>Chỉnh sửa thông tin cá nhân</h3>
	                    <form:form action="admin/thong-tin-ca-nhan/chinh-sua-thong-tin-ca-nhan.htm" method="post" modelAttribute="thongTinCaNhan">
		                  	<div class="form-group">
		                    	<label for="input-1">Tên</label>
		                    	<form:input path="ten" type="text" class="form-control form-control-rounded" id="input-1" />
		                  		<form:errors path="ten" class="text-danger" />
		                  	</div>
		                  	<div class="form-group">
		                    	<label for="input-2">Số điện thoại</label>
		                    	<form:input path="soDienThoai" type="text" class="form-control form-control-rounded" id="input-2" pattern="[0-9]{10}" />
		                  		<form:errors path="soDienThoai" class="text-danger" />
		                  	</div>
		                  	<div class="form-group">
		                    	<label for="input-3">Địa chỉ</label>
		                    	<form:input path="diaChi" type="text" class="form-control form-control-rounded" id="input-3" />
		                  		<form:errors path="diaChi" class="text-danger" />
		                  	</div>
		                  	<div class="form-group">
		                    	<label for="input-4">Ngày sinh</label>
		                    	<form:input path="ngaySinh" type="date" class="form-control form-control-rounded" id="input-4" />
		                  		<form:errors path="ngaySinh" class="text-danger" />
		                  	</div>
		                  	<div class="form-group">
		                    	<button type="submit" class="btn btn-light btn-round px-5"><i class="icon-save"></i> Cập nhật</button>
		                  	</div>
		                </form:form>
	                </div>
	            </div>
	        </div>
	      </div>
	    </div>
	        
	    </div>
	    
    </div><!-- End container-fluid-->
    </div><!--End content-wrapper-->
<%@ include file="/resources/admin/template/footer.jsp" %>