package com.football.model.board.dto;

public class ReviewDTO {
	
	private int reviewNo;
	private int reviewOriginNo;
	private int boardNo;
	private String boardType;
	private String reviewContent;
	private String reviewWriter;
	private String reviewDt;
	private int groupOrd;
	private int groupLayer;
	
	public ReviewDTO() {}

	public ReviewDTO(int reviewNo, int reviewOriginNo, int boardNo, String boardType, String reviewContent,
			String reviewWriter, String reviewDt, int groupOrd, int groupLayer) {
		super();
		this.reviewNo = reviewNo;
		this.reviewOriginNo = reviewOriginNo;
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.reviewContent = reviewContent;
		this.reviewWriter = reviewWriter;
		this.reviewDt = reviewDt;
		this.groupOrd = groupOrd;
		this.groupLayer = groupLayer;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getReviewOriginNo() {
		return reviewOriginNo;
	}

	public void setReviewOriginNo(int reviewOriginNo) {
		this.reviewOriginNo = reviewOriginNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getReviewDt() {
		return reviewDt;
	}

	public void setReviewDt(String reviewDt) {
		this.reviewDt = reviewDt;
	}

	public int getGroupOrd() {
		return groupOrd;
	}

	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}

	public int getGroupLayer() {
		return groupLayer;
	}

	public void setGroupLayer(int groupLayer) {
		this.groupLayer = groupLayer;
	}
}
