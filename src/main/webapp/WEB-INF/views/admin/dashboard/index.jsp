<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/admin/template/header.jsp"%>
<%@ include file="/resources/admin/template/sidebar.jsp"%>
<%@ include file="/resources/admin/template/topbar.jsp"%>
<!-- Chart js -->
<script src="resources/admin/assets/plugins/Chart.js/Chart.min.js"></script>
	<div class="content-wrapper">
	<div class="container-fluid">

		<!--Start Dashboard Content-->
		<div class="card mt-3">
			<div class="card-content">
				<div class="row row-group m-0">
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								${tongDon }
								<span class="float-right">
									<i class="fa fa-shopping-cart"></i>
								</span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Tổng đơn <span class="float-right">
								<!-- +4.2% <i class="zmdi zmdi-long-arrow-up"></i> -->
								</span>
							</p>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								${donNhap }
								<span class="float-right"><i class="fa fa-envira"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Đơn nhập <span class="float-right">
								<!-- +1.2% <i class="zmdi zmdi-long-arrow-up"></i> -->
								</span>
							</p>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								${donXuat }
								<span class="float-right"><i class="fa fa-usd"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Đơn xuất <span class="float-right">
								<!-- +5.2% <i class="zmdi zmdi-long-arrow-up"></i> -->
								</span>
							</p>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<div class="w3-bar w3-black">
								 Theo:
								<form method="get">
									<button name="day" type="submit" class="btn btn-light">
										 ngày
									</button>
									<button name="month" type="submit" class="btn btn-light">
										 tháng
									</button>
									<button name="year" type="submit" class="btn btn-light" disabled="true">
										 năm
									</button>
									<!-- <button name="custom" type="submit" class="btn btn-light">
										 tùy chỉnh
									</button> -->
								</form>
							  	<!-- <a href="#" class="w3-bar-item w3-button"> ngày</a>
							  	<a href="#" class="w3-bar-item w3-button"> tháng</a>
							  	<a href="#" class="w3-bar-item w3-button"> năm</a>
							  	<a href="#" class="w3-bar-item w3-button"> tùy biến</a> -->
							</div>
							<!-- <h5 class="text-white mb-0">
								250620 
								<span class="float-right"><i class="fa fa-eye"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								abc <span class="float-right">+2.2% <i
									class="zmdi zmdi-long-arrow-up"></i></span>
							</p> -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-12 col-lg-8 col-xl-8">
				<div class="card">
					<div class="card-header">
						Doanh thu theo thời gian
						<div class="card-action">
							<div class="dropdown">
								<a href="javascript:void();" class="dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown"> <i class="icon-options"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="javascript:void();">Action</a>
									<a class="dropdown-item" href="javascript:void();">Another action</a>
									<a class="dropdown-item" href="javascript:void();">Something else here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="javascript:void();">Separated link</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body">
						<ul class="list-inline">
							<li class="list-inline-item">
								<i class="fa fa-circle mr-2 text-white"></i>Đơn hàng nhập</li>
							<li class="list-inline-item">
								<i class="fa fa-circle mr-2 text-light"></i>Đơn hàng xuất</li>
							<li class="list-inline-item">
								<i class="fa fa-circle mr-2" style="color: rgb(255, 0, 0);"></i>Doanh thu</li>
						</ul>
						<div class="chart-container-1">
							<canvas id="chart1"></canvas>
							<script>
								var ctx = document.getElementById('chart1')
										.getContext('2d');
								var myChart = new Chart(
										ctx,
										{
											type : 'line',
											data : {
												labels : ${chart1Label },
												datasets : [
														{
															label : 'Đơn xuất',
															data : ${chart1TongThu },
															backgroundColor : "transparent",
															borderColor : "rgba(255, 255, 255)",
															pointRadius : "0",
															borderWidth : 3
														},
														{
															label : 'Đơn nhập',
															data : ${chart1TongChi },
															backgroundColor : "rgba(255, 255, 255, 0.25)",
															borderColor : "transparent",
															pointRadius : "0",
															borderWidth : 1
														}, {
											                label: 'Doanh thu',
											                data: ${chart1DoanhThu },
											                backgroundColor: "transparent",
											                borderColor: "rgb(255, 0, 0)",
											                pointRadius :"0",
											                borderWidth: 5
											          	}]
											},
											options : {
												maintainAspectRatio : false,
												legend : {
													display : false,
													labels : {
														fontColor : '#ddd',
														boxWidth : 40
													}
												},
												tooltips : {
													displayColors : false
												},
												scales : {
													xAxes : [ {
														ticks : {
															beginAtZero : true,
															fontColor : '#ddd'
														},
														gridLines : {
															display : true,
															color : "rgba(221, 221, 221, 0.08)"
														},
													} ],
													yAxes : [ {
														ticks : {
															beginAtZero : true,
															fontColor : '#ddd'
														},
														gridLines : {
															display : true,
															color : "rgba(221, 221, 221, 0.08)"
														},
													} ]
												}

											}
										});
							</script>
						</div>
					</div>

					<div
						class="row m-0 row-group text-center border-top border-light-3">
						<div class="col-12 col-lg-4">
							<div class="p-3">
								<h5 class="mb-0"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value = "${chart1LabelTongThu }" type = "currency"/></h5>
								<small class="mb-0">Tổng thu <span>
								<!--  <i class="fa fa-arrow-up"></i> 2.43% -->
								</span></small>
							</div>
						</div>
						<div class="col-12 col-lg-4">
							<div class="p-3">
								<h5 class="mb-0"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value = "${chart1LabelTongChi }" type = "currency"/></h5>
								<small class="mb-0">Tổng chi <span>
								<!-- <i class="fa fa-arrow-up"></i> 12.65% -->
								</span></small>
							</div>
						</div>
						<div class="col-12 col-lg-4">
							<div class="p-3">
								<h5 class="mb-0"><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value = "${chart1LabelDoanhThu }" type = "currency"/></h5>
								<small class="mb-0">Doanh thu <span>
								<!-- <i class="fa fa-arrow-up"></i> 5.62% -->
								</span></small>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-12 col-lg-4 col-xl-4">
				<div class="card">
					<div class="card-header">
						Mặt hàng bán chạy
						<div class="card-action">
							<div class="dropdown">
								<a href="javascript:void();"
									class="dropdown-toggle dropdown-toggle-nocaret"
									data-toggle="dropdown"> <i class="icon-options"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="javascript:void();">Action</a> <a
										class="dropdown-item" href="javascript:void();">Another
										action</a> <a class="dropdown-item" href="javascript:void();">Something
										else here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="javascript:void();">Separated
										link</a>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body">
						<div class="chart-container-2">
							<canvas id="chart2"></canvas>
							<script>
								var ctx = document.getElementById('chart2').getContext('2d');
								var myChart = new Chart(ctx,
										{
											type : 'doughnut',
											data : {
												labels : ${chart2Label },
												datasets : [ {
													backgroundColor : [
															"#ffffff",
															"rgba(255, 255, 255, 0.70)",
															"rgba(255, 255, 255, 0.50)",
															"rgba(255, 255, 255, 0.20)" ],
													data : ${chart2Data },
													borderWidth : [ 0, 0, 0, 0 ]
												} ]
											},
											options : {
												maintainAspectRatio : false,
												legend : {
													position : "bottom",
													display : false,
													labels : {
														fontColor : '#ddd',
														boxWidth : 15
													}
												},
												tooltips : {
													displayColors : false
												}
											}
										});
							</script>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table align-items-center">
							<tbody>
							<c:forEach var="item" items="${chart2Map }" varStatus="i">
								<tr>
									<td><i class="fa fa-circle text-white mr-2"></i> ${item.key }</td>
									<td><fmt:formatNumber pattern="#,###.## VND; -#,###.## VND" value = "${item.value }" type = "currency"/></td>
								</tr>
							</c:forEach>
								<!-- <tr>
									<td><i class="fa fa-circle  mr-2"></i> Direct</td>
									<td>$5856</td>
									<td>+55%</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-1 mr-2"></i>Affiliate</td>
									<td>$2602</td>
									<td>+25%</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-2 mr-2"></i>E-mail</td>
									<td>$1802</td>
									<td>+15%</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-3 mr-2"></i>Other</td>
									<td>$1105</td>
									<td>+5%</td>
								</tr> -->
							</tbody>
						</table>
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
<!-- 	====================================================script======================================================================= -->
<script type="text/javascript">
	document.getElementById("search").style.visibility = "hidden";
</script>
<%@ include file="/resources/admin/template/footer.jsp"%>