package com.football.model.futsal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalFacilitiesDTO;
import com.football.model.futsal.dto.FutsalImageDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalRentalDTO;

public interface FutsalService {

	void insertFutsal(FutsalDTO futsalDTO, FutsalFacilitiesDTO futsalFacilitiesDTO, FutsalRentalDTO futsalRentalDTO,
			FutsalPPHDTO futsalPPHDTO, FutsalImageDTO futsalImageDTO, String imgPath, List<MultipartFile> mf) throws Exception;

	List<FutsalDTO> selectFutsalListPage(int offset, int noOfRecords);

	int selectFutsalCount();

	FutsalDTO selectFutsalOne(int futsalNo);

	void insertFutsalReserve(String date, String hh, int futsalNo, String loginId);

}
