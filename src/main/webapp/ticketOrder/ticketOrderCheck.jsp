<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.ticketOrderDetail.model.*"%>
<%@page import="com.tha103.artion.activity.model.ActivityVO"%>
<%@ page import="com.tha103.artion.activity.*"%>
<%@page import="com.tha103.artion.activity.service.ActivityService"%>

<%--
//��com.emp.controller.EmpServlet.java��238��s�Jreq��empVO���� (������J�榡�����~�ɪ�empVO����)
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
								<h1>���b</h1>
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
		              <h2 class="h3 mb-3 text-black">�q��ӫ~</h2>
		              <div class="p-3 p-lg-5 border bg-white">
		                <table class="table site-block-order-table mb-5">
		                  <thead>
		                    <th>�q��ӫ~</th>
		                    <th>�`�p</th>
		                  </thead>
		                  
		                  
		                  <tbody>
		                    <tr>
		                      <td>${activityVO.actId}<strong class="mx-2">x</strong>${ticketOrderDetailVO,ticOrdDetQuantity}</td>
		                      <td>${ticketOrderVO,ticketOrdActuallyAmount}</td>
		                    </tr>
		                    <tr>
		                      <td>�f�J���w���s�` <strong class="mx-2">x</strong>   1</td>
		                      <td>$500</td>
		                    </tr>
		                    <tr>
		                      <td class="text-black font-weight-bold"><strong>�ӫ~���B</strong></td>
		                      <td class="text-black">$1000</td>
		                    </tr>
							<tr>
								<td class="text-black font-weight-bold"><strong>�馩���B</strong></td>
								<td class="text-black">$200</td>
							</tr>

		                    <tr>
		                      <td class="text-black font-weight-bold"><strong>��I���B</strong></td>
		                      <td class="text-black font-weight-bold"><strong>$800</strong></td>
		                    </tr>
		                  </tbody>
		                </table>
						
						
						<div class="row mb-5"> 
							<div class="col-md-12">
							
									<div class="input-group-append">
										<input type="text" class="form-control" id="coupon" placeholder="�п�J�馩�X">

										<button class="btn_usediscount" type="button" id="button-addon2">�ϥΧ馩�X</button>
									</div>
								</div>
							  </div>
							</div>
							<button class="btn_checkorder" onclick="window.location='thankyou.html'">�U�q��</button>
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
