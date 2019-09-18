package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {
	private static OrderBookDao dao = null;
	
	public static void main(String[] args) {
		insertTest();
		selectTest();
		deleteTest();
		updateTest();
		deleteAllTest();
	}
	
	private static OrderBookDao getDao() {
		dao = new OrderBookDao();
		return dao;
	}

	private static void selectTest() {
		System.out.println("order_book book select ---------------");

		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		list = dao.getList();
		for (OrderBookVo orderBookVo : list) {
			System.out.println(orderBookVo);
		}
	}

	private static void insertTest() {
		System.out.println("order_book book insert ---------------");
		dao = getDao();

		OrderBookVo vo1 = new OrderBookVo();
		vo1.setOrderNo(1L);
		vo1.setBookNo(1L);
		vo1.setAmount(10);
		vo1.setPrice(13000);
		dao.insert(vo1);
		System.out.println(vo1);

		OrderBookVo vo2 = new OrderBookVo();
		vo2.setOrderNo(1L);
		vo2.setBookNo(2L);
		vo2.setAmount(5);
		vo2.setPrice(13000);
		dao.insert(vo2);
		System.out.println(vo2);

		OrderBookVo vo3 = new OrderBookVo();
		vo3.setOrderNo(2L);
		vo3.setBookNo(1L);
		vo3.setAmount(20);
		vo3.setPrice(15000);
		dao.insert(vo3);
		System.out.println(vo3);

	}
	
	private static void deleteAllTest() {
		System.out.println("category delete all ---------------");
		dao.delete();
	}
	
	private static void deleteTest() {
		System.out.println("order_book book delete ---------------");
		dao = getDao();
		dao.delete(1, 1);
		dao.delete(1, 2);
		selectTest();
	}

	private static void updateTest() {
		// 배송지, 주문상태
		System.out.println("order_book book update ---------------");
		dao = getDao();

		OrderBookVo vo1 = new OrderBookVo();
		vo1.setOrderNo(1L);
		vo1.setBookNo(1L);
		vo1.setAmount(10);
		dao.update(vo1);
		System.out.println(vo1);

		OrderBookVo vo2 = new OrderBookVo();
		vo2.setOrderNo(1L);
		vo2.setBookNo(2L);
		vo2.setAmount(5);
		dao.update(vo2);
		System.out.println(vo2);
	}
}
