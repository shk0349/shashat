<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th, td{
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="5" width="1000px" align="center">
<c:forEach items="${list}" var="book">
<caption><h2>${book.bname} 세부정보</h2></caption>
	<tr>
		<th>도서번호</th>
		<td>${book.bnum}</td>
	</tr>
	<tr>
		<th>도서내용</th>
		<td>${book.binfo}</td>
	</tr>
	<tr>
		<th>표지</th>
		<td><img src="./image/${book.bimage}" width="400px" height="300px"></td>
	</tr>
</c:forEach>	
	<tr>
		<td colspan="2">
		<input type="button" onclick="location.href='bookout'" value="뒤로가기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</td>
	</tr>
</table>
</body>
</html>