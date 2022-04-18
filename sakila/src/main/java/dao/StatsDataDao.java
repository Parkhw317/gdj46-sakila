package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBUtil;

public class StatsDataDao {
	public List<Map<String, Object>> amountByCustomer(){ // 1. 제일 많이(금액) 빌려간 사람 내림차순

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql = "SELECT p.customer_id customerId,"
		            + "      concat(c.first_name,' ', c.last_name) name,"
		            + "      sum(p.amount) total"
		            + "      FROM payment p INNER JOIN customer c"
		            + "      ON p.customer_id = c.customer_id"
		            + "      GROUP BY p.customer_id"
		            + "      HAVING sum(p.amount) >= 180"
		            + "      ORDER BY SUM(p.amount) DESC";
	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			  while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("customerId",rs.getInt("customerId"));
		            m.put("name",rs.getString("name"));
		            m.put("total",rs.getInt("total"));
		            list.add(m);
		            System.out.println(list + "amountByCustomer");
			  }
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       return list;
	    }
	
	
	public List<Map<String, Object>> countByCustomer(){ // 2. 제일 많이(횟수) 빌려간 사람 누구?

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql = "SELECT * "
		            + "      FROM customer"
		            + "      WHERE customer_id = (SELECT customer_id"
		            + "      FROM payment"
		            + "      GROUP BY customer_id"
		            + "      ORDER BY COUNT(*) DESC"
		            + "      LIMIT 0, 1);";
	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			  while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("customerId",rs.getString("customer_id"));
		            m.put("storeId",rs.getInt("store_id"));
		            m.put("firstName",rs.getString("first_name"));
		            m.put("lastName",rs.getString("last_name"));
		            m.put("email",rs.getString("email"));
		            m.put("addressId",rs.getInt("address_id"));
		            m.put("active",rs.getString("active"));
		            m.put("createDate",rs.getString("create_date"));
		            m.put("lastUpdate",rs.getString("last_update"));
		            list.add(m);
		            System.out.println(list + "countByCustomer");
			  }
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       return list;
	}
	
	
	public List<Map<String, Object>> filmCountByRentalRate(){ // 3. rental_rate별 영화 개수
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql = "SELECT rental_rate, COUNT(*)"
		            + "      FROM film"
		            + "      GROUP BY rental_rate"
		            + "      ORDER BY COUNT(*) DESC;";

	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			  while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("rentalRate",rs.getDouble("rental_rate"));
		            m.put("count",rs.getString("count(*)"));
		            list.add(m);
		            System.out.println(list + "filmCountByRentalRate");
			  }
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       return list;
		
		
		
	}
	
	
	public List<Map<String, Object>> filmCountByRating(){ // 4. rating별 영화 개수
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql = "SELECT rating, COUNT(*)"
		            + "      FROM film"
		            + "      GROUP BY rating"
		            + "      ORDER BY COUNT(*) DESC;";

	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			  while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("rating",rs.getString("rating"));
		            m.put("count",rs.getString("count(*)"));
		            list.add(m);
		            System.out.println(list + "filmCountByRating");
			  }
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       return list;

	}
	
	public List<Map<String, Object>> languageFilmCount(){ // 5. Language별 영화 개수
			
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			conn = DBUtil.getConnection();
			
			String sql = "SELECT l.name, COUNT(*)"
			            + "      FROM film f INNER JOIN language l"
			            + "      ON f.language_id = l.language_id"
			            + "      GROUP BY l.name;";
	
		
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				  while(rs.next()) {
			            Map<String, Object> m = new HashMap<>();
			            m.put("language",rs.getString("name"));
			            m.put("count",rs.getString("count(*)"));
			            list.add(m);
			            System.out.println(list + "languageFilmCount");
				  }
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			} finally {
		         try {
		             rs.close();
		             stmt.close();
		             conn.close();
		          } catch (SQLException e) {
		             e.printStackTrace();
		          }
		       }
		       return list;
	
		}
	
	public List<Map<String, Object>> lengthFilmCount(){ // 6. length별 영화 개수(구간, 기준을 정해서)
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql = "SELECT t.length2, COUNT(*)"
		            + "      FROM (SELECT title, LENGTH,"
		            + "      case when LENGTH<=60 then'less 60'"
		            + "      when LENGTH BETWEEN 61 AND 120 then 'between 60 and 120'"
					+ "      when LENGTH BETWEEN 121 AND 180 then 'between 121 and 180'"
					+ "      ELSE 'more 180'"
					+ "      END LENGTH2"
					+ "      FROM film) t"
					+ "      GROUP BY t.length2;";
		 

	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			  while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("length",rs.getString("length2"));
		            m.put("count",rs.getString("count(*)"));
		            list.add(m);
		            System.out.println(list + "lengthFilmCount");
			  }
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       return list;

	}

	public List<Map<String, Object>> salesByDay(){ // 7. store 매장 요일별 매출 (월화수목금토일)
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql = "SELECT s.store_id, t.w, case t.w"
		            + "      when 0 then 'Mon'"
		            + "      when 1 then 'Tue'"
		            + "      when 2 then 'Wed'"
					+ "      when 3 then 'Thu'"
					+ "      when 4 then 'Fri'"
					+ "      when 5 then 'Sat'"
					+ "      when 6 then 'Sun'"
					+ "      END DAYOFWEEK, t.c"
					+ "      FROM (SELECT staff_id, WEEKDAY(payment_date) w, COUNT(*) c"
					+ "      FROM payment"
					+ "      GROUP BY staff_id, WEEKDAY(payment_date)) t"
					+ "      INNER JOIN staff s"
					+ "      ON t.staff_id = s.staff_id"
					+ "      ORDER BY s.store_id, t.w ASC;";

	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			  while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("storeId",rs.getString("store_id"));
		            m.put("dayNum",rs.getString("w"));
		            m.put("dayOfWeek",rs.getString("DAYOFWEEK"));
		            m.put("sales",rs.getString("c"));
		            list.add(m);
		            System.out.println(list + "SalesByDay");
			  }
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       return list;

	}
	
	
