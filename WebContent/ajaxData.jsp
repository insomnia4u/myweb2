<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String param=request.getParameter("type");

if(param.equals("1"))
{
	request.setAttribute("data", "성공~~");	
}
else
{
	request.setAttribute("data", "실패~~~");	
}
%>