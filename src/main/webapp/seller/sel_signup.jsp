<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.seller.model.*"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
SellerVO sellerVO = (SellerVO) request.getAttribute("sellerVO");
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

<style>
.custom-form-container {
	max-width: 800px;
	/* 调整这个值以改变表单的宽度 */
	margin: 0 auto;
	/* 水平居中 */
}
</style>
</head>

<body>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
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


	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/seller/SellerServlet.do"
		enctype="multipart/form-data" name="form1">

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

			<!-- Form Start -->
			<table>
				<div class="container-fluid pt-4 px-4">
					<div class="row g-4 justify-content-center">
						<!-- 左侧卡片区块，占据6列，即半屏宽度 -->
						<div class="col-sm-6 col-xl-4 ml-auto">
							<div class="bg-light rounded h-100 p-4">
								<h6 class="mb-4" style="font-size: 24px; color: #009CFF">廠商註冊</h6>
								<div class="mb-3">
									<label for="sellEmail" class="form-label">Email (將以此
										E-mail為登入用)</label> <input type="email" class="form-control"
										name="selAccount"
										value="<%=(sellerVO == null) ? "" : sellerVO.getSelAccount()%>"
										size="45">
								</div>
								<div class="row">
									<div class="mb-3">
										<label for="sellpassword" class="form-label">密碼
											(至少7個字元，須包含英文或數字)</label> <input type="text" class="form-control"
											id="sellName" name="selPassword"
											value="<%=(sellerVO == null) ? "" : sellerVO.getSelPassword()%>"
											size="45" />
									</div>
								</div>
								<div class="mb-3">
									<label for="sellName" class="form-label">廠商名稱</label> <input
										type="text" class="form-control" id="sellName" name="selName"
										value="<%=(sellerVO == null) ? "" : sellerVO.getSelName()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellPhoneNumber" class="form-label">電話</label> <input
										type="text" class="form-control" id="sellPhoneNumber"
										name="selPhone"
										value="<%=(sellerVO == null) ? "" : sellerVO.getSelPhone()%>"
										size="45" />
								</div>
							</div>
						</div>

						<!-- 右侧卡片区块，占据6列，即半屏宽度 -->

						<div class="col-sm-6 col-xl-4 mr-auto">
							<div class="bg-light rounded h-100 p-4">
								<div class="mb-3">
									<label for="sellAddress" class="form-label"
										style="margin-top: 55px;">廠商地址</label> <input type="text"
										class="form-control" id="sellAddress" name="selAddress"
										value="<%=(sellerVO == null) ? "" : sellerVO.getSelAddress()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">官方網址</label> <input
										type="text" class="form-control" id="sellAddress"
										name="selUrl"
										value="<%=(sellerVO == null) ? "" : sellerVO.getSelUrl()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">Facebook</label> <input
										type="text" class="form-control" id="sellAddress"
										name="selFacebook"
										value="<%=(sellerVO == null) ? "" : sellerVO.getSelFacebook()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">單位連絡人</label> <input
										type="text" class="form-control" id="sellAddress"
										name="selContactPerson"
										value="<%=(sellerVO == null) ? "" : sellerVO.getSelContactPerson()%>"
										size="45" />
								</div>
							</div>
						</div>
					</div>

					<!-- 分隔線 -->
					<div class="col-sm-12 col-xl-12 mt-4"></div>

					<!-- 下方區塊 廠商簡介-->
					<div class="row g-4 justify-content-center">
						<div class="col-sm-8">
							<div class="bg-light rounded h-100 p-4">
								<div class="col">
									<div class="mb-3">
										<label for="sellIntroduction" class="form-label">廠商簡介</label>
										<input class="form-control" id="sellIntroduction"
											name="selIntroduction"
											value="<%=(sellerVO == null) ? "" : sellerVO.getSelIntroduction()%>"
											size="45"
											style="width: 100%; max-width: 910px; min-height: 200px; box-sizing: border-box;">
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- 分隔線 -->
					<div class="col-sm-12 col-xl-12 mt-2"></div>

					<!-- 下方區塊 帳務資訊-->

					<div class="container-fluid pt-4 px-4">
						<div class="custom-form-container bg-light rounded h-100 p-4">
							<div class="row">
								<div class="col">
									<div class="mb-2">
										<div class="form-group">
											<label for="bankCode" class="form-label">銀行代碼</label>
											<div class="d-flex">
												<input type="text" class="form-control" id="bankCode"
													name="selBankCode"
													value="<%=(sellerVO == null) ? "" : sellerVO.getSelBankCode()%>"
													size="45" />
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="mb-3">
										<label for="bankAccount" class="form-label">銀行帳號</label>
										<div class="d-flex">
											<input type="text" class="form-control" id="bankAccount"
												name="selBankNumber"
												value="<%=(sellerVO == null) ? "" : sellerVO.getSelBankNumber()%>"
												size="45" />
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
												<input type="text" class="form-control" id="accountNAme"
													name="selBankName"
													value="<%=(sellerVO == null) ? "" : sellerVO.getSelBankName()%>"
													size="45" />
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="mb-3">
										<label for="remark" class="form-label">備註</label>
										<div class="d-flex">
											<input type="text" class="form-control" id="remark"
												name="selRemark"
												value="<%=(sellerVO == null) ? "" : sellerVO.getSelRemark()%>"
												size="45" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- 分隔線 -->
						<div class="col-sm-12 col-xl-12 mt-2"></div>

						<!-- 下方區塊 單位資料-->
						<div class="container-fluid pt-4 px-4">
							<div class="custom-form-container bg-light rounded h-100 p-4">
								<div class="row">
									<div class="col">
										<div class="mb-2">
											<div class="form-group">
												<label for="departmentName" class="form-label">單位名稱</label>
												<div class="d-flex">
													<input type="text" class="form-control" id="departmentName"
														name="selTitle"
														value="<%=(sellerVO == null) ? "" : sellerVO.getSelTitle()%>"
														size="45" />
												</div>
											</div>
										</div>
									</div>
									<div class="col">
										<div class="mb-3">
											<label for="departmenBoss" class="form-label">單位負責人</label>
											<div class="d-flex">
												<input type="text" class="form-control" id="departmenBoss"
													name="selPrincipal"
													value="<%=(sellerVO == null) ? "" : sellerVO.getSelPrincipal()%>"
													size="45" />
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
													<input type="text" class="form-control" id="guiNumber"
														name="selUniformNumbers"
														value="<%=(sellerVO == null) ? "" : sellerVO.getSelUniformNumbers()%>"
														size="45" />
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
													value="<%=(sellerVO == null) ? "" : sellerVO.getSelRegisteredAddress()%>"
													size="45" />
											</div>
										</div>
									</div>
								</div>
								
								<!-- 圖片上傳 -->
									<div class="mb-3">
										<label for="formFile1" class="form-label">廠商頭像</label> <input
											class="form-control" type="file" name="selProfilePicture">
									</div>
								
								<div class="text-center" style="margin-top: 30px;">
									<input type="hidden" name="action" value="insert"> <input
										type="submit" value="送出" style="margin-bottom: 20px;">
								</div>
						</table>
					</FORM>

					
	<!-- Form End -->


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