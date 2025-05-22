<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/styles/standard.css"/>">
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<div class="form-wrap">
		<form method="post" action="<c:url value="/boardPost/${boardPost.id}?form"/>">
			<div class="form-row">
				<label class="form-label">
					제목 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<input class="form-input" name="title" value="${boardPost.title}"  required>
				</div>
			</div>
			<div class="form-row">
				<label class="form-label">
					닉네임 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<input class="form-input" name="author_name" value="${boardPost.author_name}" required>
				</div>
			</div>
			<div class="form-row">
				<label class="form-label">
					비밀번호 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<input class="form-input" name="author_pass" type="password"
							value="${boardPost.author_pass}"
						  required>
				</div>
			</div>
			<div class="form-row">
				<label class="form-label">
					글내용 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<textarea rows="5" cols="80" name="content" required>${boardPost.content}</textarea>
				</div>
			</div>
			<button type="submit">글 수정하기</button>
		</form>
	</div>
</body>
</html>