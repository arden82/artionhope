<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.activity.model.*"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
ActivityVO activityVO = (ActivityVO) request.getAttribute("activityVO");
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

* {
	box-sizing: border-box;
}

/* 去除下拉選單的灰色背景 */
#county_box.form-control, #district_box.form-control {
	background-color: white !important;
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
					<img src="images/artion-logo.png">
				</a>

				<div class="navbar-nav w-100">
					<div class="nav-item">
						<a href="./sel_index.jsp" class="nav-item nav-link"><i
							class="fa-solid fa-users me-2"> </i></i>活動總覽</a> <a
							href="./sel_actadd.jsp" class="nav-item nav-link"><i
							class="fa-solid fa-heart-circle-plus me-2"> </i></i>新增活動</a> <a
							href="../seller/sel_order.jsp" class="nav-item nav-link"><i
							class="fa-solid fa-magnifying-glass me-2"> </i></i>訂單總覽</a> 
							
<!-- 							<a -->
<!-- 							href="sel_notification.jsp" class="nav-item nav-link"> <i -->
<!-- 							class="fa-solid fa-envelope me-2"> </i>通知訊息 -->
<!-- 						</a>  -->
						
						<a href="../seller/sel_profile.jsp" class="nav-item nav-link">
							<i class="fa-solid fa-address-card me-2"> </i>廠商基本資料
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
					<label for="userNameSide"></label>
					<h6 id="userNameSide" style="margin-top: 10px;">${sellerVO.selName}</h6>
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
						</form>

					</div>
				</div>
		</nav>
			<!-- Navbar End -->

			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>

			<!-- Form Start -->
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/activity/ActivityServlet.do"
				enctype="multipart/form-data" name="form1">
				<div class="container-fluid pt-4 px-4">
					<div class="row g-4">
						<div class="col-sm-12 col-xl-6">
							<div class="bg-light rounded h-100 p-4">
								<h6 class="mb-4" style="font-size: 24px; color: #009CFF">新增活動</h6>
								<div class="mb-3">
									<label for="actname" class="form-label">活動名稱</label> <input
										type="text" class="form-control" name="actName"
										value="<%=(activityVO == null) ? "" : activityVO.getActName()%>">
								</div>
								<div class="row">
									<div class="col">
										<div class="mb-2">
											<div class="form-group">
												<label for="actprice" class="form-label">票券定價</label>
												<div class="d-flex">
													<input type="number" class="form-control"
														name="actTicketPrice"
														value="<%=(activityVO == null) ? "" : activityVO.getActTicketPrice()%>">
												</div>

											</div>
										</div>
									</div>
									<div class="col">
										<div class="mb-3">
											<label for="ticketnumbers" class="form-label">票卷總數</label>
											<div class="d-flex">
												<input type="number" class="form-control"
													name="actTicketTotal"
													value="<%=(activityVO == null) ? "" : activityVO.getActTicketTotal()%>">
											</div>
										</div>
									</div>

									<div class="col">
										<div class="mb-3">
											<label for="acttype" class="form-label">活動類型</label> <select
												name="actType" class="acttype form-select">
												<option value="0">全部</option>
												<option value="1">市集</option>
												<option value="2">展覽</option>
												<option value="3">表演</option>
											</select>
										</div>
									</div>

									<div class="row">
										<div class="col">
											<div class="mb-2">
												<div class="form-group">
													<label for="ticketstartdate" class="form-label">票券開賣日期</label>
													<div class="d-flex">
														<input type="date" class="form-control"
															name=actTicketStartTime
															value="<%=(activityVO == null) ? "" : activityVO.getActTicketStartTime()%>">
													</div>
												</div>
											</div>
										</div>
										<div class="col">
											<div class="mb-2">
												<div class="form-group"></div>
												<label for="ticketenddate" class="form-label">票券結束日期</label>
												<div class="d-flex">
													<input type="date" class="form-control"
														name="actTicketEndTime"
														value="<%=(activityVO == null) ? "" : activityVO.getActTicketEndTime()%>">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="mb-2">
												<div class="form-group">
													<label for="actstartdate" class="form-label">活動開始日期</label>
													<div class="d-flex">
														<input type="date" class="form-control"
															name="actStartDate"
															value="<%=(activityVO == null) ? "" : activityVO.getActStartDate()%>">
													</div>
												</div>
											</div>
										</div>
										<div class="col">
											<div class="mb-2">
												<div class="form-group"></div>
												<label for="actenddate" class="form-label">活動結束日期</label>
												<div class="d-flex">
													<input type="date" class="form-control" name="actEndDate"
														value="<%=(activityVO == null) ? "" : activityVO.getActEndDate()%>">

												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="mb-2">
												<div class="form-group">
													<label for="actstarttime" class="form-label">活動開始時間</label>
													<div class="d-flex">
														<input type="time" class="form-control"
															name="actStartTime" id="actStartTimeInput"
															value="<%=(activityVO == null) ? "" : activityVO.getActStartTime()%>">
													</div>
												</div>
											</div>
										</div>
										<div class="col">
											<div class="mb-2">
												<div class="form-group"></div>
												<label for="actendtime" class="form-label">活動結束時間</label>
												<div class="d-flex">
													<input type="time" class="form-control" name="actEndTime"
														id="actEndTimeInput"
														value="<%=(activityVO == null) ? "" : activityVO.getActEndTime()%>">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="mb-2">
												<div class="form-group">
													<label for="act_city" class="form-label">活動縣市</label>
													<div class="d-flex">
														<input type="text" class="form-control" name=actCity
															value="<%=(activityVO == null) ? "" : activityVO.getActCity()%>">
													</div>
												</div>
											</div>
										</div>
										<div class="col">
											<div class="mb-2">
												<div class="form-group"></div>
												<label for="act_zone" class="form-label">活動區域</label>
												<div class="d-flex">
													<input type="text" class="form-control" name="actZone"
														value="<%=(activityVO == null) ? "" : activityVO.getActZone()%>">
												</div>
											</div>
										</div>
									</div>

									<div class="mb-3">
										<label for="actaddress" class="form-label">活動地址</label> <input
											type="text" class="form-control" name="actAddress"
											value="<%=(activityVO == null) ? "" : activityVO.getActAddress()%>">
									</div>
									<div class="mb-3">
										<label for="acthost" class="form-label">主辦單位</label> <input
											type="text" class="form-control" name="actOrganization"
											value="<%=(activityVO == null) ? "" : activityVO.getActOrganization()%>">
											
									</div>
									<div class="mb-3">
										<label for="exampleInputEmail1" class="form-label">Email信箱</label>
										<input type="email" class="form-control" name="actEmail"
											value="<%=(activityVO == null) ? "" : activityVO.getActEmail()%>">
									</div>
									<div class="mb-3">
										<label for="acrphonenumber" class="form-label">連絡電話</label> <input
											type="tel" class="form-control" name="actPhone"
											value="<%=(activityVO == null) ? "" : activityVO.getActPhone()%>">
									</div>

								</div>
							</div>
						</div>

						<!-- 第二個區塊（與第一個區塊結構相同） -->
						<div class="col-sm-12 col-xl-6">
							<div class="bg-light rounded h-100 p-4">
								<div class="col">
									<div class="mb-3">
										<label for="actcontent" class="form-label">活動內容</label> <input
											type="text" class="form-control" name="actContent"
											style="width: 400px; height: 300px; vertical-align: top; padding: 0"
											value="<%=(activityVO == null) ? "" : activityVO.getActContent()%>">
									</div>

									<!-- 圖片上傳 -->
									<div class="mb-3">
										<label for="formFile1" class="form-label">活動封面</label> <input
											class="form-control" type="file" name="actCoverPicture">
									</div>
										<!--第一個預覽圖-->

