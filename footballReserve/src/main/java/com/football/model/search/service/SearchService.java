package com.football.model.search.service;

import java.util.List;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalReserveDTO;
import com.football.model.search.dto.SearchFilterDTO;

public interface SearchService {

	List<String> selectSido();

	List<String> selectGugun(String sido);

	List<FutsalDTO> selectFutsalList(SearchFilterDTO searchFilterDTO, int offset, int noOfRecords);

	List<FutsalReserveDTO> selectReserveTime(String date, int futsalNo);


}