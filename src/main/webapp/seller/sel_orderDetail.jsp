<%@page import="javax.sound.midi.SysexMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.tha103.artion.ticketOrder.model.TicketOrderDAO"%>
<%@page import="com.tha103.artion.ticketOrder.model.TicketOrderVO"%>
<%@page import="com.tha103.artion.ticketOrder.model.TicketOrderService"%>
<%@page import="com.tha103.artion.ticketOrderDetail.model.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tha103.artion.activity.model.*"%>
<%@ page import="com.tha103.artion.activity.service.*"%>

<%
Integer selId = (Integer) session.getAttribute("sel_id");
if (selId == null) {
	return;
}
String ticketOrdIdStr = request.getParameter("ticketOrdId");

if (ticketOrdIdStr != null && !ticketOrdIdStr.isEmpty()) {
	try {
		Integer ticketOrdId = Integer.parseInt(ticketOrdIdStr);
		// 現在，ticketOrdId 是整數型態。
		TicketOrderService ticketOrderSvc = new TicketOrderService();
		TicketOrderVO ticketOrderVO = ticketOrderSvc.getTicketOrderDetailsByTicketOrdId(ticketOrdId);

		if (ticketOrderVO != null) {
	pageContext.setAttribute("ticketOrderVO", ticketOrderVO);
	System.out.println("訂單資訊: " + ticketOrderVO);
		} else {
	// 處理未找到訂單的情況，可能需要轉向錯誤頁面或執行其他錯誤處理邏輯
		}
	} catch (NumberFormatException e) {
		// 處理無效的 ticketOrdId 字串，可能需要轉向錯誤頁面或執行其他錯誤處理邏輯
	}
} else {
	// 處理 ticketOrdId 為 null 或空的情況
	// 在這裡添加錯誤處理邏輯
}
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title></title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link
	href="<%=request.getContextPath()%>/seller/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/seller/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="<%=request.getContextPath()%>/seller/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Template Stylesheet -->
<link href="<%=request.getContextPath()%>/seller/css/style.css"
	rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

<style>
.input-group {
	width: 200px;
	/* 自定义选择框的宽度 */
}

.small-select {
	width: 120px;
	/* 调整宽度以适应布局 */
}

@media ( max-width : 768px) {
	.small-select {
		width: 100%;
		/* 使筛选框占据整个宽度 */
		margin-bottom: 10px;
		/* 添加垂直间距 */
	}
}

.icon {
	position: fixed;
	bottom: 60px;
	right: 25px;
	z-index: 999;
	/* Ensure it's above other content */
	transition: transform 0.5s ease-in-out;
	cursor: pointer;
}
</style>
</head>

