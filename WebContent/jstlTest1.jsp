<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.util.*" %>
<!-- jstl 태그 라이브러리 등록 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h1>jstlTest1.jsp</h1>
<!-- 변수 선언 -->
<!-- int num1=100; -->
<c:set var="num1" value="100" />
<!--  어떤 데이터타입이든 가져올 수 있음 var로! -->
<!--  body content 영역 -->
<c:set var="num2">
200
</c:set>
<!-- 변수 출력 -->
<h2>num1 =${num1}</h2>
<h2>num2 =${num2}</h2>
<h2>num1+num2 = ${num1+num2}</h2>

<c:set var="m" value="<%=new HashMap() %>"/>

<c:set target="${m}" property="name" value="이정삼"/>
<c:set target="${m}" property="addr">
서울
</c:set>

<h2>이름 ${m.name}</h2>
<h2>주소 ${m['addr']}</h2>

<%
	String fruit[]={"딸기","수박","바나나","오렌지","귤"};
%>
<c:set var="f" value="<%=fruit %>"/>

<ul>
	<li>${f}</li>
	<li>${f[0]}</li>
	<li>${f['1']}</li>
	<li>${f["2"]}</li>
</ul>
<c:remove var="f"/>
<hr>
<ul>
	<li>${f}</li>
	<li>${f[0]}</li>
	<li>${f['1']}</li>
	<li>${f["2"]}</li>
</ul>
</body>
</html>