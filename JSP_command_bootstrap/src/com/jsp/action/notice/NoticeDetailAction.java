package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeDetailAction implements Action{

	NoticeService noticeService;
	
	
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/notice/detail";
		
		
		
			int nno = Integer.parseInt(request.getParameter("nno"));
			NoticeVO notice = null;
			if(request.getParameter("from")=="list") {
				notice = noticeService.getNotice(nno);
				url = "redirect:/notice/detail.do?nno=" + nno;
						//리다이렉트해서 from이 없도록 유도. 새로고침해도 영향없게끔.
			}else
				notice = noticeService.getNoticeForModify(nno);
		
			request.setAttribute("notice", notice);
		
			
			//왜 이렇게했는지? 조회수올리는거랑 따로 만드는게 맞지. 근데.
			//
		
		
		return url;
	}

}
