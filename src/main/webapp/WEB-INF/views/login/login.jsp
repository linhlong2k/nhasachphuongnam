<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/taglib.jsp" %>
<%@ include file="/common/admin/header.jsp" %>
	    <div class="container">
	    <div>${message }</div>
		<form:form action="login.htm" modelAttribute="login">
			<h4>Welcome back.</h4>
			<div class="form-floating mb-3">
				<form:input path="username" type="text" class="form-control" id="floatingInput" />
				<label for="floatingInput">username</label>
			</div>
			</br>
			<div class="form-floating mb-3">
				<form:input path="password" type="password" class="form-control" id="floatingInput2" />
				<label for="floatingInput2">password</label>
			</div>
			</br>
			<div class="wrapper">
				<span class="group-btn">
					<button class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i>
					</button>
				</span>
			</div>
		</form:form>
</div>
<%@ include file="/common/admin/footer.jsp" %>