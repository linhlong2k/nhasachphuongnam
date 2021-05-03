<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/admin/header.jsp" %>
<%@ include file="/common/admin/sidebar.jsp" %>
<%@ include file="/common/admin/topbar.jsp" %>

<!-- 	========================================================start content======================================================================= -->
	<div class="content-wrapper">
    <div class="container-fluid">
<!--     	================================================================= message =========================================================== -->
		<c:if test="${message != null}">
			<c:choose>
				<c:when test="${fn:contains(message, 'thành công')}">
					<div class="alert alert-success" role="alert"><i class="zmdi zmdi-alert-triangle"></i>${message }</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-danger" role="alert"><i class="zmdi zmdi-case-check"></i>${message }</div>
				</c:otherwise>
			</c:choose>
		</c:if>
<!-- 		================================================================ create button ===================================================== -->
		
<!--     	=================================================================== form ==================================================================== -->
		<div class="col-lg-8" style="margin: 0 auto;">
            <div class="card">
              	<div class="card-body">
                	<div class="card-title">MẶT HÀNG</div>
                	<hr>
                	<form:form action="product/create.htm" modelAttribute="product">
               			<div class="form-group">
                    		<label for="input-1">Mã mặt hàng</label>
                    		<form:input path="maMH" type="text" class="form-control form-control-rounded" id="input-1" readonly="true" />
                    		<form:errors path="maMH" class="invalid-feedback" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-2">Tên mặt hàng</label>
                    		<form:input path="tenMH" type="text" class="form-control form-control-rounded" id="input-2" required="true" />
                    		<form:errors path="tenMH" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-3">Hình ảnh</label>
                    		<form:input path="hinhAnh" type="text" class="form-control form-control-rounded" id="input-3" />
                    		<form:errors path="hinhAnh" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-4">Giá</label>
                    		<form:input path="gia" type="text" class="form-control form-control-rounded" id="input-4" />
                    		<form:errors path="gia" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-5">Số lượng</label>
                    		<form:input path="soLuong" type="text" class="form-control form-control-rounded" id="input-5" />
                    		<form:errors path="soLuong" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-6">Loại</label>
                    		<%-- <form:input path="maLoai" type="text" class="form-control form-control-rounded" id="input-6" /> --%>
                    		<form:select path="maLoai" items="${type }" itemValue="maLoai" itemLabel="tenLoai" class="form-select"/>
                    		<form:errors path="maLoai" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-7">Mô tả ngắn</label>
                    		<form:input path="moTaNgan" type="text" class="form-control form-control-rounded" id="input-7" />
                    		<form:errors path="moTaNgan" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<label for="input-8">Mô tả</label>
                    		<form:input path="moTa" type="text" class="form-control form-control-rounded" id="input-8" />
                    		<form:errors path="moTa" class="text-danger" />
                  		</div>
                  		<div class="form-group">
                    		<button type="submit" class="btn btn-light btn-round px-5">
                    			<!-- <i class="icon-lock"></i> -->
                      			Cập nhập
                      		</button>
                  		</div>
                	</form:form>
              	</div>
            </div>
		</div>
		
    </div><!-- End container-fluid-->
	</div><!--End content-wrapper-->
<!-- 	========================================================end content======================================================================= -->
<%@ include file="/common/admin/footer.jsp" %>