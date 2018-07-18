package com.football.model.futsal.dto;

public class FutsalReserveDTO {

	private int reserveNo;
	private String userId;
	private int fustalNo;
	private String reserveStart;
	private String reserveEnd;
	private char reserveStatus;
	
	public FutsalReserveDTO(int reserveNo, String userId, int fustalNo, String reserveStart, String reserveEnd,
			char reserveStatus) {
		this.reserveNo = reserveNo;
		this.userId = userId;
		this.fustalNo = fustalNo;
		this.reserveStart = reserveStart;
		this.reserveEnd = reserveEnd;
		this.reserveStatus = reserveStatus;
	}
	
	public FutsalReserveDTO() {}
	
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getFustalNo() {
		return fustalNo;
	}
	public void setFustalNo(int fustalNo) {
		this.fustalNo = fustalNo;
	}
	public String getReserveStart() {
		return reserveStart;
	}
	public void setReserveStart(String reserveStart) {
		this.reserveStart = reserveStart;
	}
	public String getReserveEnd() {
		return reserveEnd;
	}
	public void setReserveEnd(String reserveEnd) {
		this.reserveEnd = reserveEnd;
	}
	public char getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(char reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
}
