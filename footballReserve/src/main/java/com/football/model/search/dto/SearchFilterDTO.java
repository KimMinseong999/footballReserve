package com.football.model.search.dto;

public class SearchFilterDTO {
	private String sido;
	private String gugun;
	private int futsalMaxUser;
	private String futsalStart;
	private String futsalEnd;
	private String futsalAddr;
	private int futsalPrice;
	
	public SearchFilterDTO() {}
	public SearchFilterDTO(String sido, String gugun, int futsalMaxUser, String futsalStart, String futsalEnd, String futsalAddr, int futsalPrice) {
		this.sido = sido;
		this.gugun = gugun;
		this.futsalMaxUser = futsalMaxUser;
		this.futsalStart = futsalStart;
		this.futsalEnd = futsalEnd;
		this.futsalAddr = futsalAddr;
		this.futsalPrice = futsalPrice;
	}
	
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public int getFutsalMaxUser() {
		return futsalMaxUser;
	}
	public void setFutsalMaxUser(int futsalMaxUser) {
		this.futsalMaxUser = futsalMaxUser;
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
	
	public String getFutsalAddr() {
		return futsalAddr;
	}
	public void setFutsalAddr(String futsalAddr) {
		this.futsalAddr = futsalAddr;
	}
	public int getFutsalPrice() {
		return futsalPrice;
	}
	public void setFutsalPrice(int futsalPrice) {
		this.futsalPrice = futsalPrice;
	}
}
