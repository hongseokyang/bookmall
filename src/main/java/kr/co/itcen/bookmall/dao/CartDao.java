package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.util.DBConn;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDao {
	public List<CartVo> getList() {
		List<CartVo> result = new ArrayList<CartVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = DBConn.getConnection();

			String sql = "select c.no, c.amount, b.no, b.name, u.no, u.name, u.email, (b.price*c.amount) as price from cart c, book b, user u where c.book_no = b.no and c.user_no = u.no order by u.no asc, c.no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				CartVo vo = new CartVo();
				vo.setNo(rs.getLong(1));
				vo.setAmount(rs.getInt(2));
				vo.setBookNo(rs.getLong(3));
				vo.setBookName(rs.getString(4));
				vo.setUserNo(rs.getLong(5));
				vo.setUserName(rs.getString(6));
				vo.setPrice(rs.getInt(7));

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

	public Boolean insert(CartVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "insert into cart values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo.getAmount());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getUserNo());

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

			String sql = "delete from cart";

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

			String sql = "delete from cart where no = ?";

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

	public void update(CartVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "update book set amount = ?, book_no = ?, user_no = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo.getAmount());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getUserNo());
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
