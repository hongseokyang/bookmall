package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private int price;
	private String address;
	private String orderDate;
	private Long userNo;
	private String userName;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", price=" + price + ", address=" + address + ", orderDate=" + orderDate
				+ ", userNo=" + userNo + ", userName=" + userName + "]";
	}
	
}
