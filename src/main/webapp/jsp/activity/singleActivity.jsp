<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>singleActivity</title>

<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous"> -->
<!-- hao -->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link href="src/main/webapp/css/activity/singleActivity.css" rel="stylesheet" />
<link href="src/main/webapp/css/activity/singleActivityCover.css" rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="src/main/webapp/css/activity/member.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> -->
    <!-- Core theme JS-->
    <!-- <script src="js/scripts.js"></script> -->
    <!-- icon import -->
    <script src="https://kit.fontawesome.com/53f3396f69.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="src/main/webapp/js/activity/singleActivity.js">
</head>
<body>
	<!-- 整個頁面容器開始 -->
	<div class="container-fluid p-0">
		<!-- navbar top (sign_up)start -->
		<!--  navbar_mob_state 開始-->
		<nav
			class="navbar_mob navbar navbar-expand-lg navbar-light bg-light  sticky-top navbar_mob_state ">
			<div class="container-fluid  relative d-flex justify-content-end">
				<a class="navbar-brand mx-auto fixed_center logo" href="#">Artion</a>


				<div class="shoppingCart p-2 member_svg">
					<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
						class="bi bi-cart3" viewBox="0 0 16 16">
                        <path
							d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                    </svg>
				</div>

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse " id="navbarSupportedContent">
					<form class="my-2 navbar_mob">
						<input class="form-control me-2" type="search" placeholder=""
							aria-label="Search">
						<button class="colortest btn_old  w-50 me-2" type="submit">搜尋</button>
					</form>
					<a class="nav-link display_none_6 " href="./member_logUp.html">
						<button type="button" class="colortest btn_old ">登入/註冊</button>
					</a>
					<ul class="navbar-nav col-12 me-2   ">

						<li class="nav-item dropdown  "><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								活動類型 </a>
							<ul class="dropdown-menu text_align_center"
								aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item hover" href="#">全部</a></li>
								<li><a class="dropdown-item hover" href="#">展覽</a></li>
								<li><a class="dropdown-item hover" href="#">市集</a></li>
								<li><a class="dropdown-item hover" href="#">表演</a></li>
							</ul></li>
						<li class="nav-item "><a
							class="nav-link triangle hover member_svg" href="#"
							id="navbarDropdown" role="button" aria-expanded="false"> <svg
									xmlns="http://www.w3.org/2000/svg" width="30" height="30"
									viewBox="0 0 20 20">
                                    <path
										d="M16.219 1.943c.653.512 1.103 1.339 1.287 2.205a.474.474 0 0 1 .065.026l2.045.946a.659.659 0 0 1 .384.597v12.367a.665.665 0 0 1-.85.634l-5.669-1.6l-6.74 1.858a.674.674 0 0 1-.371-.004L.474 17.217a.66.66 0 0 1-.474-.63V3.998c0-.44.428-.756.855-.632l5.702 1.661l2.898-.887a.734.734 0 0 1 .122-.025c.112-.656.425-1.286.95-1.9c.623-.73 1.716-1.158 2.781-1.209c1.105-.053 1.949.183 2.91.936ZM1.333 4.881v11.215l4.87 1.449V6.298l-4.87-1.417Zm8.209.614l-2.006.613v11.279l5.065-1.394v-3.295c0-.36
                        4.299-.659.667-.659c.368 0 .666.295.666.66v3.177l4.733 1.335V6.136l-1.12-.52c-.019.11-.043.218-.073.323A6.134 6.134 0 0 1 16.4 8.05l-2.477 3.093a.67.67 0 0 1-1.073-.037l-2.315-3.353c-.382-.534-.65-1.01-.801-1.436a3.744 3.744 0 0 1-.192-.822Zm3.83-3.171c-.726.035-1.472.327-1.827.742c-.427.5-.637.968-.679 1.442c-.05.571-.016.974.126 1.373c.105.295.314.669.637 1.12l1.811 2.622l1.91-2.385a4.812 4.812 0 0 0 .841-1.657c.24-.84-.122-2.074-.8-2.604c-.695-.545-1.22-.692-2.018-.653Zm.138.697c1.104 0 2 .885 2 1.977a1.988 1.988 0 0 1-2 1.977c-1.104 0-2-.885-2-1.977s.896-1.977 2-1.977Zm0 1.318a.663.663 0 0 0-.667.659c0 .364.299.659.667.659a.663.663 0 0 0 .666-.66a.663.663 0 0 0-.666-.658Z" />
                                </svg> 地圖
						</a></li>


					</ul>

				</div>
			</div>
		</nav>
		<!--  navbar_mob_state 結束-->

		<!--   navbar_sm_state 開始-->
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light  sticky-top navbar_sm_state p-0">
			<div class="container-fluid ">
				<a class="navbar-brand mx-5 logo " href="#">Artion</a>

				<div class="shoppingCart member_svg p-2 margin_auto display_none_6">
					<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
						class="bi bi-cart3" viewBox="0 0 16 16">
                        <path
							d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                    </svg>
				</div>
				<a class="nav-link display_none_6  mx-3" href="./member_logUp.html">
					<button type="button" class="colortest btn_old   ">登入/註冊</button>
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse  d-flex-sm justify-content-end"
					id="navbarSupportedContent">
					<ul class="navbar-nav col-1-sm me-2  mb-lg-0 ">
						<li class="nav-item dropdown   "><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								活動類型 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item hover" href="#">全部</a></li>
								<li><a class="dropdown-item hover" href="#">展覽</a></li>
								<li><a class="dropdown-item hover" href="#">市集</a></li>
								<li><a class="dropdown-item hover" href="#">表演</a></li>
							</ul></li>

					</ul>
					<form class="d-flex my-2 ">
						<input class="form-control me-2" type="search" placeholder=""
							aria-label="Search">
						<button class="colortest btn_old  w-50 me-2" type="submit">搜尋</button>
					</form>
					<div class="shoppingCart member_svg p-2 display_none_7">
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
							class="bi bi-cart3" viewBox="0 0 16 16">
                            <path
								d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                        </svg>
					</div>

					<div class="map p-2 member_svg display_none_7">
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
							viewBox="0 0 20 20">
                            <path
								d="M16.219 1.943c.653.512 1.103 1.339 1.287 2.205a.474.474 0 0 1 .065.026l2.045.946a.659.659 0 0 1 .384.597v12.367a.665.665 0 0 1-.85.634l-5.669-1.6l-6.74 1.858a.674.674 0 0 1-.371-.004L.474 17.217a.66.66 0 0 1-.474-.63V3.998c0-.44.428-.756.855-.632l5.702 1.661l2.898-.887a.734.734 0 0 1 .122-.025c.112-.656.425-1.286.95-1.9c.623-.73 1.716-1.158 2.781-1.209c1.105-.053 1.949.183 2.91.936ZM1.333 4.881v11.215l4.87 1.449V6.298l-4.87-1.417Zm8.209.614l-2.006.613v11.279l5.065-1.394v-3.295c0-.36
                            4.299-.659.667-.659c.368 0 .666.295.666.66v3.177l4.733 1.335V6.136l-1.12-.52c-.019.11-.043.218-.073.323A6.134 6.134 0 0 1 16.4 8.05l-2.477 3.093a.67.67 0 0 1-1.073-.037l-2.315-3.353c-.382-.534-.65-1.01-.801-1.436a3.744 3.744 0 0 1-.192-.822Zm3.83-3.171c-.726.035-1.472.327-1.827.742c-.427.5-.637.968-.679 1.442c-.05.571-.016.974.126 1.373c.105.295.314.669.637 1.12l1.811 2.622l1.91-2.385a4.812 4.812 0 0 0 .841-1.657c.24-.84-.122-2.074-.8-2.604c-.695-.545-1.22-.692-2.018-.653Zm.138.697c1.104 0 2 .885 2 1.977a1.988 1.988 0 0 1-2 1.977c-1.104 0-2-.885-2-1.977s.896-1.977 2-1.977Zm0 1.318a.663.663 0 0 0-.667.659c0 .364.299.659.667.659a.663.663 0 0 0 .666-.66a.663.663 0 0 0-.666-.658Z" />
                        </svg>
					</div>


					<a class="nav-link display_none_7" href="./member_logUp.html">
						<button type="button" class="colortest btn_old  mx-4 ">登入/註冊</button>
					</a>
				</div>
			</div>
		</nav>

		<!--   navbar_sm_state 結束-->
		<!-- navbar top (sign_up)end -->
		<div class="container-fluid">
			<!--除了navbar 以外的東西放裡面 -->
			<!-- Page content-->
			<div class="container mt-5">
				<div class="row">
					<div class="col-lg-8">
						<!-- Post content-->
						<article>
							<!-- Post header-->
							<!-- Preview image figure-->
							<figure class="mb-4">
								<div>
									<img src="../img/精彩台灣.png" alt="" width="100%" height="100%">
								</div>
							</figure>

							<header class="mb-4">
								<!-- Post title-->
								<!-- Post categories-->
								<a class="badge bg-secondary text-decoration-none link-light"
									href="#">市集</a> <br>
								<div class="header_container">
									<h1 class="fw-bolder mb-1 activity_name">精彩台灣!城鄉厚禮</h1>
									<div id="iconCollect">
										<!-- collection1_icon -->
										<button id="collection1_icon" class="icon_style">
											<svg xmlns="http://www.w3.org/2000/svg" height="1.5em"
												viewBox="0 0 512 512">
                                                <path
													d="M225.8 468.2l-2.5-2.3L48.1 303.2C17.4 274.7 0 234.7 0 192.8v-3.3c0-70.4 50-130.8 119.2-144C158.6 37.9 198.9 47 231 69.6c9 6.4 17.4 13.8 25 22.3c4.2-4.8 8.7-9.2 13.5-13.3c3.7-3.2 7.5-6.2 11.5-9c0 0 0 0 0 0C313.1 47 353.4 37.9 392.8 45.4C462 58.6 512 119.1 512 189.5v3.3c0 41.9-17.4 81.9-48.1 110.4L288.7 465.9l-2.5 2.3c-8.2 7.6-19 11.9-30.2 11.9s-22-4.2-30.2-11.9zM239.1 145c-.4-.3-.7-.7-1-1.1l-17.8-20c0 0-.1-.1-.1-.1c0 0 0 0 0 0c-23.1-25.9-58-37.7-92-31.2C81.6 101.5 48 142.1 48 189.5v3.3c0 28.5 11.9 55.8 32.8 75.2L256 430.7 431.2 268c20.9-19.4 32.8-46.7 32.8-75.2v-3.3c0-47.3-33.6-88-80.1-96.9c-34-6.5-69 5.4-92 31.2c0 0 0 0-.1 .1s0 0-.1 .1l-17.8 20c-.3 .4-.7 .7-1 1.1c-4.5 4.5-10.6 7-16.9 7s-12.4-2.5-16.9-7z" />
                                            </svg>
										</button>
										<span class="CollectIcon1_hover">收藏活動</span>
										<!-- collection2_icon -->
										<button id="collection2_icon" class="icon_style"
											style="display: none;">
											<svg xmlns="http://www.w3.org/2000/svg" height="1.5em"
												viewBox="0 0 512 512">
                                                <path
													d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z" />
                                            </svg>
										</button>
										<span class="CollectIcon2_hover">取消收藏</span>
									</div>

									<div id="iconContainer">
										<!-- thumb-up1_icon -->
										<button id="actLike1_icon" class="icon_style actLike1_Icon">
											<svg xmlns="http://www.w3.org/2000/svg" height="1.5em"
												viewBox="0 0 512 512">
                                                <style>svg {fill: #e36868}</style>
                                                <path
													d="M323.8 34.8c-38.2-10.9-78.1 11.2-89 49.4l-5.7 20c-3.7 13-10.4 25-19.5 35l-51.3 56.4c-8.9 9.8-8.2 25 1.6 33.9s25 8.2 33.9-1.6l51.3-56.4c14.1-15.5 24.4-34 30.1-54.1l5.7-20c3.6-12.7 16.9-20.1 29.7-16.5s20.1 16.9 16.5 29.7l-5.7 20c-5.7 19.9-14.7 38.7-26.6 55.5c-5.2 7.3-5.8 16.9-1.7 24.9s12.3 13 21.3 13L448 224c8.8 0 16 7.2 16 16c0 6.8-4.3 12.7-10.4 15c-7.4 2.8-13 9-14.9 16.7s.1 15.8 5.3 21.7c2.5 2.8 4 6.5 4 10.6c0 7.8-5.6 14.3-13 15.7c-8.2 1.6-15.1 7.3-18 15.1s-1.6 16.7 3.6 23.3c2.1 2.7 3.4 6.1 3.4 9.9c0 6.7-4.2 12.6-10.2 14.9c-11.5 4.5-17.7 16.9-14.4 28.8c.4 1.3 .6 2.8 .6 4.3c0 8.8-7.2 16-16 16H286.5c-12.6 0-25-3.7-35.5-10.7l-61.7-41.1c-11-7.4-25.9-4.4-33.3 6.7s-4.4 25.9 6.7 33.3l61.7 41.1c18.4 12.3 40 18.8 62.1 18.8H384c34.7 0 62.9-27.6 64-62c14.6-11.7 24-29.7 24-50c0-4.5-.5-8.8-1.3-13c15.4-11.7 25.3-30.2 25.3-51c0-6.5-1-12.8-2.8-18.7C504.8 273.7 512 257.7 512 240c0-35.3-28.6-64-64-64l-92.3 0c4.7-10.4 8.7-21.2 11.8-32.2l5.7-20c10.9-38.2-11.2-78.1-49.4-89zM32 192c-17.7 0-32 14.3-32 32V448c0 17.7 14.3 32 32 32H96c17.7 0 32-14.3 32-32V224c0-17.7-14.3-32-32-32H32z" />
                                            </svg>
										</button>
										<span class="actLikeIcon1_hover">活動按讚</span>
										<button id="actLike2_icon" class="icon_style actLike2_Icon"
											style="display: none;">
											<svg xmlns="http://www.w3.org/2000/svg" height="1.5em"
												viewBox="0 0 512 512">
                                                <path
													d="M313.4 32.9c26 5.2 42.9 30.5 37.7 56.5l-2.3 11.4c-5.3 26.7-15.1 52.1-28.8 75.2H464c26.5 0 48 21.5 48 48c0 18.5-10.5 34.6-25.9 42.6C497 275.4 504 288.9 504 304c0 23.4-16.8 42.9-38.9 47.1c4.4 7.3 6.9 15.8 6.9 24.9c0 21.3-13.9 39.4-33.1 45.6c.7 3.3 1.1 6.8 1.1 10.4c0 26.5-21.5 48-48 48H294.5c-19 0-37.5-5.6-53.3-16.1l-38.5-25.7C176 420.4 160 390.4 160 358.3V320 272 247.1c0-29.2 13.3-56.7 36-75l7.4-5.9c26.5-21.2 44.6-51 51.2-84.2l2.3-11.4c5.2-26 30.5-42.9 56.5-37.7zM32 192H96c17.7 0 32 14.3 32 32V448c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32V224c0-17.7 14.3-32 32-32z" />
                                            </svg>
										</button>
										<span class="actLikeIcon2_hover">收回按讚</span>
										<!-- actLike-up2_icon -->
										<span id="iconCount" style="color: #e36868"></span>
									</div>
								</div>

								<!-- Post meta content-->
								<!-- <div class="card bg-light"></div> -->
								<div class="text-muted fst-italic mb-2">2023.09.01 (五)
									10:00 - 09.03 (日) 17:00 (GMT+8)</div>
								<div class="text-muted fst-italic mb-2">
									<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
										viewBox="0 0 16 16">
                                        <path fill="currentColor"
											d="M9.156 14.544C10.899 13.01 14 9.876 14 7A6 6 0 0 0 2 7c0 2.876 3.1 6.01 4.844 7.544a1.736 1.736 0 0 0 2.312 0ZM6 7a2 2 0 1 1 4 0a2 2 0 0 1-4 0Z" />
                                    </svg>
									台灣台北市中正區北平西路3號
								</div>
								<div class="text-muted fst-italic mb-2"
									style="display: inline-block; margin-right: 10px;">
									<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
										viewBox="0 0 100 100">
                                        <path fill="currentColor"
											d="M81.465 66.127c-.022-.038-.052-.069-.076-.105l.002-.001l-26.904-46.599l-.014.008a2.08 2.08 0 0 0-.929-.801l.038-.022l-11.01-6.357v.044a2.082 2.082 0 0 0-1.846-.107l-.012-.021l-.206.119c-.004.003-.009.003-.013.006c-.004.002-.007.006-.012.008L19.3 24.529a2.078 2.078 0 0 0-1.037 1.764l-.007-.004v12.714l.021-.012c-.047.427.03.872.261 1.273c.014.024.032.042.047.065l26.816 46.446c.026.055.044.112.075.166a2.085 2.085 0 0 0 2.772.801l.005.008l32.465-18.743l-.014-.025a2.092 2.092 0 0 0 .761-2.855zM36.366 29.361a3.865 3.865 0 1 1 1.415-5.279a3.864 3.864 0 0 1-1.415 5.279z" />
                                    </svg>
									100 元/人
								</div>
								<button type="button" class="btn btn-outline-danger"
									style="display: inline-block; margin-right: 10px;">立即購票</button>
								<button type="button" class="btn btn-outline-danger">加入購物車</button>
								<!-- <a class="badge bg-secondary text-decoration-none link-light" href="#!">Freebies</a> -->
							</header>
							<!-- Post content-->
							<section class="mb-5">
								<p class="fs-5 mb-4">
								<hr>
								這裡放動態活動內容。這裡放動態活動內容。這裡放動態活動內容。這裡放動態活動內容。這裡放動態活動內容。這裡放動態活動內容。這裡放動態活動內容。這裡放動態活動內容。這裡放動態活動內容。
								</p>
							</section>
						</article>
						<!-- Comments section-->
						<section class="mb-5">
							<div class="card bg-light">
								<div class="card-body" id="messageArea">
									<form class="was-validated">
										<div class="mb-3">
											<div
												style="display: flex; justify-content: space-between; align-items: center;">
												<label for="validationTextarea" class="form-label"
													style="font-size: 25px">留言板 </label>
												<div class="dropdown-center">
													<button class="btn btn-secondary dropdown-toggle"
														type="button" data-bs-toggle="dropdown"
														aria-expanded="false">排序方式</button>
													<ul class="dropdown-menu">
														<li><a class="dropdown-item" href="#">留言:由新至舊</a></li>
														<li><a class="dropdown-item" href="#">留言:由舊至新</a></li>
														<li><a class="dropdown-item" href="#">按讚:由多至少</a></li>
														<li><a class="dropdown-item" href="#">按讚:由少至多</a></li>
													</ul>
												</div>
											</div>
											<br>
											<form method="get" action="" enctype="multipart/form-data" name="form1">	
											<div class="comment-group">
												<textarea name="actComContent" id="actComContent" cols="30"
													rows="10" placeholder="在此輸入您的留言" class="actComContent"
													style="border: 1px black solid;" value="<%= (activityCommentVO==null)? "" : activityCommentVO.getActComContent()%>"></textarea>
												<button type="submit" class="btn btn-outline-secondary"
													id="subMes_button" style="border: 1px black solid;">
													送出</button>
											</div>
											<!-- <input type="file"> -->


											<!-- <div class="comment-group">
                                                <textarea class="form-control" id="validationTextarea"
                                                    placeholder="在此輸入您的留言" required></textarea>
                                                <button type="button" class="btn btn-outline-secondary"
                                                    id="subMes_button">送出</button>
                                            </div> -->
											<div id="displayMessage"></div>
										</div>
										<div class="mb-3">
											<div class="imageUpload_delete">
												<input name="actComPicUpload" type="file" id="fileInput"
													class="form-control imageInput" aria-label="file example"
													required multiple accept="image/*">
												<button type="button" class="btn btn-outline-secondary">清除檔案</button>
											</div>
											</form>
											<div id="imagePreviews">
												<!-- 預覽圖 -->
											</div>
										</div>
									</form>
								</div>
								<!-- 留言送出start -->
								<!-- <span style="display: flex">
                            <div style="border:apx black solid; padding:10px">
                                <svg xmlns="http://www.w3.org/2000/svg" height="2em" viewBox="0 0 448 512">
                                    <path
                                        d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z" />
                                </svg>
                            </div>
                            <div style="border: 1px red solid; width: 550px;">
                                <span style="font-weight: bold">會員名稱</span>
                                <br>
                                <div>留言內容留言內容留言內容留言內容留言內容留言內容</div>
                                <span style="border: 1px gray solid;font-style: italic;">留言時間</span>
                                <button style="border:1px solid purple;background-color:transparent ;"
                                    id="commentLike1">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1.5em" viewBox="0 0 512 512"
                                        style="fill:black">
                                        <path
                                            d="M323.8 34.8c-38.2-10.9-78.1 11.2-89 49.4l-5.7 20c-3.7 13-10.4 25-19.5 35l-51.3 56.4c-8.9 9.8-8.2 25 1.6 33.9s25 8.2 33.9-1.6l51.3-56.4c14.1-15.5 24.4-34 30.1-54.1l5.7-20c3.6-12.7 16.9-20.1 29.7-16.5s20.1 16.9 16.5 29.7l-5.7 20c-5.7 19.9-14.7 38.7-26.6 55.5c-5.2 7.3-5.8 16.9-1.7 24.9s12.3 13 21.3 13L448 224c8.8 0 16 7.2 16 16c0 6.8-4.3 12.7-10.4 15c-7.4 2.8-13 9-14.9 16.7s.1 15.8 5.3 21.7c2.5 2.8 4 6.5 4 10.6c0 7.8-5.6 14.3-13 15.7c-8.2 1.6-15.1 7.3-18 15.1s-1.6 16.7 3.6 23.3c2.1 2.7 3.4 6.1 3.4 9.9c0 6.7-4.2 12.6-10.2 14.9c-11.5 4.5-17.7 16.9-14.4 28.8c.4 1.3 .6 2.8 .6 4.3c0 8.8-7.2 16-16 16H286.5c-12.6 0-25-3.7-35.5-10.7l-61.7-41.1c-11-7.4-25.9-4.4-33.3 6.7s-4.4 25.9 6.7 33.3l61.7 41.1c18.4 12.3 40 18.8 62.1 18.8H384c34.7 0 62.9-27.6 64-62c14.6-11.7 24-29.7 24-50c0-4.5-.5-8.8-1.3-13c15.4-11.7 25.3-30.2 25.3-51c0-6.5-1-12.8-2.8-18.7C504.8 273.7 512 257.7 512 240c0-35.3-28.6-64-64-64l-92.3 0c4.7-10.4 8.7-21.2 11.8-32.2l5.7-20c10.9-38.2-11.2-78.1-49.4-89zM32 192c-17.7 0-32 14.3-32 32V448c0 17.7 14.3 32 32 32H96c17.7 0 32-14.3 32-32V224c0-17.7-14.3-32-32-32H32z" />
                                    </svg>
                                </button>
                                <button style="border:1px solid purple;background-color:transparent; display: none"
                                    id="commentLike2">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1.5em" viewBox="0 0 512 512"
                                        style="fill:#e36868">
                                        <path
                                            d="M313.4 32.9c26 5.2 42.9 30.5 37.7 56.5l-2.3 11.4c-5.3 26.7-15.1 52.1-28.8 75.2H464c26.5 0 48 21.5 48 48c0 18.5-10.5 34.6-25.9 42.6C497 275.4 504 288.9 504 304c0 23.4-16.8 42.9-38.9 47.1c4.4 7.3 6.9 15.8 6.9 24.9c0 21.3-13.9 39.4-33.1 45.6c.7 3.3 1.1 6.8 1.1 10.4c0 26.5-21.5 48-48 48H294.5c-19 0-37.5-5.6-53.3-16.1l-38.5-25.7C176 420.4 160 390.4 160 358.3V320 272 247.1c0-29.2 13.3-56.7 36-75l7.4-5.9c26.5-21.2 44.6-51 51.2-84.2l2.3-11.4c5.2-26 30.5-42.9 56.5-37.7zM32 192H96c17.7 0 32 14.3 32 32V448c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32V224c0-17.7 14.3-32 32-32z" />
                                    </svg>
                                </button>
                                <span id="commentLike_counter"></span>
                            </div> -->
								<!-- Button trigger modal -->
								<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#exampleModal" style="background-color:white ;border-color: #CCCCCC; color: black; max-height: 40px; font-size: 10px;margin-left: 5px;">
                                檢舉留言
                            </button> -->

								<!-- Modal -->
								<!-- <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">確定要檢舉以下留言?</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            {動態抓留言}
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary"
                                                data-bs-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary">確定檢舉</button>
                                        </div>
                                    </div>
                                </div>
                            </div> -->
								</span> <span id="imagePreviewsForMessage"></span>
								<!-- <hr> -->
								<!-- 留言送出end -->
							</div>
						</section>
					</div>

					<!-- 廠商介紹start-->
					<div class="col-lg-4 ">
						<div class="card mb-4 sel_introduce">
							<div class="card-header card_header_fontstyle">廠商照片和名稱</div>
							<div class="card-body">
								<p class="content-text">
									經濟部中小企業處一路伴隨臺灣城鄉產業的進步與成長，營造城鄉及地方特色的魅力，鼓勵國內中小企業，由創生場域改造活化、在地文化塑造、特色產業發展、商業模式創新。透過一鄉鎮一特產，結合當地特色，發展具有區隔性手工藝或食品特產的產業，推廣城鄉在地美好的人、事、物，透過過去在地深耕的實際行動，一步一步的改變，讓城鄉有不同的樣貌，對社會產生正向的影響力。
								</p>
							</div>
						</div>
						<!-- 廠商介紹end-->
						<!-- 活動地圖start -->
						<div class="card mb-4 act_map">
							<div class="card-header card_header_fontstyle">活動地圖</div>
							<div class="card-body">
								<div>google map api</div>
							</div>
						</div>
						<!-- 活動地圖end -->
					</div>
				</div>
			</div>

		</div>
		<!-- 整個頁面容器結束 -->
	</div>
	<!-- 即時客服開始 -->
	<div class="fixed-bottom heading member_svg">
		<svg xmlns="http://www.w3.org/2000/svg" width="40" height="40"
			class="bi bi-chat-text" viewBox="0 0 16 16">
            <path
				d="M2.678 11.894a1 1 0 0 1 .287.801 10.97 10.97 0 0 1-.398 2c1.395-.323 2.247-.697 2.634-.893a1 1 0 0 1 .71-.074A8.06 8.06 0 0 0 8 14c3.996 0 7-2.807 7-6 0-3.192-3.004-6-7-6S1 4.808 1 8c0 1.468.617 2.83 1.678 3.894zm-.493 3.905a21.682 21.682 0 0 1-.713.129c-.2.032-.352-.176-.273-.362a9.68 9.68 0 0 0 .244-.637l.003-.01c.248-.72.45-1.548.524-2.319C.743 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.52.263-1.639.742-3.468 1.105z" />
            <path
				d="M4 5.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8zm0 2.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5z" />
        </svg>
	</div>
	<!-- 即時客結束 -->
	
</body>
</html>