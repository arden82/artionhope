<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, java.util.Base64, com.seller.model.*" %>
<%@ page import="java.util.*"%>
<%@ page import="com.seller.model.*"%>
<%-- 此頁練習採用 S 的寫法取值 --%>

<%
SellerService sellerSvc = new SellerService();
List<SellerVO> list = sellerSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有廠商資料 - listAllSeller.jsp</title>

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
	width: 800px;
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

	<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有廠商資料 - listAllSeller.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>廠商編號</th>
			<th>帳號:</th>
			<th>密碼:</th>
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
			<th>修改</th>
			<th>刪除</th>
		</tr>
<%@ include file="page1.file" %> 
<c:forEach var="sellerVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
            <tr>
                <td>${sellerVO.sel_id}</td>
                <td>${sellerVO.sel_account}</td>
                <td>${sellerVO.sel_password}</td>
                <td>${sellerVO.sel_name}</td>
                <td>${sellerVO.sel_phone}</td>
                <td>${sellerVO.sel_address}</td>
                <td>${sellerVO.sel_url}</td>
                <td>${sellerVO.sel_facebook}</td>
                <td>${sellerVO.sel_contactPerson}</td>
                <td>${sellerVO.sel_introduction}</td>
                <td>${sellerVO.sel_bankCode}</td>
                <td>${sellerVO.sel_bankNumber}</td>
                <td>${sellerVO.sel_bankName}</td>
                <td>${sellerVO.sel_remark}</td>
                <td>${sellerVO.sel_title}</td>
                <td>${sellerVO.sel_principal}</td>
                <td>${sellerVO.sel_uniformNumbers}</td>
                <td>${sellerVO.sel_registeredAddress}</td>
                <td>
                    <img src="/IBM_emp_0201MVC_Single-Table_mySQL8/seller/seller2.do?sel_id=${sellerVO.sel_id}" width=200px height=200px />
                </td>
                <td>${sellerVO.sel_registerdTime}</td>
                <td>${sellerVO.sel_lastModifiedTime}</td>
                <td>${sellerVO.sel_status}</td>

                <td>
                    <FORM METHOD="post"
                        ACTION="<%=request.getContextPath()%>/seller/seller.do"
                        style="margin-bottom: 0px;">
                        <input type="submit" value="修改"> <input type="hidden"
                            name="sel_id" value="${sellerVO.sel_id}"> <input
                            type="hidden" name="action" value="getOne_For_Update">
                    </FORM>
                </td>
                <td>
                    <FORM METHOD="post"
                        ACTION="<%=request.getContextPath()%>/seller/seller.do"
                        style="margin-bottom: 0px;">
                        <input type="submit" value="刪除"> <input type="hidden"
                            name="sel_id" value="${sellerVO.sel_id}"> <input
                            type="hidden" name="action" value="delete">
                    </FORM>
                </td>
            </tr>
        </c:forEach>
    </table>
    	<%@ include file="page2.file"%>
</body>
</html>