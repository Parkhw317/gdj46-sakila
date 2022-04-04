package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import vo.FilmList;


public class FilmListDao {
	
	public List<FilmList> selectFilmListByPage(int beginRow, int rowPerPage){
		List<FilmList> list = new ArrayList<FilmList>();
		
		Connection conn = null;
		conn = DBUtil.getConnection();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM film_list ORDER BY fid LIMIT ?, ?";

	
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
		
			while(rs.next()) {
				FilmList filmList = new FilmList();
				filmList.setFilmId(rs.getInt("FID"));
				filmList.setTitle(rs.getString("title"));
				filmList.setDescription(rs.getString("description"));
				filmList.setCategory(rs.getString("category"));
				filmList.setPrice(rs.getDouble("price"));
				filmList.setLength(rs.getInt("length"));
				filmList.setRating(rs.getString("rating"));
				filmList.setActors(rs.getString("actors"));
				System.out.println(filmList.toString() + "FilmList");
				list.add(filmList);
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
		String sql = "select count(*) cnt from film_list";
		
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
	
		
		
		


