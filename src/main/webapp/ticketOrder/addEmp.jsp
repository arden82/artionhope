<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tha103.artion.ticketOrder.model.*"%>

<% //見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
TicketOrderVO ticketorderVO = (TicketOrderVO) request.getAttribute("ticketorderVO");
%>
--<%= ticketorderVO==null %>--${ticketorderVO.ticketOrd_id}-- <!-- line 100 -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>周邊商品資料新增 - addEmp.jsp</title>

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
	<tr><td>
		 <h3>周邊商品資料新增 - addEmp.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="ticketorder.do" name="form1">
<table>
	
	
	
	
	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="mem_id" value="<%= (ticketorderVO==null)? 7001 : ticketorderVO.getMember()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>實付金額:</td>
		<td><input type="TEXT" name="ticketOrdStatus" value="<%= (ticketorderVO==null)? 500 : ticketorderVO.getTicketOrdStatus()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>付款狀態:</td>
		<td><input type="TEXT" name="ticketOrdTotalPrice" value="<%= (ticketorderVO==null)? 1 : ticketorderVO.getTicketOrdTotalPrice()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>周邊商品訂單狀態:</td>
		<td><input type="TEXT" name="ticketOrdProCodeAmount" value="<%= (ticketorderVO==null)? 1 : ticketorderVO.getTicketOrdProCodeAmount()%>" size="45"/></td>
	</tr>
	
	
	
	<tr>
		<td>收件地址:</td>
		<td><input type="TEXT" name="ticketOrdActuallyAmount"   value="<%= (ticketorderVO==null)? "台北市民權西路1段2號" : ticketorderVO.getTicketOrdActuallyAmount()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>周邊商品訂代碼:</td>
		<td><input type="TEXT" name="ticketOrdPayStatus"   value="<%= (ticketorderVO==null)? "def987654321" : ticketorderVO.getTicketOrdPayStatus()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>周邊商品訂代碼:</td>
		<td><input type="TEXT" name="mypromocode"   value="<%= (ticketorderVO==null)? "def987654321" : ticketorderVO.getMypromocode()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>周邊商品訂代碼:</td>
		<td><input type="TEXT" name="ticketOrdAddress"   value="<%= (ticketorderVO==null)? "def987654321" : ticketorderVO.getTicketOrdAddress()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>周邊商品訂代碼:</td>
		<td><input type="TEXT" name="seller"   value="<%= (ticketorderVO==null)? "def987654321" : ticketorderVO.getSeller()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>周邊商品訂代碼:</td>
		<td><input type="TEXT" name="ticketOrdCode"   value="<%= (ticketorderVO==null)? "def987654321" : ticketorderVO.getTicketOrdCode()%>" size="45"/></td>
	</tr>
	
	
	

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />
	<tr>
		<td>部門:<font color=red><b>*</b></font></td>
		<td><select size="1" name="deptno">
			<c:forEach var="deptVO" items="${deptSvc.all}">
				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname}   <!-- 此行重要 -->
			</c:forEach>
		</select></td>
	</tr>
--%>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

 
  

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
 <%--       $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=memberNotReceiveTime%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
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
        //      }});    --%>
        
</script>
</html>