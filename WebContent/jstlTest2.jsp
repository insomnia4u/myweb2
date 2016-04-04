<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h2>jstlTest2.jsp</h2>
<form name="fm">
이름 <input type="text" name="name">
<input type="submit" value="전달">
</form>
<hr>
<c:if test="${empty param.name}">
<h2 style="color:dimgray;">이름을 입력해라!</h2>
</c:if>
<c:if test="${param.name=='이정삼'}">
<h2 style="color:red;">이정삼님 완전 환영합니다.</h2>

</c:if>
<h2>현재 사용자 ${param.name}</h2>
<hr>
<c:choose>
	<c:when test="${param.name=='둘리'}">
		둘리는 꺼져!
	</c:when>
	<c:when test="${param.name=='킬러'}">
		킬러는 위험하니까 꺼졍!
	</c:when>
	<c:otherwise>
		나머지는 환영!
	</c:otherwise>
</c:choose>
</body>
</html>