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
	
	StaffListDao staffListDao = new StaffListDao();
	
	List<StaffList> list = staffListDao.selectStaffListByPage(beginRow, rowPerPage);
	int lastPage = staffListDao .lastPage(beginRow, rowPerPage);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff List2</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-info btn-sm" role="button">홈으로</a>

	<h1 class="text-center">Staff List2</h1>
	<table class="table">

				<tr class = "table-info">
				<th class="text-primary" >StaffId</th>
				<th class="text-primary">StaffName</th>
				<th class="text-primary">address</th>
				<th class="text-primary">zipCode</th>	
				<th class="text-primary">phone</th>	
				<th class="text-primary">city</th>	
				<th class="text-primary">country</th>	
				<th class="text-primary">SID</th>	
			</tr>

			<%
				for(StaffList s : list) {
			
			%>
				<tr>
			      <td><%=s.getStaffId()%></td>
			      <td><%=s.getStaffName()%></td>
			      <td><%=s.getAddress()%></td>
			      <td><%=s.getZipCode()%></td>
			      <td><%=s.getPhone()%></td>
			      <td><%=s.getCity()%></td>
			      <td><%=s.getCountry()%></td>
			      <td><%=s.getSid()%></td>
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
				<a href="<%=request.getContextPath()%>/StaffList2.jsp?currentPage=<%=currentPage-1%>" class="btn btn-info btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/StaffList2.jsp?currentPage=<%=currentPage+1%>" class="btn btn-info btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>










