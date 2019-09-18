package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.util.DBConn;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDao {
	
	public List<BookVo> getList() {
		List<BookVo> result = new ArrayList<BookVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = DBConn.getConnection();

			String sql = "select b.no, b.name, b.price, c.category_no, c.category_name from book b, category c where b.category_no = c.no order by b.no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				BookVo vo = new BookVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setCategoryNo(rs.getLong(4));
				vo.setCategoryName(rs.getString(5));

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

	public Boolean insert(BookVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategoryNo());
			
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
	
	public Boolean delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {

			connection = DBConn.getConnection();

			String sql = "delete from book";

			pstmt = connection.prepareStatement(sql);

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
	
	public Boolean delete(int no) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {

			connection = DBConn.getConnection();

			String sql = "delete from book where no = ?";

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

	public void update(BookVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "update book set name = ?, price = ?, category_no = ? where no = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategoryNo());
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
