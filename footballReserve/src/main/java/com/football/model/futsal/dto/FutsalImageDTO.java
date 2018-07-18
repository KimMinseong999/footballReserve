package com.football.model.futsal.dto;

import org.springframework.web.multipart.MultipartFile;

public class FutsalImageDTO {

	private int futsalImageNo;
	private int futsalNo;
	private String futsalImagePath;
	private MultipartFile files;
	
	public FutsalImageDTO() {}

	public FutsalImageDTO(int futsalImageNo, int futsalNo, String futsalImagePath, MultipartFile files) {
		this.futsalImageNo = futsalImageNo;
		this.futsalNo = futsalNo;
		this.futsalImagePath = futsalImagePath;
		this.files = files;
	}

	public int getFutsalImageNo() {
		return futsalImageNo;
	}

	public void setFutsalImageNo(int futsalImageNo) {
		this.futsalImageNo = futsalImageNo;
	}

	public int getFutsalNo() {
		return futsalNo;
	}

	public void setFutsalNo(int futsalNo) {
		this.futsalNo = futsalNo;
	}

	public String getFutsalImagePath() {
		return futsalImagePath;
	}

	public void setFutsalImagePath(String futsalImagePath) {
		this.futsalImagePath = futsalImagePath;
	}

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}
}
