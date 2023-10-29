<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String email = request.getParameter("email");
String generatedCode = request.getParameter("generatedCode");
if (email != null && generatedCode != null) {
	request.setAttribute("email", email);
	request.setAttribute("generatedCode", generatedCode);
	System.out.println(email);
	System.out.println(generatedCode);
}
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>DASHMIN - Bootstrap Admin Template</title>
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
</head>

<style>
.logo-img {
	width: 150px; /* 调整 logo 宽度 */
	height: auto;
	margin: 0 auto; /* 设置 logo 居中 */
}
</style>
<body>

	<c:if test="${not empty errorMsg}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsg}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<c:if test="${not empty successfulMsg}">
		<font style="color: red">你已成功修改密碼!</font>
		<ul>
			<c:forEach var="message" items="${successfulMsg}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<c:if test="${not empty sendMailMsg}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${sendMailMsg}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

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

		<!-- Sign In Start -->
		<div class="container-fluid">
			<div class="row h-100 align-items-center justify-content-center"
				style="min-height: 100vh;">
				<div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
					<div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
						<div class="d-grid gap-2 col-6 mx-auto mb-3">
							<a href="index.jsp" class="text-center"> <img
								src="./images/artion-logo.png" class="logo-img">
								<h3 class="text-primary"></h3>
							</a>
						</div>
						<div class="text-center" style="font-size: 26px;">
							<h3>忘記密碼?</h3>

							<div class="text" style="font-size: 16px;">
								<h6>請輸入Email信件中的驗證碼及新密碼</h6>
								<br>
							</div>

							<form
								action="<%=request.getContextPath()%>/seller/selResetPassword"
								method="post">
								<div class="form-floating mb-3">
									<input type="text" name="verificationCode" class="form-control"
										id="verificationCode"> <label for="floatingInput"
										style="font-size: 14px;">驗證碼</label>


								</div>

								<div class="form-floating mb-3">
									<input type="text" name="selPassword" class="form-control"
										id="selPassword"><label for="floatingInput" 
										style="font-size: 14px;">請輸入密碼</label>

								</div>

								<div class="form-floating mb-3">
									<input type="text" name="selPassword2" class="form-control"
										id="selPassword2"><label for="floatingInput" 
										style="font-size: 14px;">請再輸入一次密碼</label>

								</div>

								<input type="hidden" name="action" value="resetPassword">
								<input type="submit" value="送出">
							</Form>

						</div>
					</div>
				</div>
				<!-- Sign In End -->


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