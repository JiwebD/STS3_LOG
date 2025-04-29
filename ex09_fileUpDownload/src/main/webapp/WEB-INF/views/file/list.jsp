<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ${pageContext.request.contextPath}/file/download?dir=${subdir.getName()}&filename=${file.getName()} -->
	<h1>/file/list</h1>
	<div>upload : ${uploadPath}</div>
	
	<c:forEach items='${uploadPath.listFiles()}' var='subdir'>
		<hr/>
		FOLDER : ${subdir.getPath()}
		
		<c:forEach items='${subdir.listFiles()}' var='file'>
		<br/>
		- FILE : 
			<a href="javascript:void(0)" class="item" 
			data-dir="${subdir.getPath()}" data-filename="${file.getName()}">
				${file.getPath()}
			</a>			
		</c:forEach>
		<hr/>
	</c:forEach>
	
	
	<script>
	const projectPath = '${pageContext.request.contextPath}';
	
	const item_els = document.querySelectorAll('.item');
	item_els.forEach((item)=>{
		
		item.addEventListener('click',function(){
			
			const filepath= encodeURIComponent(item.getAttribute('data-dir')+"\\"+item.getAttribute('data-filename'))
			alert(filepath);
			location.href=projectPath+"/file/download?path="+filepath;
		})
		
	})

</script>

</body>
</html>