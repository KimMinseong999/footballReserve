package com.football.model.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.football.model.board.dto.BoardDTO;
import com.football.model.board.dto.ReviewDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	private Object noOfRecords;

	@Override
	public List<BoardDTO> selectBoardList(String boardType) {

		return session.selectList("boardMapper.selectBoardList", boardType);
	}

	@Override
	public void deleteBoardNo(String boardType, int boardNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", boardType);
		map.put("boardNo", boardNo);

		session.delete("boardMapper.deleteBoardNo", map);
	}

	@Override
	public BoardDTO selectBoardOne(String boardType, int boardNo, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", boardType);
		map.put("boardNo", boardNo);

		return session.selectOne("boardMapper.selectBoardOne", map);
	}

	@Override
	public void updateBoard(String boardType, int boardNo, String boardSub, String boardContent) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", boardType);
		map.put("boardNo", boardNo);
		map.put("boardSub", boardSub);
		map.put("boardContent", boardContent);

		session.update("boardMapper.updateBoard", map);
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		session.insert("boardMapper.insertBoard", boardDTO);
	}

	@Override
	public List<ReviewDTO> selectReviewList(String boardType, int boardNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", boardType);
		map.put("boardNo", boardNo);

		return session.selectList("boardMapper.selectReviewList", map);
	}

	@Override
	public int selectBoardReviewNo(ReviewDTO reviewDTO) {

		return session.selectOne("boardMapper.selectBoardReviewNo", reviewDTO);
	}

	@Override
	public void insertBoardReview(ReviewDTO reviewDTO) {
		session.insert("boardMapper.insertBoardReview", reviewDTO);
	}

	@Override
	public List<BoardDTO> selectBoardPage(int offset, int noOfRecords) {
		List<BoardDTO> writeList = new ArrayList<BoardDTO>();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("offset", offset);
		map.put("noOfRecords", noOfRecords);
		writeList = session.selectList("boardMapper.selectBoardPage", map);
		this.noOfRecords = session.selectOne("boardMapper.selectBoardCount");
		return writeList;
	}

	@Override
	public int selectBoardCount() {
		return session.selectOne("boardMapper.selectBoardCount");
	}

	@Override
	public void increaseBoardHit(BoardDTO boardDTO) {
		session.update("boardMapper.increaseBoardHit", boardDTO);
	}

}
