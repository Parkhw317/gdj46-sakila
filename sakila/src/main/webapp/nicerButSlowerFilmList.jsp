<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
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
	
	NicerButSlowerFilmListDao nicerButSlowerFilmListDao= new NicerButSlowerFilmListDao();
	
	List<NicerButSlowerFilmList> list = nicerButSlowerFilmListDao.selectNicerButSlowerFilmListByPage(beginRow, rowPerPage);
	int lastPage = nicerButSlowerFilmListDao.lastPage(beginRow, rowPerPage);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nicer But Slower Film List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-warning btn-sm" role="button">홈으로</a>

	<h1 class="text-center">Nicer But Slower Film List</h1>
	<table class="table">

				<tr class = "table-warning">
				<th class="text-danger" >FilmId</th>
				<th class="text-danger">title</th>
				<th class="text-danger">description</th>
				<th class="text-danger">category</th>	
				<th class="text-danger">price</th>	
				<th class="text-danger">length</th>	
				<th class="text-danger">rating</th>	
				<th class="text-danger">actors</th>	
			</tr>

			<%
				for(NicerButSlowerFilmList n : list) {
			
			%>
				<tr>
			      <td><%=n.getFilmId()%></td>
			      <td><%=n.getTitle()%></td>
			      <td><%=n.getDescription()%></td>
			      <td><%=n.getCategory()%></td>
			      <td><%=n.getPrice()%></td>
			      <td><%=n.getLength()%></td>
			      <td><%=n.getRating()%></td>
			      <td><%=n.getActors()%></td>
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
				<a href="<%=request.getContextPath()%>/nicerButSlowerFilmList.jsp?currentPage=<%=currentPage-1%>" class="btn btn-warning btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/nicerButSlowerFilmList.jsp?currentPage=<%=currentPage+1%>" class="btn btn-warning btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>











