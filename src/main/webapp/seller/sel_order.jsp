<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.*, java.util.Base64, com.tha103.artion.seller.model.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.tha103.artion.seller.service.*"%>
<%@page import="com.tha103.artion.ticketOrder.model.TicketOrderVO"%>
<%@page import="com.tha103.artion.ticketOrder.model.TicketOrderService"%>
<%@page import="com.tha103.artion.ticketOrder.model.TicketOrderDAO"%>
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
<meta charset="utf-8">
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
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

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
						
						<a href="sel_actadd.jsp" class="nav-item nav-link"><i
							class="fa-solid fa-magnifying-glass me-2"></i>
							</i>訂單總覽</a> 
							
							<a href="sel_notification.html" class="nav-item nav-link"> 
							<i class="fa-solid fa-envelope me-2"></i>通知訊息</a> 
						
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
						width=50px height=50px />
				</div>
				<div
					style="margin-left: 10px; display: flex; flex-direction: column; align-items: center;">
					<h6 id="userNameSide" class="mb-0">寬宏藝術</h6>
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
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"> <i class="fa fa-envelope me-lg-2"></i>
							<span class="d-none d-lg-inline-flex"></span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle" src="images/user.jpg" alt=""
										style="width: 40px; height: 40px;">
									<div class="ms-2">
										<h6 class="fw-normal mb-0">Jhon send you a message</h6>
										<small>15 minutes ago</small>
									</div>
								</div>
							</a>
							<hr class="dropdown-divider">
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle" src="images/user.jpg" alt=""
										style="width: 40px; height: 40px;">
									<div class="ms-2">
										<h6 class="fw-normal mb-0">Jhon send you a message</h6>
										<small>15 minutes ago</small>
									</div>
								</div>
							</a>
							<hr class="dropdown-divider">
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle" src="images/user.jpg" alt=""
										style="width: 40px; height: 40px;">
									<div class="ms-2">
										<h6 class="fw-normal mb-0">Jhon send you a message</h6>
										<small>15 minutes ago</small>
									</div>
								</div>
							</a>
							<hr class="dropdown-divider">
							<a href="#" class="dropdown-item text-center">See all message</a>
						</div>
					</div>

					<!-- 右上角头像 -->
					<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-bs-toggle="dropdown"> <img
								src="<%=request.getContextPath()%>/seller/SellerServlet2.do?selId=${sellerVO.selId}"
								width=50px height=50px /> <span id="userNameNav"
								class="d-none d-lg-inline-flex">寬宏藝術</span>
							</a>
							<div
								class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
								<a href="../seller/sel_profile.jsp" class="dropdown-item">My
									Profile</a>
								<form
									action="<%=request.getContextPath()%>/seller/LogOutHandler.do"
									method="post">
									<button type="submit" class="dropdown-item">Log Out</button>
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
							<form
								class="d-md-flex justify-content-between align-items-center mb-3">
								<div class="col-md-6 d-md-flex justify-content-md-end">
									<!-- Existing content -->

								</div>
								<div class="col-md-6 d-md-flex justify-content-md-end">
									<!-- Move the select elements here -->
									<select id="orderstatus" class="form-select me-2 small-select"
										style="font-size: 14px">
										<option value="0">訂單狀態</option>
										<option value="1">訂單未完成</option>
										<option value="2">訂單已完成</option>
										<option value="3">訂單取消</option>
									</select> <select id="paymentstatus"
										class="form-select me-2 small-select" style="font-size: 14px">
										<option value="0">付款狀態</option>
										<option value="1">未付款</option>
										<option value="2">已付款</option>
										<option value="3">已取消</option>
									</select> <select id="ordertime" class="form-select me-2 small-select"
										style="font-size: 14px">
										<option value="0">訂單時間</option>
										<option value="1">最新到最舊</option>
										<option value="2">最舊到最新</option>
									</select>
								</div>
							</form>


							<table class="table"
								style="font-size: 18px; text-align: center; vertical-align: middle;">
								<thead>
									<tr>
										<th scope="col">訂單編號</th>
										<th scope="col">訂單成立時間</th>
										<th scope="col">會員編號</th>
										<th scope="col">實付金額</th>
										<th scope="col">付款狀態</th>
										<th scope="col">訂單狀態</th>
										<th scope="col">詳情</th>

									</tr>
								</thead>

								<c:forEach var="ticketOrderVO" items="${list}">
									<tr>
										<td>${ticketOrderVO.ticketOrdId}</td>
										<td>${ticketOrderVO.ticketOrdTime}</td>
										<td>${ticketOrderVO.member.memId}</td>
										<td>${ticketOrderVO.ticketOrdActuallyAmount}</td>
										
										<td><c:choose>
												<c:when test="${ticketOrderVO.ticketOrdPayStatus == 1}">
                   								未付款
                								</c:when>
												<c:when test="${ticketOrderVO.ticketOrdPayStatus == 2}">
                    							已付款
                								</c:when>
												<c:when test="${ticketOrderVO.ticketOrdPayStatus == 3}">
                    							已退款
                								</c:when>
											</c:choose></td>

											<td><c:choose>
												<c:when test="${ticketOrderVO.ticketOrdStatus == 1}">
                   								未完成
                								</c:when>
												<c:when test="${ticketOrderVO.ticketOrdStatus == 2}">
                    							已完成
                								</c:when>
												<c:when test="${ticketOrderVO.ticketOrdStatus == 3}">
                    							已取消
                								</c:when>
											</c:choose></td>
											<td>請點我</td>
									</tr>

								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- Table End -->

			<!-- Page Start -->
			<ul class="pagination ">
				<li id="prevPage"><a href="#">上一頁</a></li>
				<li id="currentPage">第1頁</li>
				<li id="nextPage"><a href="#">下一頁</a></li>

			</ul>

			<!-- Page End -->

			<!-- Footer Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-light rounded-top p-4">
					<div class="row">
						<div class="col-12 col-sm-6 text-center text-sm-start"
							style="margin-bottom: 20px !important;">
							&copy; <a href="#">Artion</a>, All Right Reserved.
						</div>
					</div>
				</div>

				<!-- Footer End -->

				<!-- Content End -->

				<!-- Instant Customer Support Icon -->
				<div id="customer-support-icon" class="icon">
					<i class="fa-brands fa-rocketchat fa-2x"></i>
				</div>
			</div>

			<script>
                    // JavaScript 代碼，用於處理分頁邏輯
                    const content = document.getElementById('content');
                    const prevPage = document.getElementById('prevPage');
                    const nextPage = document.getElementById('nextPage');
                    const currentPageElement = document.getElementById('currentPage');

                    let currentPage = 1; // 當前頁數
                    const totalPages = 5; // 總頁數，您可以根據需要更改

                    // 函數，用於更新顯示的頁數和內容
                    function updatePage() {
                        currentPageElement.textContent = `第${currentPage}頁`;

                        // 在此處根據當前頁數生成內容
                        const pageContent = generatePageContent(currentPage);
                        content.innerHTML = pageContent;

                        prevPage.disabled = currentPage === 1;
                        nextPage.disabled = currentPage === totalPages;
                    }

                    // 函數，用於根據頁數生成內容
                    function generatePageContent(page) {
                        // 在此處生成您的動態內容，這是一個示例
                        return `<p>這是第${page}頁的內容。</p>`;
                    }

                    // 上一頁按鈕的點擊事件處理程序
                    prevPage.addEventListener('click', () => {
                        if (currentPage > 1) {
                            currentPage--;
                            updatePage();
                        }
                    });

                    // 下一頁按鈕的點擊事件處理程序
                    nextPage.addEventListener('click', () => {
                        if (currentPage < totalPages) {
                            currentPage++;
                            updatePage();
                        }
                    });

                    // 初始化頁面
                    updatePage();
                </script>

			<script>
                    // 更換profile pic會同步
                    function handleImageUpload(input, imageId) {
                        var userImage = document.getElementById(imageId);
                        var uploadText = userImage.nextElementSibling; // 使用图像元素的下一个兄弟元素（即文本元素）

                        if (input.files && input.files[0]) {
                            var reader = new FileReader();

                            reader.onload = function (e) {
                                userImage.src = e.target.result;
                                uploadText.style.display = 'none'; // 设置为 'none' 以隐藏文本

                                // 添加以下代码来更新右上角的头像
                                var userImageNav = document.getElementById('userImageNav');
                                if (userImageNav) {
                                    userImageNav.src = e.target.result;
                                }
                            };

                            reader.readAsDataURL(input.files[0]);
                        }
                    }
                    // 在页面加载后，为头像上传元素添加事件监听
                    document.addEventListener('DOMContentLoaded', function () {
                        var fileInput = document.getElementById('fileInput'); // 侧边栏头像上传元素
                        var userImageNav = document.getElementById('userImageNav'); // 右上角的头像元素

                        fileInput.addEventListener('change', function () {
                            handleImageUpload(this, 'userImageNav');
                        });
                    });
                </script>
			<!-- JavaScript Libraries -->
			<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
			<script
				src="<%=request.getContextPath()%>/seller/lib/chart/chart.min.js"></script>
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
			<script src="js/main.js"></script>
</body>

</html>