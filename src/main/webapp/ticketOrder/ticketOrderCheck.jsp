<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.ticketOrderDetail.model.*"%>
<%@page import="com.tha103.artion.activity.model.ActivityVO"%>
<%@ page import="com.tha103.artion.activity.*"%>
<%@page import="com.tha103.artion.activity.service.ActivityService"%>

<%--
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
ActivityVO activityVO1 = (ActivityVO) request.getAttribute("ActivityVO");
--%>

<%-- ActivityDAO activityVO = new ActivityDAO();
ActivityVO activity=activityVO.findByPK(10001);
pageContext.setAttribute("activity",activity);
--%>

<%
    ActivityService activitySvc = new ActivityService();
    List<ActivityVO> list = activitySvc.getAll();
    pageContext.setAttribute("list",list);
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
		<link rel="stylesheet" href="./css/checkout.css">
		
		<title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
	</head>

	<body>

		<!-- Start Hero Section -->
			<div class="p-0">
				<div class="container">
					<div class="row justify-content-between">
						<div class="col-lg-5">
							<div class="intro-excerpt">
								<h1>結帳</h1>
							</div>
						</div>
						<div class="col-lg-7">
							
						</div>
					</div>
				</div>
			</div>				         
		        <div class="col-md-6 mx-auto">
	        
		          <div class="row mb-5">
		            <div class="col-md-12">
		              <h2 class="h3 mb-3 text-black">訂單商品</h2>
		              <div class="p-3 p-lg-5 border bg-white">
		                <table class="table site-block-order-table mb-5">
		                  <thead>
		                    <th>訂單商品</th>
		                    <th>總計</th>
		                  </thead>
		                  
		                  
		                  <tbody>
		                    <tr>
		                      <td>${activityVO.actId}<strong class="mx-2">x</strong>${ticketOrderDetailVO,ticOrdDetQuantity}</td>
		                      <td>${ticketOrderVO,ticketOrdActuallyAmount}</td>
		                    </tr>
		                    <tr>
		                      <td>柏克金德國啤酒節 <strong class="mx-2">x</strong>   1</td>
		                      <td>$500</td>
		                    </tr>
		                    <tr>
		                      <td class="text-black font-weight-bold"><strong>商品金額</strong></td>
		                      <td class="text-black">$1000</td>
		                    </tr>
							<tr>
								<td class="text-black font-weight-bold"><strong>折扣金額</strong></td>
								<td class="text-black">$200</td>
							</tr>

		                    <tr>
		                      <td class="text-black font-weight-bold"><strong>實付金額</strong></td>
		                      <td class="text-black font-weight-bold"><strong>$800</strong></td>
		                    </tr>
		                  </tbody>
		                </table>
						
						
						<div class="row mb-5"> 
							<div class="col-md-12">
							
									<div class="input-group-append">
										<input type="text" class="form-control" id="coupon" placeholder="請輸入折扣碼">

										<button class="btn_usediscount" type="button" id="button-addon2">使用折扣碼</button>
									</div>
								</div>
							  </div>
							</div>
							<button class="btn_checkorder" onclick="window.location='thankyou.html'">下訂單</button>
						</div>		                		               
						</div>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>		      
		    </div>
		  </div>

		
		<script src="jquery/jquery-3.4.1.min.js"></script>
		<script src="jquery/checkout.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
		<script src="js/tiny-slider.js"></script>
		<script src="js/custom.js"></script>
	</body>

</html>
