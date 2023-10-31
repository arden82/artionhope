<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <script>
    <%-- 增加时间戳来更换验证码图片 --%>
        window.onload=function(){
            document.getElementById("img").onclick=function(){
            	this.src = "<%=request.getContextPath()%>/seller/CheckCodeServlet?time=" + new Date().getTime();

            }
        }
        
<%-- 用于打开注册的窗口--%>
        function reg() {
            window.open("register.jsp");
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>

<form action="/daydayup/loginServlet" method="post">
    <table>
        <tr>
            <td>帳號</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密碼</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>驗證碼</td>
            <td><input type="text" name="checkcode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="<%=request.getContextPath()%>/seller/CheckCodeServlet" alt=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="登入"></td>
            <td><input type="button" value="註冊" onclick="reg()" ></td>

        </tr>
    </table>
</form>

<div>${requestScope.login_error}</div>
<div>${requestScope.checkcode_error}</div>
</body>
</html>
