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
<table>
<c:forEach var="i" begin="1" end="9" step="1">
<tr>
	<c:forEach var="j" begin="2" end="9" step="1">
	<td>
	${j} * ${i} = ${j*i}
	</td>
	</c:forEach>
</tr>
</c:forEach>
</table>
</body>
</html>