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
<caption><h2>자유게시판</h2></caption>
	<tr>
		<th>글번호</th><th>작성자</th><th>제목</th><th>작성일자</th><th>조회수</th><th>비고</th>
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
		<td><a href="boardupdv?bnum=${board.bnum}">수정</a> / <a href="boarddelv?bnum=${board.bnum}">삭제</a></td>
	</tr>
</c:forEach>
<!-- 페이징처리 4444444444-->
<tr style="border-left: none;border-right: none;border-bottom: none">
   <td colspan="8" style="text-align: center;">
   
   <c:if test="${paging.startPage!=1 }">
      <a href="boardout?nowPage=${paging.startPage-1 }&cntPerPage=${paging.cntPerPage}"></a>
   </c:if>   
      <c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="p"> 
         <c:choose>
            <c:when test="${p == paging.nowPage }">
               <b><span style="color: red;">${p}</span></b>
            </c:when>   
            <c:when test="${p != paging.nowPage }">
               <a href="boardout?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
            </c:when>   
         </c:choose>
      </c:forEach>
      
      <c:if test="${paging.endPage != paging.lastPage}">
      <a href="boardout?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage }">  </a>
   </c:if>
   
   </td>
</tr>
<!-- 페이징처리 4444444444-->
	<tr>
		<td colspan="7" align="center">
			<input type="button" onclick="location.href='boardinput'" value="게시물 작성">
			<input type="button" onclick="location.href='boardsearch'" value="게시물 검색">
			<input type="button" onclick="location.href='main'" value="메인화면">
		</td>
	</tr>
</table>
</body>
</html>