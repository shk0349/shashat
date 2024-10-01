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
<table border="5" width="600px" align="center">
<caption><h2>검색한 게시물정보</h2></caption>
	<tr>
		<th>글번호</th><th>작성자</th><th>제목</th><th>작성일자</th><th>조회수</th>
	</tr>
<c:forEach items="${list}" var="board">
	<tr>
		<td>${board.bnum}</td><td>${board.bwriter}</td>
		<td style="text-align:left">
		<c:forEach var="i" begin="1" end="${board.indent}">
			&emsp;☞
		</c:forEach>
		<a href="boarddetail?bnum=${board.bnum}">${board.btitle}</a></td>
		<td>${board.bdate}</td><td>${board.bcnt}회</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="8" align="center">
			<input type="button" onclick="location.href='boardsearch'" value="추가검색">
			<input type="button" onclick="location.href='main'" value="메인화면">
		</td>
	</tr>
</table>
</body>
</html>