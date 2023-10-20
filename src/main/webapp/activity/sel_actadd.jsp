<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity.model.*"%>



<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
ActivityVO activityVO = (ActivityVO) request.getAttribute("activityVO");
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
				<a href="sel_index.html" class="navbar-brand mx-4 mb-3 artionimg">
					<!-- <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>Artion</h3> -->
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
								href="sel_signin.html" class="dropdown-item">Log Out</a>
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
			<FORM METHOD="post" ACTION="activity.do"
				enctype="multipart/form-data" name="form1">
				<div class="container-fluid pt-4 px-4">
					<div class="row g-4">
						<div class="col-sm-12 col-xl-6">
							<div class="bg-light rounded h-100 p-4">
								<h6 class="mb-4" style="font-size: 24px; color: #009CFF">新增活動</h6>
								<div class="mb-3">
									<label for="actname" class="form-label">活動名稱</label> <input
										type="text" class="form-control" name="act_name"
										value="<%=(activityVO == null) ? "清涼一下天母啤酒節" : activityVO.getAct_name()%>">
								</div>
								<div class="row">
									<div class="col">
										<div class="mb-2">
											<div class="form-group">
												<label for="actprice" class="form-label">票券定價</label>
												<div class="d-flex">
													<input type="number" class="form-control"
														name="act_ticketPrice"
														value="<%=(activityVO == null) ? "100" : activityVO.getAct_ticketPrice()%>">
												</div>

											</div>
										</div>
									</div>
									<div class="col">
										<div class="mb-3">
											<label for="ticketnumbers" class="form-label">票卷總數</label>
											<div class="d-flex">
												<input type="number" class="form-control"
													name="act_ticketTotal"
													value="<%=(activityVO == null) ? "200" : activityVO.getAct_ticketTotal()%>">
											</div>
										</div>
									</div>

									<div class="col">
										<div class="mb-3">
											<label for="acttype" class="form-label">活動類型</label> <select
												name="act_type" class="acttype form-select">
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
															name=act_ticketStartTime
															value="<%=(activityVO == null) ? "" : activityVO.getAct_ticketStartTime()%>">
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
														name="act_ticketEndTime"
														value="<%=(activityVO == null) ? "" : activityVO.getAct_ticketEndTime()%>">
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
															name="act_startDate"
															value="<%=(activityVO == null) ? "" : activityVO.getAct_startDate()%>">
													</div>
												</div>
											</div>
										</div>
										<div class="col">
											<div class="mb-2">
												<div class="form-group"></div>
												<label for="actenddate" class="form-label">活動結束日期</label>
												<div class="d-flex">
													<input type="date" class="form-control" name="act_endDate"
														value="<%=(activityVO == null) ? "" : activityVO.getAct_endDate()%>">

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
															name="act_startTime" id="actStartTimeInput"
															value="<%=(activityVO == null) ? "" : activityVO.getAct_startTime()%>">
													</div>
												</div>
											</div>
										</div>
										<div class="col">
											<div class="mb-2">
												<div class="form-group"></div>
												<label for="actendtime" class="form-label">活動結束時間</label>
												<div class="d-flex">
													<input type="time" class="form-control" name="act_endTime"
														id="actEndTimeInput"
														value="<%=(activityVO == null) ? "" : activityVO.getAct_endTime()%>">
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
														<input type="text" class="form-control" name=act_city
															value="<%=(activityVO == null) ? "台北市" : activityVO.getAct_city()%>">
													</div>
												</div>
											</div>
										</div>
										<div class="col">
											<div class="mb-2">
												<div class="form-group"></div>
												<label for="act_zone" class="form-label">活動區域</label>
												<div class="d-flex">
													<input type="text" class="form-control" name="act_zone"
														value="<%=(activityVO == null) ? "大安區" : activityVO.getAct_zone()%>">
												</div>
											</div>
										</div>
									</div>


									<!-- 		<div class="row"> -->
									<!--                                 <div class="col"> -->
									<!--                                     <div class="mb-2"> -->
									<!--                                         <div class="form-group"> -->
									<!--                                             <label for="actcity" class="form-label">活動縣市</label> -->
									<!--                                             <div class="d-flex"> -->
									<!--                                                 <select name="county" id="county_box" class="form-control"> -->
									<!--                                                     <option value="">選擇縣市</option> -->
									<!--                                                 </select> -->
									<!--                                             </div> -->
									<!--                                         </div> -->
									<!--                                     </div> -->
									<!--                                 </div> -->

									<!--                                 <div class="col"> -->
									<!--                                     <div class="mb-2"> -->
									<!--                                         <div class="form-group"></div> -->
									<!--                                         <label for="actarea" class="form-label">活動區域</label> -->
									<!--                                         <div class="d-flex"> -->
									<!--                                             <select name="district" id="district_box" class="form-control"> -->
									<!--                                                 <option value="">選擇鄉鎮市區</option> -->
									<!--                                             </select> -->
									<!--                                         </div> -->
									<!--                                     </div> -->
									<!--                                 </div> -->
									<!--                             </div> -->
									<div class="mb-3">
										<label for="actaddress" class="form-label">活動地址</label> <input
											type="text" class="form-control" name="act_address"
											value="<%=(activityVO == null) ? "台北市大安區仁愛路300號" : activityVO.getAct_address()%>">
									</div>
									<div class="mb-3">
										<label for="acthost" class="form-label">主辦單位</label> <input
											type="text" class="form-control" name="act_organization"
											value="<%=(activityVO == null) ? "橘子工坊" : activityVO.getAct_organization()%>">
									</div>
									<div class="mb-3">
										<label for="exampleInputEmail1" class="form-label">Email信箱</label>
										<input type="email" class="form-control" name="act_email"
											value="<%=(activityVO == null) ? "orange@yahoo.com.tw" : activityVO.getAct_email()%>">
									</div>
									<div class="mb-3">
										<label for="acrphonenumber" class="form-label">連絡電話</label> <input
											type="tel" class="form-control" name="act_phone"
											value="<%=(activityVO == null) ? "0975727514" : activityVO.getAct_phone()%>">
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
											type="text" class="form-control" name="act_content"
											style="width: 400px; height: 300px; vertical-align: top; padding: 0"
											value="<%=(activityVO == null) ? "夏日最好玩的活動，天母啤酒節來了!" : activityVO.getAct_content()%>">
									</div>

									<!-- 圖片上傳 -->
									<div class="mb-3">
										<label for="formFile1" class="form-label">活動封面</label> <input
											class="form-control" type="file" name="act_coverPicture"
											onchange="previewFile(1)">
									</div>
									<div id="imagePreview1">
										<!--第一個預覽圖-->
									</div>

									<div class="mb-3">
										<label for="formFile2" class="form-label">活動圖片1</label> <input
											class="form-control" type="file" name="act_picture1"
											onchange="previewFile(2)">
									</div>
									<div id="imagePreview2">
										<!-- 预览图将显示在这里 -->
									</div>

									<div class="mb-3">
										<label for="formFile3" class="form-label">活動圖片2</label> <input
											class="form-control" type="file" name="act_picture2"
											onchange="previewFile(3)">
									</div>
									<div id="imagePreview3">
										<!-- 预览图将显示在这里 -->
									</div>

									<div class="mb-3">
										<label for="formFile4" class="form-label">活動圖片3</label> <input
											class="form-control" type="file" name="act_picture3"
											onchange="previewFile(4)">
									</div>
									<div id="imagePreview4">
										<!-- 预览图将显示在这里 -->
									</div>
									<!-- 添加更多文件上传输入框和预览图按照相同的结构 -->


									<!-- 									<button type="button" class="btn btn-outline-secondary m-2" -->
									<!-- 										id="modifyButton">修改</button> -->
									<!-- 									<button type="button" class="btn btn-outline-secondary m-2" -->
									<!-- 										id="saveButton">儲存</button> -->
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
	<script>

                //圖片預覽功能
                function previewFile(fileNumber) {
                    const fileInput = document.querySelector(`#formFile${fileNumber}`);
                    const imagePreview = document.getElementById(`imagePreview${fileNumber}`);

                    // 确保选择了文件
                    if (fileInput.files && fileInput.files[0]) {
                        const reader = new FileReader();

                        reader.onload = function (e) {
                            // 创建一个 img 元素来显示预览图
                            const img = document.createElement('img');
                            img.src = e.target.result;
                            img.classList.add('img-thumbnail'); // 可以添加样式类
                            img.style.maxWidth = '100px'; // 设置预览图的最大宽度

                            // 清除之前的预览图（如果有）
                            imagePreview.innerHTML = '';

                            // 将预览图添加到页面
                            imagePreview.appendChild(img);
                        };

                        // 读取文件内容并触发onload事件
                        reader.readAsDataURL(fileInput.files[0]);
                    }
                }
            </script>
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
                // 函数在文件选择时触发
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
	<script>
            document.getElementById('modifyButton').addEventListener('click', function() {
                // 获取页面上需要编辑的元素
                var editableElements = document.querySelectorAll('.editable');

                // 启用编辑模式
                for (var i = 0; i < editableElements.length; i++) {
                    var element = editableElements[i];
                    element.contentEditable = 'true'; // 将元素设置为可编辑
                    element.classList.add('editable-active'); // 添加一个可编辑的类，以更改样式
                }
            });

            document.getElementById('saveButton').addEventListener('click', function() {
                // 在此添加代码以保存用户的更改
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