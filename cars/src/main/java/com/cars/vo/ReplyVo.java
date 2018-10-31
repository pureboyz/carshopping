package com.cars.vo;

public class ReplyVo {
	
	int rno;
	String auth;
	String comment;
	int cno;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	
	@Override
	public String toString() {
		return "ReplyVo [rno=" + rno + ", auth=" + auth + ", comment=" + comment + ", cno=" + cno + "]";
	}
	
	

}
