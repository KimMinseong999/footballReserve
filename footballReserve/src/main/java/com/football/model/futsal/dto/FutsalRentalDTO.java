package com.football.model.futsal.dto;

public class FutsalRentalDTO {

	private int futsalNo;
	private char futsalRentalBall;
	private char futsalRentalUniform;
	private char futsalRentalShoes;
	
	public FutsalRentalDTO(int futsalNo, char futsalRentalBall, char futsalRentalUniform, char futsalRentalShoes) {
		this.futsalNo = futsalNo;
		this.futsalRentalBall = futsalRentalBall;
		this.futsalRentalUniform = futsalRentalUniform;
		this.futsalRentalShoes = futsalRentalShoes;
	}

	public FutsalRentalDTO() {}

	public int getFutsalNo() {
		return futsalNo;
	}

	public void setFutsalNo(int futsalNo) {
		this.futsalNo = futsalNo;
	}

	public char getFutsalRentalBall() {
		return futsalRentalBall;
	}

	public void setFutsalRentalBall(char futsalRentalBall) {
		this.futsalRentalBall = futsalRentalBall;
	}

	public char getFutsalRentalUniform() {
		return futsalRentalUniform;
	}

	public void setFutsalRentalUniform(char futsalRentalUniform) {
		this.futsalRentalUniform = futsalRentalUniform;
	}

	public char getFutsalRentalShoes() {
		return futsalRentalShoes;
	}

	public void setFutsalRentalShoes(char futsalRentalShoes) {
		this.futsalRentalShoes = futsalRentalShoes;
	}	
}
