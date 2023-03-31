<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

<meta charset="UTF-8">
<title>질문 응답 사이트</title>
<style>
.container {
	width: 80%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="animate__animated animate__fadeInDown">질문하세요</h1>
		<form action="/ask" method="POST" class="animate__animated animate__bounce">
			<label for="question">질문:</label> <input type="text" name="question"
				id="question" required>
			<button type="submit">질문하기</button>
		</form>
		<hr>
		<c:if test="${not empty question}">
			<div>
				<h3>질문: ${question}</h3>
				<h3>답변: ${answer}</h3>
			</div>
		</c:if>
	</div>
</body>
</html>
