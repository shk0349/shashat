<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 20px;
        background-image: url('./resources/image/블루패브릭.jpg');
        background-size: cover; /* 이미지가 화면 전체를 덮도록 설정 */
        background-position: center; /* 이미지를 가운데에 배치 */
        background-repeat: no-repeat; /* 이미지를 반복하지 않음 */
        background-attachment: fixed; /* 배경이 고정된 상태로 스크롤 */
    }
h3
{
 text-align: center;
 background-color: #fee1d1; 
 border-radius: 30px;
 
}
p
{
text-align: right;
}
.navbar-inverse {
	font-family: Arial, sans-serif;
	font-size: 18px;
    background-color: rgba(255, 255, 255, 0.5) !important; /* 흰색, 투명도 50% */
    border-color: rgba(255, 255, 255, 0.5) !important; /* 테두리도 동일한 투명도 적용 */
    border-bottom: 2px solid #94c3ef !important; /* 바 하단 검은색 라인 */
}

/* 기본 링크 스타일 - hover 상태에서 색상 변화 없음 */
.navbar-inverse .navbar-nav > li > a {
    color: #000 !important;  /* 기본 글씨 색상 검정 */
    background-color: transparent !important;  /* 배경색 투명 */
}
/* 상단 메뉴바 (스크롤 내려오는거) */
/* hover 상태에서 색상 및 배경 변화 제거 */
.navbar-inverse .navbar-nav > li > a:hover {
    color: white !important;  /* hover 상태에서도 색상 변화 없음 */
    background-color: #94c3ef !important;  /* 배경색 변화 없음 */
}

/* Home 버튼 */
/* Active 상태에서만 스타일 적용 */
.navbar-inverse .navbar-nav > li.active > a {
    color: #white !important;  /* active 상태에서 더 어두운 글씨색 */
    border-radius: 4px;  /* 모서리 둥글게 */
}

/* 타이틀 영역 */
.navbar-inverse .container-fluid .navbar-header > a{
	font-family: Arial, sans-serif;
	font-size: 25px;
	font-weight: bold;
	letter-spacing: 2px;
	color: #666666;
}
</style>

<script type="text/javascript">
		
		
	function timer(){
			var nt=document.getElementById("nowtime");
			nt.innerHTML=(new Date()).toLocaleTimeString();
		}
			setInterval("timer()",1000);
				
			</script>				
		
		

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">잡다구리</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main">Home</a></li>

         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리<span class="caret"></span></a>
     		<ul class="dropdown-menu">
          		<li><a href="meminput">회원정보입력</a></li>
          		<li><a href="memout">회원정보출력</a></li>
          		<li><a href="memsearch">회원정보검색</a></li>
        	</ul>
      	 </li>

         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">성적관리<span class="caret"></span></a>
     		<ul class="dropdown-menu">
          		<li><a href="scoreinput">성적입력</a></li>
          		<li><a href="scoreout">성적출력</a></li>
          		<li><a href="scoresearch">성적검색</a></li>
        	</ul>
      	 </li>
      
         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">도서관리<span class="caret"></span></a>
     		<ul class="dropdown-menu">
          		<li><a href="bookinput">도서정보입력</a></li>
          		<li><a href="bookout">도서정보출력</a></li>
          		<li><a href="booksearch">도서정보검색</a></li>
        	</ul>
      	 </li>

         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">자유게시판<span class="caret"></span></a>
     		<ul class="dropdown-menu">
          		<li><a href="boardinput">게시물작성</a></li>
          		<li><a href="boardout">게시판보기</a></li>
          		<li><a href="boardsearch">게시물검색</a></li>
          		<li><a href="musicplay">음악감상</a></li>
        	</ul>
      	 </li>
    
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><p id="nowtime"></p></a></li>
<c:choose>
	<c:when test="${loginstate==true}">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> ${member.id}님 반갑습니다.</a></li>
	      	<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
	</c:when>
	
	<c:when test="${adminloginstate==true}">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> 관리자님 반갑습니다.</a></li>
	      	<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
	</c:when>

	<c:otherwise>
			<li><a href="meminput"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
	      	<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	</c:otherwise>
</c:choose>
    </ul>
  </div>
</nav>
  
</body>
</html>