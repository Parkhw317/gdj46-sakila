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
import vo.RewordReport;

public class RewordReportDao {
	public Map<String, Object> rewordRepord(int monthlyPurchases, int dollarAmountPurchased) {
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		// PreparedStatement : 쿼리를 실행
		// CallableStatement : 프로시저를 실행 
		CallableStatement stmt = null;
		ResultSet rs = null;
	
		List<RewordReport> list = new ArrayList<>();
		
		Integer count = 0;
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareCall("{CALL rewards_report(?, ?, ?)}");
			stmt.setInt(1, monthlyPurchases);
			stmt.setInt(2, dollarAmountPurchased);
			stmt.registerOutParameter(3, Types.INTEGER);
			rs = stmt.executeQuery();
			while(rs.next()) {
				RewordReport rewordReport = new RewordReport();
				rewordReport.setCustomerId(rs.getInt("customer_id"));
				rewordReport.setStoreId(rs.getInt("Store_id"));
				rewordReport.setFirstName(rs.getString("first_name"));
				rewordReport.setLastName(rs.getString("last_name"));
				rewordReport.setEmail(rs.getString("email"));
				rewordReport.setAddressId(rs.getInt("address_id"));
				rewordReport.setActive(rs.getInt("active"));
				rewordReport.setCreateDate(rs.getString("create_date"));
				rewordReport.setLastUpdate(rs.getString("last_update"));
				System.out.println(rewordReport.toString() + "RewordReport");
				list.add(rewordReport);
				
	
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
		RewordReportDao rr = new RewordReportDao();
		int monthlyPurchases = 7; 
		int dollarAmountPurchased = 20; 
		Map<String, Object> map = rr.rewordRepord(monthlyPurchases , dollarAmountPurchased);
		List<RewordReport> list = (List<RewordReport>)map.get("list");
		int count = (Integer)map.get("count");
		
		System.out.println(monthlyPurchases + "월에 " + dollarAmountPurchased + "달러 이상 구매한 고객");
		for(RewordReport vo : list) {
			System.out.println(vo.toString());
		}
	}
}
