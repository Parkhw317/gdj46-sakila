package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBUtil;
import vo.ActorInfo;

public class ActorInfoDao {
	
	public List<ActorInfo> selectActorInfoListByPage(int beginRow, int rowPerPage) {
		List<ActorInfo> list = new ArrayList<ActorInfo>();
		
		Connection conn = null;
		conn = DBUtil.getConnection();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM actor_info ORDER BY actor_id LIMIT ?, ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ActorInfo actorInfo = new ActorInfo();
				actorInfo.setActorId(rs.getInt("actor_id"));
				actorInfo.setFirstName(rs.getString("first_name"));
				actorInfo.setLastName(rs.getString("last_name"));
				actorInfo.setFilmInfo(rs.getString("film_info"));
				System.out.println(actorInfo.toString() + "actor_info");
				list.add(actorInfo);
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
		String sql = "select count(*) cnt from actor_info";
		
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





