package com.football.model.board.dto;

import java.util.List;

public class BoardDTO {

	private int boardNo;
	private String boardType;
	private String userId;
	private String boardSub;
	private String boardContent;
	private String boardDt;
	private int boardHit;
	private int startIndex;
	private int pageSize;
	private List<ReviewDTO> reviewDTO;
	
	public BoardDTO() {}

	public BoardDTO(int boardNo, String boardType, String userId, String boardSub, String boardContent, String boardDt,
			int boardHit, int startIndex, int pageSize, List<ReviewDTO> reviewDTO) {
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.userId = userId;
		this.boardSub = boardSub;
		this.boardContent = boardContent;
		this.boardDt = boardDt;
		this.boardHit = boardHit;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
		this.reviewDTO = reviewDTO;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoardSub() {
		return boardSub;
	}

	public void setBoardSub(String boardSub) {
		this.boardSub = boardSub;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDt() {
		return boardDt;
	}

	public void setBoardDt(String boardDt) {
		this.boardDt = boardDt;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<ReviewDTO> getReviewDTO() {
		return reviewDTO;
	}

	public void setReviewDTO(List<ReviewDTO> reviewDTO) {
		this.reviewDTO = reviewDTO;
	}
}
