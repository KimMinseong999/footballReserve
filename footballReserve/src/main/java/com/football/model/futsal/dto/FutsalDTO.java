package com.football.model.futsal.dto;

import java.util.List;

public class FutsalDTO {

	private int futsalNo;
	private String userId;
	private String futsalSub;
	private String futsalContent;
	private String futsalAddr;
	private String futsalMaxUser;

	private FutsalFacilitiesDTO futsalFacilitiesDTO;
	private FutsalRentalDTO futsalRentalDTO;
	private FutsalPPHDTO futsalPPHDTO;
	private List<FutsalImageDTO> futsalImageDTO;
	private List<FutsalReviewDTO> futsalReviewDTO;
	private List<FutsalReserveDTO> futsalReserveDTO;
	
	public FutsalDTO() {}
	
	public FutsalDTO(int futsalNo, String userId, String futsalSub, String futsalContent, String futsalAddr,
			String futsalMaxUser, FutsalFacilitiesDTO futsalFacilitiesDTO, FutsalRentalDTO futsalRentalDTO,
			FutsalPPHDTO futsalPPHDTO, List<FutsalImageDTO> futsalImageDTO, List<FutsalReviewDTO> futsalReviewDTO,
			List<FutsalReserveDTO> futsalReserveDTO) {
		this.futsalNo = futsalNo;
		this.userId = userId;
		this.futsalSub = futsalSub;
		this.futsalContent = futsalContent;
		this.futsalAddr = futsalAddr;
		this.futsalMaxUser = futsalMaxUser;
		this.futsalFacilitiesDTO = futsalFacilitiesDTO;
		this.futsalRentalDTO = futsalRentalDTO;
		this.futsalPPHDTO = futsalPPHDTO;
		this.futsalImageDTO = futsalImageDTO;
		this.futsalReviewDTO = futsalReviewDTO;
		this.futsalReserveDTO = futsalReserveDTO;
	}

	public int getFutsalNo() {
		return futsalNo;
	}

	public void setFutsalNo(int futsalNo) {
		this.futsalNo = futsalNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFutsalSub() {
		return futsalSub;
	}

	public void setFutsalSub(String futsalSub) {
		this.futsalSub = futsalSub;
	}

	public String getFutsalContent() {
		return futsalContent;
	}

	public void setFutsalContent(String futsalContent) {
		this.futsalContent = futsalContent;
	}

	public String getFutsalAddr() {
		return futsalAddr;
	}

	public void setFutsalAddr(String futsalAddr) {
		this.futsalAddr = futsalAddr;
	}

	public String getFutsalMaxUser() {
		return futsalMaxUser;
	}

	public void setFutsalMaxUser(String futsalMaxUser) {
		this.futsalMaxUser = futsalMaxUser;
	}

	public FutsalFacilitiesDTO getFutsalFacilitiesDTO() {
		return futsalFacilitiesDTO;
	}

	public void setFutsalFacilitiesDTO(FutsalFacilitiesDTO futsalFacilitiesDTO) {
		this.futsalFacilitiesDTO = futsalFacilitiesDTO;
	}

	public FutsalRentalDTO getFutsalRentalDTO() {
		return futsalRentalDTO;
	}

	public void setFutsalRentalDTO(FutsalRentalDTO futsalRentalDTO) {
		this.futsalRentalDTO = futsalRentalDTO;
	}

	public FutsalPPHDTO getFutsalPPHDTO() {
		return futsalPPHDTO;
	}

	public void setFutsalPPHDTO(FutsalPPHDTO futsalPPHDTO) {
		this.futsalPPHDTO = futsalPPHDTO;
	}

	public List<FutsalImageDTO> getFutsalImageDTO() {
		return futsalImageDTO;
	}

	public void setFutsalImageDTO(List<FutsalImageDTO> futsalImageDTO) {
		this.futsalImageDTO = futsalImageDTO;
	}

	public List<FutsalReviewDTO> getFutsalReviewDTO() {
		return futsalReviewDTO;
	}

	public void setFutsalReviewDTO(List<FutsalReviewDTO> futsalReviewDTO) {
		this.futsalReviewDTO = futsalReviewDTO;
	}

	public List<FutsalReserveDTO> getFutsalReserveDTO() {
		return futsalReserveDTO;
	}

	public void setFutsalReserveDTO(List<FutsalReserveDTO> futsalReserveDTO) {
		this.futsalReserveDTO = futsalReserveDTO;
	}
}
