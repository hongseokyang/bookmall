package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.util.DBConn;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDao {
	
	public List<CategoryVo> getList() {
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = DBConn.getConnection();

			String sql = "select no, name from category order by no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);

				CategoryVo vo = new CategoryVo();
				vo.setNo(no);
				vo.setName(name);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error: "+e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection !=  null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Boolean insert(CategoryVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "insert into category values(null, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo.setNo(no);
			}
			
		} catch (SQLException e) {
			System.out.println("error: "+e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection !=  null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Boolean delete(int no) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {

			connection = DBConn.getConnection();

			String sql = "delete from category where no = ?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (SQLException e) {
			System.out.println("error: "+e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection !=  null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void update(CategoryVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "update category set name = ? where no = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setLong(2, vo.getNo());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("error: "+e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection !=  null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
}
