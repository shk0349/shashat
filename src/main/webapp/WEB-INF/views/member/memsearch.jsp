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
<form action="memsearchsave" method="post">
<table border="5" width="400px" align="center">
<caption><h2>회원정보검색</h2></caption>
	<tr>
		<th>
			<select name="memkey">
				<option value="id">아이디
				<option value="name">이름
				<option value="gender">성별
				<option value="address">주소
			</select>
		</th>
		<td><input type="text" name="svalue"></td>
	</tr>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="검색하기">
		<input type="button" onclick="location.href='memout'" value="뒤로가기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>