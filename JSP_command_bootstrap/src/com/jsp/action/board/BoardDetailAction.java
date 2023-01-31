package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardDetailAction implements Action{

	BoardService boardService;
	
	
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/detail";
		
		
		
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardVO board = null;
			if(request.getParameter("from")=="list") {
				board = boardService.getBoard(bno);
				url = "redirect:/board/detail.do?bno=" + bno;
						//리다이렉트해서 from이 없도록 유도. 새로고침해도 영향없게끔.
			}else
				board = boardService.getBoardForModify(bno);
		
			request.setAttribute("board", board);
		
			
			//왜 이렇게했는지? 조회수올리는거랑 따로 만드는게 맞지. 근데.
			//
		
		
		return url;
	}

}
