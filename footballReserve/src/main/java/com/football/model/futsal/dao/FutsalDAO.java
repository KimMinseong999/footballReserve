package com.football.model.futsal.dao;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalFacilitiesDTO;
import com.football.model.futsal.dto.FutsalImageDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalRentalDTO;

public interface FutsalDAO {

	void insertFutsal(FutsalDTO futsalDTO);

	void insertFutsalFacilities(FutsalFacilitiesDTO futsalFacilitiesDTO);

	void insertFutsalRental(FutsalRentalDTO futsalRentalDTO);

	void insertFutsalPPH(FutsalPPHDTO futsalPPHDTO);

	int insertImg(FutsalImageDTO futsalImageDTO);

	int selectFutsalNo();

}