<body>
	<div class="container-xxl position-relative bg-white d-flex p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->

		<!-- Sidebar Start -->
		<div class="sidebar pe-4 pb-3 d-flex flex-column">
			<nav class="navbar bg-light navbar-light">
				<a href="../activity/sel_index.jsp" class="navbar-brand mx-4 mb-3 artionimg">
					<img src="./images/artion-logo.png">
				</a>

				<div class="navbar-nav w-100">
					<div class="nav-item">
						<a href="../activity/sel_index.jsp" class="nav-item nav-link">
						<i class="fa-solid fa-users me-2"></i>
						</i>活動總覽</a> 
						
						<a href="../activity/sel_actadd.jsp" class="nav-item nav-link">
						<i class="fa-solid fa-heart-circle-plus me-2"></i>
						</i>新增活動</a> 
						
						<a href="./sel_order.jsp" class="nav-item nav-link"><i
							class="fa-solid fa-magnifying-glass me-2"></i>
							</i>訂單總覽</a> 
							
						<a href="./sel_profile.jsp" class="nav-item nav-link"> <i
							class="fa-solid fa-address-card me-2"></i>廠商基本資料
						</a>
					</div>
				</div>
			</nav>
			<!-- Sidebar 头像 -->
			<div class="d-flex mt-auto"
				style="margin-left: 40px; align-items: center; margin-bottom: 40px;">
				<div class="position-relative">
					<img
						src="<%=request.getContextPath()%>/seller/SellerServlet2.do?selId=${sellerVO.selId}"
						width=50px height=50px style="border-radius: 50%;" />
				</div>
				<div
					style="margin-left: 10px; display: flex; flex-direction: column; align-items: center;">
					<h6 id="userNameSide" class="mb-0">${sellerVO.selName}</h6>
				</div>
			</div>
		</div>
	</div>
	<!-- Sidebar End -->

	<!-- Content Start -->
	<div class="content">
		<!-- Navbar Start -->
		<nav
			class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
			<a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
				<h2 class="text-primary mb-0">
					<i class="fa fa-hashtag"></i>
				</h2>
			</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
				class="fa fa-bars"></i>
			</a>

			<div class="navbar-nav align-items-center ms-auto">
				

				<!-- 右上角头像 -->
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"> <img
						src="<%=request.getContextPath()%>/seller/SellerServlet2.do?selId=${sellerVO.selId}"
						width=50px height=50px style="border-radius: 50%;" />
					</a>
					<div
						class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
						<a href="../seller/sel_profile.jsp" class="dropdown-item">My
							Profile</a>
						<form
								action="<%=request.getContextPath()%>/seller/LogOutHandler.do"
								method="post">
								<button type="submit" class="dropdown-item">Log Out</button>
								<input type="hidden" name="action" value="logout">
							</form>

					</div>
				</div>
		</nav>
		<!-- Navbar End -->

		<!-- Form Start -->
		<div class="container-fluid pt-4 px-4">
			<div class="row g-4">
				<!-- 第一个區塊 -->
				<div class="col-sm-12 col-xl-12">
					<div class="bg-light rounded h-100 py-4">
						<h6 class="mb-4"
							style="font-size: 24px; color: #009CFF; margin-left: 20px">訂單詳情</h6>
						<div class="mb-3">

							<div class="mb-3">
								<label for="ticketOrdId" class="form-label"
									style="margin-left: 40px">訂單編號:</label> <span>${ticketOrderVO.ticketOrdId}</span>
							</div>

							<div class="mb-3">
								<label for="ticketOrdStatus" class="form-label"
									style="margin-left: 40px">訂單狀態:</label>
									<c:choose>
											<c:when test="${ticketOrderVO.ticketOrdStatus == 1}">
                   								未完成
                								</c:when>
											<c:when test="${ticketOrderVO.ticketOrdStatus == 2}">
                    							已完成
                								</c:when>
											<c:when test="${ticketOrderVO.ticketOrdStatus == 3}">
                    							已取消
                								</c:when>
										</c:choose>
							</div>

							<!-- 这是分隔线 -->
							<div class="col-sm-12 col-xl-12">
								<h6 class="mb-3"
									style="font-size: 20px; color: #757575; margin-left: 20px">訂購商品
								</h6>
								<table class="table table-borderless">
									<thead>
										<tr>
											<th scope="col" style="padding-left: 20px">活動名稱</th>
											<th scope="col" style="padding-left: 20px">訂單成立時間</th>
											<th scope="col" style="padding-left: 20px">數量</th>
											<th scope="col" style="padding-left: 20px">單價</th>
											<th scope="col" style="padding-left: 20px">小計</th>
										</tr>
									</thead>

									<c:forEach var="ticOrdDets" items="${ticketOrderVO.ticOrdDets}">

										<tbody>
											<tr>
												<th scope="col" style="padding-left: 20px"><span>${ticOrdDets.activity.actName}</span>
												</th>

												<th scope="col" style="padding-left: 20px"><span>${ticketOrderVO.ticketOrdTime}</span>
												</th>
												<th scope="col" style="padding-left: 20px"><span>${ticOrdDets.ticOrdDetQuantity}</span>
												</th>
												<th scope="col" style="padding-left: 20px"><span>${ticOrdDets.activity.actTicketPrice}</span>
												<th scope="col" style="padding-left: 20px"><span>${ticOrdDets.ticOrdDetQuantity * ticOrdDets.ticOrdDetPrice}</span>
													<%-- 											<span>${getActNameByActId(detail.activity.actId)}"</span> --%>

												</th>
											</tr>
										</tbody>
								</table>
								</c:forEach>
							</div>
							<hr>
							<!-- 这是分隔线 -->
						</div>
						<div class="col-sm-12 col-xl-12 d-flex justify-content-end">
							<div>
								<h6 id="orderAmount" class="mb-3" style="margin-right: 60px">
									訂購金額：<span>${ticketOrderVO.ticketOrdTotalPrice}</span>
								</h6>

								<h6 id="discountAmount" class="mb-3" style="margin-right: 60px">
									優惠金額： <span>${ticketOrderVO.ticketOrdProCodeAmount}</span>
								</h6>

								<h6 id="totalAmount" class="mb-3" style="margin-right: 60px">
									實付金額：<span>${ticketOrderVO.ticketOrdActuallyAmount}</span>
								</h6>
							</div>
						</div>

						<div class="col-sm-12 col-xl-12  content-container">
							<div class="row">
								<div class="col-6">
									<!-- 左边内容 -->
									<h6 class="mb-3"
										style="font-size: 20px; color: #757575; margin-left: 20px">
										付款人資訊</h6>
									<hr>
									<!-- 这是分隔线 -->
									<h6 id="orderSellId" class="mb-3"
										style="font-size: 14px; color: #757575; margin-left: 20px">
										會員編號: <span>${ticketOrderVO.member.memId}</span>
									</h6>
									<h6 id="orderName" class="mb-3"
										style="font-size: 14px; color: #757575; margin-left: 20px">
										會員名稱: <span>${ticketOrderVO.member.memName}</span></h6>
									<h6 id="orderPhoneNumber" class="mb-3"
										style="font-size: 14px; color: #757575; margin-left: 20px">連絡電話:
										<span>${ticketOrderVO.member.memMobile}</span></h6>
									
								</div>
								<div class="col-6 " style="overflow: hidden;">
									<!-- 右边内容 -->
									<h6 class="mb-3"
										style="font-size: 20px; color: #757575; text-align: left">
										付款資訊</h6>
									<hr>
									<!-- 这是分隔线 -->
									<h6 id="orderAmount" class="mb-3"
										style="font-size: 14px; color: #757575; text-align: left">付款狀態:已付款</h6>
									<h6 id="discountAmount" class="mb-3"
										style="font-size: 14px; color: #757575; text-align: left">付款方式:信用卡</h6>
									<h6 id="discountAmount" class="mb-3"
										style="font-size: 14px; color: #757575; text-align: left">第三方支付平台:綠界
									</h6>
								</div>

							</div>
							<div class="row  mx-auto">
								<div class="col-12
                                    "
									style="height: 50px; background-color: #ffffff"></div>
							</div>
						</div>
					</div>
					<!-- Footer Start -->
					<div class="container-fluid">
						<div class="bg-light rounded-top p-4">
							<div class="row">
								<div class="col-10 col-sm-4 text-center text-sm-start"
									style="margin-bottom: 10px !important;">
									&copy; <a href="#">Artion</a>, All Right Reserved.
								</div>
							</div>
						</div>
					</div>
					<!-- Footer End -->
				</div>
				<!-- Content End -->

				<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/seller/lib/easing/easing.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/seller/lib/waypoints/waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/seller/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/seller/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/seller/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/seller/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="<%=request.getContextPath()%>/seller/js/main.js"></script>
</body>

</html>