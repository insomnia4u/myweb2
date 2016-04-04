<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</body>
</html>