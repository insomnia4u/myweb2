<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h1>글쓰기</h1>
<form name="write" action="bbsWrite.sam">
작성자<input type="text" name="writer">
비밀번호<input type="password" name="pwd">
제목<input type="text" name="subject">
내용<input type="text" name="content">
<input type="submit" value="글 작성">
<input type="reset" value="다시 쓰기">
</form>
</body>
</html>