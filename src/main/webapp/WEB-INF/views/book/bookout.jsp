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
<table border="5" width="750px" align="center">
<caption><h2>도서정보</h2></caption>
	<tr>
		<th>도서번호</th><th>도서명</th><th>저자명</th><th>출판사</th><th>가격</th><th>출판일자</th><th>조회수</th><th>비고</th>
	</tr>
<c:forEach items="${list}" var="book">
	<tr>
		<td>${book.bnum}</td>
		<td><a href="bookdetv?bnum=${book.bnum}">${book.bname}</a></td>
		<td>${book.bwriter}</td><td>${book.bcompany}</td>
		<td>${book.bprice}원</td><td>${book.bdate}</td><td>${book.bcnt}</td>
		<td><a href="bookupdv?bnum=${book.bnum}">수정</a> / <a href="bookdelv?bnum=${book.bnum}">삭제</a></td>
	</tr>
</c:forEach>
<!-- 페이징처리 4444444444-->
<tr style="border-left: none;border-right: none;border-bottom: none">
   <td colspan="8" style="text-align: center;">
   
   <c:if test="${paging.startPage!=1 }">
      <a href="bookout?nowPage=${paging.startPage-1 }&cntPerPage=${paging.cntPerPage}"></a>
   </c:if>   
      <c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="p"> 
         <c:choose>
            <c:when test="${p == paging.nowPage }">
               <b><span style="color: red;">${p}</span></b>
            </c:when>   
            <c:when test="${p != paging.nowPage }">
               <a href="bookout?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
            </c:when>   
         </c:choose>
      </c:forEach>
      
      <c:if test="${paging.endPage != paging.lastPage}">
      <a href="bookout?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage }">  </a>
   </c:if>
   
   </td>
</tr>
<!-- 페이징처리 4444444444-->
	<tr>
		<td colspan="8" align="center">
			<input type="button" onclick="location.href='bookinput'" value="도서정보추가">
			<input type="button" onclick="location.href='booksearch'" value="도서정보검색">
			<input type="button" onclick="location.href='main'" value="메인화면">
		</td>
	</tr>
</table>
</body>
</html>