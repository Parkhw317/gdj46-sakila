package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import vo.CustomerList;


public class CustomerListDao {
	
	public List<CustomerList> selectCustomerListByPage(int beginRow, int rowPerPage) {
		List<CustomerList> list = new ArrayList<CustomerList>();
		
		Connection conn = null;
		conn = DBUtil.getConnection();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM customer_list ORDER BY id LIMIT ?, ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				CustomerList customerList = new CustomerList();
				customerList.setCustomerId(rs.getInt("ID"));
				customerList.setCustomerName(rs.getString("name"));
				customerList.setCustomerAddr(rs.getString("address"));
				customerList.setZipCode(rs.getString("zip code"));
				customerList.setPhone(rs.getString("phone"));
				customerList.setCity(rs.getString("city"));
				customerList.setCountry(rs.getNString("country"));
				customerList.setNotes(rs.getString("notes"));
				customerList.setSid(rs.getInt("sid"));
				System.out.println(customerList.toString() + "customer_list");
				list.add(customerList);
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
		String sql = "select count(*) cnt from customer_list";
		
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
	
		
		
		


