<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h2>content.jsp?idx=3&cp=2</h2>
<c:url var="contentUrl" value="content.jsp">
	<c:param name="idx">3</c:param>
	<c:param name="cp">2</c:param>
</c:url>
<h2>${contentUrl}</h2>
<c:import var="mnaver" url="http://m.naver.com"></c:import>
<div style="width:480px;zheight:720px;border:1px solid black;overflow:hidden;">
${mnaver}</div>

<c:catch var="excep">
<% String str=null;
	System.out.println(str.toString());%>
</c:catch>
</body>
</html>