package com.jsp.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jsp.command.SearchCriteria;
import com.jsp.datasource.MySqlSessionFactory;

public class TestBoardDAOImpl {

	
	private MySqlSessionFactory sqlSessionFactory = new MySqlSessionFactory();
	private BoardDAO boardDAO = new BoardDAOImpl();
	private SqlSession session;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession(false);
		session.commit();
	}
	
	@After
	public void destroy() {
		if(session!=null) {
			session.rollback();
			session.close();
		}
		
	}
	
	
	@Test
	public void test() throws SQLException {
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword("");
		cri.setPage(1);
		cri.setPerPageNum(10);
		cri.setSearchType("");
		System.out.println(boardDAO.selectSearchBoardList(session, cri));

		
	}
	
	
	
	
}
