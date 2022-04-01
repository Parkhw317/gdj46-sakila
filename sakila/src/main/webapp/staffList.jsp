<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<%@ page import = "dao.*" %>
<%
	StaffDao staffDao = new StaffDao();
	List<Map<String, Object>> list = staffDao.selectStaffList();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<div class="container">
<body>
	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-warning btn-sm" role="button">홈으로</a>
	<h1 class="text-center">Staff List</h1>
	<table class="table">
		<thead>
		<tr class = "table-warning">
			<th class="text-danger">staffId</th>
			<th class="text-danger">staffName</th>
			<th class="text-danger">addressId</th>
			<th class="text-danger">email</th>
			<th class="text-danger">storeId</th>
			<th class="text-danger">active</th>
			<th class="text-danger">userName</th>
			<th class="text-danger">password</th>
			<th class="text-danger">lastUpdate</th>
		</tr>
		</thead>
			<tbody>
				<%
					for(Map m : list) {
				%>
			<tr>
				<td><%=m.get("staffId") %></td>
				<td><%=m.get("staffName") %></td>
				<td><%=m.get("addressId") %></td>
				<td><%=m.get("email") %></td>
				<td><%=m.get("storeId") %></td>
				<td><%=m.get("active") %></td>
				<td><%=m.get("userName") %></td>
				<td><%=m.get("password") %></td>
				<td><%=m.get("lastUpdate") %></td>
			</tr>
				<%
					}
				%>
		</tbody>
	</table>
</body>
</div>
</html>