package com.cars.vo;

import java.util.Date;

public class BoardVo {
	
	int bNo;
	String title;
	String content;
	String writer;
	int mNo;
	Date regDate;
	int viewCnt;
	int bGrade;	
	
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bno) {
		this.bNo = bno;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getbGrade() {
		return bGrade;
	}
	public void setbGrade(int bGrade) {
		this.bGrade = bGrade;
	}
	
	@Override
	public String toString() {
		return "BoardVo [bNo=" + bNo + ", title=" + title + ", content=" + content + ", writer=" + writer + ", mNo="
				+ mNo + ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", bGrade=" + bGrade + "]";
	}

}
