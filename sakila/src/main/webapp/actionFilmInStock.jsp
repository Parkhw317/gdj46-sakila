<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.*" %>
<%
	int filmId = 0;
	int storeId = 0;
	
	
	if(request.getParameter("filmId") != null){
		filmId = Integer.parseInt(request.getParameter("filmId"));
	}
	
	if(request.getParameter("storeId") != null){
		storeId = Integer.parseInt(request.getParameter("storeId"));
	}
	
	FilmDao filmdao = new FilmDao();
	
	Map<String, Object> list = filmdao.filmInStockCall(filmId, storeId);
	Map<String, Object> map = filmdao.filmInStockCall(filmId, storeId);
	int count = (int)map.get("count");

	
	/*
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sakila","root","java1234");
	String call = "{call film_in_stock(?, ?, ?)}";
	CallableStatement cstmt = conn.prepareCall(call);
	// 1번 필름이 1번 가게에 남아있는 inventory_id 출력
	cstmt.setInt(1, 1); // 1번 필름
	cstmt.setInt(2, 1); // 1번 가게
	cstmt.registerOutParameter(3, Types.INTEGER);  // 몇개 남았는지 out매개변수
	ResultSet rs = cstmt.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt(1));
	}
	System.out.println(cstmt.getInt(3));
	*/
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film In Stock</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">	
	<a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-warning btn-sm" role="button">홈으로</a>
	
	
	<h1 class="text-center">Film In Stock</h1>
	
		<table class="table">
		
			<tr class = "table-warning">
	            <td>필름 번호</td>
	            <td><%=filmId%></td>
	        </tr>
	   
	        <tr class = "table-info">
	            <td>지점 번호</td>
	            <td><%=storeId%></td>
	        </tr>
     
     		<tr class = "table-warning">
	            <td>재고 수량</td>
	            <td><%=count%></td>
	        </tr>     
     	 </table>
</div>
</body>
</html>
		
		
	









