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
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memdel" method="post">
<table border="5" width="400px" align="center">
<caption><h2>삭제할 회원정보</h2></caption>
<c:forEach items="${list}" var="my">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id" value="${my.id}" readonly></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" value="${my.name}" readonly></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><input type="text" name="tell" value="${my.phone}" readonly></td>
	</tr>
	<tr>
		<th>성별</th>
		<td><input type="text" name="gender" value="${my.gender}" readonly></td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="address" value="${my.address}" readonly></td>
	</tr>
	<tr>
		<th>취미</th>
		<td><input type="text" name="hobby" value="${my.hobby}" readonly></td>
	</tr>
</c:forEach>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="전송하기">
		<input type="button" onclick="location.href='memout'" value="취소하기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>