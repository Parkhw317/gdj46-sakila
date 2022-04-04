package dao;
import java.util.*;

import util.DBUtil;

import java.sql.*;
public class StaffDao {
	public List <Map<String, Object>> selectStaffList(){
		List<Map<String, Object>> list = new ArrayList<>(); // 다형성
		Connection conn = null; // conn null값 변수 선언
		PreparedStatement stmt = null; // stmt null값 변수 선언
		ResultSet rs = null; // rs null값 변수 선언
		try {
			conn = DBUtil.getConnection();
			// Class.forName("org.mariadb.jdbc.Driver");
			// conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sakila","root","java1234");
			/*
			 	SELECT
				s1.store_id storeId,
				s1.manager_staff_id staffId,
				CONCAT(s2.first_name,' ', s2.last_name) staffName,
				s1.address_id addressId,
				s2.picture picture,
				s2.email email,
				s2.active active,
				s2.username userName,
				s2.password password,
				CONCAT(a.address, ifnull(a.address2, ' '), district) staffAddress,
				s2.last_update
				FROM store s1 INNER JOIN staff s2
				INNER JOIN address a
				ON s1.manager_staff_id = s2.staff_id
				AND s1.address_id = a.address_id; 
			 */
			String sql = "SELECT"
					+ "		s1.store_id storeId,"
					+ "		s1.manager_staff_id staffId,"
					+ "		CONCAT(s2.first_name,' ',s2.last_name) staffName,"
					+ "		s1.address_id addressId,"
				//	+ "		s2.picture picture,"
					+ "		s2.email email,"					
					+ "		s2.active active,"
					+ "		s2.username userName,"
					+ "		s2.password password,"
					+ "		CONCAT(a.address, IFNULL(a.address2, ' '), district) staffAddress,"
					+ "		s2.last_update lastUpdate"
					+ " FROM store s1"
					+ " INNER JOIN staff s2"
					+ " INNER JOIN address a"
					+ " ON s1.manager_staff_id = s2.staff_id"
					+ " AND s1.address_id = a.address_id;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("staffId", rs.getInt("staffId"));
				map.put("staffName", rs.getString("staffName"));
				map.put("addressId", rs.getInt("addressId"));
			//	map.put("picture", rs.getString("picture"));
				map.put("email", rs.getString("email"));
				map.put("storeId", rs.getInt("storeId"));
				map.put("active", rs.getInt("active"));
				map.put("userName", rs.getString("userName"));
				map.put("password", rs.getString("password"));
				map.put("lastUpdate", rs.getString("lastUpdate"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("StaffDao 예외발생");
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
		// selectStaffList() 테스트 코드
		public static void main(String[] args) {
			StaffDao dao = new StaffDao();
			List<Map<String, Object>> list = dao.selectStaffList();
			for(Map m : list) {
				System.out.println(m.get("staffId")+"◀◀◀ StaffId");
				System.out.println(m.get("staffName")+"◀◀◀ staffName");
				System.out.println(m.get("addressId")+"◀◀◀ addressId");
			//	System.out.println(m.get("picture")+"◀◀◀ picture");
				System.out.println(m.get("email")+"◀◀◀ email");
				System.out.println(m.get("storeId")+"◀◀◀ storeId");
				System.out.println(m.get("active")+"◀◀◀ active");
				System.out.println(m.get("userName")+"◀◀◀ userName");
				System.out.println(m.get("password")+"◀◀◀ password");
				System.out.println(m.get("lastUpdate")+"◀◀◀ lastUpdate");
				System.out.println("");
			}
		}
	}
				

	



		
	
	


