<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Title</title>
</head>
<body>
<h1>사원 관리 프로그램</h1>
<form name="empAdd" action="empAdd.sam">
<fieldset>
<legend>사원 등록</legend>
이름<input type="text" name="name"><br>
이메일<input type="text" name="email"><br>
부서<input type="text" name="dept"><br>
<input type="submit" value="사원등록"><input type="reset">
</fieldset>
</form>
<form name="empDel" action="empDel.sam">
<fieldset>
<legend>사원 삭제</legend>
이름<input type="text" name="name"><br>
<input type="submit" value="사원삭제"><input type="reset">
</fieldset>
</form>
<h2><a href="empList.sam">모든 사원 보기</a></h2>
<form name="empFind" action="empFind.sam">
<fieldset>
<legend>사원 검색</legend>
<select id="s1" onchange="select();">
	<option value="idx">사원 번호</option>
	<option value="name">이름</option>
</select>
<input type="text" name="param">
<input type="submit" value="검색">
</fieldset>
</form>
</body>
<script>
	
</script>
</html>