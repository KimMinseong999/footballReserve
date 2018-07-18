package com.football.model.futsal.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalFacilitiesDTO;
import com.football.model.futsal.dto.FutsalImageDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalRentalDTO;

@Repository
public class FutsalDAOImpl implements FutsalDAO {

	@Autowired
	private SqlSession session;

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

}
