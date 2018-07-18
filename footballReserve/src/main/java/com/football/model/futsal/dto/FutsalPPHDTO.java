package com.football.model.futsal.dto;

public class FutsalPPHDTO {

	private int futsalNo;
	private int futsalPrice;
	private String futsalStart;
	private String futsalEnd;
		
	public FutsalPPHDTO() {}
	
	public FutsalPPHDTO(int futsalNo, int futsalPrice, String futsalStart, String futsalEnd) {
		this.futsalNo = futsalNo;
		this.futsalPrice = futsalPrice;
		this.futsalStart = futsalStart;
		this.futsalEnd = futsalEnd;
	}

	public int getFutsalNo() {
		return futsalNo;
	}

	public void setFutsalNo(int futsalNo) {
		this.futsalNo = futsalNo;
	}

	public int getFutsalPrice() {
		return futsalPrice;
	}

	public void setFutsalPrice(int futsalPrice) {
		this.futsalPrice = futsalPrice;
	}

	public String getFutsalStart() {
		return futsalStart;
	}

	public void setFutsalStart(String futsalStart) {
		this.futsalStart = futsalStart;
	}

	public String getFutsalEnd() {
		return futsalEnd;
	}

	public void setFutsalEnd(String futsalEnd) {
		this.futsalEnd = futsalEnd;
	}
}
