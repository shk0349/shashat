<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#idcheck").click(function(){
		var id=$("#id").val();
		$.ajax({
			type:"post",
			url:"idcheck2",
			data:{"id":id},
			async:true,
			success:function(data){
				if(data=="available") {
					alert("사용 가능한 아이디입니다...!");
				}
				else {
					alert("해당 아이디는 사용불가합니다... 다시 입력해주세요...");
				}
				
			}
		});
	});
});
</script>
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
<form action="memsave" method="post">
<table border="5" width="600px" align="center">
<caption><h2>회원가입</h2></caption>
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" id="id">
			<input type="button" value="중복확인" id="idcheck">
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>
			<select name="phone1">
    			<option value="010">010</option>
    			<option value="011">011</option>
    			<option value="016">016</option>
			    <option value="017">017</option>
			    <option value="018">018</option>
			    <option value="019">019</option>
			</select>-<input type="text" name="phone2">-<input type="text" name="phone3">
		</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>
			<input type="radio" name="gender" value="남성">남성
			<input type="radio" name="gender" value="여성">여성
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="address"></td>
	</tr>
	<tr>
		<th>취미</th>
		<td>
			<input type="radio" name="hobby" value="요리">요리
			<input type="radio" name="hobby" value="음악감상">음악감상
			<input type="radio" name="hobby" value="영화감상">영화감상
			<input type="radio" name="hobby" value="드라이브">드라이브
			<input type="radio" name="hobby" value="그림">그림
			<input type="radio" name="hobby" value="기타">기타
		</td>
	</tr>
	<tr>
		<th>가입인사</th>
		<td><textarea rows="5" cols="50" name="hello"></textarea></td>
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