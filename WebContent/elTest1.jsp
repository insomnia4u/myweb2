<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h1>elTest1.jsp</h1>
<h2>정수:${10}</h2>
<h2>실수:${3.14}</h2>
<h2>boolean:${true}</h2>
<h2>3+5=${3+5}</h2>
<h2>"3"+5=${"3"+5}</h2>
<!-- 문자열 처리된 숫자도 강제 파싱됨 -->
<h2>"삼"+5=$</h2>
<!-- 산술연산자가 있으면 무조건 파싱하므로 문자열이 에러를 토해냄 -->
<h2>null+3=${null+3}</h2>
<!-- null은 0으로 인식 -->
<h2>3/2=${3/2}</h2>
<!--나누기를 할 경우는 실제로 몫과 나머지가 모두 발생됨 -->
<h2>4==3 : ${4==3 } or ${4 eq 4 }</h2>
</body>
</html>