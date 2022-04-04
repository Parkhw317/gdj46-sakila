package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.SalesByStore;

public class SalesByStoreDao {

	public List<SalesByStore> selectSaleByStoreByPage(int beginRow, int rowPerPage){
		List<SalesByStore> list = new ArrayList<SalesByStore>();
		
		Connection conn = null;
		conn = DBUtil.getConnection();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sales_by_store";

	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
		
			while(rs.next()) {
				SalesByStore saleByStore = new SalesByStore();
				saleByStore.setStore(rs.getString("store"));
				saleByStore.setManager(rs.getString("manager"));
				saleByStore.setTotalSales(rs.getDouble("total_sales"));
				System.out.println(saleByStore.toString() + "saleByStore");
				list.add(saleByStore);
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
	

	public int lastPage (int beginRow, int rowPerPage) {
		int totalRow = 0;
		int lastPage = 0;
		
		Connection conn = null;
		conn = DBUtil.getConnection();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from sales_by_store";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				totalRow = rs.getInt("cnt");
			}
			if(totalRow % rowPerPage == 0) {
				lastPage = totalRow / rowPerPage;
			} else {
				lastPage = (totalRow / rowPerPage) + 1;
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
		
		return lastPage;
		
		
	}
	
	
}
	
		
		
		


