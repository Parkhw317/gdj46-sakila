<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reword Report</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">	
	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-warning btn-sm" role="button">홈으로</a>
	 <form method="post" action="<%=request.getContextPath() %>/actionRewordReport.jsp">
	
	<h1 class="text-center">Reword Report</h1>
	
		<table class="table">
		
			<tr class = "table-warning">
	            <td>구매 월</td>
	            <td><input type = "number" name = "monthlyPurchases"></td>
	        </tr>
	   
	        <tr class = "table-info">
	            <td>최소 구매 금액(달러)</td>
	            <td><input type = "number" name = "dollarAmountPurchased"></td>
	        </tr>
     
     	 </table>
      <button type = "submit" class = "btn btn-outline-success">입력</button>
   
   </form>
</div>
</body>
</html>