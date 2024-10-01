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
<caption><h2>음악재생</h2></caption>
<tr>
	<th><h4>가수</h4></th><th><h4>노래</h4></th><th><h4>재생버튼</h4></th>
</tr>
<tr>
	<th><h4>먼데이키즈</h4></th><th><h4>Bye Bye Bye</h4></th>
	<th><audio controls><source src="./resources/music/Monday Kiz - Bye Bye Bye.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>먼데이키즈</h4></th><th><h4>이런남자</h4></th>
	<th><audio controls><source src="./resources/music/Monday Kiz - 이런 남자.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>먼데이키즈</h4></th><th><h4>남자야</h4></th>
	<th><audio controls><source src="./resources/music/Monday Kiz - 남자야.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>먼데이키즈</h4></th><th><h4>가슴으로 외쳐(Feat. Rhymer)</h4></th>
	<th><audio controls><source src="./resources/music/Monday Kiz - 가슴으로 외쳐 (Feat. Rhymer).mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>먼데이키즈</h4></th><th><h4>발자국</h4></th>
	<th><audio controls><source src="./resources/music/Monday Kiz - 발자국.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>바이브</h4></th><th><h4>술이야</h4></th>
	<th><audio controls><source src="./resources/music/Vibe - 술이야.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>이지훈</h4></th><th><h4>인형(Duet With 신혜성)</h4></th>
	<th><audio controls><source src="./resources/music/이지훈 - 인형 (Duet With 신혜성).mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>김범수</h4></th><th><h4>보고싶다</h4></th>
	<th><audio controls><source src="./resources/music/김범수 - 보고 싶다.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>김범수</h4></th><th><h4>제발</h4></th>
	<th><audio controls><source src="./resources/music/김범수 - 제발.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>윤하</h4></th><th><h4>기다리다</h4></th>
	<th><audio controls><source src="./resources/music/윤하 - 기다리다.mp3" type="audio/mp3"></audio></th>
</tr>
<tr>
	<th><h4>윤하</h4></th><th><h4>오늘 헤어졌어요</h4></th>
	<th><audio controls><source src="./resources/music/윤하 - 오늘 헤어졌어요.mp3" type="audio/mp3"></audio></th>
</tr>
	<tr>
		<td colspan="3" align="center">
		<h4><input type="button" onclick="location.href='main'" value="메인화면"></h4>
		</td>
	</tr>
</table>
</body>
</html>