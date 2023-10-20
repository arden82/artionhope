<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.*, java.util.Base64, com.tha103.artion.seller.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tha103.artion.seller.service.*"%>


<%
// 从 Session 中获取用户帐号和密码
String userAccount = (String) session.getAttribute("userAccount");
String userPassword = (String) session.getAttribute("userPassword");

// 创建 SellerService 实例
SellerService sellerSvc = new SellerService();

// 调用 getSelName 方法获取卖家的名称
String sellerName = sellerSvc.getSelName(userAccount);

// 检查是否成功获取卖家的名称
if (sellerName != null) {
%>
    <!-- 在页面中显示卖家的名称 -->
    <p>卖家名称: <%= sellerName %></p>
<%
} else {
%>
    <!-- 如果未能获取卖家的名称，显示相应消息 -->
    <p>未找到卖家信息。</p>
<%
}
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


</head>

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
				<a href="sel_index.html" class="navbar-brand mx-4 mb-3 artionimg">
					<img src="./images/artion-logo.png">
				</a>

				<div class="navbar-nav w-100">
					<div class="nav-item">
						<a href="sel_index.html" class="nav-item nav-link"><i
							class="fa-solid fa-users me-2"></i></i>活動總覽</a> <a href="sel_actadd.html"
							class="nav-item nav-link"><i
							class="fa-solid fa-heart-circle-plus me-2"></i></i>新增活動</a> <a
							href="sel_order.html" class="nav-item nav-link"><i
							class="fa-solid fa-magnifying-glass me-2"></i></i>訂單總覽</a> <a
							href="sel_notification.html" class="nav-item nav-link"> <i
							class="fa-solid fa-envelope me-2"></i>通知訊息
						</a> <a href="sel_profile.html" class="nav-item nav-link"> <i
							class="fa-solid fa-address-card me-2"></i>廠商基本資料
						</a>
					</div>
				</div>
			</nav>
			<!-- Sidebar 头像 -->
			<div class="d-flex mt-auto"
				style="margin-left: 40px; align-items: center; margin-bottom: 40px;">
				<div class="position-relative">
					<label for="fileInput"> <img id="userImageSide"
						class="rounded-circle" src="img/user.jpg" alt=""
						style="width: 50px; height: 50px; cursor: pointer;">
						<div id="uploadText"
							style="display: none; position: absolute; top: 0; left: 0; width: 100%; height: 100%; font-size: 15px; background-color: rgba(0, 0, 0, 0.5); color: white; text-align: center; line-height: 40px; cursor: pointer;">
							更換</div>
					</label> <input type="file" id="fileInput" accept="image/*"
						style="display: none;"
						onchange="handleImageUpload(this, 'userImageSide')">
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
							data-bs-toggle="dropdown"> <img id="userImageNav"
							class="rounded-circle me-lg-2" src="img/user.jpg" alt=""
							style="width: 40px; height: 40px;"> <span id="userNameNav"
							class="d-none d-lg-inline-flex">寬宏藝術</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
							<a href="sel_profile.jsp" class="dropdown-item">My Profile</a> <a
								href="#" class="dropdown-item">Settings</a> <a
								href="sel_signin.jsp" class="dropdown-item">Log Out</a>
						</div>
					</div>
			</nav>
			<!-- Navbar End -->

			<!-- Form Start -->
			 <c:forEach items="${list}" var="seller">
    <c:if test="${seller.selAccount eq userAccount && seller.selPassword eq userPassword}">

				<div class="container-fluid pt-4 px-4">
					<div class="row g-4">
						<!-- 左侧卡片区块，占据6列，即半屏宽度 -->
						<div class="col-sm-12 col-xl-6">
							<div class="bg-light rounded h-100 p-4">
								<h6 class="mb-4" style="font-size: 24px; color: #009CFF">廠商基本資料</h6>
								<div class="mb-3">
									<div class="form-group">
										<label for="sellEmail" class="form-label">E-mail</label> <input
											type="email" class="form-control" id="sellEmail" name="selAccount"
											value="${userAccount}" style="color: lightgrey"
											readonly>	

									</div>
									<div class="row">
										<div class="col">
											<div class="mb-2">
												<label for="sellpassword" class="form-label" >密碼</label>
												<div class="d-flex">
													<input type="password" class="form-control" name="selPassword"
														id="sellpassword" value="${userPassword}">
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="mb-3">
									<label for="sellName" class="form-label">廠商名稱</label> <input
										type="text" class="form-control" id="sellName" name="selName"
										value="${userSelName}">
								</div>
								<div class="mb-3">
									<label for="sellPhoneNumber" class="form-label">電話</label> <input
										type="text" class="form-control" id="sellPhoneNumber" name="selPhone"
										value="${sellerVO.selPhone}">
								</div>
							</div>
						</div>

						<!-- 右侧卡片区块，占据6列，即半屏宽度 -->

						<div class="col-sm-12 col-xl-6">
							<div class="bg-light rounded h-100 p-4">
								<div class="mb-3">
									<label for="sellAddress" class="form-label"
										style="margin-top: 55px;">廠商地址</label> <input type="text"
										class="form-control" id="sellAddress" name="selAddress" value="${sellerVO.selAddress}">
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">官方網址</label> <input
										type="text" class="form-control" id="sellAddress" name="selUrl"
										value="${sellerVO.selUrl}">
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">Facebook</label> <input
										type="text" class="form-control" id="sellAddress" name="selFacebook"
										value="${sellerVO.selFacebook}">
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">單位連絡人</label> <input
										type="text" class="form-control" id="sellAddress" name="selContactPerson"
										value="${sellerVO.selContactPerson}">
								</div>
							</div>
						</div>
					</div>

					<!-- 分隔線 -->
					<div class="col-sm-12 col-xl-12 mt-4"></div>

					<!-- 下方區塊 廠商簡介-->
					<div class="row g-4">
						<div class="col-sm-12">
							<div class="bg-light rounded h-100 p-4">
								<div class="col">
									<div class="mb-3">
										<label for="sellIntroduction" class="form-label">廠商簡介</label>
										<textarea class="form-control" id="sellIntroduction" name="selIntroduction"
											style="width: 100%; max-width: 910px; min-height: 200px; box-sizing: border-box; 
											value="${sellerVO.selIntroduction}"></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- 分隔線 -->
					<div class="col-sm-12 col-xl-12 mt-4"></div>

					<!-- 下方區塊 帳務資訊-->
					<div class="col-sm-12">
						<div class="bg-light rounded h-100 p-4">
							<div class="row">
								<div class="col">
									<div class="mb-2">
										<div class="form-group">
											<label for="bankCode" class="form-label">銀行代碼</label>
											<div class="d-flex">
												<input type="text" class="form-control" id="bankCode" name="selBankCode"
													value="${sellerVO.selBankCode}">
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="mb-3">
										<label for="bankAccount" class="form-label">銀行帳號</label>
										<div class="d-flex">
											<input type="text" class="form-control" id="bankAccount" name="selBankNumber"
												value="${sellerVO.selBankNumber}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="mb-2">
										<div class="form-group">
											<label for="accountNAme" class="form-label">戶名</label>
											<div class="d-flex">
												<input type="text" class="form-control" id="accountNAme" name="selBankName"
													value="${sellerVO.selBankName}">
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="mb-3">
										<label for="remark" class="form-label">備註</label>
										<div class="d-flex">
											<input type="text" class="form-control" id="remark" name="selRemark"
											value="${sellerVO.selRemark}">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- 下方區塊 單位資料-->
					<div class="col-sm-12">
						<div class="bg-light rounded h-100 p-4">
							<div class="row">
								<div class="col">
									<div class="mb-2">
										<div class="form-group">
											<label for="departmentName" class="form-label">單位名稱</label>
											<div class="d-flex">
												<input type="text" class="form-control" id="departmentName" name="selTitle"
													value="${sellerVO.selTitle}">
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="mb-3">
										<label for="departmenBoss" class="form-label">單位負責人</label>
										<div class="d-flex">
											<input type="text" class="form-control" id="departmenBoss" name="selPrincipal"
												value="${sellerVO.selPrincipal}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="mb-2">
										<div class="form-group">
											<label for="guiNumber" class="form-label">統一編號</label>
											<div class="d-flex">
												<input type="text" class="form-control" id="guiNumber" name="selUniformNumbers"
													value="${sellerVO.selUniformNumbers}">
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="mb-3">
										<label for="registeredAddress" class="form-label">單位立案地址</label>
										<div class="d-flex">
											<input type="text" class="form-control"
												id="registeredAddress" name="selRegisteredAddress"
												value="${sellerVO.selRegisteredAddress}">
										</div>
									</div>
								</div>
							</div>

							<div class="text-center" style="margin-top: 30px;">
							
							<td>
                    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/seller/SellerServlet.do"
                        style="margin-bottom: 0px;">
                        <input type="submit" value="修改"> <input type="hidden"
                            name="sel_id" value="${sellerVO.selId}"> <input
                            type="hidden" name="action" value="getOne_For_Update">
                    </FORM>
                </td>
                <td>
                    <FORM METHOD="post"
                        ACTION="<%=request.getContextPath()%>/seller/SellerServlet.do"
                        style="margin-bottom: 0px;">
                        <input type="submit" value="刪除"> <input type="hidden"
                            name="sel_id" value="${sellerVO.selId}"> <input
                            type="hidden" name="action" value="delete">
                    </FORM>
                </td>
			   </c:if>
    </c:forEach>
		</div>
	</div>
	</div>
	<!-- Form End -->

	<!-- Footer Start -->
	<div class="container-fluid pt-4 px-8">
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
	</div>
	<!-- Content End -->

	<!-- Instant Customer Support Icon -->
	<div id="customer-support-icon" class="icon">
		<i class="fa-brands fa-rocketchat fa-2x"></i>
	</div>

	<script>
		// 更換profile pic會同步
		function handleImageUpload(input, imageId) {
			var userImage = document.getElementById(imageId);
			var uploadText = userImage.nextElementSibling; // 使用图像元素的下一个兄弟元素（即文本元素）

			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
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
		document.addEventListener('DOMContentLoaded', function() {
			var fileInput = document.getElementById('fileInput'); // 侧边栏头像上传元素
			var userImageNav = document.getElementById('userImageNav'); // 右上角的头像元素

			fileInput.addEventListener('change', function() {
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
	<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>

</html>