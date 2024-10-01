<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{
text-align: center;
}
td{
text-align: left;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardsearchsave" method="post">
<table border="5" width="300px" align="center">
<caption><h2>게시판검색</h2></caption>
	<tr>
		<th>
			<select name="boardkey">
				<option value="bwriter">작성자
				<option value="btitle">제목
				<option value="bcontents">내용
			</select>
		</th>
		<td><input type="text" name="svalue"></td>
	</tr>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="검색하기">
		<input type="button" onclick="location.href='boardout'" value="뒤로가기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>