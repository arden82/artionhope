<!-- /*
* Bootstrap 5
* Template Name: Furni
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.ticketOrder.model.*"%>
<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
TicketOrderVO ticketOrderVO = (TicketOrderVO) request.getAttribute("ticketOrderVO");
%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="images/artion-logo_.png">

  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />

		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
		<link href="css/tiny-slider.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="./css/member.css">
		<link rel="stylesheet" href="./css/cart.css">

		<title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
	
	</head>

	<body>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
		<div class="untree_co-section before-footer-section" >
            <div class="container mx-auto">
              <!-- <div class="row mb-5"> -->
                <form class="col-md-12" method="post">
                  <div class="site-blocks-table">
                    <table class="table">
                      <thead>
                        <tr>
						  
                          <th class="product-thumbnail">商品圖片</th>
                          <th class="product-name">商品名稱</th>
                          <th class="product-price">單價</th>
                          <th class="product-quantity">數量</th>
                          <th class="product-total">總計</th>
                          <th class="product-remove">刪除</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="product-thumbnail">
							
                            <img src="images/exhibition pic.jpg" alt="Image" class="img-fluid">
                          </td>
                          <td class="product-name">
                            <h2 class="h5 text-black">柏克金德國啤酒節</h2>
                          </td>
                          <td class="price">$100</td>
			
                          <td>
                            <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
                              <div class="input-group-prepend">
                                <button class="btn btn-outline-black decrease" type="button">&minus;</button>
                              </div>
                              <input type="text" class="form-control text-center quantity-amount" value="1" : ticketOrderVO.get %>" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                              <div class="input-group-append">
                                <button class="btn btn-outline-black increase" type="button">&plus;</button>
                              </div>
                            </div>
                          </td>

                          <td class="total_price">$100</td>
						
                          <td><a href="#" class="btn btn-black btn-sm">X</a></td>
                        </tr>
        
                        <tr>
                          <td class="product-thumbnail">

                            <img src="images/展覽圖4.jpg" alt="Image" class="img-fluid">
                          </td>
                          <td class="product-name">
                            <h2 class="h5 text-black">福爾摩沙藝術節</h2>
                          </td>
                          <td class="price">$100</td>
                          <td>
                            <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
                              <div class="input-group-prepend">
                                <button class="btn btn-outline-black decrease" type="button">&minus;</button>
                              </div>
                              <input type="text" class="form-control text-center quantity-amount" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                              <div class="input-group-append">
                                <button class="btn btn-outline-black increase" type="button">&plus;</button>
                              </div>
                            </div>
        
                          </td>
                          <td class="total_price">$100</td>
                          <td><a href="#" class="btn btn-black btn-sm">X</a></td>
                        </tr>


 		<jsp:useBean id="ticketorderSvc" scope="page" class="com.ticketOrder.model.TicketOrderService" /> 


						<tr>
							<td class="product-thumbnail">
							  <img src="images/展覽圖5.jpg" alt="Image" class="img-fluid">
							</td>
							<td class="product-name">
							  <h2 class="h5 text-black">清涼一下水上活動</h2>
							</td>
						
							<td class="price">$100</td>
							<td>
							  <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
								<div class="input-group-prepend">
								  <button class="btn btn-outline-black decrease" type="button">&minus;</button>
								</div>
								<input type="text" class="form-control text-center quantity-amount" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
								<div class="input-group-append">
								  <button class="btn btn-outline-black increase" type="button">&plus;</button>
								</div>
							  </div>
		  
							</td>
							<td class="total_price">$100</td>
							<td><a href="#" class="btn btn-black btn-sm">X</a></td>
						  </tr>

						   <tr>
							<td class="product-thumbnail">
							  
							  <img src="images/展覽圖2.jpg" alt="Image" class="img-fluid">
							</td>
							<td class="product-name">
							  <h2 class="h5 text-black">大港開唱</h2>
							</td>
							<td class="price">$100</td>
			  
							<td>
							  <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
								<div class="input-group-prepend">
								  <button class="btn btn-outline-black decrease" type="button">&minus;</button>
								</div>
								<input type="text" class="form-control text-center quantity-amount" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
								<div class="input-group-append">
								  <button class="btn btn-outline-black increase" type="button">&plus;</button>
								</div>
							  </div>
							</td>
  
							<td class="total_price">$100</td>
						
							<td><a href="#" class="btn btn-black btn-sm">X</a></td>
						  </tr>

						  <tr id="tic111">
							<td class="product-thumbnail">
							  
							  <img src="images/展覽圖1.jpg" alt="Image" class="img-fluid">
							</td>
							<td class="product-name">
							  <h2 class="h5 text-black">台北國際藝術博覽會</h2>
							</td>
							<td class="price">$100</td>
			  
							<td >
							  <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
								<div class="input-group-prepend">
								  <button class="btn btn-outline-black decrease" type="button">&minus;</button>
								</div>
								<input type="text" class="form-control text-center quantity-amount" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
								<div class="input-group-append">
								  <button class="btn btn-outline-black increase" type="button">&plus;</button>
								</div>
							  </div>
							</td>
  
							<td class="total_price">$100</td>
					
							<td><a href="#" class="btn btn-black btn-sm" id="de111">X</a></td>
						  </tr>

                      </tbody>
                    </table>
                  </div>
                </form>
              </div>

					<div class="horizontal-line"></div>
					
					<br>
					<!-- <button class="btn_reshop " style="">再去逛逛</button>                    -->
					<button class="btn_checkorder" onclick="window.location='checkout.html'">再去逛逛</button>
					<br>
					<br>

				<div class="container">
					<div class="text-end">
					  <h3 class="total_money offset-md-4 md-1">金額總計</h3>
					</div>
				  
					<div class="money">
					  <span class="text-black">小計</span>
					  <strong class="price_smallcount text-black">$300</strong>
					</div>
					  <br>
					<div class="money1">
						<span class="price_discount1 text-black">折扣金額</span>
						<strong class="price_discount text-black">$300</strong>
					</div>
					<br>
					<div class="money2">
					  <span class="text-black2">商品總金額</span>
					  <strong class="price_all text-black">$300</strong>
					</div>
				</div>

					<button class="btn_checkorder" onclick="window.location='checkout.html'">去買單</button>
					  <input type="text" class="form-control" id="coupon" placeholder="請輸入折扣碼">
                      <button class="btn_discount">使用折扣碼</button>
                  </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
		

		
		
		<script src="jquery/jquery-3.4.1.min.js"></script>
		<script src="jquery/cart.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
		<script src="js/tiny-slider.js"></script>
		<script src="js/custom.js"></script>
	</body>

</html>
