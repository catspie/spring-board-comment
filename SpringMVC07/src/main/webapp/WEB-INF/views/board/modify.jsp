<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http	s://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body> 
 
<div class="container">
  <h2>Spring MVC</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
    <form action="${cpath}/board/modify" method="post">
    	<table class="table table-bordered">
   			<tr>
	   			<td>번호</td>
	   			<td><input type="text" readonly="readonly" value="${vo.idx}" class="form-control" name="idx"/></td>

   			</tr>
   			<tr>
	   			<td>제목</td>
	   			<td><input type="text" value="${vo.title}" class="form-control" name="title"/></td>	   			
   			</tr>
   			<tr>
	   			<td>내용</td>
	   			<td><textarea rows="10" class="form-control" name="content">${vo.content}</textarea></td>
   			</tr>
   			<tr>
	   			<td>작성자</td>
	   			<td><input type="text" readonly="readonly" value="${vo.writer}" class="form-control" name="writer"/></td>	   			
	   			</tr>
   			<tr>
   				<td colspan="2" style="text-align:center;">
   					<c:if test="${!empty mvo && mvo.memId eq vo.memId}">
	   					<button type="submit" class="btn btn-cm btn-primary">수정</button>
	   					<button type="button" class="btn btn-cm btn-warning" onclick="location.href='${cpath}/board/remove?idx=${vo.idx}'">삭제</button>
   					</c:if>
   					<c:if test="${empty mvo || mvo.memId ne vo.memId}">
	   					<button disabled="disabled" type="submit" class="btn btn-cm btn-primary">수정</button>
	   					<button disabled="disabled" type="button" class="btn btn-cm btn-warning" onclick="location.href='${cpath}/board/remove?idx=${vo.idx}'">삭제</button>
   					</c:if>
   					
   					<button type="button" class="btn btn-cm btn-info" onclick="location.href='${cpath}/board/list'">목록</button>
   				</td>
   			</tr>
    	</table>
    	</form>
    </div>
	<div class="panel-footer">
		<h3>답변형 게시판 만들기</h3>
	</div>
  </div>
</div>
</body>
</html>
