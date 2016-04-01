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
</body>
</html>