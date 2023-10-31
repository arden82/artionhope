
    let state =localStorage.getItem("memId");
    let loginstate=document.querySelector(".loginstate");
    console.log(state);
 
    if(state){
        loginstate.innerHTML=` 

        <nav class="navbar_mob navbar  navbar-expand-lg navbar-light bg-light  sticky-top navbar_mob_state ">
            <div class="container-fluid  relative d-flex justify-content-end">
                <a class="navbar-brand mx-auto fixed_center logo" href="../activity/ActivityPage.html">Artion</a>
                <div class="shoppingCart p-2 member_svg">
               <a class="member_svg " href="../../html/ticketCartOrder/CartTable.html">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-cart3"
                        viewBox="0 0 16 16">
                        <path
                            d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                    </svg>
                    </a>
                </div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse logo_color " id="navbarSupportedContent">
                    <form class="my-2 navbar_mob">
                        <input class="form-control me-2" type="search" placeholder="" aria-label="Search">
                        <button class=" btn_old colortest w-50 me-2" type="submit">搜尋</button>
                    </form>
                    <ul class="navbar-nav col-12 me-2   ">
                        <li class="nav-item dropdown d-flex"><a class="nav-link d-flex align-items-center hover"
                                href="../member/memberProfile.html">
                                <div class="account mem_profilePhoto">
                                    <!-- <img src="./image/6446d860dbbfe540e9e2cbab5f98f1e3-6-560x313.png" alt="用戶頭像"> -->
                                </div>
                            </a>
                            <div class="account_wrap ">
                                <span class="mem_nickname account_name"></span>
                                <span class="member_level"></span>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25"
                                        aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>

                        </li>
                        <li class="nav-item dropdown  "><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                                role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                活動類型 </a>
                            <ul class="dropdown-menu text_align_center" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item hover allAct" href="../activity/ActivityPage.html">全部</a>
                                </li>
                                <li><a class="dropdown-item hover exhiAct" href="../activity/ActivityPage.html">展覽</a>
                                </li>
                                <li><a class="dropdown-item hover marAct" href="../activity/ActivityPage.html">市集</a>
                                </li>
                                <li><a class="dropdown-item hover perAct" href="../activity/ActivityPage.html">表演</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item  "><a class="nav-link triangle  member_svg" href="../../map/map.html" id="navbarDropdown"
                                role="button" aria-expanded="false"> <svg xmlns="http://www.w3.org/2000/svg" width="30"
                                    height="30" viewBox="0 0 20 20">
                                    <path
                                        d="M16.219 1.943c.653.512 1.103 1.339 1.287 2.205a.474.474 0 0 1 .065.026l2.045.946a.659.659 0 0 1 .384.597v12.367a.665.665 0 0 1-.85.634l-5.669-1.6l-6.74 1.858a.674.674 0 0 1-.371-.004L.474 17.217a.66.66 0 0 1-.474-.63V3.998c0-.44.428-.756.855-.632l5.702 1.661l2.898-.887a.734.734 0 0 1 .122-.025c.112-.656.425-1.286.95-1.9c.623-.73 1.716-1.158 2.781-1.209c1.105-.053 1.949.183 2.91.936ZM1.333 4.881v11.215l4.87 1.449V6.298l-4.87-1.417Zm8.209.614l-2.006.613v11.279l5.065-1.394v-3.295c0-.36
                        4.299-.659.667-.659c.368 0 .666.295.666.66v3.177l4.733 1.335V6.136l-1.12-.52c-.019.11-.043.218-.073.323A6.134 6.134 0 0 1 16.4 8.05l-2.477 3.093a.67.67 0 0 1-1.073-.037l-2.315-3.353c-.382-.534-.65-1.01-.801-1.436a3.744 3.744 0 0 1-.192-.822Zm3.83-3.171c-.726.035-1.472.327-1.827.742c-.427.5-.637.968-.679 1.442c-.05.571-.016.974.126 1.373c.105.295.314.669.637 1.12l1.811 2.622l1.91-2.385a4.812 4.812 0 0 0 .841-1.657c.24-.84-.122-2.074-.8-2.604c-.695-.545-1.22-.692-2.018-.653Zm.138.697c1.104 0 2 .885 2 1.977a1.988 1.988 0 0 1-2 1.977c-1.104 0-2-.885-2-1.977s.896-1.977 2-1.977Zm0 1.318a.663.663 0 0 0-.667.659c0 .364.299.659.667.659a.663.663 0 0 0 .666-.66a.663.663 0 0 0-.666-.658Z" />
                                </svg> 地圖
                            </a></li>
                        <li class="nav-item "><a class="nav-link triangle hover member_svg store" href="../merch/merchPage.html" id="navbarDropdown"
                                role="button" aria-expanded="false"> <svg xmlns="http://www.w3.org/2000/svg" width="30"
                                    height="30" class="bi bi-shop" viewBox="0 0 16 16">
                                    <path
                                        d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z" />
                                </svg>&nbsp;商品
                            </a></li>
                        <li class="nav-item "><a class="nav-link dropdown-toggle " href="#" id="navbarDropdown"
                                role="button" data-bs-toggle="dropdown" aria-expanded="false"> <svg
                                    xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-person"
                                    viewBox="0 0 16 16">
                                    <path
                                        d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                                </svg> 我的帳戶
                            </a>
                            <ul class="dropdown-menu text_align_center" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item hover" href="../member/memberProfile.html">個人檔案</a></li>
                                <li><a class="dropdown-item hover" href="./member_checkOutPassword.html">更改密碼</a></li>
                            </ul>
                        </li>
                        <li class="nav-item "><a class="nav-link triangle hover member_svg"
                                 href="../member/memberShoppingList.html" id="navbarDropdown" role="button"
                                aria-expanded="false"> <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
                                    class="bi bi-clipboard-check" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
                                        d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
                                    <path
                                        d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z" />
                                    <path
                                        d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z" />
                                </svg> 購物清單
                            </a></li>
                        <li class="nav-item "><a class="nav-link  triangle member_svg hover" href="../member/memberNotifyhtml"
                                id="navbarDropdown" role="button" aria-expanded=" false"> <svg
                                    xmlns="http://www.w3.org/2000/svg" width="30" height="30" class=" bi bi-bell-fill"
                                    viewBox="0 0 16 16">
                                    <path
                                        d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zm.995-14.901a1 1 0 1 0-1.99 0A5.002 5.002 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901z" />
                                </svg> 我的通知
                            </a></li>
                        <li class="nav-item "><a class="nav-link  triangle hover member_svg"
                               <a href="../member/memberCollection.html" id="navbarDropdown" role="button" aria-expanded="false">
                                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-bookmarks"
                                    viewBox="0 0 16 16">
                                    <path
                                        d="M2 4a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v11.5a.5.5 0 0 1-.777.416L7 13.101l-4.223 2.815A.5.5 0 0 1 2 15.5V4zm2-1a1 1 0 0 0-1 1v10.566l3.723-2.482a.5.5 0 0 1 .554 0L11 14.566V4a1 1 0 0 0-1-1H4z" />
                                    <path
                                        d="M4.268 1H12a1 1 0 0 1 1 1v11.768l.223.148A.5.5 0 0 0 14 13.5V2a2 2 0 0 0-2-2H6a2 2 0 0 0-1.732 1z" />
                                </svg> 我的收藏
                            </a></li>
                        <li class="nav-item "><a class="nav-link triangle member_svg hover"
                                href="../member/memberCalendar.html" id="navbarDropdown" role="button" aria-expanded="false">
                                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
                                    class="bi bi-calendar-date" viewBox="0 0 16 16">
                                    <path
                                        d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z" />
                                    <path
                                        d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
                                </svg> 我的行事曆
                            </a></li>


                    </ul>
                </div>
            </div>
        </nav>
 
        <nav class="navbar navbar-expand-lg border navbar-light bg-light  sticky-top navbar_sm_state p-0">
            <div class="container-fluid logo_color">
                <a class="navbar-brand mx-5 logo" href="../activity/ActivityPage.html">Artion</a>
                <div class="shoppingCart p-2 margin_auto display_none_6 member_svg">
                 <a class="member_svg " href="../../html/ticketCartOrder/CartTable.html">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-cart3"
                        viewBox="0 0 16 16">
                        <path
                            d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                    </svg>
				</a>
                </div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse  d-flex-sm justify-content-end" id="navbarSupportedContent">

                    <ul class="navbar-nav col-1-sm me-2  mb-lg-0 ">
                        <li class="nav-item dropdown   "><a class="nav-link dropdown-toggle" href="#"
                                id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                活動類型 </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item hover allAct" href="../activity/ActivityPage.html">全部</a>
                                </li>
                                <li><a class="dropdown-item hover exhiAct " href="../activity/ActivityPage.html">展覽</a>
                                </li>
                                <li><a class="dropdown-item hover marAct" href="../activity/ActivityPage.html">市集</a>
                                </li>
                                <li><a class="dropdown-item hover perAct" href="../activity/ActivityPage.html">表演</a>
                                </li>
                            </ul>
                        </li>

                    </ul>

                    <form class="d-flex my-2 hover">
                        <input class="form-control me-2" type="search" placeholder="" aria-label="Search">
                        <button class="colortest btn_old  w-50 me-2" type="submit">搜尋</button>
                    </form>
                    <div class="shoppingCart p-2 display_none_7 hover member_svg">
                     <a class="member_svg " href="../../html/ticketCartOrder/CartTable.html">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-cart3"
                            viewBox="0 0 16 16">
                            <path
                                d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                        </svg>
                        </a>
                    </div>
                    <div class="map p-2 display_none_7 hover member_svg">
                    <a class="member_svg " href="../../map/map.html">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 20 20">
                            <path
                                d="M16.219 1.943c.653.512 1.103 1.339 1.287 2.205a.474.474 0 0 1 .065.026l2.045.946a.659.659 0 0 1 .384.597v12.367a.665.665 0 0 1-.85.634l-5.669-1.6l-6.74 1.858a.674.674 0 0 1-.371-.004L.474 17.217a.66.66 0 0 1-.474-.63V3.998c0-.44.428-.756.855-.632l5.702 1.661l2.898-.887a.734.734 0 0 1 .122-.025c.112-.656.425-1.286.95-1.9c.623-.73 1.716-1.158 2.781-1.209c1.105-.053 1.949.183 2.91.936ZM1.333 4.881v11.215l4.87 1.449V6.298l-4.87-1.417Zm8.209.614l-2.006.613v11.279l5.065-1.394v-3.295c0-.36
                    4.299-.659.667-.659c.368 0 .666.295.666.66v3.177l4.733 1.335V6.136l-1.12-.52c-.019.11-.043.218-.073.323A6.134 6.134 0 0 1 16.4 8.05l-2.477 3.093a.67.67 0 0 1-1.073-.037l-2.315-3.353c-.382-.534-.65-1.01-.801-1.436a3.744 3.744 0 0 1-.192-.822Zm3.83-3.171c-.726.035-1.472.327-1.827.742c-.427.5-.637.968-.679 1.442c-.05.571-.016.974.126 1.373c.105.295.314.669.637 1.12l1.811 2.622l1.91-2.385a4.812 4.812 0 0 0 .841-1.657c.24-.84-.122-2.074-.8-2.604c-.695-.545-1.22-.692-2.018-.653Zm.138.697c1.104 0 2 .885 2 1.977a1.988 1.988 0 0 1-2 1.977c-1.104 0-2-.885-2-1.977s.896-1.977 2-1.977Zm0 1.318a.663.663 0 0 0-.667.659c0 .364.299.659.667.659a.663.663 0 0 0 .666-.66a.663.663 0 0 0-.666-.658Z" />
                        </svg>
                        </a>
                    </div>
                    <div class="store p-2 member_svg display_none_7">
						<a class="member_svg " href="../merch/merchPage.html">
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-shop"
							viewBox="0 0 16 16">
							<path
								d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z" />
						</svg>
					</a>
					</div>
                    <div class=" d-flex-sm display_none_7">
                        <ul class="navbar-nav col-1-sm me-2  mb-lg-0 col-12 ">
                            <li class="nav-item dropdown  "><a
                                    class="nav-link dropdown-toggle triangle logo_color notify_icon  hover member_svg"
                                    href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                                    aria-expanded="false"> <svg xmlns="http://www.w3.org/2000/svg" width="30"
                                        height="30" class=" bi bi-bell-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zm.995-14.901a1 1 0 1 0-1.99 0A5.002 5.002 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901z" />
                                    </svg>
                                </a> <!-- /////// -->
                                <ul class="dropdown-menu notify_span " aria-labelledby="navbarDropdown">
                                    <li class=" notify_p"><a class="dropdown-item d-flex" href="#">
                                            <div class="notify_img ">
                                                <!-- <img src="./image/6446d860dbbfe540e9e2cbab5f98f1e3-6-560x313.png"
                                                    alt=""> -->
                                            </div>
                                            <div>
                                                <p class="notify_title">台北音樂節</p>
                                                <p>你收藏的【2023台北音樂節】主題展將台灣台北市中正區北平西路3號於2023.09.01
                                                    (五)早上9:00開始。</p>
                                                <span class="notify_time d-flex justify-content-end">pm&nbsp;1:21</span>
                                            </div>
                                        </a></li>
                                    <li class=" notify_p"><a class="dropdown-item d-flex" href="#">
                                            <div class="notify_img ">
                                                <!-- <img src="./image/6446d860dbbfe540e9e2cbab5f98f1e3-6-560x313.png"
                                                    alt=""> -->
                                            </div>
                                            <div>
                                                <p class="notify_title">2023精采臺灣．城鄉厚禮</p>
                                                <p>你收藏的【2023精采臺灣．城鄉厚禮】主題展將台灣台北市中正區北平西路3號於2023.09.01
                                                    (五)早上9:00開始。</p>
                                                <span class="notify_time d-flex justify-content-end">pm&nbsp;1:21</span>
                                            </div>
                                        </a></li>
                                    <li>
                                        <div class="notify_all d-flex justify-content-end">
                                            <a href="../member/memberNotify.html" class="nav-link">查看所有通知</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <a class="nav-link display_none_7" href="../member/memberProfile.html">
                        <div class="account display_none_7 mem_profilePhoto">
                        </div>
                    </a>
                </div>
            </div>
        </nav>

`;
 let memId = localStorage.getItem("memId");
    let path = window.location.pathname;
        path = path.substring(0, path.indexOf("/", 1));
  let mem_profilePhoto = document.querySelectorAll(".mem_profilePhoto");
                mem_profilePhoto.forEach(e => { e.innerHTML = ` <img src="${window.location, path}/memberImg?id=${memId}" alt="用戶頭像">` });
    }else{
       loginstate.innerHTML=`				
		<nav class="navbar_mob navbar navbar-expand-lg navbar-light bg-light  sticky-top navbar_mob_state ">
			<div class="container-fluid  relative d-flex justify-content-end">
				<a class="navbar-brand  mx-auto fixed_center logo" href="../activity/ActivityPage.html">Artion</a>
				<div class="shoppingCart member_svg p-2">
					<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-cart3"
						viewBox="0 0 16 16">
						<path
							d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
					</svg>
				</div>

				<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse  " id="navbarSupportedContent">
					<form class="my-2 navbar_mob">
						<input class="form-control me-2" type="search" placeholder="" aria-label="Search">
						<button class="colortest btn_old  w-50 me-2" type="submit">搜尋</button>
					</form>
					<a class="nav-link display_none_6 " href="../member/memberLogin.html">
						<button type="button" class="colortest btn_old  ">登入/註冊</button>
					</a>
					<ul class="navbar-nav col-12 me-2   ">

						<li class="nav-item dropdown  "><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
								活動類型 </a>
							<ul class="dropdown-menu text_align_center" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item hover allAct" href="../activity/ActivityPage.html">全部</a></li>
                                <li><a class="dropdown-item hover exhiAct " href="../activity/ActivityPage.html">展覽</a></li>
                                <li><a class="dropdown-item hover marAct" href="../activity/ActivityPage.html">市集</a></li>
                                <li><a class="dropdown-item hover perAct" href="../activity/ActivityPage.html">表演</a></li>
							</ul>
						</li>
							<li class="nav-item "><a class="nav-link triangle hover member_svg store" href="../../map/map.html" id="navbarDropdown"
								role="button" aria-expanded="false"> <svg xmlns="http://www.w3.org/2000/svg" width="30"
									height="30" class="bi bi-shop" viewBox="0 0 16 16">
									<path
										d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z" />
								</svg>&nbsp;地圖
							</a></li>
						<li class="nav-item "><a class="nav-link triangle hover member_svg store" href="../merch/merchPage.html" id="navbarDropdown"
								role="button" aria-expanded="false"> <svg xmlns="http://www.w3.org/2000/svg" width="30"
									height="30" class="bi bi-shop" viewBox="0 0 16 16">
									<path
										d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z" />
								</svg>&nbsp;商品
							</a></li>


					</ul>

				</div>
			</div>
		</nav>

		<nav class="navbar navbar-expand-lg navbar-light bg-light  sticky-top navbar_sm_state p-0 ">
			<div class="container-fluid ">
				<a class="navbar-brand mx-5 logo " href="../activity/ActivityPage.html">Artion</a>

				<div class="shoppingCart member_svg p-2 margin_auto display_none_6">
					<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-cart3"
						viewBox="0 0 16 16">
						<path
							d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
					</svg>
				</div>
				<a class="nav-link display_none_6  mx-3" href="../member/memberLogin.html">
					<button type="button" class="colortest btn_old  ">登入/註冊</button>
				</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse  d-flex-sm justify-content-end" id="navbarSupportedContent">
					<ul class="navbar-nav col-1-sm me-2  mb-lg-0 ">
						<li class="nav-item dropdown   "><a class="nav-link dropdown-toggle" href="#"
								id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
								活動類型 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item hover allAct" href="../activity/ActivityPage.html">全部</a></li>
                                <li><a class="dropdown-item hover exhiAct " href="../activity/ActivityPage.html">展覽</a></li>
                                <li><a class="dropdown-item hover marAct" href="../activity/ActivityPage.html">市集</a></li>
                                <li><a class="dropdown-item hover perAct" href="../activity/ActivityPage.html">表演</a></li>
							</ul>
						</li>

					</ul>
					<form class="d-flex my-2 ">
						<input class="form-control me-2" type="search" placeholder="" aria-label="Search">
						<button class="colortest btn_old  w-50 me-2" type="submit">搜尋</button>
					</form>
					<div class="shoppingCart member_svg p-2 display_none_7">
					 <a class="member_svg " href="../../html/ticketCartOrder/CartTable.html">
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-cart3"
							viewBox="0 0 16 16">
							<path
								d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
						</svg>
						</a>
					</div>

					<div class="map p-2 member_svg display_none_7">
					<a class="member_svg " href="../../map/map.html">
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 20 20">
							<path
								d="M16.219 1.943c.653.512 1.103 1.339 1.287 2.205a.474.474 0 0 1 .065.026l2.045.946a.659.659 0 0 1 .384.597v12.367a.665.665 0 0 1-.85.634l-5.669-1.6l-6.74 1.858a.674.674 0 0 1-.371-.004L.474 17.217a.66.66 0 0 1-.474-.63V3.998c0-.44.428-.756.855-.632l5.702 1.661l2.898-.887a.734.734 0 0 1 .122-.025c.112-.656.425-1.286.95-1.9c.623-.73 1.716-1.158 2.781-1.209c1.105-.053 1.949.183 2.91.936ZM1.333 4.881v11.215l4.87 1.449V6.298l-4.87-1.417Zm8.209.614l-2.006.613v11.279l5.065-1.394v-3.295c0-.36
                            4.299-.659.667-.659c.368 0 .666.295.666.66v3.177l4.733 1.335V6.136l-1.12-.52c-.019.11-.043.218-.073.323A6.134 6.134 0 0 1 16.4 8.05l-2.477 3.093a.67.67 0 0 1-1.073-.037l-2.315-3.353c-.382-.534-.65-1.01-.801-1.436a3.744 3.744 0 0 1-.192-.822Zm3.83-3.171c-.726.035-1.472.327-1.827.742c-.427.5-.637.968-.679 1.442c-.05.571-.016.974.126 1.373c.105.295.314.669.637 1.12l1.811 2.622l1.91-2.385a4.812 4.812 0 0 0 .841-1.657c.24-.84-.122-2.074-.8-2.604c-.695-.545-1.22-.692-2.018-.653Zm.138.697c1.104 0 2 .885 2 1.977a1.988 1.988 0 0 1-2 1.977c-1.104 0-2-.885-2-1.977s.896-1.977 2-1.977Zm0 1.318a.663.663 0 0 0-.667.659c0 .364.299.659.667.659a.663.663 0 0 0 .666-.66a.663.663 0 0 0-.666-.658Z" />
						</svg>
						</a>
					</div>

					<div class="store p-2 member_svg display_none_7">
						<a class="member_svg " href="../merch/merchPage.html">
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" class="bi bi-shop"
							viewBox="0 0 16 16">
							<path
								d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z" />
						</svg>
					</a>
					</div>
					<a class="nav-link display_none_7" href="../member/memberLogin.html">
						<button type="button" class="colortest btn_old mx-4 ">登入/註冊</button>
					</a>
				</div>
			</div>
		</nav>


	`;
    }
    

