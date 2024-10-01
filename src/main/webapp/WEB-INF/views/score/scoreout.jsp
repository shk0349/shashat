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
<table border="5" width="1200px" align="center">
<caption><h2>시험결과</h2></caption>
	<tr>
		<th>학년 / 반 / 번호</th><th>이름</th><th>국어점수</th><th>영어점수</th><th>수학점수</th><th>총점수</th><th>평균점수</th><th>학점</th><th>반등수</th><th>전교등수</th><th>비고</th>
	</tr>
<c:forEach items="${list}" var="score">
	<tr>
		<td>${score.sclass}학년 ${score.sban}반 ${score.sbunho}번</td><td>${score.sname}</td>
		<td>${score.kor}점</td><td>${score.eng}점</td><td>${score.mat}점</td><td>${score.tot}점</td><td>${score.avg}점</td>
		<td>${score.hakjum}</td><td>${score.sclass}학년 ${score.sban}반 ${score.brank}등</td><td>전교 ${score.crank}등</td>
		<td><a href="scoreupdv?sclass=${score.sclass}&sban=${score.sban}&sbunho=${score.sbunho}">수정</a> / 
		<a href="scoredelv?sclass=${score.sclass}&sban=${score.sban}&sbunho=${score.sbunho}">삭제</a></td>
	</tr>
</c:forEach>
<!-- 페이징처리 4444444444-->
<tr style="border-left: none;border-right: none;border-bottom: none">
   <td colspan="11" style="text-align: center;">
   
   <c:if test="${paging.startPage!=1 }">
      <a href="scoreout?nowPage=${paging.startPage-1 }&cntPerPage=${paging.cntPerPage}"></a>
   </c:if>   
      <c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="p"> 
         <c:choose>
            <c:when test="${p == paging.nowPage }">
               <b><span style="color: red;">${p}</span></b>
            </c:when>   
            <c:when test="${p != paging.nowPage }">
               <a href="scoreout?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
            </c:when>   
         </c:choose>
      </c:forEach>
      
      <c:if test="${paging.endPage != paging.lastPage}">
      <a href="scoreout?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage }">  </a>
   </c:if>
   
   </td>
</tr>
<!-- 페이징처리 4444444444-->
	<tr>
		<th colspan="11" align="center">
			<input type="button" onclick="location.href='scoreinput'" value="성적추가">
			<input type="button" onclick="location.href='scoresearch'" value="성적검색">
			<input type="button" onclick="location.href='main'" value="메인화면">
		</th>
	</tr>
</table>
</body>
</html>