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
<h2>자유게시판 답변글쓰기</h2>
<c:set var="dto" value="${requestScope.dto }"></c:set>
   <form name="bbsReWrite" action="bbsReWrite.sam">
   <input type="hidden" name="ref" value="${dto.ref}">
   <input type="hidden" name="lev" value="${dto.lev}">
   <input type="hidden" name="sunbun" value="${dto.sunbun}">
   <ul>
      <li><label>작성자</label>
      <input type="text" name=writer></li>
      <li><label>비밀번호</label>
      <input type="text" name="pwd"></li>
      <li><label>제목</label>
      <input type="text" name="subject" value="Re:>${dto.subject}"></li>
      <li><textarea rows="10" cols="45" name="content"></textarea></li>
   </ul>
       <p>   
      <input type="submit" value="저장">
      <input type="reset" value="다시작성">
      </p>
       
    
   </form>
</body>
</html>