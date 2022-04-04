package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.SalesByFilmCategory;

public class SalesByFilmCategoryDao {

	public List<SalesByFilmCategory> selectSalesByFilmCategoryByPage(int beginRow, int rowPerPage){
		List<SalesByFilmCategory> list = new ArrayList<SalesByFilmCategory>();
		
		Connection conn = null;
		conn = DBUtil.getConnection();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sales_by_film_category";

	
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
		
			while(rs.next()) {
				SalesByFilmCategory salesByFilmCategory = new SalesByFilmCategory();
				salesByFilmCategory.setCategory(rs.getString("category"));
				salesByFilmCategory.setTotalSales(rs.getDouble("total_sales"));
				System.out.println(salesByFilmCategory.toString() + "salesByFilmCategory");
				list.add(salesByFilmCategory);
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
		String sql = "select count(*) cnt from sales_by_film_category";
		
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
	
		
		
		


