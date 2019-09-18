package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.util.DBConn;
import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDao {
	public List<OrderBookVo> getList() {
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = DBConn.getConnection();

			String sql = "select o.no, ob.amount, (ob.amount * ob.price) as price, o.order_date, u.user_name, b.name, from order_book ob, order o, user u, book b where ob.order_no = o.no and o.no = u.no and ob.book_no = b.no order by o.no desc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long orderNo = rs.getLong(1);
				int amount = rs.getInt(2);
				int price = rs.getInt(3);
				String orderDate = rs.getString(4);
				String userName = rs.getString(5);
				String bookName = rs.getString(6);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderNo(orderNo);
				vo.setAmount(amount);
				vo.setPrice(price);
				vo.setOrderDate(orderDate);
				vo.setUserName(userName);
				vo.setBookName(bookName);
				
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

	public Boolean insert(OrderBookVo vo) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "insert into order_book values(?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getAmount());
			pstmt.setInt(4, vo.getPrice());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			
		} catch (SQLException e) {
			System.out.println("error: "+e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
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

			String sql = "delete from order_book";
			
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
	
	public Boolean delete(int orderNo, int bookNo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {

			connection = DBConn.getConnection();

			String sql = "delete from order_book where order_no = ? and book_no = ?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, bookNo);
			
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

	public void update(OrderBookVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			connection = DBConn.getConnection();

			String sql = "update order_book set amount = ? where order_no = ? and book_no = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo.getAmount());
			pstmt.setLong(2, vo.getOrderNo());
			pstmt.setLong(3, vo.getBookNo());
			
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
