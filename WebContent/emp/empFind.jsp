<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="sam.emp.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h2>사원 검색 결과</h2>
<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>이름</th>
			<th>이메일</th>
			<th>부서</th>
		</tr>
	</thead>
	<tbody>
		<% ArrayList<EmpDTO> arr=(ArrayList<EmpDTO>)request.getAttribute("dtos");
			if(arr==null){		
		%>
		<tr>
			<td colspan="4">검색된 사원이 없습니다.</td>
		</tr>
		<%}else{
			for(int i=0;i<arr.size();i++){
		%>
		<tr>
			<td><%=arr.get(i).getIdx() %></td>
			<td><%=arr.get(i).getName() %></td>
			<td><%=arr.get(i).getEmail() %></td>
			<td><%=arr.get(i).getDept() %></td>
		</tr>
		<%}} %>
	</tbody>
</table>
</body>
</html>