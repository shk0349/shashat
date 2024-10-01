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
<form action="bookupd" method="post" enctype="multipart/form-data">
<table border="5" width="400px" align="center">
<caption><h2>수정할 회원정보</h2></caption>
<c:forEach items="${list}" var="book">
	<tr>
		<th>도서번호</th>
		<td><input type="number" name="bnum" value="${book.bnum}" readonly></td>
	</tr>
	<tr>
		<th>도서명</th>
		<td><input type="text" name="bname"></td>
	</tr>
	<tr>
		<th>저자명</th>
		<td><input type="text" name="bwriter"></td>
	</tr>
	<tr>
		<th>출판사</th>
		<td><input type="text" name="bcompany"></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="number" name="bprice"></td>
	</tr>
	<tr>
		<th>출판일</th>
		<td><input type="date" name="bdate"></td>
	</tr>
	<tr>
		<th>도서내용</th>
		<td><textarea rows="5" cols="25" name="binfo"></textarea></td>
	</tr>
	<tr>
		<th>표지</th>
		<td><input type="file" name="bimage"></td>
	</tr>
</c:forEach>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="수정하기">
		<input type="reset" value="취소하기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>