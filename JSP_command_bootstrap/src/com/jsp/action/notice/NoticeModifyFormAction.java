package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeModifyFormAction implements Action{

	private NoticeService noticeService;
	
	
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/notice/modify";
		
		NoticeVO notice = noticeService.getNotice(Integer.parseInt(request.getParameter("nno")));
		
		request.setAttribute("notice", notice);
		
		
		return url;
	}

	
	
	
	
}
