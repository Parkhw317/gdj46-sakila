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

		<h3 class="text-center">테이블 상세보기</h3>
		<a href="<%=request.getContextPath()%>/storeList.jsp" class="btn btn-info btn-block" role="button">Store List로 이동</a>
		<a href="<%=request.getContextPath()%>/staffList.jsp" class="btn btn-warning btn-block" role="button">Staff List로 이동</a>
		
		<h3 class="text-center">뷰 상세보기</h3>
		<!-- view 7개 -->
		<a href="<%=request.getContextPath()%>/actorInfoList.jsp" class="btn btn-info btn-block" role="button">ActorInfo List로 이동</a>
		<a href="<%=request.getContextPath()%>/customerList.jsp" class="btn btn-warning btn-block" role="button">Customer List로 이동</a>
		<a href="<%=request.getContextPath()%>/filmList.jsp" class="btn btn-info btn-block" role="button">Film List로 이동</a>
		<a href="<%=request.getContextPath()%>/nicerButSlowerFilmList.jsp" class="btn btn-warning btn-block" role="button">Nicer But Slower Film List로 이동</a>
		<a href="<%=request.getContextPath()%>/salesByFilmCategory.jsp" class="btn btn-info btn-block" role="button">Sales By Film Category로 이동</a>
		<a href="<%=request.getContextPath()%>/salesByStore.jsp" class="btn btn-warning btn-block" role="button">Sales By Store로 이동</a>
		<a href="<%=request.getContextPath()%>/staffList2.jsp" class="btn btn-info btn-block" role="button">Staff List2로 이동</a>

		 <h3 class="text-center">프로시저</h3>
		<!-- 프로시저 3개 -->
		<a href="<%=request.getContextPath()%>/formFilmInStock.jsp" class="btn btn-warning btn-block" role="button">Film In Stock로 이동</a>
		<a href="<%=request.getContextPath()%>/formFilmNotInStock.jsp" class="btn btn-info btn-block" role="button">Film Not In Stock로 이동</a>
		<a href="<%=request.getContextPath()%>/formRewardsReport.jsp" class="btn btn-warning btn-block" role="button">Reword Report로 이동</a>
		
		<h3 class="text-center">상세 검색</h3>
		<a href="<%=request.getContextPath()%>/filmSearchForm.jsp" class="btn btn-info btn-block" role="button">Film Search Form로 이동</a>
		<a href="<%=request.getContextPath()%>/rentalSearchForm.jsp" class="btn btn-info btn-block" role="button">Rental Search Form로 이동</a>
</div>
</body>

</html>