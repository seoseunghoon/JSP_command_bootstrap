package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.BoardService;

public class BoardRemoveAction implements Action{

	
	private BoardService boardService;
	
	
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String url = "/board/remove_success";
		
		boardService.remove(Integer.parseInt(request.getParameter("bno")));
		
		
		
		return url;
	}

}
