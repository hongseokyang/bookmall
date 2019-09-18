package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private String address;
	private String orderDate;
	private Long userNo;
	private String userName;
	private String userEmail;
	private Long deleveryStateNo;
	private String deleveryState;
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Long getDeleveryStateNo() {
		return deleveryStateNo;
	}
	public void setDeleveryStateNo(Long deleveryStateNo) {
		this.deleveryStateNo = deleveryStateNo;
	}
	public String getDeleveryState() {
		return deleveryState;
	}
	public void setDeleveryState(String deleveryState) {
		this.deleveryState = deleveryState;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
		return "OrderVo [no=" + no + ", address=" + address + ", orderDate=" + orderDate + ", userNo=" + userNo
				+ ", userName=" + userName + ", userEmail=" + userEmail + ", deleveryStateNo=" + deleveryStateNo
				+ ", deleveryState=" + deleveryState + "]";
	}
	
	
	
}
