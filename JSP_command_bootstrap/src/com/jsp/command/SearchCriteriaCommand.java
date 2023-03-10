package com.jsp.command;

public class SearchCriteriaCommand {
	
	private String page="1";
	private String perPageNum="10";
	private String searchType="";
	private String keyword="";

	
	public SearchCriteriaCommand() {}
	
	
	
	public void setPage(String page) {
		this.page = page;
	}

	public void setPerPageNum(String perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	

	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
	 
	
	public SearchCriteria toSearchCriteria() {
		SearchCriteria cri =new SearchCriteria();
		if(page != null && !page.isEmpty()) {
			cri.setPage(Integer.parseInt(page));
		}

		if(perPageNum != null && !perPageNum.isEmpty()) {
			cri.setPerPageNum(Integer.parseInt(perPageNum));
		}
		
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		return cri;
	}
	
	
	
}
