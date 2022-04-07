<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<%@ page import = "dao.*"%>
<%@ page import = "vo.*"%>
<%
	String category = request.getParameter("category");
	String rating = request.getParameter("rating");
	double price = -1; // price 데이터가 입력되지 않았을때
	if(!request.getParameter("price").equals("")) {
		price = Double.parseDouble(request.getParameter("price"));
	}
	int length = -1; // length 데이터가 입력되지 않았을때
	if(!request.getParameter("length").equals("")) {
		length = Integer.parseInt(request.getParameter("length"));
	}
	String title = request.getParameter("title");
	String actors = request.getParameter("actors");
	
	
	int rowPerPage = 10;
	int lastPage = 0;
	int currentPage = 1;
	int beginRow = (currentPage-1)*rowPerPage;
	
	
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	System.out.println(currentPage + "<-- currentPage");
	
	
	// 디버깅
	System.out.println("category->" + category);
	System.out.println("rating->" + rating);
	System.out.println("price->" + price);
	System.out.println("length->" + length);
	System.out.println("title->" + title);
	System.out.println("category->" + category);
	System.out.println("actors->" + actors);
	

	FilmDao filmDao = new FilmDao();
	List<FilmList> list = filmDao.selectFilmListSearch(beginRow ,rowPerPage ,category, rating, price, length, title, actors);
	System.out.println(list.size()); // 0
	
	int totalRow = filmDao.totalRow(category, rating, price, length, title, actors);
	
	
	if(totalRow % rowPerPage == 0) {
		lastPage = totalRow / rowPerPage;
	} else {
		lastPage = (totalRow / rowPerPage) + 1;
	}
	
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<h1 class="text-center">Film List</h1>
<h6 class="text-center"><%=totalRow %></h6>
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
				<a href="<%=request.getContextPath()%>/filmSearchAction.jsp?currentPage=<%=currentPage-1%>&category=<%=category%>&rating=<%=rating%>&price=<%=price%>
      &length=<%=length%>&title=<%=title%>&actosr=<%=actors%>" class="btn btn-info btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/filmSearchAction.jsp?currentPage=<%=currentPage+1%>&category=<%=category%>&rating=<%=rating%>&price=<%=price%>
      &length=<%=length%>&title=<%=title%>&actors=<%=actors%>" class="btn btn-info btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>
