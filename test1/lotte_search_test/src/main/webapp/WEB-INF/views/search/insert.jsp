<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/DiscoveryInsert" method="GET">
	<input type="hidden" name="searchIdx" value="0">
	<label>한글 제목 : </label><input type="text" name="kor_title"><br>
	<label>영어 제목 : </label><input type="text" name="eng_title"><br>
	<label>내용 : </label><input type="text" name="I_abstract"><br>
	<label>키워드 : </label><input type="text" name="I_keyword"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>