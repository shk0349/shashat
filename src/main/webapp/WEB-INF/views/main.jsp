<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th,td{
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="5" width="450px" align="center">
<caption><h2>메인메뉴</h2></caption>
<tr>
	<th colspan="3"><h4>메뉴선택</h4></th>
</tr>
<tr>
	<td>
		<h4><input type="button" onclick="location.href='meminput'" value="회원정보입력"></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='memout'" value="회원정보출력"></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='memsearch'" value="회원정보검색"></h4>
	</td>
</tr>
<tr>
	<td>
		<h4><input type="button" onclick="location.href='scoreinput'" value="성적입력"></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='scoreout'" value="성적출력"></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='scoresearch'" value="성적검색"></h4>
	</td>
</tr>
<tr>
	<td>
		<h4><input type="button" onclick="location.href='bookinput'" value="도서정보입력"></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='bookout'" value=도서정보출력></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='booksearch'" value="도서정보검색"></h4>
	</td>
</tr>
<tr>
	<td>
		<h4><input type="button" onclick="location.href='boardinput'" value="게시물작성"></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='boardout'" value="게시판보기"></h4>
	</td>
	<td>
		<h4><input type="button" onclick="location.href='boardsearch'" value="게시물검색"></h4>
	</td>
</tr>
<tr>
	<td colspan="3">
		<h4><input type="button" onclick="location.href='musicplay'" value="음악감상"></h4>
	</td>
</tr>
<tr>
	<td colspan="3">
		<img alt="" src="./image/죠까ㅆㅂㄹㅁ-2.gif" width="400px" height="300px">
	</td>
</tr>
</table>
</body>
</html>