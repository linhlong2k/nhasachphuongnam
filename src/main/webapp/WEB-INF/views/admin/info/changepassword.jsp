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
			<div class="card" style="width: 500px; margin: 0 auto;">
			<div class="card-header">
				<strong>Thay đổi mật khẩu</strong>
			</div>
            <div class="card-body">
			  	<form:form action="admin/thong-tin-ca-nhan/thay-doi-mat-khau.htm" method="post" >
                  <div class="form-group">
                    <label for="input-1">Mật khẩu cũ</label>
                    <input name="password" type="password" class="form-control form-control-rounded" id="input-1"/>
                  </div>
                  <div class="form-group">
                    <label for="input-2">Mật khẩu mới</label>
                    <input name="passwordnew" type="password" class="form-control form-control-rounded" id="input-2" />
                  </div>
                  <div class="form-group">
                    <label for="input-3">Xác nhận mật khẩu mới</label>
                    <input name="passwordconfirm" type="password" class="form-control form-control-rounded" id="input-3" />
                  </div>
                  <div class="form-group">
                    <button type="submit" class="btn btn-light btn-round px-5"><i class="icon-lock"></i> Lưu</button>
                  </div>
				</form:form>           
            </div>
            </div>
    </div>
    <!-- End container-fluid-->
    </div><!--End content-wrapper-->
<%@ include file="/resources/admin/template/footer.jsp" %>