<!-- 									<div class="mb-3"> -->
<!-- 										<label for="formFile2" class="form-label">活動圖片1</label> <input -->
<!-- 											class="form-control" type="file" name="actPicture1" -->
<!-- 											onchange="previewFile(2)"> -->
<!-- 									</div> -->
<!-- 									<div id="imagePreview2"> -->
<!-- 										预览图将显示在这里 -->
<!-- 									</div> -->

<!-- 									<div class="mb-3"> -->
<!-- 										<label for="formFile3" class="form-label">活動圖片2</label> <input -->
<!-- 											class="form-control" type="file" name="actPicture2" -->
<!-- 											onchange="previewFile(3)"> -->
<!-- 									</div> -->
<!-- 									<div id="imagePreview3"> -->
<!-- 										预览图将显示在这里 -->
<!-- 									</div> -->

<!-- 									<div class="mb-3"> -->
<!-- 										<label for="formFile4" class="form-label">活動圖片3</label> <input -->
<!-- 											class="form-control" type="file" name="actPicture3" -->
<!-- 											onchange="previewFile(4)"> -->
<!-- 									</div> -->
<!-- 									<div id="imagePreview4"> -->
										<!-- 预览图将显示在这里 -->
									</div>
									<!-- 添加更多文件上传输入框和预览图按照相同的结构 -->

									<input type="hidden" name="action" value="insert"
										class="btn btn-outline-secondary m-2"> <input
										type="submit" value="送出" class="btn btn-outline-secondary m-2">
			</form>
		</div>
	</div>
	</div>



	<!-- Instant Customer Support Icon -->
	<div id="customer-support-icon" class="icon">
		<i class="fa-brands fa-rocketchat fa-2x"></i>
	</div>

	<!-- Form End -->

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



 	<script> 
 		document.getElementById("actStartTimeInput").addEventListener("input", function () {
    		 // Add seconds ":00" to match the HH:mm:ss format
     		var inputTime = this.value;
    		 if (inputTime) {
        		this.value = inputTime + ":00";
     		}
 		});
		
		document.getElementById("actEndTimeInput").addEventListener("input", function () {
 	   		 // Add seconds ":00" to match the HH:mm:ss format
 	    		var inputTime = this.value;
 	   		 if (inputTime) {
 	        		this.value = inputTime + ":00";
	    		}
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
</head>
<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>

</html>