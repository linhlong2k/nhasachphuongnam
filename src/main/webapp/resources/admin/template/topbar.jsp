<%@ page pageEncoding="UTF-8"%>
<!--Start topbar header-->
<header class="topbar-nav">
	<nav class="navbar navbar-expand fixed-top">
		<ul class="navbar-nav mr-auto align-items-center">
			<li class="nav-item">
				<a class="nav-link toggle-menu" href="javascript:void();"><i class="icon-menu menu-icon"></i></a>
			</li>
			<li class="nav-item" style="width: 300px; overflow: hidden;">
				<strong>&nbsp;&nbsp;<label id="mainLabel"></label></strong>
			</li>
			<li class="nav-item">
				<form class="search-bar">
					<input type="text" class="form-control" placeholder="Tìm kiếm" id="search" onkeyup="myFunction()">
					<!-- <a href="javascript:void();"><i class="icon-magnifier"></i></a> -->
				</form>
			</li>
		</ul>

		<ul class="navbar-nav align-items-center right-nav-link">
			<li class="nav-item dropdown-lg">
				<a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
					<i class="fa fa-envelope-open-o"></i>
				</a>
			</li>
			<li class="nav-item dropdown-lg">
				<a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
					<i class="fa fa-bell-o"></i>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown" href="#">
					<span class="user-profile">
						<c:choose>
	                    	<c:when test="${empty user.hinhAnh}">
	                    		<img src="resources/images/users/defaultUser.jpg" class="img-circle" alt="user avatar"/>	
							</c:when>
							<%-- test="${not empty prod.hinhAnh }" --%>
							<c:otherwise>
								<img src="data:image/jpeg;base64,${user.getBase64Photo() }" class="img-circle" alt="user avatar"/>	
							</c:otherwise>
						</c:choose>
					</span>
				</a>
				<ul class="dropdown-menu dropdown-menu-right">
					<li class="dropdown-item user-details">
						<a  href="admin/thong-tin-ca-nhan/index.htm" > <!-- href="javaScript:void();" -->
							<div class="media">
								<div class="avatar">
									<c:choose>
				                    	<c:when test="${empty user.hinhAnh}" >
				                    		<img class="align-self-start mr-3" alt="user avatar" src="resources/images/users/defaultUser.jpg" class="img-circle" alt="user avatar"/>	
										</c:when>
										<%-- test="${not empty prod.hinhAnh }" --%>
										<c:otherwise>
											<img class="align-self-start mr-3" alt="user avatar" src="data:image/jpeg;base64,${user.getBase64Photo() }" class="img-circle" alt="user avatar"/>	
										</c:otherwise>
									</c:choose>
								</div>
								<div class="media-body">
									<h6 class="mt-2 user-title">${user.ten}</h6>
									<p class="user-subtitle">${user.soDienThoai }</p>
								</div>
							</div>
						</a>
					</li>
					<li class="dropdown-divider"></li>
					<li class="dropdown-item"><i class="icon-envelope mr-2"></i>Tin nhắn</li>
					<li class="dropdown-divider"></li>
					<li class="dropdown-item"><a href="admin/thong-tin-ca-nhan/index.htm"><i class="icon-wallet mr-2"></i>Thông tin tài khoản</a></li>
					<li class="dropdown-divider"></li>
					<li class="dropdown-item"><i class="icon-settings mr-2"></i>Cài đặt</li>
					<li class="dropdown-divider"></li>
					<li class="dropdown-item"><a href="dang-xuat.htm"><i class="icon-power mr-2"></i>Đăng xuất</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</header>
<!--End topbar header-->
<div class="clearfix"></div>