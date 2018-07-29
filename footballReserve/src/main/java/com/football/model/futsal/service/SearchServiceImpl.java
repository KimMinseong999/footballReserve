package com.football.model.futsal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.search.dto.SearchFilterDTO;
import com.football.model.serach.dao.SearchDAO;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	SearchDAO searchDAO;
	
	@Override
	public List<String> selectSido() {
		return searchDAO.selectSido();
	}

	@Override
	public List<String> selectGugun(String sido) {
		return searchDAO.selectGugun(sido);
	}

	@Override
	public List<FutsalDTO> selectFutsalList(SearchFilterDTO searchFilterDTO, int offset, int noOfRecords) {
		return searchDAO.selectFutsalList(searchFilterDTO, offset, noOfRecords);
	}

}
