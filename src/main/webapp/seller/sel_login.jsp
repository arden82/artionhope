<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
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
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<style>
.logo-img {
	width: 150px; /* 调整 logo 宽度 */
	height: auto;
	margin: 0 auto; /* 设置 logo 居中 */
}
</style>
<body>
	<div class="error-message">
		<c:if test="${not empty requestScope.error}">
			<p class="text-danger">${requestScope.error}</p>
		</c:if>
	</div>

	<form action="<%=request.getContextPath()%>/seller/LoginHandler.do"
		method="post">
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
			<div class="error-message">
				<c:if test="${not empty requestScope.error}">
					<p class="text-danger">${requestScope.error}</p>
				</c:if>
			</div>

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
								<h3>嗨！歡迎來到Artion後台管理系統</h3>
							</div>
							<div class="form-floating mb-3">
								<input type="text" name="selAccount" class="form-control"
									id="floatingInput"> <label for="floatingInput">帳號
									Account</label>
							</div>
							<div class="form-floating mb-4">
								<input type="password" name="selPassword" class="form-control"
									id="floatingPassword"> <label for="floatingPassword">密碼
									Password</label>
							</div>
							<div
								class="d-flex align-items-center justify-content-between mb-4">
								<div class="form-check">
									<input type="checkbox" class="form-check-input"
										id="rememberMyPassword"> <label
										class="form-check-label" for="rememberMyPassword">記住我的帳號</label>
								</div>
								<a href="sel_forget_password.html">忘記密碼</a>
							</div>
							<!--                         <input -->
							<!--                             type="hidden" name="action" value="getOne_For_Update"> -->
							<button type="submit" class="btn btn-primary py-3 w-100 mb-4">登入</button>
							<input type="hidden" name="action" value="getOne_For_Update"></input>

							<p class="text-center mb-0">
								立即申請線上註冊 <a href="sel_signup.jsp">註冊</a>
							</p>
	</form>
	</div>
	</div>
	</div>
	</div>
	<!-- Sign In End -->
	</div>

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