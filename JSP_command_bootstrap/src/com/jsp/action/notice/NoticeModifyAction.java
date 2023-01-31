package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.command.NoticeModifyCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeModifyAction implements Action {

	
	private NoticeService noticeService;
	
	
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/notice/detail.do?nno=" + request.getParameter("nno");
		
		
		
		NoticeModifyCommand noticeCommand = HttpRequestParameterAdapter.execute(request, NoticeModifyCommand.class);
		NoticeVO notice = noticeCommand.toNoticeVO();
		String title = HTMLInputFilter.htmlSpecialChars(notice.getTitle());
		notice.setTitle(title);
		
		noticeService.modify(notice);
		
		
		return url;
	}

}
