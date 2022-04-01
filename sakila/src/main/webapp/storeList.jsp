<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "dao.*" %>
<%
	StoreDao storeDao = new StoreDao();
	List<Map<String, Object>> list = storeDao.selectStoreList();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<div class="container">
<body>

	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-info btn-sm" role="button">홈으로</a>
	
	<h1 class="text-center">Store List</h1>
	<table class="table">
		<thead>
			<tr class = "table-info">
				<th class="text-primary" >StoreId</th>
				<th class="text-primary">StaffId</th>
				<th class="text-primary">staffName</th>
				<th class="text-primary">addressId</th>	
				<th class="text-primary">staffAddress</th>
				<th class="text-primary">lastUpdate</th>
			</tr>
			</thead>
		<tbody>
			<%
				for(Map m : list) {
			
			%>
				<tr>
			      <td><%=m.get("storeId")%></td>
			      <td><%=m.get("staffId")%></td>
			      <td><%=m.get("staffName")%></td>
			      <td><%=m.get("addressId")%></td>
			      <td><%=m.get("staffAddress")%></td>
			      <td><%=m.get("lastUpdate")%></td>
				</tr>
	  		
	  		<%
	  			}
	  		%>		
		
		</tbody>
	</table>
</body>
</div>
</html>