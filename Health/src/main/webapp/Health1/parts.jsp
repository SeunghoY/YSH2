
<%@page import="com.jsp.health.HealthDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.health.HealthDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${part}부위 화면</title>
</head>
<body>

<% if(request.getAttribute("message") != null) { %>
    <script>
        alert("<%= request.getAttribute("message") %>");
    </script>
<% } %>

<c:set var="part" value="${param.part}" />
<c:set var="dao" value="<%= HealthDAO.getInstance() %>" />
<c:set var="healthArr" value="${dao.HPartList(part)}" />

<h>부분: ${part}</h>

<c:forEach var="dto" items="${healthArr}">
  <hr>
  <tr>
    <td><img src="images/${part}/${dto.hImg}" style="width:175px; height:175px;"></td>
    <br>
    <td>병원이름: ${dto.hName}</td>
    <br>
    <td>병원주소: ${dto.hAddress}</td>
  </tr>
  
  <%if("admin".equals(session.getAttribute("userClass"))){ %>
  <a href="HospitalUpdateController?hId=${dto.hId}&amp;hImg=${dto.hImg}&amp;hName=${dto.hName}&amp;hAddress=${dto.hAddress}">수정</a>
  <%} %>
  
  <%if("admin".equals(session.getAttribute("userClass"))){ %>
  <a href="HospitaldeleteController?hId=${dto.hId}">삭제</a>
  <%} %>
  
</c:forEach>
<hr>

<%if("hospitalOwner".equals(session.getAttribute("userClass"))){ %>
  <a href="hospitalInsertForm.jsp">병원소유주이신가요?병원등록 요청하기</a>
  <%} %>
<br>
<a href="bodyparts.jsp">부위별화면으로</a>
</body>
</html>