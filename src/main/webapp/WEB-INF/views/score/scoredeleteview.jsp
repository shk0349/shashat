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
<form action="scoredel" method="post">
<table border="5" width="1200px" align="center">
<caption><h2>삭제할 성적정보</h2></caption>
<c:forEach items="${list}" var="score">
<input type="hidden" name="sclass" value="${score.sclass}">
<input type="hidden" name="sban" value="${score.sban}">
<input type="hidden" name="sbunho" value="${score.sbunho}">
	<tr>
		<th>학년/반/번호</th><th>이름</th><th>국어점수</th><th>영어점수</th><th>수학점수</th><th>총점수</th><th>평균점수</th><th>학점</th><th>반등수</th><th>전교등수</th>
	</tr>
	<tr>
		<td>${score.sclass}학년 ${score.sban}반 ${score.sbunho}번</td><td>${score.sname}</td>
		<td>${score.kor}점</td><td>${score.eng}점</td><td>${score.mat}점</td><td>${score.tot}점</td><td>${score.avg}점</td>
		<td>${score.hakjum}</td><td>${score.brank}등</td><td>${score.crank}등</td>
	</tr>
</c:forEach>
	<tr>
		<th colspan="10" align="center">
		<input type="submit" value="전송하기">
		<input type="button" onclick="location.href='scoreout'" value="취소하기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>