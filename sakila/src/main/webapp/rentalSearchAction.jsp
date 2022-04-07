<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "vo.*" %>
<%
	int rowPerPage = 10;
	int currentPage = 1;


	int storeId = -1;
	if(!request.getParameter("storeId").equals("")) {
		storeId = Integer.parseInt(request.getParameter("storeId"));
	}
	
	String customerName = request.getParameter("customerName");
	String beginDate = request.getParameter("beginDate");
	String endDate = request.getParameter("endDate");
	

	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}

	int beginRow = (currentPage-1)*rowPerPage;
	
	RentalDao rentalDao = new RentalDao();
	
	StoreDao storeDao = new StoreDao();
	List<Integer> storeList = storeDao.selectStoreIdList();
	
	int totalRow = rentalDao.totalRow(storeId, customerName, beginDate, endDate);
	int lastPage = (int)(Math.ceil((double)totalRow/(double)rowPerPage)); 
	
	
	if(totalRow % rowPerPage == 0) {
		lastPage = totalRow / rowPerPage;
	} else {
		lastPage = (totalRow / rowPerPage) + 1;
	}
	
	List<Map<String, Object>> list = rentalDao.selectRentalSearchList(beginRow, rowPerPage, storeId, customerName, beginDate, endDate);
	System.out.println(list +"rentalSearchAction 오류~");
	

	System.out.println("storeId->" + storeId);
	System.out.println("customerName->" + customerName);
	System.out.println("beginDate->" + beginDate);
	System.out.println("endDate->" + endDate);
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rental Search</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<h1 class="text-center">Rental Search</h1>
<h6 class="text-center"><%=totalRow %></h6>

	<table class="table">
	
			<tr class = "table-info">
				<th class="text-primary" >rentalId</th>
				<th class="text-primary">rentalDate</th>
				<th class="text-primary">inventoryId</th>
				<th class="text-primary">customerId</th>	
				<th class="text-primary">returnDate</th>	
				<th class="text-primary">staffId</th>	
				<th class="text-primary">lastUpdate</th>	
				<th class="text-primary">customerName</th>	
				<th class="text-primary">storeId</th>	
				<th class="text-primary">filmId</th>	
				<th class="text-primary">title</th>	
			</tr>
	
	

		<%
			for( Map m : list ) {
		%>
				<tr>
					<td><%=m.get("rentalId")%></td>
					<td><%=m.get("rentalDate")%></td>
					<td><%=m.get("inventoryId")%></td>
					<td><%=m.get("customerId")%></td>
					<td><%=m.get("returnDate")%></td>
					<td><%=m.get("staffId")%></td>
					<td><%=m.get("lastUpdate")%></td>
					<td><%=m.get("customerName")%></td>
					<td><%=m.get("storeId")%></td>
					<td><%=m.get("filmId")%></td>
					<td><%=m.get("title")%></td>
					
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
				<a href="<%=request.getContextPath()%>/rentalSearchAction.jsp?currentPage=<%=currentPage-1%>&storeId=<%=storeId%>&customerName=<%=customerName%>&beginDate=<%=beginDate%>&endDate=<%=endDate%>" class="btn btn-info btn-sm" role="button">이전</a>
				</li></ul>
				
		<%	
			}
		%>
		
		<%
	
			if(currentPage < lastPage) {
		%>
				<ul class="pagination">
				<li class="page-item">
				<a href="<%=request.getContextPath()%>/rentalSearchAction.jsp?currentPage=<%=currentPage+1%>&storeId=<%=storeId%>&customerName=<%=customerName%>&beginDate=<%=beginDate%>&endDate=<%=endDate%>" class="btn btn-info btn-sm" role="button">다음</a>
				</li></ul>
		<%		
			}
		%>
	</div>
	</div>
	
	

</body>
</html>
