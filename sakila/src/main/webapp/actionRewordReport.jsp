<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>
<%
	

	int monthlyPurchases = Integer.parseInt(request.getParameter("monthlyPurchases"));

	int dollarAmountPurchased = Integer.parseInt(request.getParameter("dollarAmountPurchased"));
	
	RewordReportDao rewordReportDao = new RewordReportDao();
	
	
	Map<String, Object> map = rewordReportDao.rewordRepord(monthlyPurchases, dollarAmountPurchased);
	List<RewordReport> list = (List<RewordReport>)map.get("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reword Report</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">	
	
	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-info btn-sm" role="button">홈으로</a>
	
	<h1 class="text-center">Reword Report</h1>
	<table class="table">

			<tr class = "table-info">
				<th class="text-primary">CustomerId</th>
				<th class="text-primary">StoreId</th>
				<th class="text-primary">FirstName</th>
				<th class="text-primary">LastName</th>	
				<th class="text-primary">Email</th>	
				<th class="text-primary">AddressId</th>	
				<th class="text-primary">Active</th>	
				<th class="text-primary">CreateDate</th>	
				<th class="text-primary">LastUpdate</th>	
				
			</tr>

			<%
				for(RewordReport r : list) {
			
			%>
				<tr>
			      <td><%=r.getCustomerId()%></td>
			      <td><%=r.getStoreId()%></td>
			      <td><%=r.getFirstName()%></td>
			      <td><%=r.getLastName()%></td>
			      <td><%=r.getEmail()%></td>
			      <td><%=r.getAddressId()%></td>
			      <td><%=r.getActive()%></td>
			      <td><%=r.getCreateDate()%></td>
			      <td><%=r.getLastUpdate()%></td>
				</tr>
	  		
	  		<%
	  			}
	  		%>		
	</table>
	</div>
	
	



</body>
</html>