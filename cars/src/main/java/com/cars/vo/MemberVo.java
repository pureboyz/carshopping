package com.cars.vo;

public class MemberVo {
	
	int mNo;
	String mId;
	String mPass;
	String mName;
	int mAge;
	int mGender;
	int mGrade;
	int isOut;
	
	
	public int getIsOut() {
		return isOut;
	}
	public void setIsOut(int isOut) {
		this.isOut = isOut;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPass() {
		return mPass;
	}
	public void setmPass(String mPass) {
		this.mPass = mPass;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmAge() {
		return mAge;
	}
	public void setmAge(int mAge) {
		this.mAge = mAge;
	}
	public int getmGender() {
		return mGender;
	}
	public void setmGender(int mGender) {
		this.mGender = mGender;
	}
	public int getmGrade() {
		return mGrade;
	}
	public void setmGrade(int mGrade) {
		this.mGrade = mGrade;
	}
	
	
	@Override
	public String toString() {
		return "MemberVo [mNo=" + mNo + ", mId=" + mId + ", mPass=" + mPass + ", mName=" + mName + ", mAge=" + mAge
				+ ", mGender=" + mGender + ", mGrade=" + mGrade + ", isOut=" + isOut + "]";
	}
	

}
