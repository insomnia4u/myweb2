<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<%
	request.setAttribute("addr", "서울");
	request.setAttribute("tel", "02-2112-2121");
%>
<jsp:forward page="CCC.jsp"></jsp:forward>
</body>
</html>