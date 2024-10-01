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
<form action="booksearchsave" method="post">
<table border="5" width="300px" align="center">
<caption><h2>도서정보검색</h2></caption>
	<tr>
		<th>
			<select name="bookkey">
				<option value="bname">도서명
				<option value="bwriter">저자명
				<option value="bcompany">출판사
				<option value="binfo">도서내용
			</select>
		</th>
		<td><input type="text" name="svalue"></td>
	</tr>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="검색하기">
		<input type="button" onclick="location.href='bookout'" value="뒤로가기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>