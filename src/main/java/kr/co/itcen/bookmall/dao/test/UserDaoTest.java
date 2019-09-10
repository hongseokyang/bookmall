package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;

public class UserDaoTest {
	UserDao dao = null;
	
	private UserDao getDao() {
		dao = new UserDao();
		return dao;
	}
	
	public void selectTest() {
		System.out.println("user select ---------------");
		
		List<UserVo> list = new ArrayList<UserVo>();
		list = dao.getList();
		for (UserVo userVo : list) {
			System.out.println(userVo);
		}
	}
	
	public void insertTest() {
		System.out.println("user insert ---------------");
		dao = getDao();
		
		UserVo vo1 = new UserVo();
		vo1.setName("윤종진");
		vo1.setPhone("01012345678");
		vo1.setEmail("abc@gmail.com");
		vo1.setPasswd("1111");
		vo1.setAddress("서울시 용산구");
		dao.insert(vo1);
		System.out.println(vo1);
		
		UserVo vo2 = new UserVo();
		vo1.setName("이지수");
		vo1.setPhone("01012341234");
		vo1.setEmail("dea@gmail.com");
		vo1.setPasswd("1111");
		vo1.setAddress("서울시 강남구");		
		dao.insert(vo2);
		System.out.println(vo2);
		
		UserVo vo3 = new UserVo();
		vo1.setName("이지은");
		vo1.setPhone("01045678912");
		vo1.setEmail("ghs@gmail.com");
		vo1.setPasswd("1111");
		vo1.setAddress("서울시 동작구");
		dao.insert(vo3);
		System.out.println(vo3);
		
	}
	
	public void deleteTest() {
		System.out.println("user delete ---------------");
		dao = getDao();
		dao.delete(1);
		dao.delete(2);
		selectTest();
	}
	
	public void updateTest() {
		System.out.println("user update ---------------");
		dao = getDao();
		
		UserVo vo1 = new UserVo();
		vo1.setNo(1L);
		vo1.setName("김재원");
		vo1.setPhone("01012345678");
		vo1.setEmail("abc@gmail.com");
		vo1.setPasswd("1111");
		vo1.setAddress("서울시 용산구");
		dao.update(vo1);
		System.out.println(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setNo(2L);
		vo1.setName("김유진");
		vo1.setPhone("01045678912");
		vo1.setEmail("ghs@gmail.com");
		vo1.setPasswd("1111");
		vo1.setAddress("서울시 동작구");
		dao.update(vo2);
		System.out.println(vo2);
		
	}
}
