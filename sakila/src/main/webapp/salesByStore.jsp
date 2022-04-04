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
	
	SalesByStoreDao saleByStoreDao = new SalesByStoreDao();
	
	List<SalesByStore> list = saleByStoreDao.selectSaleByStoreByPage(beginRow, rowPerPage);
	int lastPage = saleByStoreDao.lastPage(beginRow, rowPerPage);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sales By Store</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-warning btn-sm" role="button">홈으로</a>

	<h1 class="text-center">Sales By Store</h1>
	<table class="table">

				<tr class = "table-warning">
				<th class="text-danger" >store</th>
				<th class="text-danger" >manager</th>
				<th class="text-danger">total_sales</th>	
				</tr>

			<%
				for(SalesByStore s : list) {
			
			%>
				<tr>
			      <td><%=s.getStore()%></td>
			      <td><%=s.getManager()%></td>
			      <td><%=s.getTotalSales()%></td>
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
				<a href="<%=request.getContextPath()%>/salesByStore.jsp?currentPage=<%=currentPage-1%>" class="btn btn-warning btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/salesByStore.jsp?currentPage=<%=currentPage+1%>" class="btn btn-warning btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>











