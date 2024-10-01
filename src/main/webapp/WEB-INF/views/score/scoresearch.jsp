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
<form action="scoresearchsave" method="post">
<table border="5" width="400px" align="center">
<caption><h2>성적검색</h2></caption>
	<tr>
		<th>
			<select name="scorekey">
				<option value="sclass">학년
				<option value="sban">반
				<option value="sname">이름
			</select>
		</th>
		<td><input type="text" name="svalue"></td>
	</tr>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="검색하기">
		<input type="button" onclick="location.href='scoreout'" value="뒤로가기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>