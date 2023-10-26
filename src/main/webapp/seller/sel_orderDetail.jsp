<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.tha103.artion.ticketOrder.model.*"%>
<%@page import="com.tha103.artion.ticketOrderDetail.model.*"%>
	
<!DOCTYPE html>
<html lang="en">

<% 
TicketOrderVO TicketOrderVO = (TicketOrderVO) request.getAttribute("TicketOrderVO");
TicketOrderDetailVO ticketOrderDetailVO = (TicketOrderDetailVO) request.getAttribute("ticketOrderDetailVO");
%>

<head>
<meta charset="utf-8">
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
									<img class="rounded-circle" src="img/user.jpg" alt=""
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
									<img class="rounded-circle" src="img/user.jpg" alt=""
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
									<img class="rounded-circle" src="img/user.jpg" alt=""
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

			<!-- Form Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<!-- 第一个區塊 -->
					<div class="col-sm-12 col-xl-12">
						<div class="bg-light rounded h-100 py-4">
							<h6 class="mb-4"
								style="font-size: 24px; color: #009CFF; margin-left: 20px">訂單詳情</h6>
							<div class="mb-3">
								<label for="ticketOrdId"
									style="font-weight: bold; margin-left: 20px">訂單編號：</label> <input
										type="text" class="form-control" id="sellPhoneNumber"
										name="ticketOrdId" value="${ticketOrderVO.ticketOrdId}">
				
								<!-- 这里用于显示 "訂單編號：" 文本和订单号 -->
							</div>
							<div class="row">
								<div class="col">
									<div class="mb-3">
										<div class="form-group">
											<label for="orderNumber"
												style="font-weight: bold;; margin-left: 20px">訂單狀態：</label>
											<input
										type="text" class="form-control" id="ticketOrdStatus"
										name="ticketOrdStatus" value="${ticketOrderVO.ticketOrdStatus}">
											<!-- 这里用于显示 "訂單編號：" 文本和订单号 -->
										</div>
									</div>
									<hr>
									<!-- 这是分隔线 -->
									<div class="col-sm-12 col-xl-12">
										<h6 class="mb-3"
											style="font-size: 20px; color: #757575; margin-left: 20px">訂購商品
										</h6>
										<table class="table table-borderless">
											<thead>
												<tr>
													<th scope="col" style="padding-left: 20px">票券編號</th>
													<th scope="col" style="padding-left: 20px">活動名稱</th>
													<th scope="col" style="padding-left: 20px">訂單成立時間</th>
													<th scope="col" style="padding-left: 20px">數量</th>
													<th scope="col" style="padding-left: 20px">單價</th>
													<th scope="col" style="padding-left: 20px">小計</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th scope="row" style="padding-left: 20px">02022</th>
													<th scope="col" style="padding-left: 20px">迪士尼動畫展
													</td>
													<th scope="col" style="padding-left: 20px">2023-02-25
														09:20 AM
													</td>
													<th scope="col" style="padding-left: 20px">2
													</td>
													<th scope="col" style="padding-left: 20px">200
													</td>
													<th scope="col" style="padding-left: 20px">400
													</td>
												</tr>
												<tr>
													<th scope="col" style="padding-left: 20px">03456</th>
													<th scope="col" style="padding-left: 20px">松菸水水市集
													</td>
													<th scope="col" style="padding-left: 20px">2023-02-25
														09:20 AM
													</td>
													<th scope="col" style="padding-left: 20px">1
													</td>
													<th scope="col" style="padding-left: 20px">150
													</td>
													<th scope="col" style="padding-left: 20px">150
													</td>
												</tr>
											</tbody>
										</table>
									</div>
									<hr>
									<!-- 这是分隔线 -->
								</div>
								<div class="col-sm-12 col-xl-12 d-flex justify-content-end">
									<div>
										<h6 id="orderAmount" class="mb-3" style="margin-right: 60px">
											訂購金額：550</h6>
										<h6 id="discountAmount" class="mb-3"
											style="margin-right: 60px">優惠金額：0</h6>
										<h6 id="totalAmount" class="mb-3" style="margin-right: 60px">
											實付金額：550</h6>
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
												會員編號: 205981</h6>
											<h6 id="orderName" class="mb-3"
												style="font-size: 14px; color: #757575; margin-left: 20px">
												會員名稱: 陳小明</h6>
											<h6 id="orderPhoneNumber" class="mb-3"
												style="font-size: 14px; color: #757575; margin-left: 20px">連絡電話:
												0939111345</h6>
											<h6 id="orderEmail" class="mb-3"
												style="font-size: 14px; color: #757575; margin-left: 20px">
												Email: hdksahw@gmail.com</h6>
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

							<!-- Instant Customer Support Icon -->
							<div id="customer-support-icon" class="icon">
								<i class="fa-brands fa-rocketchat fa-2x"></i>
							</div>

							<script>
                                //即時客服

                                const customerSupportIcon = document.getElementById('customer-support-icon');
                                let isIconUp = false;

                                customerSupportIcon.addEventListener('click', () => {
                                    if (isIconUp) {
                                        customerSupportIcon.style.transform = 'translateY(0)';
                                    } else {
                                        customerSupportIcon.style.transform = 'translateY(-100px)'; // Adjust the distance as needed
                                    }
                                    isIconUp = !isIconUp;
                                });
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
							<script src="lib/chart/chart.min.js"></script>
							<script src="lib/easing/easing.min.js"></script>
							<script src="lib/waypoints/waypoints.min.js"></script>
							<script src="lib/owlcarousel/owl.carousel.min.js"></script>
							<script src="lib/tempusdominus/js/moment.min.js"></script>
							<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
							<script
								src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

							<!-- Template Javascript -->
							<script src="js/main.js"></script>
</body>

</html>