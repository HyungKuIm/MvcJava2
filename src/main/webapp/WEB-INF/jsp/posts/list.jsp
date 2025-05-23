<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/styles/standard.css"/>">
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
		<td>
			<c:if test="${boardPost.reply > 0}">
				<c:forEach begin="0" end="${boardPost.reply}">
					&nbsp;&nbsp;
				</c:forEach>
			
				<img src="<c:url value="/resources/images/re.png"/>">
			</c:if>
			<a href="<c:url value="/boardPost/${boardPost.id}"/>">${boardPost.title}</a>
		</td>
		<td>${boardPost.hit}</td>
		<td>${boardPost.created_at}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<a href="<c:url value="/boardPost?form"/>">게시글 쓰기</a>
</body>
</html>
