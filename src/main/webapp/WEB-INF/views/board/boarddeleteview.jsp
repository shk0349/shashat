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
<form action="boarddel" method="post">
<table border="5" width="400px" align="center">
<caption><h2>삭제할 게시물정보</h2></caption>
<c:forEach items="${list}" var="board">
	<tr>
		<th>상품번호</th>
		<td><input type="number" name="bnum" value="${board.bnum}" readonly></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="bwriter" value="${board.bwriter}" readonly></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="btitle" value="${board.btitle}" readonly></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><input type="text" name="bcontents" value="${board.bcontents}" readonly></td>
	</tr>
	<tr>
		<th>게시일자</th>
		<td><input type="text" name="bdate" value="${board.bdate}" readonly></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><input type="number" name="bcnt" value="${board.bcnt}" readonly></td>
	</tr>
</c:forEach>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="삭제하기">
		<input type="button" onclick="location.href='boardout'" value="취소하기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>