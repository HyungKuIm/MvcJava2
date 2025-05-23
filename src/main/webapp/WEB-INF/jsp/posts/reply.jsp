<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/styles/standard.css"/>">
<title>답글 쓰기</title>
</head>
<body>
	<h1>답글 쓰기</h1>
	<div class="form-wrap">
		<form method="post" action="<c:url value="/boardPost/${boardPost.id}/reply"/>">
			<div class="form-row">
				<label class="form-label">
					제목 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<input class="form-input" name="title" value="${boardPost.title}" required>
				</div>
			</div>
			<div class="form-row">
				<label class="form-label">
					닉네임 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<input class="form-input" name="author_name" required>
				</div>
			</div>
			<div class="form-row">
				<label class="form-label">
					비밀번호 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<input class="form-input" name="author_pass" type="password"  required>
				</div>
			</div>
			<div class="form-row">
				<label class="form-label">
					글내용 <span class="required">(필수 입력)</span>
				</label>
				<div class="form-input-wrap">
					<textarea rows="5" cols="80" name="content" required></textarea>
				</div>
			</div>
			<button type="submit">답글 작성하기</button>
		</form>
	</div>
</body>
</html>