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
<form action="bookdel" method="post">
<table border="5" width="400px" align="center">
<caption><h2>삭제할 도서정보</h2></caption>
<c:forEach items="${list}" var="book">
	<tr>
		<th>도서번호</th>
		<td><input type="number" name="bnum" value="${book.bnum}" readonly></td>
	</tr>
	<tr>
		<th>도서명</th>
		<td><input type="text" name="bname" value="${book.bname}" readonly></td>
	</tr>
	<tr>
		<th>저자명</th>
		<td><input type="text" name="bwriter" value="${book.bwriter}" readonly></td>
	</tr>
	<tr>
		<th>출판사</th>
		<td><input type="text" name="bcompany" value="${book.bcompany}" readonly></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="number" name="bprice" value="${book.bprice}" readonly></td>
	</tr>
	<tr>
		<th>출판일</th>
		<td><input type="text" name="bdate" value="${book.bdate}" readonly></td>
	</tr>
	<tr>
		<th>도서내용</th>
		<td><input type="text" name="bdate" value="${book.binfo}" readonly></td>
	</tr>
</c:forEach>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="삭제하기">
		<input type="reset" value="취소하기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>