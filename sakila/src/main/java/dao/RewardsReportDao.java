package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBUtil;

public class RewardsReportDao {
	public Map<String, Object> rewardsReport(int monthly , int amount) {
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		// PreparedStatement : 쿼리를 실행
		// CallableStatement : 프로시저를 실행 
		CallableStatement stmt = null;
		ResultSet rs = null;
		// select inventory_id .... 
		List<Integer> list = new ArrayList<>();
		// select count(inventroy_id) ....
		Integer count = 0;
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareCall("{CALL rewards_report(?, ?, ?)}");
			stmt.setInt(1, monthly);
			stmt.setInt(2, amount);
			stmt.registerOutParameter(3, Types.INTEGER);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1));
	
			}
			count = stmt.getInt(3); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		map.put("list", list);
		map.put("count", count);
		return map;
	}
	
	
	// 디버깅
	public static void main(String[] args) { 
		RewardsReportDao rr = new RewardsReportDao();
		int monthly = 7; 
		int amount = 20; 
		Map<String, Object> map = rr.rewardsReport(monthly , amount);
		List<Integer> list = (List<Integer>)map.get("list");
		int count = (Integer)map.get("count");
		
		System.out.println(monthly + "월에 " + amount + "달러 이상 구매한 고객");
		for(int id : list) {
			System.out.println(id);
		}
	}
}
