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
	
	CustomerListDao customerListDao = new CustomerListDao();
	
	List<CustomerList> list = customerListDao.selectCustomerListByPage(beginRow, rowPerPage);
	int lastPage = customerListDao.lastPage(beginRow, rowPerPage);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-warning btn-sm" role="button">홈으로</a>

	<h1 class="text-center">Customer List</h1>
	<table class="table">

				<tr class = "table-warning">
				<th class="text-danger" >customerId</th>
				<th class="text-danger">customerName</th>
				<th class="text-danger">customerAddr</th>
				<th class="text-danger">zipCode</th>	
				<th class="text-danger">phone</th>	
				<th class="text-danger">city</th>	
				<th class="text-danger">country</th>	
				<th class="text-danger">notes</th>	
				<th class="text-danger">sid</th>	

			</tr>

			<%
				for(CustomerList c : list) {
			
			%>
				<tr>
			      <td><%=c.getCustomerId()%></td>
			      <td><%=c.getCustomerName()%></td>
			      <td><%=c.getCustomerAddr()%></td>
			      <td><%=c.getZipCode()%></td>
			      <td><%=c.getPhone()%></td>
			      <td><%=c.getCity()%></td>
			      <td><%=c.getCountry()%></td>
			      <td><%=c.getNotes()%></td>
			      <td><%=c.getSid()%></td>
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
				<a href="<%=request.getContextPath()%>/customerList.jsp?currentPage=<%=currentPage-1%>" class="btn btn-warning btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/customerList.jsp?currentPage=<%=currentPage+1%>" class="btn btn-warning btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>





</div>
</body>
</html>










