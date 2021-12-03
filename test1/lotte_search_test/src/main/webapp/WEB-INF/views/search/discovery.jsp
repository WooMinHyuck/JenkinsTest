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
<h1>discovery 색인데이터</h1>
<c:set var="modelItem" value="abstract"/>
<%-- ${res[0][modelItem] }
${res[3][modelItem] } --%>
<c:forEach items="${res }" var="resModel" varStatus="status">
	<div>
		<p>${resModel.idx }</p>
		<p>${resModel.kor_title }</p>
		<p>${resModel.eng_title }</p>
		<p>${res[status.index][modelItem] }</p>
		<p>${resModel.keyword }</p>
		<p>${resModel.createMonth }</p> 
		
		<a href="/discoveryMod?Idx=${resModel.idx }">modify</a>
		<a href="/discoveryDel?Idx=${resModel.idx }">delete</a>
	</div>
</c:forEach>
</body>

</html>