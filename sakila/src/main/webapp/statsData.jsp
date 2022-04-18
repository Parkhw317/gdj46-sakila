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
	List<Map<String, Object>> customerRentalCount = statsDateDao.customerRentalCount();
	List<Map<String, Object>> staffRentalCount = statsDateDao.staffRentalCount();
	List<Map<String, Object>> actorFilmCount = statsDateDao.actorFilmCount();
	List<Map<String, Object>> storeFilmCount = statsDateDao.storeFilmCount();
	List<Map<String, Object>> customerStoreCount = statsDateDao.customerStoreCount();
	
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
		
		<h1>고객별 렌탈 횟수</h1>
		<table border="1">
			<tr>
				<td>고객 번호</td>
				<td>고객명</td>
				<td>렌탈 횟수</td>
				
			</tr>
		<%
			for(Map<String, Object> rc : customerRentalCount){
		%>
			<tr>
				<td><%=rc.get("customerId")%></td>
				<td><%=rc.get("customerName")%></td>
				<td><%=rc.get("rentalCount")%></td>
			</tr>
		<%
			}
		%>	
		</table>
	
		<h1>직원별 고객 렌탈 횟수</h1>
		<table border="1">
			<tr>
				<td>직원 번호</td>
				<td>렌탈 횟수</td>
				
			</tr>
		<%
			for(Map<String, Object> sr : staffRentalCount){
		%>
			<tr>
				<td><%=sr.get("staffId")%></td>
				<td><%=sr.get("rentalCount")%></td>
			</tr>
		<%
			}
		%>	
		</table>
		
		<h1>배우별 영화 출연 횟수</h1>
		<table border="1">
			<tr>
				<td>배우 번호</td>
				<td>배우 이름</td>
				<td>출연 횟수</td>
				
			</tr>
		<%
			for(Map<String, Object> af : actorFilmCount){
		%>
			<tr>
				<td><%=af.get("actorId")%></td>
				<td><%=af.get("actorName")%></td>
				<td><%=af.get("count")%></td>
			</tr>
		<%
			}
		%>	
		</table>
		
		<h1>지점별 영화 소지 개수</h1>
		<table border="1">
			<tr>
				<td>지점 번호</td>
				<td>소지 개수</td>
				
			</tr>
		<%
			for(Map<String, Object> sf : storeFilmCount){
		%>
			<tr>
				<td><%=sf.get("storeId")%></td>
				<td><%=sf.get("inventoryCount")%></td>
			</tr>
		<%
			}
		%>	
		</table>
		
		<h1>고객별 지점 이용 횟수</h1>
		<table border="1">
			<tr>
				<td>고객 번호</td>
				<td>지점 번호</td>
				<td>이용 횟수</td>
				
			</tr>
		<%
			for(Map<String, Object> cs : customerStoreCount){
		%>
			<tr>
				<td><%=cs.get("customerId")%></td>
				<td><%=cs.get("storeId")%></td>
				<td><%=cs.get("rentalCount")%></td>
			</tr>
		<%
			}
		%>	
		</table>
	
	
	
	
</body>
</html>