<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="boardList" value="${dataMap.boardList}"/>
<c:set var="pageMaker" value="${dataMap.pageMaker}"/>
<c:set var="cri" value="${pageMaker.cri}"/>

<title>공지목록</title>

<body>
	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지목록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
	 <!-- Main content -->
    <section class="content">		
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('registForm.do','공지등록',800,700);">공지등록</button>				
				<div id="keyword" class="card-tools" style="width:540px;">
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum"
					  		onchange="list_go();">
					  		<option value="10" ${cri.perPageNum eq 10 ? 'selected' : '' } >정렬개수</option>
					  		<option value="20" ${cri.perPageNum eq 20 ? 'selected' : '' }>20개씩</option>
					  		<option value="50" ${cri.perPageNum eq 50 ? 'selected' : '' }>50개씩</option>
					  		<option value="100"${cri.perPageNum eq 100 ? 'selected' : '' }>100개씩</option>
					  	</select>						
					  	
						<select class="form-control col-md-4" name="searchType" id="searchType">
							<option value="" ${cri.searchType eq '' ? 'selected' : '' }>전 체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected' : '' }>제 목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected' : '' }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected' : '' }>내 용</option>
							<option value="tc" ${cri.searchType eq 'tc' ? 'selected' : '' }>제목+내용</option>
							<option value="cw" ${cri.searchType eq 'cw' ? 'selected' : '' }>작성자+내용</option>							
							<option value="twc" ${cri.searchType eq 'twc' ? 'selected' : '' }>작성자+제목+내용</option>
						</select>					
						<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value=""/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="list_go(${cri.page},'<%=request.getContextPath()%>/board/list.do');" 
							data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>						
			</div>
			<div class="card-body">
				<table class="table table-bordered text-center" >					
					<tr style="font-size:0.95em;">
						<th style="width:10%;">번 호</th>
						<th style="width:50%;">제 목</th>
						<th style="width:15%;">작성자</th>
						<th>등록일</th>
						<th style="width:10%;">조회수</th>
					</tr>				
					<c:forEach items="${dataMap.boardList }" var="board">
					<tr style="font-size:0.95em;" onclick = "OpenWindow('detail.do?bno=${board.bno}&from=list','.',800,400)">
							<td style="width:10%;">${board.bno }</td>
							<td style="width:50%;">${board.title }</td>
							<td style="width:15%;">${board.writer }</td>
							<td><fmt:formatDate value ="${board.regDate }" pattern = "yyyy-MM-dd"/></td>
							<td style="width:10%;">${board.viewcnt }</td>
			
					</tr>
					</c:forEach>		
					<c:if test="${empty boardList }">
						<tr>	
							<td colspan="5">데이터가 없습니다.</td>
						</tr>
					W</c:if>
						
				</table>				
			</div>
			<div class="card-footer">
				<div style="display:${!empty boardList ? 'visible':'none' };">
	    			<%@ include file="/WEB-INF/module/pagination.jsp" %>
	    		</div>
			</div>
		
		</div>
		
    </section>