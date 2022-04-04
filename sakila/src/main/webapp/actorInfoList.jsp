<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>

<%
	
	int currentPage = 1;
	
	if(request.getParameter("currentPage") != null) { 
		 currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}	
	System.out.println(currentPage + "<-- currentPage");
	
	
	int rowPerPage = 10;
	int beginRow = (currentPage-1) * rowPerPage;
	
	
	ActorInfoDao actorinfoDao = new ActorInfoDao();
	
	
	List<ActorInfo> list = actorinfoDao.selectActorInfoListByPage(beginRow, rowPerPage); 
	int lastPage = actorinfoDao.lastPage(beginRow, rowPerPage);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actor Info List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">	
	
	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-info btn-sm" role="button">홈으로</a>
	
	<h1 class="text-center">Actor Info List</h1>
	<table class="table">

			<tr class = "table-info">
				<th class="text-primary" >ActorId</th>
				<th class="text-primary">firstName</th>
				<th class="text-primary">lastName</th>
				<th class="text-primary">filmInfo</th>	
			</tr>

			<%
				for(ActorInfo a : list) {
			
			%>
				<tr>
			      <td><%=a.getActorId()%></td>
			      <td><%=a.getFirstName()%></td>
			      <td><%=a.getLastName()%></td>
			      <td><%=a.getFilmInfo()%></td>
				</tr>
	  		
	  		<%
	  			}
	  		%>		
	</table>
	<br>
	<div class="btn-group">
		<%
			if(currentPage > 1) { 
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/actorInfoList.jsp?currentPage=<%=currentPage-1%>" class="btn btn-info btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/actorInfoList.jsp?currentPage=<%=currentPage+1%>" class="btn btn-info btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>