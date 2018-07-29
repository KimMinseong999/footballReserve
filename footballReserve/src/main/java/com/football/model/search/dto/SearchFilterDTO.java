package com.football.model.search.dto;

public class SearchFilterDTO {
	private String sido;
	private String gugun;
	private int futsalMaxUser;
	private String futsalStart;
	private String futsalEnd;
	
	public SearchFilterDTO() {}
	public SearchFilterDTO(String sido, String gugun, int futsalMaxUser, String futsalStart, String futsalEnd) {
		this.sido = sido;
		this.gugun = gugun;
		this.futsalMaxUser = futsalMaxUser;
		this.futsalStart = futsalStart;
		this.futsalEnd = futsalEnd;
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
}
