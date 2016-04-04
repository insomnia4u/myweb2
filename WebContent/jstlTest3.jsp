<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h1>jstlTest3.jsp</h1>
<%
	ArrayList<String> arr=new ArrayList<String>();

	arr.add("이정삼");
	arr.add("박양선");
	arr.add("강준호");
	arr.add("조국");
	arr.add("이지현");
%>
<c:set var="arr" value="<%=arr%>"/>
<ul>
<c:forEach var="tmp" items="${arr}">
		<li>${tmp}</li>
</c:forEach>
</ul>
<hr>
<c:forEach var="i" begin="1" end="10" step="2">
${i}<br>
</c:forEach>
<hr>
<c:forTokens var="tmp" items="사과/배/포도/딸기" delims="/">
	<li>${tmp}</li>
</c:forTokens>
</body>
</html>