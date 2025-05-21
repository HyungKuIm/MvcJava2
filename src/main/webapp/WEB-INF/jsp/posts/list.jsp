<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공관련 게시판</title>
</head>
<body>
	<h1>항공 관련 게시판</h1>
	<table border="1">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${boardPosts}" var="boardPost">
	<tr>
		<td>${boardPost.id}</td>
		<td>${boardPost.title}</td>
		<td>${boardPost.hit}</td>
		<td>${boardPost.created_at}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>