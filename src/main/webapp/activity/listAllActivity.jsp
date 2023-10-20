<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, java.util.Base64, com.activity.model.*"%>
<%@ page import="java.util.*"%>
<%-- 此頁練習採用 S 的寫法取值 --%>

<%
ActivityService activitySvc = new ActivityService();
List<ActivityVO> list = activitySvc.getAll();
pageContext.setAttribute("list", list);
System.out.println("有跑到這裡!");
%>


<html>
<head>
<title>所有廠商資料 - listAllActivity.jsp</title>

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
				<h3>所有廠商資料 - listAllActivity.jsp</h3>
				<h4>
					<a href="sel_index.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>活動編號</th>
			<th>活動名稱</th>
			<th>票劵編號</th>
			<th>票劵定價</th>
			<th>票劵開賣時間</th>
			<th>票劵結束販賣時間</th>
			<th>活動類型</th>
			<th>活動開始日</th>
			<th>活動結束日</th>
			<th>活動開始時間</th>
			<th>活動結束時間</th>
			<th>縣市</th>
			<th>區域</th>
			<th>活動地址</th>
			<th>主辦單位</th>
			<th>email信箱</th>
			<th>聯絡電話</th>
			<th>票劵總數</th>
			<th>活動內容</th>
<!-- 			<th>活動封面</th> -->
<!-- 			<th>活動圖片1</th> -->
<!-- 			<th>活動圖片2</th> -->
<!-- 			<th>活動圖片3</th> -->
<!-- 			<th>按讚次數</th> -->
<!-- 			<th>瀏覽次數</th> -->
<!-- 			<th>活動審核狀態</th> -->
<!-- 			<th>活動狀態</th> -->
<!-- 			<th>廠商編號</th> -->
<!-- 			<th>經度</th> -->
<!-- 			<th>緯度</th> -->
<!-- 			<th>售出總數</th> -->
<!-- 			<th>管理者編號</th> -->
<!-- 			<th>最新修改活動時間</th> -->
<!-- 			<th>審核結果內容</th> -->
			<th>修改</th>
			<th>刪除</th>

		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="activityVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${activityVO.act_id}</td>
				<td>${activityVO.act_name}</td>
				<td>${activityVO.act_ticketID}</td>
				<td>${activityVO.act_ticketPrice}</td>
				<td>${activityVO.act_ticketStartTime}</td>
				<td>${activityVO.act_ticketEndTime}</td>
				<td>${activityVO.act_type}</td>
				<td>${activityVO.act_startDate}</td>
				<td>${activityVO.act_endDate}</td>
				<td>${activityVO.act_startTime}</td>
				<td>${activityVO.act_endTime}</td>
				<td>${activityVO.act_city}</td>
				<td>${activityVO.act_zone}</td>
				<td>${activityVO.act_address}</td>
				<td>${activityVO.act_organization}</td>
				<td>${activityVO.act_email}</td>
				<td>${activityVO.act_phone}</td>
				<td>${activityVO.act_ticketTotal}</td>
				<td>${activityVO.act_content}</td>

<!-- 				<td><img -->
<%-- 					src="/IBM_emp_0201MVC_Single-Table_mySQL8/activity/activity.do?act_id=${activityVO.act_id}" --%>
<!-- 					width="200" height="200" /></td> -->
<!-- 				<td><img -->
<%-- 					src="/IBM_emp_0201MVC_Single-Table_mySQL8/activity/activity.do?act_id=${activityVO.act_id}" --%>
<!-- 					width="200" height="200" /></td> -->
<!-- 				<td><img -->
<%-- 					src="/IBM_emp_0201MVC_Single-Table_mySQL8/activity/activity.do?act_id=${activityVO.act_id}" --%>
<!-- 					width="200" height="200" /></td> -->
<!-- 				<td><img -->
<%-- 					src="/IBM_emp_0201MVC_Single-Table_mySQL8/activity/activity.do?act_id=${activityVO.act_id}" --%>
<!-- 					width="200" height="200" /></td> -->
<%-- 				<td>${activityVO.act_likeTimes}</td> --%>
<%-- 				<td>${activityVO.act_views}</td> --%>
<%-- 				<td>${activityVO.act_approalStatus}</td> --%>
<%-- 				<td>${activityVO.act_status}</td> --%>
<%-- 				<td>${activityVO.sel_id}</td> --%>
<%-- 				<td>${activityVO.act_longitude}</td> --%>
<%-- 				<td>${activityVO.act_latitude}</td> --%>
<%-- 				<td>${activityVO.act_ticketTotalSell}</td> --%>
<%-- 				<td>${activityVO.adm_id}</td> --%>
<%-- 				<td>${activityVO.act_lastModifiedTime}</td> --%>
<%-- 				<td>${activityVO.act_ResultContent}</td> --%>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/activity/activity.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="act_id" value="${activityVO.act_id}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/activity/activity.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="act_id" value="${activityVO.act_id}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>
</body>
</html>