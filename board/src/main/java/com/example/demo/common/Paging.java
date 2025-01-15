package com.example.demo.common;

import lombok.Data;

// 계산방법은 책 p302 ~ p305
@Data
public class Paging {
	int pageUnit = 10; // 한페이지 출력할 레코드 건수
	int pageSize = 10; // 페이지번호 수 (5) 1~ 5까지
	int lastPage; // 마지막 페이지번호
	int totalRecord; // 전체 레코드건수
	Integer page = 1; // 현재 페이지
	int startPage; // 페이지그룹내에서 시작페이지번호
	int endPage; // 페이지그룹내에서 마지막페이지번호
	int first;
	int last;

	// 1 ~ 10, 11 ~ 20, 21 ~ 30 까지의 1, 11, 21 첫 번째 페이지 !!
	public int getFirst() {
		first = (getPage() - 1) * getPageUnit() + 1;
		return first;
	}

	// 1 ~ 10, 11 ~ 20, 21 ~ 30 까지의 10, 20, 30 마지막 페이지 !!
	public int getLast() {
		last = getPage() * getPageUnit();
		return last;
	}


	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getLastPage() {
		lastPage = totalRecord / pageUnit + (totalRecord % pageUnit > 0 ? 1 : 0);
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getStartPage() {
		// 현재 페이지 번호로 1 ~ 10, 11 ~ 20 범위 구하기
		startPage = (page - 1) / pageSize * pageSize + 1;
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	// 이전버튼 1,2,3,4,5,6,7,8,9,10 다음버튼
	// 이전버튼 11,12,13,14,15,16,17,18,19,20 다음버튼
	public int getEndPage() {
		// 마지막 페이지 = () / 10
		endPage = (page - 1) / pageSize * pageSize + pageSize;
		if (endPage > getLastPage())
			endPage = getLastPage();
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
