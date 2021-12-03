<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<c:set var="modelItem" value="abstract"/>
<%-- ${res[0][modelItem] }
${res[3][modelItem] } --%>
<c:forEach items="${res }" var="resModel" varStatus="status">
	<%-- <div>
		<p>${resModel.idx }</p>
		<p>${resModel.kor_title }</p>
		<p>${resModel.eng_title }</p>
		<p>${res[status.index][modelItem] }</p>
		<p>${resModel.keyword }</p>
		<p>${resModel.createMonth }</p> 
		
		<a href="/discoveryMod?Idx=${resModel.idx }">modify</a>
		<a href="/discoveryDel?Idx=${resModel.idx }">delete</a>
	</div> --%>
	<!-- <form action="/DiscoveryUpdate" method="GET"> -->
	<input type="hidden" id="IDX" name="Idx" value=${resModel.idx }>
	<label>한글 제목 : </label><%-- <input type="text" name="kor_title" value=${resModel.kor_title }> --%><br>
	<textarea id="kor_title" name="kor_title" rows="5" cols="50" >${resModel.kor_title }</textarea><br>
	<label>영어 제목 : </label><%-- <input type="text" name="eng_title" value=${resModel.eng_title }> --%><br>
	<textarea id="eng_title" name="eng_title" rows="5" cols="50" >${resModel.eng_title }</textarea><br>
	<label>내용: </label><%-- <input type="text" name="I_abstract" value=${res[status.index][modelItem] }> --%><br>
	<textarea id="I_abstract" name="I_abstract" rows="5" cols="50">${res[status.index][modelItem] }</textarea><br>
	<label>키워드 : </label><%-- <input type="text" name="I_keyword" value=${resModel.keyword }>--%><br>
	<textarea id="I_keyword" name="I_keyword" rows="5" cols="50">${resModel.keyword }</textarea><br> 
	<!-- <input type="submit" value="수정"> -->
	<button id="subDis">수정</button>
<!-- </form> -->
</c:forEach>

<script>
var kor_title = $("#kor_title").val();
var eng_title = $("#eng_title").val();
var I_abstract = $("#I_abstract").val();
var I_keyword = $("#I_keyword").val();
var Idx = $("#IDX").val();
console.log(kor_title);
console.log(eng_title);
console.log(I_abstract);
console.log(I_keyword);


$('#subDis').on('click',function(){
	kor_title = $("#kor_title").val();
	eng_title = $("#eng_title").val();
	I_abstract = $("#I_abstract").val();
	I_keyword = $("#I_keyword").val();
	Idx = $("#IDX").val();
	
	$.ajax({
	url:'/DiscoveryUpdate',
	data : {'kor_title':kor_title,'eng_title':eng_title,'I_abstract':I_abstract,'I_keyword':I_keyword,"Idx":Idx},
	type:'POST',
	dataType:'json',
	success:function(data){
		
	},error:function(){
		
	}

});
});
</script>


</html>