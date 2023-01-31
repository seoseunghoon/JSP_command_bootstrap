package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.ReplyVO;

public interface ReplyDAO {

	
		List<ReplyVO> selectReplyListPage(SqlSession session, int bno, SearchCriteria cri)throws SQLException;
		
	
}
