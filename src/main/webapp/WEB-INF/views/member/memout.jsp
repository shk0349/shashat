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
<table border="5" width="900px" align="center">
<caption><h2>회원정보</h2></caption>
	<tr>
		<th>아이디</th><th>이름</th><th>전화번호</th><th>성별</th><th>주소</th><th>취미</th><th>가입인사</th><th>비고</th>
	</tr>
<c:forEach items="${list}" var="my">
	<tr>
		<td>${my.id}</td><td>${my.name}</td><td>${my.phone}</td><td>${my.gender}</td><td>${my.address}</td><td>${my.hobby}</td><td>${my.hello}</td>
		<td><a href="memupdv?id=${my.id}">수정</a> / <a href="memdelv?id=${my.id}">삭제</a></td>
	</tr>
</c:forEach>
	<tr>
		<th colspan="8" align="center">
			<input type="button" onclick="location.href='memin'" value="회원정보추가">
			<input type="button" onclick="location.href='memsearch'" value="회원정보검색">
			<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</body>
</html>