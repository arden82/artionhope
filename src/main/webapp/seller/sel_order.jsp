<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.*, java.util.Base64, com.tha103.artion.seller.model.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.tha103.artion.seller.service.*"%>
<%@page import="com.tha103.artion.ticketOrder.model.*"%>

<%
Integer selId = (Integer) session.getAttribute("sel_id");
if (selId == null) {
	return;
}
TicketOrderService ticketOrderSvc = new TicketOrderService();
List<TicketOrderVO> list = ticketOrderSvc.getTicketOrderBySellerId(selId);
pageContext.setAttribute("list", list);
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
<link href="images/favicon.ico" rel="icon">

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

/* 添加一些基本的樣式以美化分頁 */
.pagination {
	display: flex;
	list-style: none;
	justify-content: center;
	/* 將內容水平置中 */
	align-items: center;
	/* 垂直置中（如果有多行文本） */
	padding: 0;
	/* 清除默認的內邊距 */
}

.pagination li {
	margin: 5px;
}

.pagination li a {
	text-decoration: none;
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
.footer-fixed {
    position: fixed;
    bottom: 0;
    width: 100%;
    z-index: 1000; /* 這個屬性確保footer始終在其他元素之上 */
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
				<a href="../activity/sel_index.jsp"
					class="navbar-brand mx-4 mb-3 artionimg"> <img
					src="./images/artion-logo.png">
				</a>

				<div class="navbar-nav w-100">
					<div class="nav-item">
						<a href="../activity/sel_index.jsp" class="nav-item nav-link">
							<i class="fa-solid fa-users me-2"></i> </i>活動總覽
						</a> <a href="../activity/sel_actadd.jsp" class="nav-item nav-link">
							<i class="fa-solid fa-heart-circle-plus me-2"></i> </i>新增活動
						</a> <a href="./sel_order.jsp" class="nav-item nav-link"><i
							class="fa-solid fa-magnifying-glass me-2"></i> </i>訂單總覽</a> <a
							href="./sel_profile.jsp" class="nav-item nav-link"> <i
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
						width=50px height=50px style="border-radius: 50%;" /> <span
						id="userNameNav" class="d-none d-lg-inline-flex"></span>
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

		<!-- Table Start -->
		<div class="container-fluid pt-4 px-4">
			<div class="row g-4">
				<div class="col-12">
					<div class="bg-light rounded h-100 p-4">
						<h6 class="mb-4" style="font-size: 24px">
							<a href="">訂單總覽</a>
						</h6>

						<table class="table"
							style="font-size: 18px; text-align: center; vertical-align: middle;">
							<thead>
								<tr>
									<th scope="col">訂單編號</th>
									<th scope="col">訂單成立時間</th>
									<th scope="col">會員編號</th>
									<th scope="col">實付金額</th>
<!-- 									<th scope="col">付款狀態</th> -->
<!-- 									<th scope="col">訂單狀態</th> -->
									<th scope="col">詳情</th>
								</tr>
							</thead>
							<%@ include file="page1.file"%>
							<c:forEach var="ticketOrderVO" items="${list}"
								begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">

								<tr>
									<td>${ticketOrderVO.ticketOrdId}</td>
									<td>${ticketOrderVO.ticketOrdTime}</td>
									<td>${ticketOrderVO.member.memId}</td>
									<td>${ticketOrderVO.ticketOrdActuallyAmount}</td>

<%-- 									<td><c:choose> --%>
<%-- 											<c:when test="${ticketOrderVO.ticketOrdPayStatus == 1}"> --%>
<!--                    								未付款 -->
<%--                 								</c:when> --%>
<%-- 											<c:when test="${ticketOrderVO.ticketOrdPayStatus == 2}"> --%>
<!--                     							已付款 -->
<%--                 								</c:when> --%>
<%-- 											<c:when test="${ticketOrderVO.ticketOrdPayStatus == 3}"> --%>
<!--                     							已退款 -->
<%--                 								</c:when> --%>
<%-- 										</c:choose></td> --%>

<%-- 									<td><c:choose> --%>
<%-- 											<c:when test="${ticketOrderVO.ticketOrdStatus == 1}"> --%>
<!--                    								未完成 -->
<%--                 								</c:when> --%>
<%-- 											<c:when test="${ticketOrderVO.ticketOrdStatus == 2}"> --%>
<!--                     							已完成 -->
<%--                 								</c:when> --%>
<%-- 											<c:when test="${ticketOrderVO.ticketOrdStatus == 3}"> --%>
<!--                     							已取消 -->
<%--                 								</c:when> --%>
<%-- 										</c:choose></td> --%>
									<td><a
										href="sel_orderDetail.jsp?ticketOrdId=${ticketOrderVO.ticketOrdId}">查看詳情</a>
									</td>
								</tr>

							</c:forEach>
						</table>
						<%@ include file="page2.file"%>
					</div>
				</div>
			</div>
		</div>

		<!-- Table End -->

		<!-- Footer Start -->
		<div class="container-fluid footer-fixed pt-4 px-4">
			<div class="bg-light rounded-top p-4">
				<div class="row">
					<div class="col-12 col-sm-6 text-center text-sm-start"
						style="margin-bottom: 30px !important;">
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