<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/styles/standard.css"/>">
<title>게시글 보기</title>
<script type="text/javascript">
	function deletePost(postId) {
		console.log(postId);
		//console.log(`/MvcSample2/boardPost/${postId}/delete`);
		if (confirm("정말 삭제하시겠습니까?")) {
			fetch('/MvcSample2/boardPost/' + postId + '/delete', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				}
			})
			.then(response => {
				if (response.redirected) {
					window.location.href = response.url;
				} else {
					alert("삭제 실패");
				}
			})
			.catch(error => {
				alert("삭제 중 오류 발생: " + error);
			});
		} 
	}
</script>
</head>
<body>
	<div>
		<h1>게시글 보기</h1>
		<article>
			<header>
				<h4>${boardPost.title}</h4>
				<dl>
					<dt>작성자</dt>
					<dd>${boardPost.author_name}</dd>
				</dl>
				<dl>
					<dt>작성일</dt>
					<dd>${boardPost.created_at}</dd>
				</dl>
				<dl>
					<dt>조회수</dt>
					<dd>${boardPost.hit}</dd>
				</dl>
			</header>
			<div>${boardPost.content}</div>
		</article>
		<a href="<c:url value="/boardPost/${boardPost.id}?form"/>">수정</a>
		<button type="button" onclick="deletePost(${boardPost.id})">삭제</button>
		
		<a href="<c:url value="/boardPost"/>">목록</a>
	</div>
</body>
</html>











