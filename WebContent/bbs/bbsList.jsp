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
<h1>게시판</h1>
<table>
<thead>
<tr>
<th>글번호</th>
<th>제목</th>
<th>작성자</th>
<th>작성일</th>
<th>조회수</th>
</tr>
</thead>
<tbody>
<c:set var="dto" value="${requestScope.dto}"/>

<c:set var="pages" value="${requestScope.pages}"/>
<c:forEach var="i" items="${dto}">
<tr>
	<td>${i.idx }</td>
	<c:url var="contentUrl" value="bbsContent.sam">
		<c:param name="idx">${i.idx }</c:param>
	</c:url>
	<td><a href="${contentUrl}">${i.subject }</a></td>
	<td>${i.writer }</td>
	<td>${i.writedate }</td>
	<td>${i.readnum }</td>
<tr>
</c:forEach>
<tr>
<td colspan="3" align="center">
${requestScope.pageStr }
</tr>
</tbody> 

</table>
<input type="button" value="글쓰기" onclick="location.href='write.sam'">
</body>
</html>