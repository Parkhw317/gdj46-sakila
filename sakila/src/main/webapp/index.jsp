<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h1 class="text-center">INDEX</h1>

		<a href="<%=request.getContextPath()%>/storeList.jsp" class="btn btn-info btn-block" role="button">Store List로 이동</a>
		<a href="<%=request.getContextPath()%>/staffList.jsp" class="btn btn-warning btn-block" role="button">Staff List로 이동</a>
		<a href="<%=request.getContextPath()%>/actorInfoList.jsp" class="btn btn-info btn-block" role="button">ActorInfo List로 이동</a>
		<a href="<%=request.getContextPath()%>/customerList.jsp" class="btn btn-warning btn-block" role="button">Customer List로 이동</a>
		<a href="<%=request.getContextPath()%>/filmList.jsp" class="btn btn-info btn-block" role="button">Film List로 이동</a>
		<a href="<%=request.getContextPath()%>/nicerButSlowerFilmList.jsp" class="btn btn-warning btn-block" role="button">Nicer But Slower Film List로 이동</a>
		<a href="<%=request.getContextPath()%>/salesByFilmCategory.jsp" class="btn btn-info btn-block" role="button">Sales By Film Category로 이동</a>
		<a href="<%=request.getContextPath()%>/salesByStore.jsp" class="btn btn-warning btn-block" role="button">Sales By Store로 이동</a>
		<a href="<%=request.getContextPath()%>/staffList2.jsp" class="btn btn-info btn-block" role="button">Staff List2로 이동</a>

</div>
</body>

</html>