package com.football.model.serach.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalReserveDTO;
import com.football.model.search.dto.SearchFilterDTO;

@Repository
public class SearchDAOImpl implements SearchDAO{

	@Autowired
	SqlSession session;
	private Object noOfRecords;
	
	@Override	
	public List<String> selectSido() {
		return session.selectList("searchMapper.selectSidoList");
	}

	@Override
	public List<String> selectGugun(String sido) {
		return session.selectList("searchMapper.selectGugunList",sido);
	}

	@Override
	public List<FutsalDTO> selectFutsalList(SearchFilterDTO searchFilterDTO, int offset, int noOfRecords) {
		
		List<FutsalDTO> futsalList = new ArrayList<FutsalDTO>();
		Map<String, Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("noOfRecords", noOfRecords);
		map.put("searchFilterDTO", searchFilterDTO);

		futsalList = session.selectList("searchMapper.selectFutsalListPage", map);
		this.noOfRecords = session.selectOne("futsalMapper.selectFutsalCount");
	
		return futsalList;
	}

	@Override
	public List<FutsalReserveDTO> selectReserveTime(String date, int futsalNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("date", date);
		map.put("futsalNo", futsalNo);
		
		return session.selectList("searchMapper.selectReserveTime", map);
	}
}
