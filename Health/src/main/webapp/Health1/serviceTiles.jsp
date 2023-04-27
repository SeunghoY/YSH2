<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 탭</title>
</head>
<body>
서비스 탭
<% if(request.getAttribute("message") != null) { %>
    <script>
        alert("<%= request.getAttribute("message") %>");
    </script>
<% } %>

<% if (session.getAttribute("userId") == null) { %>
	<button onclick="location.href='LoginController'">로그인하기</button> <!-- url mapping -->
<% } %>

<% if (session.getAttribute("userId") != null) { %>
	<%=session.getAttribute("userId") %>로 로그인됨
	권한:<%=session.getAttribute("userClass") %>
	<a href="LogoutController">로그아웃하기</a>
<% } %>

<hr> 



<button onclick="location.href='bodyparts.jsp'">부위별</button> 

<button onclick="location.href='medicalDepartment.jsp'">진료과별</button>

<button onclick="location.href='healthGuide.jsp'">Symptom Guide</button>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>



<br>
<a href="Main.jsp">처음화면으로</a>
</body>
</html>