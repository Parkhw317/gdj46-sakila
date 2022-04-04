<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<div class="container">
<body>
	<h1 class="text-center">INDEX</h1>

		<a href="<%=request.getContextPath()%>/storeList.jsp" class="btn btn-info btn-block" role="button">Store List로 이동</a>
		<a href="<%=request.getContextPath()%>/staffList.jsp" class="btn btn-warning btn-block" role="button">Staff List로 이동</a>
		<a href="<%=request.getContextPath()%>/actorInfoList.jsp" class="btn btn-secondary btn-block" role="button">ActorInfo List로 이동</a>
		

	
</body>
</div>
</html>