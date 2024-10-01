<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="scoresave" method="post">
<table border="5" width="600px" align="center">
<caption><h2>성적입력</h2></caption>
	<tr>
		<th>학년</th>
		<td>
			<select name="sclass">
    			<option value="1">1</option>
    			<option value="2">2</option>
    			<option value="3">3</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>반</th>
		<td>
			<select name="sban">
    			<option value="1">1</option>
    			<option value="2">2</option>
    			<option value="3">3</option>
			    <option value="4">4</option>
			    <option value="5">5</option>
			    <option value="6">6</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<td><input type="number" name="sbunho"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="sname"></td>
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
	<tr>
		<th colspan="2" align="center">
		<input type="submit" value="전송하기">
		<input type="reset" value="취소하기">
		<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</form>
</body>
</html>