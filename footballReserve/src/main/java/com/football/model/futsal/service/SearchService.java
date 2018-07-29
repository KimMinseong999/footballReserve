package com.football.model.futsal.service;

import java.util.List;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.search.dto.SearchFilterDTO;

public interface SearchService {

	List<String> selectSido();

	List<String> selectGugun(String sido);

	List<FutsalDTO> selectFutsalList(SearchFilterDTO searchFilterDTO, int offset, int noOfRecords);

}
