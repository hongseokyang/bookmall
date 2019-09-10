package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	CategoryDao dao = null;
	
	private CategoryDao getDao() {
		dao = new CategoryDao();
		return dao;
	}
	
	public void selectTest() {
		System.out.println("category select ---------------");
		
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		list = dao.getList();
		for (CategoryVo categoryVo : list) {
			System.out.println(categoryVo);
		}
	}
	
	public void insertTest() {
		System.out.println("category insert ---------------");
		dao = getDao();
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("소설");
		dao.insert(vo1);
		System.out.println(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo1.setName("역사");
		dao.insert(vo2);
		System.out.println(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo1.setName("종교");
		dao.insert(vo3);
		System.out.println(vo3);
		
	}
	
	public void deleteTest() {
		System.out.println("category delete ---------------");
		dao = getDao();
		dao.delete(1);
		dao.delete(2);
		selectTest();
	}
	
	public void updateTest() {
		System.out.println("category update ---------------");
		dao = getDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setNo(1L);
		vo1.setName("it");
		dao.update(vo1);
		System.out.println(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setNo(2L);
		vo2.setName("과학");
		dao.update(vo2);
		System.out.println(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setNo(3L);
		vo3.setName("에세이");
		dao.update(vo3);
		System.out.println(vo3);
	}
}
