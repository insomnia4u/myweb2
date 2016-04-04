<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h1>CCC.jsp</h1>
<%
	String name=request.getParameter("name");

	String addr=(String)request.getAttribute("addr");
	
%>
<h2>이름 <%=name %></h2>
<h2>주소 <%=addr %></h2>
<hr>
<h2>나이 ${param.age }</h2>
<h2>전화번호 ${requestScope.tel}</h2>
</body>
</html>