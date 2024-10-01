<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logincheck" method="post">
<table border="5" width="400px" align="center">
<caption><h2>로그인</h2></caption>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="로그인">
		<input type="reset" value="취소하기">
		<input type="button" onclick="location.href='meminput'" value="회원가입">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</td>
	</tr>
</table>
</form>
</body>
</html>