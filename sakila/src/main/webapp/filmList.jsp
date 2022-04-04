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
	
	FilmListDao filmListDao = new FilmListDao();
	
	List<FilmList> list = filmListDao.selectFilmListByPage(beginRow, rowPerPage);
	int lastPage = filmListDao.lastPage(beginRow, rowPerPage);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-info btn-sm" role="button">홈으로</a>

	<h1 class="text-center">Film List</h1>
	<table class="table">

				<tr class = "table-info">
				<th class="text-primary" >FilmId</th>
				<th class="text-primary">title</th>
				<th class="text-primary">description</th>
				<th class="text-primary">category</th>	
				<th class="text-primary">price</th>	
				<th class="text-primary">length</th>	
				<th class="text-primary">rating</th>	
				<th class="text-primary">actors</th>	
			</tr>

			<%
				for(FilmList f : list) {
			
			%>
				<tr>
			      <td><%=f.getFilmId()%></td>
			      <td><%=f.getTitle()%></td>
			      <td><%=f.getDescription()%></td>
			      <td><%=f.getCategory()%></td>
			      <td><%=f.getPrice()%></td>
			      <td><%=f.getLength()%></td>
			      <td><%=f.getRating()%></td>
			      <td><%=f.getActors()%></td>
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
				<a href="<%=request.getContextPath()%>/filmList.jsp?currentPage=<%=currentPage-1%>" class="btn btn-info btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/filmList.jsp?currentPage=<%=currentPage+1%>" class="btn btn-info btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>










