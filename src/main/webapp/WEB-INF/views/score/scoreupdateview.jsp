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
<form action="scoreupdate" method="post">
<table border="5" width="600px" align="center">
<caption><h2>수정할 회원정보</h2></caption>
<c:forEach items="${list}" var="score">
	<tr>
		<th>학년</th>
		<td><input type="number" name="sclass" value="${score.sclass}" readonly></td>
	</tr>
		<tr>
		<th>반</th>
		<td><input type="number" name="sban" value="${score.sban}" readonly></td>
	</tr>
		<tr>
		<th>번호</th>
		<td><input type="number" name="sbunho" value="${score.sbunho}" readonly></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="sname" value="${score.sname}" readonly></td>
	</tr>
	<tr>
		<th>국어점수</th>
		<td><input type="number" name="kor"></td>
	</tr>
	<tr>
		<th>영어점수</th>
		<td><input type="number" name="eng"></td>
	</tr>
	<tr>
		<th>수학점수</th>
		<td><input type="number" name="mat"></td>
	</tr>
</c:forEach>
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="전송하기">
		<input type="button" onclick="location.href='scoreout'" value="취소하기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>