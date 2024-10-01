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
<table border="5" width="750px" align="center">
<caption><h2>검색한 도서정보</h2></caption>
	<tr>
		<th>도서번호</th><th>도서명</th><th>저자명</th><th>출판사</th><th>가격</th><th>출판일자</th><th>조회수</th>
	</tr>
<c:forEach items="${list}" var="book">
	<tr>
		<td>${book.bnum}</td>
		<td><a href="bookdetv?bnum=${book.bnum}">${book.bname}</a></td>
		<td>${book.bwriter}</td><td>${book.bcompany}</td>
		<td>${book.bprice}원</td><td>${book.bdate}</td><td>${book.bcnt}</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="7" align="center">
			<input type="button" onclick="location.href='booksearch'" value="추가검색">
			<input type="button" onclick="location.href='main'" value="메인화면">
		</td>
	</tr>
</table>
</body>
</html>