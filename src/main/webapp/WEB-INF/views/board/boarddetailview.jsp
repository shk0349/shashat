<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<form action="boardreply" method="post">
<table border="5" width="550px" align="center">
<caption><h2>${list.btitle} 세부정보</h2></caption>
<input type="hidden" value="${list.bnum}" name="bnum">
	<tr>
		<th>글번호</th>
		<td>${list.bnum}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${list.bwriter}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${list.btitle}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" cols="60">${list.bcontents}</textarea></td>
	</tr>
	<tr>
		<th>작성일자</th>
		<td>${list.bdate}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${list.bcnt}회</td>
	</tr>
	<tr>
		<th colspan="2">
		<input type="submit" value="댓글달기">
		<input type="button" onclick="location.href='boardout'" value="뒤로가기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>