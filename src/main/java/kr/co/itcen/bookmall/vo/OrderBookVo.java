package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private Long orderNo;
	private int price;		// 주문시의 책 가격 * 수량
	private String address;
	private String orderDate;
	private Long userNo;
	private String userName;
	private Long bookNo;
	private String bookName;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "OrderBookVo [orderNo=" + orderNo + ", price=" + price + ", address=" + address + ", orderDate="
				+ orderDate + ", userNo=" + userNo + ", userName=" + userName + ", bookNo=" + bookNo + ", bookName="
				+ bookName + "]";
	}
	
}
