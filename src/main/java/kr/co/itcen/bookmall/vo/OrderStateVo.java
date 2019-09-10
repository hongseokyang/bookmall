package kr.co.itcen.bookmall.vo;

public class OrderStateVo {
	private Long no;
	private String state;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "OrderState [no=" + no + ", state=" + state + "]";
	}
	
}
