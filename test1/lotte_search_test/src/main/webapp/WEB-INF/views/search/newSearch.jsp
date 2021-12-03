<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/newsearch" method="post">
	<input type="hidden" name="searchIdx" value="0">
	<label>아이디 : </label><input type="text" name="userId"><br>
	<label>검색어 : </label><input type="text" name="searchWord"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>