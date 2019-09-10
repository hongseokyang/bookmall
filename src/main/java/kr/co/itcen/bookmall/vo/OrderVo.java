package kr.co.itcen.bookmall.vo;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderVo {
	private Long no;
	private String address;
	private String orderDate;
	private Long userNo;
	private String userName;
	private Long orderStateNo;
	private String orderState;
	private int price;		// 주문 가격
	private ArrayList<OrderBookVo> orderBook;
	
	public ArrayList<OrderBookVo> getOrderBook() {
		return orderBook;
	}
	public void setOrderBook(ArrayList<OrderBookVo> orderBook) {
		this.orderBook = orderBook;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getOrderStateNo() {
		return orderStateNo;
	}
	public void setOrderStateNo(Long orderStateNo) {
		this.orderStateNo = orderStateNo;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
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
				+ ", userName=" + userName + ", orderStateNo=" + orderStateNo + ", orderState=" + orderState
				+ ", price=" + price + ", orderBook=" + orderBookList() + "]";
	}
	
	public String orderBookList() {
		String[] orderBookArr = new String[orderBook.size()];
		int i=0;
		for (OrderBookVo orderBookVo : orderBook) {
			orderBookArr[i] = orderBookVo.getBookName();
		}
		
		return Arrays.toString(orderBookArr);
	}
}
