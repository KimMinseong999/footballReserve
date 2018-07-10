package com.football.model.board.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.football.model.board.dto.BoardDTO;
import com.football.model.board.dto.ReviewDTO;

public interface BoardDAO {

	List<BoardDTO> selectBoardList(String boardType);

	void deleteBoardNo(String boardType, int boardNo);

	BoardDTO selectBoardOne(String boardType, int boardNo, HttpServletRequest request, HttpServletResponse response);

	void updateBoard(String boardType, int boardNo, String boardSub, String boardContent);

	void insertBoard(BoardDTO boardDTO);

	List<ReviewDTO> selectReviewList(String boardType, int boardNo);

	int selectBoardReviewNo(ReviewDTO reviewDTO);

	void insertBoardReview(ReviewDTO reviewDTO);

	List<BoardDTO> selectBoardPage(int offset, int noOfRecords);

	int selectBoardCount();

	void increaseBoardHit(BoardDTO boardDTO);


}
