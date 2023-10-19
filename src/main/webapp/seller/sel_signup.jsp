<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.seller.service.*"%>
<%@ page import="com.tha103.artion.seller.model.*"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
SellerVO sellerVO = (SellerVO) request.getAttribute("sellerVO");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
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


<FORM METHOD="post" ACTION="seller.do" enctype="multipart/form-data"
			name="form1">
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
										name="sel_account"
										value="<%=(sellerVO == null) ? "123@gmail.com" : sellerVO.getSelAccount()%>"
										size="45">
								</div>
								<div class="row">
									<div class="mb-3">
										<label for="sellpassword" class="form-label">密碼
											(至少7個字元，須包含英文或數字)</label> <input type="text" class="form-control"
											id="sellName" name="sel_password"
											value="<%=(sellerVO == null) ? "12345678" : sellerVO.getSelPassword()%>"
											size="45" />
									</div>
								</div>
								<div class="mb-3">
									<label for="sellName" class="form-label">廠商名稱</label> <input
										type="text" class="form-control" id="sellName" name="sel_name"
										value="<%=(sellerVO == null) ? "王小明藝術中心" : sellerVO.getSelName()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellPhoneNumber" class="form-label">電話</label> <input
										type="text" class="form-control" id="sellPhoneNumber"
										name="sel_phone"
										value="<%=(sellerVO == null) ? "02-12345678" : sellerVO.getSelPhone()%>"
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
										class="form-control" id="sellAddress" name="sel_address"
										value="<%=(sellerVO == null) ? "新北市汐止區忠孝東路222號" : sellerVO.getSelAddress()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">官方網址</label> <input
										type="text" class="form-control" id="sellAddress"
										name="sel_url"
										value="<%=(sellerVO == null) ? "www.artion.com.tw" : sellerVO.getSelUrl()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">Facebook</label> <input
										type="text" class="form-control" id="sellAddress"
										name="sel_facebook"
										value="<%=(sellerVO == null) ? "www.facebook/artion.com" : sellerVO.getSelFacebook()%>"
										size="45" />
								</div>
								<div class="mb-3">
									<label for="sellAddress" class="form-label">單位連絡人</label> <input
										type="text" class="form-control" id="sellAddress"
										name="sel_contactPerson"
										value="<%=(sellerVO == null) ? "王小明" : sellerVO.getSelContactPerson()%>"
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
										<textarea class="form-control" id="sellIntroduction"
											name="sel_introduction"
											value="<%=(sellerVO == null) ? "yoyoyo" : sellerVO.getSelIntroduction()%>"
											size="45"
											style="width: 100%; max-width: 910px; min-height: 200px; box-sizing: border-box;"></textarea>
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
													name="sel_bankCode"
													value="<%=(sellerVO == null) ? "001" : sellerVO.getSelBankCode()%>"
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
												name="sel_bankNumber"
												value="<%=(sellerVO == null) ? "123456789" : sellerVO.getSelBankNumber()%>"
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
													name="sel_bankName"
													value="<%=(sellerVO == null) ? "王小名" : sellerVO.getSelBankName()%>"
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
												name="sel_remark"
												value="<%=(sellerVO == null) ? "請準時匯款" : sellerVO.getSelRemark()%>"
												size="45" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- 分隔線 -->
						<div class="col-sm-12 col-xl-12 mt-4"></div>

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
														name="sel_title"
														value="<%=(sellerVO == null) ? "活動企劃部" : sellerVO.getSelTitle()%>"
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
													name="sel_principal"
													value="<%=(sellerVO == null) ? "王小名" : sellerVO.getSelPrincipal()%>"
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
														name="sel_uniformNumbers"
														value="<%=(sellerVO == null) ? "12345678" : sellerVO.getSelUniformNumbers()%>"
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
													id="registeredAddress" name="sel_registeredAddress"
													value="<%=(sellerVO == null) ? "新北市汐止區忠孝東路888號" : sellerVO.getSelRegisteredAddress()%>"
													size="45" />
											</div>
										</div>
									</div>
								</div>

								<div class="text-center" style="margin-top: 30px;">
									<!-- 文本置中並設定上邊距 -->
									<!--                             <button type="button" class="btn btn-outline-secondary m-2">修改</button> -->
									<!--                             <button type="button" class="btn btn-outline-secondary m-2">儲存</button> -->
									<input type="hidden" name="action" value="insert"> <input type="submit" value="送出">
			</table>
			</FORM>
	</div>

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