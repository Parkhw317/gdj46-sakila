package dao;
import java.util.*;

import util.DBUtil;

import java.sql.*;
public class StoreDao {
	
	
	public List<Integer> selectStoreIdList(){
		List<Integer> storeList = new ArrayList<Integer>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Integer count = 0;
		
		conn=DBUtil.getConnection();
		
		
		try {
			String sql = "SELECT store_id storeId From store;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt("storeId");
				storeList.add(count);
			}
			
		} catch (Exception e) {
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
		
		return storeList;
	}
	
	
	
	
	
	public List<Map<String, Object>> selectStoreList() {
		List<Map<String, Object>> list = new ArrayList<>(); // 다형성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// Class.forName("org.mariadb.jdbc.Driver");
			// conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sakila","root","java1234");
			conn = DBUtil.getConnection();
			
			/*
				SELECT 
					s1.store_id storeId,
					s1.manager_staff_id staffId, 
					concat(s2.first_name,' ',s2.last_name) staffName,
					s1.address_id addressId,
					CONCAT(a.address, IFNULL(a.address2, ' '), district) staffAddress,
					s1.last_update lastUpdate
				FROM store s1 
					INNER JOIN staff s2
					INNER JOIN address a
				ON s1.manager_staff_id = s2.staff_id 
				AND s1.address_id = a.address_id
			 */
			String sql = "SELECT"
					+ "		s1.store_id storeId,"
					+ "		s1.manager_staff_id staffId,"
					+ "		concat(s2.first_name,' ',s2.last_name) staffName,"
					+ "		s1.address_id addressId,"
					+ "		CONCAT(a.address, IFNULL(a.address2, ' '), district) staffAddress,"
					+ "		s1.last_update lastUpdate"
					+ " FROM store s1"
					+ " INNER JOIN staff s2"
					+ " INNER JOIN address a"
					+ " ON s1.manager_staff_id = s2.staff_id"
					+ " AND s1.address_id = a.address_id;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>(); // 다형성
				map.put("storeId", rs.getInt("storeId"));
				map.put("staffId", rs.getInt("staffId"));
				map.put("staffName", rs.getString("staffName"));
				map.put("addressId", rs.getInt("addressId"));
				map.put("staffAddress", rs.getString("staffAddress"));
				map.put("lastUpdate", rs.getString("lastUpdate"));
				list.add(map);
			}
		} catch (Exception e) { // ClassNotFoundException, SQLException두개의 예외를 부모타입 Exception으로 처리 -> 다형성
			e.printStackTrace();
			System.out.println("예외발생");
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
	
	// selectStoreList() 테스트 코드 
	public static void main(String[] args) {
		StoreDao dao = new StoreDao();
		List<Map<String, Object>> list = dao.selectStoreList();
		for(Map m : list) {
			System.out.println(m.get("storeId")+", ");
			System.out.println(m.get("staffId")+", ");
			System.out.println(m.get("staffName")+", ");
			System.out.println(m.get("addressId")+", ");
			System.out.println(m.get("staffAddress")+", ");
			System.out.println(m.get("lastUpdate")+", ");
			System.out.println("");
		}
	}

}

