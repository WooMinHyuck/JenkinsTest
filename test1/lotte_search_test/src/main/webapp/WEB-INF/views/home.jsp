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
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p><a href="/search">내가 찾은 검색어 보기</a></p>
<p><a href="/newsearch">검색어 등록</a></p>
<p><a href="/discovery">디스커버리</a></p>
<p><a href="/insert">디스커버리 데이터등록</a></p>

</body>
</html>
