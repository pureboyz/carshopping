package com.cars.vo;

public class PageMaker {
	
	int currentPage;
	int countPerPage;
	int totalCount;
	int startPage;
	int endPage;
	int displayPageNum;
	int start;
	boolean prev = false;
	boolean next = false;
	
	int mno;
	int cno;
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	@Override
	public String toString() {
		return "PageMaker [currentPage=" + currentPage + ", countPerPage=" + countPerPage + ", totalCount=" + totalCount
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", displayPageNum=" + displayPageNum
				+ ", start=" + start + ", prev=" + prev + ", next=" + next + ", mno=" + mno + ", cno=" + cno + "]";
	}
	
	
	
	
	
	
	
	

}
