package com.football.model.futsal.dto;

public class FutsalFacilitiesDTO {

	private int futsalNo;
	private char futsalGrass;
	private char futsalLight;
	private char futsalShowerRoom;
	private char futsalPark;
	
	public FutsalFacilitiesDTO() {}

	public FutsalFacilitiesDTO(int futsalNo, char futsalGrass, char futsalLight, char futsalShowerRoom,
			char futsalPark) {
		this.futsalNo = futsalNo;
		this.futsalGrass = futsalGrass;
		this.futsalLight = futsalLight;
		this.futsalShowerRoom = futsalShowerRoom;
		this.futsalPark = futsalPark;
	}

	public int getFutsalNo() {
		return futsalNo;
	}

	public void setFutsalNo(int futsalNo) {
		this.futsalNo = futsalNo;
	}

	public char getFutsalGrass() {
		return futsalGrass;
	}

	public void setFutsalGrass(char futsalGrass) {
		this.futsalGrass = futsalGrass;
	}

	public char getFutsalLight() {
		return futsalLight;
	}

	public void setFutsalLight(char futsalLight) {
		this.futsalLight = futsalLight;
	}

	public char getFutsalShowerRoom() {
		return futsalShowerRoom;
	}

	public void setFutsalShowerRoom(char futsalShowerRoom) {
		this.futsalShowerRoom = futsalShowerRoom;
	}

	public char getFutsalPark() {
		return futsalPark;
	}

	public void setFutsalPark(char futsalPark) {
		this.futsalPark = futsalPark;
	}
}
