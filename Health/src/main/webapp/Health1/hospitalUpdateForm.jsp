<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원업데이트 페이지</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
병원 정보 수정 
<% if(request.getAttribute("message") != null) { %>
    <script>
        alert("<%= request.getAttribute("message") %>");
    </script>
<% } %>

<form action="HospitalUpdateController?hId=<%=request.getParameter("hId") %>" method="post">


병원사진파일명:<input type="text" name="hImg" value=<%=request.getParameter("hImg") %>><br>
병원이름:<input type="text" name="hName" value=<%=request.getParameter("hName") %>><br>
병원주소:<input type="text" name="hAddress" value=<%=request.getParameter("hAddress") %>><br>

전문부위:<select name="hPart">
	<option value="">선택</option>
    <option value="머리">머리</option>
    <option value="어깨">어깨</option>
    <option value="팔">팔</option>
    <option value="몸통">몸통</option>
    <option value="다리">다리</option>
    <option value="발">발</option>
  </select>
<br>

<input type="submit" value="병원수정"><br>
</form>
<a href="bodyparts.jsp">부위별메인화면</a>
</body>
</html>