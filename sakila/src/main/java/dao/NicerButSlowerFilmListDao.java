package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import vo.NicerButSlowerFilmList;


public class NicerButSlowerFilmListDao {
	
	public List<NicerButSlowerFilmList> selectNicerButSlowerFilmListByPage(int beginRow, int rowPerPage){
		List<NicerButSlowerFilmList> list = new ArrayList<NicerButSlowerFilmList>();
		
		Connection conn = null;
		conn = DBUtil.getConnection();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM nicer_but_slower_film_list ORDER BY fid LIMIT ?, ?";

	
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
		
			while(rs.next()) {
				NicerButSlowerFilmList nicerButSlowerFilmList = new NicerButSlowerFilmList();
				nicerButSlowerFilmList.setFilmId(rs.getInt("FID"));
				nicerButSlowerFilmList.setTitle(rs.getString("title"));
				nicerButSlowerFilmList.setDescription(rs.getString("description"));
				nicerButSlowerFilmList.setCategory(rs.getString("category"));
				nicerButSlowerFilmList.setPrice(rs.getDouble("price"));
				nicerButSlowerFilmList.setLength(rs.getInt("length"));
				nicerButSlowerFilmList.setRating(rs.getString("rating"));
				nicerButSlowerFilmList.setActors(rs.getString("actors"));
				System.out.println(nicerButSlowerFilmList.toString() + "NicerButSlowerFilmList");
				list.add(nicerButSlowerFilmList);
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
		String sql = "select count(*) cnt from nicer_but_slower_film_list";
		
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
	
		
		
		