public List<Map<String, Object>> customerRentalCount(){ // 8. customer별 빌린 횟수
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql = "SELECT r.customer_id,"
				+ " CONCAT(c.first_name,' ',c.last_name) name,"
				+ " COUNT(*) rentalCount"
				+ " FROM rental r INNER JOIN customer c"
				+ " ON r.customer_id = c.customer_id"
				+ " GROUP BY r.customer_id"
				+ " ORDER BY r.customer_id ASC;";

		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			  while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("customerId",rs.getInt("customer_id"));
		            m.put("customerName",rs.getString("name"));
		            m.put("rentalCount",rs.getInt("rentalCount"));
		            list.add(m);
		            System.out.println(list + "custometRentalCount");
			  }
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
	         try {
	             rs.close();
	             stmt.close();
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       return list;

	}	
	
public List<Map<String, Object>> staffRentalCount(){ // 9. staff별 고객에게 rental 횟수
	
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	conn = DBUtil.getConnection();
	
	String sql = "SELECT r.staff_id, COUNT(*) rentalCount"
				+ " FROM rental r INNER JOIN store s"
				+ " ON r.staff_id = s.manager_staff_id"
				+ " GROUP BY r.staff_id;";


	try {
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		  while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("staffId",rs.getInt("staff_id"));
	            m.put("rentalCount",rs.getString("rentalCount"));
	            list.add(m);
	            System.out.println(list + "staffRentalCount");
		  }
		
	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
         try {
             rs.close();
             stmt.close();
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }
       }
       return list;

}	
	
public List<Map<String, Object>> actorFilmCount(){ // 10. actor별 영화 출연 횟수
	
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	conn = DBUtil.getConnection();
	
	String sql = "SELECT f.actor_id,"
			+ " CONCAT(a.first_name,' ',a.last_name) name,"
			+ " COUNT(*) count"
			+ " FROM film_actor f INNER JOIN actor a"
			+ " ON f.actor_id = a.actor_id"
			+ " GROUP BY f.actor_id"
			+ " ORDER BY f.actor_id ASC;";


	try {
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		  while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("actorId",rs.getInt("actor_id"));
	            m.put("actorName",rs.getString("name"));
	            m.put("count",rs.getInt("count"));
	            
	            list.add(m);
	            System.out.println(list + "actorFilmCount");
		  }
		
	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
         try {
             rs.close();
             stmt.close();
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }
       }
       return list;

}	
	
public List<Map<String, Object>> storeFilmCount(){ // 11. store별 영화 소지 개수
	
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	conn = DBUtil.getConnection();
	
	String sql = "SELECT s.store_id,"
			+ " COUNT(*) inventoryCount"
			+ " FROM store s INNER JOIN inventory i"
			+ " ON s.store_id = i.store_id"
			+ " GROUP BY s.store_id;";


	try {
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		  while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("storeId",rs.getInt("store_id"));
	            m.put("inventoryCount",rs.getInt("inventoryCount"));
	            
	            list.add(m);
	            System.out.println(list + "storeFilmCount");
		  }
		
	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
         try {
             rs.close();
             stmt.close();
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }
       }
       return list;

}	
	
public List<Map<String, Object>> customerStoreCount(){ // 12. customer별 store를 이용한 횟수
	
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	conn = DBUtil.getConnection();
	
	String sql = "SELECT r.customer_id,"
			+ " s.store_id,"
			+ " COUNT(*) rentalCount"
			+ " FROM rental r"
			+ " INNER JOIN staff s"
			+ " ON r.staff_id = s.staff_id"
			+ " GROUP BY r.customer_id, s.store_id;";

	try {
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		  while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("customerId",rs.getInt("customer_id"));
	            m.put("storeId",rs.getInt("store_id"));
	            m.put("rentalCount",rs.getInt("rentalCount"));
	      
	            list.add(m);
	            System.out.println(list + "customerStoreCount");
		  }
		
	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
         try {
             rs.close();
             stmt.close();
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }
       }
       return list;

}	
	
	
	
	
}







