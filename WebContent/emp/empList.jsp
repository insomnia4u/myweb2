<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="sam.emp.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Title</title>
</head>
<body>
<h2>모든 사원 보기</h2>
<table>
<thead>
	<tr>
		<th>IDX</th>
		<th>이름</th>
		<th>이메일</th>
		<th>부서</th>
		<th>수정</th>
	</tr>
</thead>

<tbody>
<c:set var="arr" value="${requestScope.arr }"/>
<c:if test="${empty arr}">
	<tr>
		<td colspan="5">등록된 사원이 없습니다.</td>
	</tr>
</c:if>
<c:forEach var="i" items="${arr}">	
	<tr>
	
	<td colspan="5">
	<form name="edit-${i} %>" class="f-${i}" action="empEdit.sam">
		<input type="text" class="t-${i}" name="idx"  value="${i.idx}" readonly>
		<input type="text" class="t-${i}" name="name" value="${i.name}" readonly>
		<input type="text" class="t-${i}" name="email" value="${i.email}" readonly>
		<input type="text" class="t-${i}" name="dept" value="${i.dept}" readonly>
		<input type="button" class="button-${i}" value="수정">
	</form>
	
	</td>
	
	</tr>

<script>
$(function(){
		$('.button-'+${i}+'').click(function(){
			      if ($('.button-'+${i}+'').val() == "완료") {
			    	  $('.f-'+${i}+'').submit();
    	  
					return true;
			      }
			      $('.t-'+${i}+'').attr('readonly',false);
				    $('.button-'+${i}+'').attr('value','완료');

			      return false;
			    });
});
</script>	
</c:forEach>
	</tbody>
</table>
</body>
<script>

</script>

</html>