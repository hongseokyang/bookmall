package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {
	private static CartDao dao = null;
	
	public static void main(String[] args) {
		insertTest();
		selectTest();
		deleteTest();
		updateTest();
		deleteAllTest();
	}
	
	private static CartDao getDao() {
		dao = new CartDao();
		return dao;
	}

	private static void selectTest() {
		System.out.println("cart select ---------------");

		List<CartVo> list = new ArrayList<CartVo>();
		list = dao.getList();
		for (CartVo cartVo : list) {
			System.out.println(cartVo);
		}
	}

	private static void insertTest() {
		System.out.println("cart insert ---------------");
		dao = getDao();

		CartVo vo1 = new CartVo();
		vo1.setAmount(10);
		vo1.setBookNo(1L);
		vo1.setUserNo(1L);
		dao.insert(vo1);
		System.out.println(vo1);

		CartVo vo2 = new CartVo();
		vo2.setAmount(20);
		vo2.setBookNo(2L);
		vo2.setUserNo(1L);
		dao.insert(vo2);
		System.out.println(vo2);

		CartVo vo3 = new CartVo();
		vo3.setAmount(30);
		vo3.setBookNo(2L);
		vo3.setUserNo(2L);
		dao.insert(vo3);
		System.out.println(vo3);

	}
	
	private static void deleteAllTest() {
		System.out.println("cart delete all ---------------");
		dao.delete();
	}
	
	private static void deleteTest() {
		System.out.println("cart delete ---------------");
		dao = getDao();
		dao.delete(1);
		dao.delete(2);
		selectTest();
	}

	private static void updateTest() {
		System.out.println("cart update ---------------");
		dao = getDao();

		CartVo vo1 = new CartVo();
		vo1.setAmount(20);
		vo1.setBookNo(1L);
		vo1.setUserNo(1L);
		dao.update(vo1);
		System.out.println(vo1);

		CartVo vo2 = new CartVo();
		vo2.setAmount(40);
		vo2.setBookNo(2L);
		vo2.setUserNo(1L);
		dao.update(vo2);
		System.out.println(vo2);

	}
}
