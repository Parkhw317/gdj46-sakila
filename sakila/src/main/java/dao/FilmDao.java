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
import vo.FilmList;

public class FilmDao {
	
	   public List<FilmList> selectFilmListSearch(int beginRow, int rowPerPage, String category, String rating, double price, int length, String title, String actors) {      
		      List<FilmList> list = new ArrayList<FilmList>();
		      Connection conn = null;
		      PreparedStatement stmt = null;
		      ResultSet rs = null;
		      conn = DBUtil.getConnection();
		      try {
		         // 동적쿼리
		         String sql = "SELECT fid,title,description,category,price,length,rating,actors FROM film_list WHERE title LIKE ? AND actors LIKE ?";
		         if(category.equals("") && rating.equals("") && price==-1 && length==-1) { // All Null값
		            sql += " ORDER BY fid LIMIT ?, ?";
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, "%"+title+"%");
		            stmt.setString(2, "%"+actors+"%");
		            stmt.setInt(3, beginRow);
		            stmt.setInt(4, rowPerPage);
		         } else if(category.equals("") && rating.equals("") && price==-1 && length!=-1) { // length(영화시간)만 입력
		            if(length == 0) {
		               sql += " AND length<60 ORDER BY fid LIMIT ?, ?";
		            } else if(length == 1) {
		               sql += " AND length>=60 ORDER BY fid LIMIT ?, ?";
		            }
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, "%"+title+"%");
		            stmt.setString(2, "%"+actors+"%");
		            stmt.setInt(3, beginRow);
		            stmt.setInt(4, rowPerPage);
		         } else if(category.equals("") && rating.equals("") && price!=-1 && length==-1) { // price(대여료)만 입력
		            sql += " AND price=? ORDER BY fid LIMIT ?, ?";
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, "%"+title+"%");
		            stmt.setString(2, "%"+actors+"%");
		            stmt.setDouble(3, price);
		            stmt.setInt(4, beginRow);
		            stmt.setInt(5, rowPerPage);
		         } else if(!category.equals("") && rating.equals("") && price==-1 && length==-1) { // category(카테고리)만 입력
			            sql += " AND category=? ORDER BY fid LIMIT ?, ?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setInt(4, beginRow);
			            stmt.setInt(5, rowPerPage);
			     } else if(category.equals("") && !rating.equals("") && price==-1 && length==-1) { // rating(등급)만 입력
			            sql += " AND rating=? ORDER BY fid LIMIT ?, ?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			            stmt.setInt(4, beginRow);
			            stmt.setInt(5, rowPerPage);
			     } else if(category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // price(대여료),length(영화시간)만 입력
			    	 
			    	 if(length == 0) {
			               sql += "AND price=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND price=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }

			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setDouble(3, price);
			            stmt.setInt(4, beginRow);
			            stmt.setInt(5, rowPerPage);
			     } else if(!category.equals("") && rating.equals("") && price!=-1 && length==-1) { // 카테고리, 대여료만 입력
			            sql += " AND category=? AND price=? ORDER BY fid LIMIT ?, ?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setDouble(4, price);
			            stmt.setInt(5, beginRow);
			            stmt.setInt(6, rowPerPage);
			     } else if(category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // 등급, 영화시간만 입력
			    	 if(length == 0) {
			               sql += "AND rating=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND rating=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }
			            
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			            stmt.setInt(4, beginRow);
			            stmt.setInt(5, rowPerPage);
			     } else if(category.equals("") && !rating.equals("") && price!=-1 && length==-1) { //등급, 대여료만 입력
			            sql += " AND category=? AND price=? ORDER BY fid LIMIT ?, ?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			            stmt.setDouble(4, price);
			            stmt.setInt(5, beginRow);
			            stmt.setInt(6, rowPerPage);
			     } else if(category.equals("") && rating.equals("") && price!=-1 && length!=-1) { //대여료, 영화시간만 입력
			    	 if(length == 0) {
			               sql += "AND price=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND price=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setDouble(3, price);
			            stmt.setInt(4, beginRow);
			            stmt.setInt(5, rowPerPage);
			     } else if(!category.equals("") && rating.equals("") && price==-1 && length!=-1) { //카테고리, 영화시간만 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND category=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setInt(4, beginRow);
			            stmt.setInt(5, rowPerPage);
			     } else if(!category.equals("") && !rating.equals("") && price==-1 && length==-1) { // 카테고리, 등급만 입력
			            sql += " AND category=? AND rating=? ORDER BY fid LIMIT ?, ?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);
			            stmt.setInt(5, beginRow);
			            stmt.setInt(6, rowPerPage);
		         
			     } else if(category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 등급, 대여료, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND rating=? AND price=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND rating=? AND price=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			            stmt.setDouble(4, price);
			            stmt.setInt(5, beginRow);
			            stmt.setInt(6, rowPerPage); 
			     } else if(!category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // 카테고리, 대여료, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND price=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND category=? AND price=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setDouble(4, price);
			            stmt.setInt(5, beginRow);
			            stmt.setInt(6, rowPerPage); 
		         
			     } else if(!category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // 카테고리, 등급, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND rating=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND category=? AND rating=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);
			            stmt.setInt(5, beginRow);
			            stmt.setInt(6, rowPerPage); 
		         
			     } else if(!category.equals("") && !rating.equals("") && price!=-1 && length==-1) { // 카테고리, 등급, 대여료 입력
			            sql += " AND category=? AND rating=? AND price=? ORDER BY fid LIMIT ?, ?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);
			            stmt.setDouble(5, price);
			            stmt.setInt(6, beginRow);
			            stmt.setInt(7, rowPerPage);
			     } else if(!category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 카테고리, 등급, 대여료, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND rating=? AND price=? AND length<60 ORDER BY fid LIMIT ?, ?";
			            } else if(length == 1) {
			               sql += "AND category=? AND rating=? AND price=? AND length>=60 ORDER BY fid LIMIT ?, ?";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);
			            stmt.setDouble(5, price);
			            stmt.setInt(6, beginRow);
			            stmt.setInt(7, rowPerPage); 
		         
			     }
		          
		         rs = stmt.executeQuery();
		         while(rs.next()) {
		            FilmList f = new FilmList();
		            f.setFilmId(rs.getInt("fid"));
		            f.setTitle(rs.getString("title"));
		            f.setDescription(rs.getString("description"));
		            f.setCategory(rs.getString("category"));
		            f.setPrice(rs.getDouble("price"));
		            f.setLength(rs.getInt("length"));
		            f.setRating(rs.getString("rating"));
		            f.setActors(rs.getString("actors"));
		            list.add(f);
		         }
		      } catch(SQLException e) {
		         e.printStackTrace();
		      }
		      return list;
		   }
	   
	
	   public int totalRow(String category, String rating, double price, int length, String title, String actors) {
		     
		   int count = 0;
		      
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   conn = DBUtil.getConnection();
		      
		      try {
		         // 동적쿼리
		         String sql = "SELECT COUNT(*) cnt FROM film_list WHERE title LIKE ? AND actors LIKE ?";
		         if(category.equals("") && rating.equals("") && price==-1 && length==-1) { // All Null값
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, "%"+title+"%");
		            stmt.setString(2, "%"+actors+"%");
		         } else if(category.equals("") && rating.equals("") && price==-1 && length!=-1) { // length(영화시간)만 입력
		            if(length == 0) {
		               sql += " AND length<60";
		            } else if(length == 1) {
		               sql += " AND length>=60";
		            }
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, "%"+title+"%");
		            stmt.setString(2, "%"+actors+"%");
		         } else if(category.equals("") && rating.equals("") && price!=-1 && length==-1) { // price(대여료)만 입력
		            sql += " AND price=?";
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, "%"+title+"%");
		            stmt.setString(2, "%"+actors+"%");
		            stmt.setDouble(3, price);
		         } else if(!category.equals("") && rating.equals("") && price==-1 && length==-1) { // category(카테고리)만 입력
			            sql += " AND category=?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			     } else if(category.equals("") && !rating.equals("") && price==-1 && length==-1) { // rating(등급)만 입력
			            sql += " AND rating=?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			     } else if(category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // price(대여료),length(영화시간)만 입력
			    	 
			    	 if(length == 0) {
			               sql += "AND price=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND price=? AND length>=60";
			            }

			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setDouble(3, price);
			     } else if(!category.equals("") && rating.equals("") && price!=-1 && length==-1) { // 카테고리, 대여료만 입력
			            sql += " AND category=? AND price=? ORDER BY fid LIMIT ?, ?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setDouble(4, price);
			     } else if(category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // 등급, 영화시간만 입력
			    	 if(length == 0) {
			               sql += "AND rating=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND rating=? AND length>=60";
			            }
			            
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			     } else if(category.equals("") && !rating.equals("") && price!=-1 && length==-1) { //등급, 대여료만 입력
			            sql += " AND category=? AND price=?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			            stmt.setDouble(4, price);

			     } else if(category.equals("") && rating.equals("") && price!=-1 && length!=-1) { //대여료, 영화시간만 입력
			    	 if(length == 0) {
			               sql += "AND price=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND price=? AND length>=60";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setDouble(3, price);

			     } else if(!category.equals("") && rating.equals("") && price==-1 && length!=-1) { //카테고리, 영화시간만 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND category=? AND length>=60";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);

			     } else if(!category.equals("") && !rating.equals("") && price==-1 && length==-1) { // 카테고리, 등급만 입력
			            sql += " AND category=? AND rating=?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);

		         
			     } else if(category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 등급, 대여료, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND rating=? AND price=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND rating=? AND price=? AND length>=60";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, rating);
			            stmt.setDouble(4, price);
		
			     } else if(!category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // 카테고리, 대여료, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND price=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND category=? AND price=? AND length>=60 ";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setDouble(4, price);
		         
			     } else if(!category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // 카테고리, 등급, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND rating=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND category=? AND rating=? AND length>=60";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);
		         
			     } else if(!category.equals("") && !rating.equals("") && price!=-1 && length==-1) { // 카테고리, 등급, 대여료 입력
			            sql += " AND category=? AND rating=? AND price=?";
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);
			            stmt.setDouble(5, price);

			     } else if(!category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 카테고리, 등급, 대여료, 영화시간 입력
			    	 if(length == 0) {
			               sql += "AND category=? AND rating=? AND price=? AND length<60";
			            } else if(length == 1) {
			               sql += "AND category=? AND rating=? AND price=? AND length>=60";
			            }
			            stmt = conn.prepareStatement(sql);
			            stmt.setString(1, "%"+title+"%");
			            stmt.setString(2, "%"+actors+"%");
			            stmt.setString(3, category);
			            stmt.setString(4, rating);
			            stmt.setDouble(5, price);

		         
			     }
		          
		         rs = stmt.executeQuery();
		         
		         while(rs.next()) {
		        	 count=rs.getInt("cnt");
		          
		         }
		      } catch(SQLException e) {
		         e.printStackTrace();
		      }
		      return count;
		   }
	  
	   
	   

	public List<Double> selectfilmPriceList() {
	      List<Double> list = new ArrayList<Double>();
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      conn = DBUtil.getConnection();
	      String sql = "SELECT DISTINCT price FROM film_list ORDER BY price";
	      try {
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            list.add(rs.getDouble("price"));
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
		
		
	
	
	
	
	public Map<String, Object> filmInStockCall(int filmId, int storeId) {
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
			stmt = conn.prepareCall("{call film_in_stock(?, ?, ?)}");
			stmt.setInt(1, filmId);
			stmt.setInt(2, storeId);
			stmt.registerOutParameter(3, Types.INTEGER);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1)); // rs.getInt("inventory_id")
			}
			count = stmt.getInt(3); // 프로시저 3번째 out변수 값
		} catch (SQLException e) {
			e.printStackTrace();
		}
		map.put("list", list);
		map.put("count", count);
		return map;
	}
	
	
	// 디버깅
	public static void main(String[] args) { 
		FilmDao fd = new FilmDao();
		int filmId = 7; // 필름 아이디 입력
		int storeId = 2; // 스토어 아이디 입력
		Map<String, Object> map = fd.filmInStockCall(filmId, storeId);
		List<Integer> list = (List<Integer>)map.get("list");
		int count = (Integer)map.get("count");
		
		System.out.println(filmId + "번 영화는 "+ storeId +"번 가게에 "+count+"개 남음");
		for(int id : list) {
			System.out.println(id);
		}
	}
}
