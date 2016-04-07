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
<c:set var="dto" value="${requestScope.dto }"/>
<h1>게시글 보기</h1>
<h2>제목 ${dto.subject }</h2>
<h3>작성자 ${dto.writer }</h3>
<h3>작성일 ${dto.writedate }</h3>
<p>내용 ${dto.content }</p>
<input type="button" onclick="location.href='bbsReWriteForm.sam?idx=${dto.idx}'" value="답글 달기">
</body>
</html>