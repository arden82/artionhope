<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.seller.model.*"%>


<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
SellerVO sellerVO = (SellerVO) request.getAttribute("sellerVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>廠商資料新增 - addSeller.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>廠商資料新增 - addSeller.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

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

		<table>

			<tr>
				<td>帳號:</td>
				<td><input type="TEXT" name="sel_account"
					value="<%=(sellerVO == null) ? "abc@yahoo.com.tw" : sellerVO.getSelAccount()%>"
					size="45" /></td>
			</tr>

			<tr>
				<td>密碼:</td>
				<td><input type="TEXT" name="sel_password"
					value="<%=(sellerVO == null) ? "aa01234567" : sellerVO.getSelPassword()%>"
					size="45" /></td>
			</tr>

			<tr>
				<td>廠商名稱:</td>
				<td><input type="TEXT" name="sel_name"
					value="<%=(sellerVO == null) ? "王小明藝術中心" : sellerVO.getSelName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="TEXT" name="sel_phone"
					value="<%=(sellerVO == null) ? "02-12345678" : sellerVO.getSelPhone()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>廠商地址:</td>
				<td><input type="TEXT" name="sel_address"
					value="<%=(sellerVO == null) ? "新北市汐止區忠孝東路222號" : sellerVO.getSelAddress()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>官方網址:</td>
				<td><input type="TEXT" name="sel_url"
					value="<%=(sellerVO == null) ? "www.artion.com.tw" : sellerVO.getSelUrl()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>facebook:</td>
				<td><input type="TEXT" name="sel_facebook"
					value="<%=(sellerVO == null) ? "www.facebook/artion.com" : sellerVO.getSelFacebook()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>單位連絡人:</td>
				<td><input type="TEXT" name="sel_contactPerson"
					value="<%=(sellerVO == null) ? "王小明" : sellerVO.getSelContactPerson()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>廠商介紹:</td>
				<td><input type="TEXT" name="sel_introduction"
					value="<%=(sellerVO == null) ? "yoyoyo" : sellerVO.getSelIntroduction()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>銀行代碼:</td>
				<td><input type="TEXT" name="sel_bankCode"
					value="<%=(sellerVO == null) ? "001" : sellerVO.getSelBankCode()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>銀行帳號:</td>
				<td><input type="TEXT" name="sel_bankNumber"
					value="<%=(sellerVO == null) ? "123456789" : sellerVO.getSelBankNumber()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>戶名:</td>
				<td><input type="TEXT" name="sel_bankName"
					value="<%=(sellerVO == null) ? "王小名" : sellerVO.getSelBankName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>備註:</td>
				<td><input type="TEXT" name="sel_remark"
					value="<%=(sellerVO == null) ? "請準時匯款" : sellerVO.getSelRemark()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>單位名稱:</td>
				<td><input type="TEXT" name="sel_title"
					value="<%=(sellerVO == null) ? "活動企劃部" : sellerVO.getSelTitle()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>單位負責人:</td>
				<td><input type="TEXT" name="sel_principal"
					value="<%=(sellerVO == null) ? "王小名" : sellerVO.getSelPrincipal()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>統一編號:</td>
				<td><input type="TEXT" name="sel_uniformNumbers"
					value="<%=(sellerVO == null) ? "12345678" : sellerVO.getSelUniformNumbers()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>單位立案地址:</td>
				<td><input type="TEXT" name="sel_registeredAddress"
					value="<%=(sellerVO == null) ? "新北市汐止區忠孝東路888號" : sellerVO.getSelRegisteredAddress()%>"
					size="45" /></td>
			</tr>

		</table>

		<!-- 剩余表单字段 -->
		<input type="file" name="sel_profilePicture"> 
<!-- 		<input -->
<!-- 			type="submit" value="上傳"> <br>  -->
		<input type="hidden" name="action" value="insert"> 
		<input type="submit" value="送出新增">
	</FORM>

</body>

<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
java.sql.Timestamp sel_registerdTime = null;

try {
	sel_registerdTime = sellerVO.getSelRegisterdTime();
} catch (Exception e) {
	sel_registerdTime = new java.sql.Timestamp(System.currentTimeMillis());
}

java.sql.Timestamp sel_lastModifiedTime = null;

try {
	sel_lastModifiedTime = sellerVO.getSelLastModifiedTime();
} catch (Exception e) {
	sel_lastModifiedTime = new java.sql.Timestamp(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>

$.datetimepicker.setLocale('zh');
// 初始化廠商註冊時間的datetimepicker
$('#sel_registerdTime').datetimepicker({
	theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d',         //format:'Y-m-d H:i:s',
	   value: '<%=sel_registerdTime%>', // value:   new Date(),
});

// 初始化最後修改時間的datetimepicker
$('#sel_lastModifiedTime').datetimepicker({
	theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d',         //format:'Y-m-d H:i:s',
	value: '<%=sel_lastModifiedTime%>
	', // value:   new Date(),
	});
	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
</script>
</html>