<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dao.*" %>
<%



	StatsDataDao statsDateDao = new StatsDataDao();
	
	// 1. customer별 총 amount
	List<Map<String, Object>> amountByCustomer = statsDateDao.amountByCustomer();
	List<Map<String, Object>> countByCustomer = statsDateDao.countByCustomer();
	List<Map<String, Object>> filmCountByRentalRate = statsDateDao.filmCountByRentalRate();
	List<Map<String, Object>> filmCountByRating = statsDateDao.filmCountByRating();
	List<Map<String, Object>> languageFilmCount = statsDateDao.languageFilmCount();
	List<Map<String, Object>> lengthFilmCount = statsDateDao.lengthFilmCount();
	List<Map<String, Object>> salesByDay = statsDateDao.salesByDay();
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제액 $180 이상 고객명단</h1>
	<table border="1">
		<tr>
			<td>고객 번호</td>
			<td>고객 이름</td>
			<td>총 결제액</td>
		</tr>
	<%
		for(Map<String, Object> m : amountByCustomer){
	%>
		<tr>
			<td><%=m.get("customerId")%></td>
			<td><%=m.get("name")%></td>
			<td><%=m.get("total")%></td>
		
		</tr>
	<%
		}
	%>
	</table>
	
		<h1>대여횟수 최다고객 명단</h1>
		<table border="1">
			<tr>
				<td>고객 번호</td>
				<td>지점 번호</td>
				<td>firstName</td>
				<td>lastName</td>
				<td>Email</td>
				<td>주소 번호</td>
				<td>활성화 여부</td>
				<td>createDate</td>
				<td>lastUpdate</td>
				
			</tr>
		<%
			for(Map<String, Object> c : countByCustomer){
		%>
			<tr>
				<td><%=c.get("customerId")%></td>
				<td><%=c.get("storeId")%></td>
				<td><%=c.get("firstName")%></td>
				<td><%=c.get("lastName")%></td>
				<td><%=c.get("email")%></td>
				<td><%=c.get("addressId")%></td>
				<td><%=c.get("active")%></td>
				<td><%=c.get("createDate")%></td>
				<td><%=c.get("lastUpdate")%></td>
				
			</tr>
		<%
			}
		%>	
	</table>
	
	
	
	
	<h1>대여가격별 영화 개수</h1>
		<table border="1">
			<tr>
				<td>대여가격 목록</td>
				<td>총 합계</td>
			</tr>
		<%
			for(Map<String, Object> f : filmCountByRentalRate){
		%>
			<tr>
				<td><%=f.get("rentalRate")%></td>
				<td><%=f.get("count")%></td>
			</tr>
		<%
			}
		%>
	</table>
	
	<h1>영화등급별 영화 개수</h1>
		<table border="1">
			<tr>
				<td>영화등급 목록</td>
				<td>총 합계</td>
			</tr>
		<%
			for(Map<String, Object> r : filmCountByRating){
		%>
			<tr>
				<td><%=r.get("rating")%></td>
				<td><%=r.get("count")%></td>
			</tr>
		<%
			}
		%>	
	</table>
	
	<h1>언어별 영화 개수</h1>
		<table border="1">
			<tr>
				<td>언어 목록</td>
				<td>총 합계</td>
			</tr>
		<%
			for(Map<String, Object> l : languageFilmCount){
		%>
			<tr>
				<td><%=l.get("language")%></td>
				<td><%=l.get("count")%></td>
			</tr>
		<%
			}
		%>	
	</table>
	
	<h1>영화시간별 영화 개수</h1>
		<table border="1">
			<tr>
				<td>영화시간 목록</td>
				<td>총 합계</td>
			</tr>
		<%
			for(Map<String, Object> le : lengthFilmCount){
		%>
			<tr>
				<td><%=le.get("length")%></td>
				<td><%=le.get("count")%></td>
			</tr>
		<%
			}
		%>	
	</table>
	
	<h1>매장 요일별 매출</h1>
		<table border="1">
			<tr>
				<td>매장</td>
				<td>요일 번호</td>
				<td>요일</td>
				<td>매출</td>
				
			</tr>
		<%
			for(Map<String, Object> s : salesByDay){
		%>
			<tr>
				<td><%=s.get("storeId")%></td>
				<td><%=s.get("dayNum")%></td>
				<td><%=s.get("dayOfWeek")%></td>
				<td><%=s.get("sales")%></td>
			</tr>
		<%
			}
		%>	
	</table>
	
	
	
</body>
</html>