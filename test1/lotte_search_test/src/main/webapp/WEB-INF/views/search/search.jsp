<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내가 찾은 검색어</h1>
<c:forEach items="${res }" var="res">
	<div>${res.search_word } <a href="/delsearch?searchIdx=${res.search_idx }">x</a></div>
</c:forEach>
</body>
</html>