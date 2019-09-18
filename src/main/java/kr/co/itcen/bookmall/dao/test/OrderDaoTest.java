package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {
	private static OrderDao dao = null;

	public static void main(String[] args) {
		insertTest();
		selectTest();
		deleteTest();
		updateTest();
		deleteAllTest();
	}
	
	private static OrderDao getDao() {
		dao = new OrderDao();
		return dao;
	}

	private static void selectTest() {
		System.out.println("order select ---------------");

		List<OrderVo> list = new ArrayList<OrderVo>();
		list = dao.getList();
		for (OrderVo orderVo : list) {
			System.out.println(orderVo);
		}
	}

	private static void insertTest() {
		System.out.println("order insert ---------------");
		dao = getDao();

		OrderVo vo1 = new OrderVo();
		vo1.setAddress("서울시 용산구");
		vo1.setUserNo(1L);
		vo1.setDeleveryStateNo(1L);
		dao.insert(vo1);
		System.out.println(vo1);

		OrderVo vo2 = new OrderVo();
		vo2.setAddress("서울시 강남구");
		vo2.setUserNo(1L);
		vo2.setDeleveryStateNo(1L);
		dao.insert(vo2);
		System.out.println(vo2);

		OrderVo vo3 = new OrderVo();
		vo3.setAddress("서울시 동작구");
		vo3.setUserNo(1L);
		vo3.setDeleveryStateNo(1L);
		dao.insert(vo3);
		System.out.println(vo3);

	}

	private static void deleteAllTest() {
		System.out.println("order delete all ---------------");
		dao.delete();
	}
	
	private static void deleteTest() {
		System.out.println("order delete ---------------");
		dao = getDao();
		dao.delete(1);
		dao.delete(2);
		selectTest();
	}

	private static void updateTest() {
		// 배송지, 주문상태
		System.out.println("order update ---------------");
		dao = getDao();

		OrderVo vo1 = new OrderVo();
		vo1.setAddress("서울시 서대문구");
		vo1.setUserNo(1L);
		vo1.setDeleveryStateNo(2L);
		dao.update(vo1);
		System.out.println(vo1);

		OrderVo vo2 = new OrderVo();
		vo2.setAddress("서울시 강남구");
		vo2.setUserNo(2L);
		vo2.setDeleveryStateNo(2L);
		dao.update(vo2);
		System.out.println(vo2);
	}
}
