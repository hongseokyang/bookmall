package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {
	private static BookDao dao = null;
	
	public static void main(String[] args) {
		insertTest();
		selectTest();
		deleteTest();
		updateTest();
		deleteAllTest();
	}
	

	private static BookDao getDao() {
		dao = new BookDao();
		return dao;
	}

	private static void selectTest() {
		System.out.println("book select ---------------");

		List<BookVo> list = new ArrayList<BookVo>();
		list = dao.getList();
		for (BookVo bookVo : list) {
			System.out.println(bookVo);
		}
	}

	private static void insertTest() {
		System.out.println("book insert ---------------");
		dao = getDao();

		BookVo vo1 = new BookVo();
		vo1.setName("실용주의 프로그래머");
		vo1.setPrice(13000);
		vo1.setCategoryNo(1L);
		dao.insert(vo1);
		System.out.println(vo1);

		BookVo vo2 = new BookVo();
		vo2.setName("익스트림 프로그래밍");
		vo2.setPrice(13000);
		vo2.setCategoryNo(1L);
		dao.insert(vo2);
		System.out.println(vo2);

		BookVo vo3 = new BookVo();
		vo3.setName("소프트웨어 장인");
		vo3.setPrice(13000);
		vo3.setCategoryNo(1L);
		dao.insert(vo3);
		System.out.println(vo3);

	}

	private static void deleteTest() {
		System.out.println("book delete ---------------");
		dao = getDao();
		dao.delete(1);
		dao.delete(2);
		selectTest();
	}
	
	private static void deleteAllTest() {
		System.out.println("book delete all ---------------");
		dao.delete();
	}
	
	private static void updateTest() {
		System.out.println("book update ---------------");
		dao = getDao();

		BookVo vo1 = new BookVo();
		vo1.setNo(1L);
		vo1.setName("실용주의 프로그래머");
		vo1.setPrice(15000);
		vo1.setCategoryNo(1L);
		dao.update(vo1);
		System.out.println(vo1);

		BookVo vo2 = new BookVo();
		vo2.setNo(2L);
		vo2.setName("익스트림 프로그래밍");
		vo2.setPrice(10000);
		vo2.setCategoryNo(1L);
		dao.update(vo2);
		System.out.println(vo2);

	}
}
