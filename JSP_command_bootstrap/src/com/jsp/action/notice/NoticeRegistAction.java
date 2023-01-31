package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action{

	
	private NoticeService noticeService;
	
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/notice/regist_success";
		
		
		//set함수로 넣어주는거 ok근데 화면단에서 모든 정보를 줬다는 보장이 없다는거지. 근데 어차피 화면은 내가만드는거고. 오류뜨는건 당연한거지.
		//그럼 특정오류만 잘띄워주면 되겠네 exception으로.
		//크로스사이트 스크립트도 생각해야한다.보통 regist같이 등록, 수정에 고려할 사항이지. - 시큐어코딩
		//내용은 summernote가 해준다. 스프링에서도 시큐어코딩 고려해야함. 인터셉터.
		//파라미터 이름이 같고,받는 파라미터에 맞는 객체 데이터형이 String인 경우.
		//servlet에서 exception처리 다해놨기때문에 따로 안한다.
		
			NoticeVO notice = HttpRequestParameterAdapter.execute(request, NoticeVO.class);
			String title = HTMLInputFilter.htmlSpecialChars(notice.getTitle());
			notice.setTitle(title);
			noticeService.regist(notice);
		
		return url;
	}

}
