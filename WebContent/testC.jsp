<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TestC.jsp</h1>
<%
	String name=request.getParameter("name");

	String age=(String)request.getAttribute("addr");
%>
<h2>넘어온 이름 <%=name %></h2>
<h2>넘어온 나이 <%=age %></h2>
</body>
</html>