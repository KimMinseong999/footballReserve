package com.football.model.futsal.dto;

public class FutsalReviewDTO {
	
	private int futsalReviewNo;	
	private int futsalNo;
	private String futsalReviewContent;
	private int futsalReviewStar;
	
	public FutsalReviewDTO() {}

	public FutsalReviewDTO(int futsalReviewNo, int futsalNo, String futsalReviewContent, int futsalReviewStar) {
		this.futsalReviewNo = futsalReviewNo;
		this.futsalNo = futsalNo;
		this.futsalReviewContent = futsalReviewContent;
		this.futsalReviewStar = futsalReviewStar;
	}

	public int getFutsalReviewNo() {
		return futsalReviewNo;
	}

	public void setFutsalReviewNo(int futsalReviewNo) {
		this.futsalReviewNo = futsalReviewNo;
	}

	public int getFutsalNo() {
		return futsalNo;
	}

	public void setFutsalNo(int futsalNo) {
		this.futsalNo = futsalNo;
	}

	public String getFutsalReviewContent() {
		return futsalReviewContent;
	}

	public void setFutsalReviewContent(String futsalReviewContent) {
		this.futsalReviewContent = futsalReviewContent;
	}

	public int getFutsalReviewStar() {
		return futsalReviewStar;
	}

	public void setFutsalReviewStar(int futsalReviewStar) {
		this.futsalReviewStar = futsalReviewStar;
	}	
}
