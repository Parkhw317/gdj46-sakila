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
import vo.RewardsReport;

public class RewardsReportDao {
	public Map<String, Object> rewardsReport(int monthlyPurchases, int dollarAmountPurchased) {
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		// PreparedStatement : 쿼리를 실행
		// CallableStatement : 프로시저를 실행 
		CallableStatement stmt = null;
		ResultSet rs = null;

		List<RewardsReport> list = new ArrayList<>();

		Integer count = 0;
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareCall("{CALL rewards_report(?, ?, ?)}");
			stmt.setInt(1, monthlyPurchases);
			stmt.setInt(2, dollarAmountPurchased);
			stmt.registerOutParameter(3, Types.INTEGER);
			rs = stmt.executeQuery();
			while(rs.next()) {
				RewardsReport rewardsReport = new RewardsReport();
				rewardsReport.setCustomerId(rs.getInt("customer_id"));
				rewardsReport.setStoreId(rs.getInt("Store_id"));
				rewardsReport.setFirstName(rs.getString("first_name"));
				rewardsReport.setLastName(rs.getString("last_name"));
				rewardsReport.setEmail(rs.getString("email"));
				rewardsReport.setAddressId(rs.getInt("address_id"));
				rewardsReport.setActive(rs.getInt("active"));
				rewardsReport.setCreateDate(rs.getString("create_date"));
				rewardsReport.setLastUpdate(rs.getString("last_update"));
				System.out.println(rewardsReport.toString() + "RewordReport");
				list.add(rewardsReport);


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
		int monthlyPurchases = 7; 
		int dollarAmountPurchased = 20; 
		Map<String, Object> map = rr.rewardsReport(monthlyPurchases , dollarAmountPurchased);
		List<RewardsReport> list = (List<RewardsReport>)map.get("list");
		int count = (Integer)map.get("count");

		System.out.println(monthlyPurchases + "월에 " + dollarAmountPurchased + "달러 이상 구매한 고객");
		for(RewardsReport vo : list) {
			System.out.println(vo.toString());
		}
	}
}