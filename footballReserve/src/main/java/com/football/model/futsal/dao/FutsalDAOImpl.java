package com.football.model.futsal.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.football.model.board.dto.BoardDTO;
import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalFacilitiesDTO;
import com.football.model.futsal.dto.FutsalImageDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalRentalDTO;

@Repository
public class FutsalDAOImpl implements FutsalDAO {

	@Autowired
	private SqlSession session;
	private Object noOfRecords;

	@Override
	public void insertFutsal(FutsalDTO futsalDTO) {
		session.insert("futsalMapper.insertFutsal", futsalDTO);
	}

	@Override
	public void insertFutsalFacilities(FutsalFacilitiesDTO futsalFacilitiesDTO) {
		session.insert("futsalMapper.insertFutsalFacilities", futsalFacilitiesDTO);

	}

	@Override
	public void insertFutsalRental(FutsalRentalDTO futsalRentalDTO) {
		session.insert("futsalMapper.insertFutsalRental", futsalRentalDTO);
	}

	@Override
	public void insertFutsalPPH(FutsalPPHDTO futsalPPHDTO) {
		session.insert("futsalMapper.insertFutsalPPH", futsalPPHDTO);
	}

	@Override
	public int insertImg(FutsalImageDTO futsalImageDTO) {
		return session.insert("futsalMapper.insertImg", futsalImageDTO);
	}

	@Override
	public int selectFutsalNo() {
		return session.selectOne("futsalMapper.selectFutsalNo");
	}

	@Override
	public List<FutsalDTO> selectFutsalListPage(int offset, int noOfRecords) {
		List<FutsalDTO> futsalList = new ArrayList<FutsalDTO>();
		Map<String, Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("noOfRecords", noOfRecords);

		futsalList = session.selectList("futsalMapper.selectFutsalListPage", map);
		this.noOfRecords = session.selectOne("futsalMapper.selectFutsalCount");
		return futsalList;
	}

	@Override
	public int selectfutsalCount() {
		return session.selectOne("futsalMapper.selectFutsalCount");
	}

	@Override
	public FutsalDTO selectFutsalOne(int futsalNo) {
		return session.selectOne("futsalMapper.selectFutsalOne", futsalNo);
	}

}
