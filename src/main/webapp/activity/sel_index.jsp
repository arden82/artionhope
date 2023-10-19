<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity.model.*"%>
<%-- 此頁練習採用 S 的寫法取值 --%>

<%
ActivityService activitySvc = new ActivityService();
List<ActivityVO> list = activitySvc.getAll();
pageContext.setAttribute("list", list);
System.out.println(list.size());
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
				<a href="sel_index.jsp" class="navbar-brand mx-4 mb-3 artionimg">
					<!-- <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>Artion</h3> -->
					<img src="./images/artion-logo.png">
				</a>

				<div class="navbar-nav w-100">
					<div class="nav-item">
						<a href="sel_index.jsp" class="nav-item nav-link"><i class="fa-solid fa-users me-2"> 
						</i></i>活動總覽</a>
							 
						<a href="sel_actadd.jsp" class="nav-item nav-link"><i class="fa-solid fa-heart-circle-plus me-2">
						</i></i> 新增活動</a> 
						
						<a href="sel_actadd.jsp" class="nav-item nav-link"><i class="fa-solid fa-magnifying-glass me-2">
						</i></i>訂單總覽</a> 
						
						<a href="sel_actadd.jsp" class="nav-item nav-link"> <i class="fa-solid fa-envelope me-2">
						</i>通知訊息</a> 
						<a href="sel_profile.html" class="nav-item nav-link"> <i class="fa-solid fa-address-card me-2">
						</i>廠商基本資料
						</a>
					</div>
				</div>
			</nav>

			<!-- Sidebar 头像 -->
			<div class="d-flex mt-auto"
				style="margin-left: 40px; align-items: center; margin-bottom: 40px;">
				<div class="position-relative">
					<label for="fileInput"> <img id="userImageSide"
						class="rounded-circle" src="images/user.jpg" alt=""
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
							data-bs-toggle="dropdown"> <img id="userImageNav"
							class="rounded-circle me-lg-2" src="images/user.jpg" alt=""
							style="width: 40px; height: 40px;"> <span id="userNameNav"
							class="d-none d-lg-inline-flex">寬宏藝術</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
							<a href="sel_profile.html" class="dropdown-item">My Profile</a> <a
								href="#" class="dropdown-item">Settings</a> <a
								href="/IBM_emp_0201MVC_Single-Table_mySQL8/seller/login.jsp"
								class="dropdown-item">Log Out</a>
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
								<a href="">活動總覽</a>
							</h6>
							<form
								class="d-md-flex justify-content-between align-items-center mb-3">
								<div class="input-group col-md-6">
									<input class="form-control border" type="search"
										placeholder="Search">
									<button class="btn btn-primary" type="submit">Search</button>
								</div>

								<div class="col-md-6 d-md-flex justify-content-md-end">
									<button class="btn btn-success me-2">匯出</button>
									<select id="filterSelect" class="form-select me-2 small-select">
										<option value="0">活動類型</option>
										<option value="1">表演</option>
										<option value="2">展覽</option>
										<option value="3">市集</option>
									</select> <select id="quantityFilter"
										class="form-select me-2 small-select">
										<option value="0">銷售數量</option>
										<option value="1">高到低</option>
										<option value="2">低到高</option>
									</select> <select id="statusFilter"
										class="form-select me-2 small-select">
										<option value="type">審核狀態</option>
										<option value="0">草稿</option>
										<option value="1">未審核</option>
										<option value="2">審核通過</option>
										<option value="3">審核未通過</option>
									</select>
								</div>
							</form>
							<table class="table"
								style="font-size: 16px; text-align: center; vertical-align: middle;">
								<thead>
									<tr>
										<td><input type="checkbox"></td>
										<th>活動編號</th>
										<th>活動名稱</th>
										<th>活動類型</th>
										<th>價格</th>
										<th>銷售數量</th>
										<th>審核狀態</th>
										<th>活動狀態</th>
										<th>活動開始日期</th>
										<th>活動結束日期</th>
									</tr>
								</thead>

								<%@ include file="page1.file"%>
								<c:forEach var="activityVO" items="${list}"
									begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">

									<tr>
										<td><input type="checkbox"></td>
										<td>${activityVO.act_id}</td>
										<td>${activityVO.act_name}</td>
										<td>${activityVO.act_type}</td>
										<td>${activityVO.act_ticketPrice}</td>
										<td>${activityVO.act_ticketTotalSell}</td>
										<td>${activityVO.act_approalStatus}</td>
										<td>${activityVO.act_status}</td>
										<td>${activityVO.act_startDate}</td>
										<td>${activityVO.act_endDate}</td>
									</tr>
								</c:forEach>
							</table>
							<%@ include file="page2.file"%>
						</div>
					</div>
				</div>
				<!-- Table End -->

				<!-- Footer Start -->
				<div class="container-fluid pt-4 px-4">
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
			<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

			<!-- Template Javascript -->
			<script src="js/main.js"></script>
</body>

</html>