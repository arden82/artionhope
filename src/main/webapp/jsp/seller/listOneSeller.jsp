<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.seller.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
SellerVO sellerVO = (SellerVO) request.getAttribute("sellerVO"); //SellerServlet.java(Concroller), 存入req的sellerVO物件
%>

<html>
<head>
<title>廠商資料 - listOneSeller.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>廠商資料 - ListOneSeller.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>廠商編號</th>
			<th>Email</th>
			<th>密碼</th>
			<th>廠商名稱</th>
			<th>電話</th>
			<th>廠商地址</th>
			<th>官方網址</th>
			<th>facebook</th>
			<th>單位連絡人</th>
			<th>廠商簡介</th>
			<th>銀行代碼</th>
			<th>銀行帳號</th>
			<th>戶名</th>
			<th>備註</th>
			<th>單位名稱</th>
			<th>單位負責人</th>
			<th>統一編號</th>
			<th>單位立案地址</th>
			<th>廠商頭貼</th>
			<th>廠商註冊時間</th>
			<th>最後修改時間</th>
			<th>廠商狀態</th>

		</tr>
		<tr>
			<td><%=sellerVO.getSel_id()%></td>
			<td><%=sellerVO.getSel_account()%></td>
			<td><%=sellerVO.getSel_password()%></td>
			<td><%=sellerVO.getSel_name()%></td>
			<td><%=sellerVO.getSel_phone()%></td>
			<td><%=sellerVO.getSel_address()%></td>
			<td><%=sellerVO.getSel_url()%></td>
			<td><%=sellerVO.getSel_facebook()%></td>
			<td><%=sellerVO.getSel_contactPerson()%></td>
			<td><%=sellerVO.getSel_introduction()%></td>
			<td><%=sellerVO.getSel_bankCode()%></td>
			<td><%=sellerVO.getSel_bankNumber()%></td>
			<td><%=sellerVO.getSel_bankName()%></td>
			<td><%=sellerVO.getSel_remark()%></td>
			<td><%=sellerVO.getSel_title()%></td>
			<td><%=sellerVO.getSel_principal()%></td>
			<td><%=sellerVO.getSel_uniformNumbers()%></td>
			<td><%=sellerVO.getSel_registeredAddress()%></td>
		   <td>
<img src="/IBM_emp_0201MVC_Single-Table_mySQL8/seller/seller2.do?sel_id=${sellerVO.sel_id}" width= 100px height= 100px/>
                </td>
			<td><%=sellerVO.getSel_registerdTime()%></td>
			<td><%=sellerVO.getSel_lastModifiedTime()%></td>
			<td><%=sellerVO.getSel_status()%></td>

		</tr>
	</table>

</body>
</html>