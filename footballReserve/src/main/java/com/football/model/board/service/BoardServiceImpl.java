package com.football.model.board.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.football.model.board.dao.BoardDAO;
import com.football.model.board.dto.BoardDTO;
import com.football.model.board.dto.ReviewDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardDTO> selectBoardList(String boardType) {

		return boardDAO.selectBoardList(boardType);
	}

	@Override
	public void deleteBoardNo(String boardType, int boardNo) {
		boardDAO.deleteBoardNo(boardType, boardNo);

	}

	@Transactional
	@Override
	public BoardDTO selectBoardOne(String boardType, int boardNo, HttpServletRequest request,
			HttpServletResponse response) {
		BoardDTO boardDTO = boardDAO.selectBoardOne(boardType, boardNo, request, response);
		
		Cookie[] cookies = request.getCookies();
		String boardCookieVal = "";
		boolean hasRead = false;

		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();

				if ("boardCookie".equals(name)) {
					boardCookieVal = value;
					if (boardCookieVal.contains("|" + boardDTO.getBoardNo() + "|")) {
						hasRead = true;
						break;
					}
				}

			}
		}

		// 게시글 읽음 여부 따지기
		if (!hasRead) {
			// 조회수 증가
			boardDTO.setBoardHit(boardDTO.getBoardHit() + 1);
			boardDAO.increaseBoardHit(boardDTO);

			// 쿠키생성
			Cookie boardCookie = new Cookie("boardCookie", boardCookieVal + "|" + boardDTO.getBoardNo() + "|");
			// boardCookie.setPath("/mvc/board"); 안적으면 저절로 현재 경로로 잡힘.
			// boardCookie.setMaxAge(60*60*24); //작성 안하면, 브라우져에 영구저장.
			response.addCookie(boardCookie);
		}

		return boardDTO;
	}

	@Override
	public void updateBoard(String boardType, int boardNo, String boardSub, String boardContent) {
		boardDAO.updateBoard(boardType, boardNo, boardSub, boardContent);
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		boardDAO.insertBoard(boardDTO);
	}

	@Override
	public List<ReviewDTO> selectReviewList(String boardType, int boardNo) {
		return boardDAO.selectReviewList(boardType, boardNo);
	}

	@Transactional
	@Override
	public void insertBoardReview(ReviewDTO reviewDTO) {
		int reviewNo = boardDAO.selectBoardReviewNo(reviewDTO);
		reviewDTO.setReviewOriginNo(reviewNo + 1);
		boardDAO.insertBoardReview(reviewDTO);
	}

	@Override
	public void insertBoardReview(ReviewDTO reviewDTO, int reviewOriginNo) {
		reviewDTO.setReviewOriginNo(reviewOriginNo);
		boardDAO.insertBoardReview(reviewDTO);
	}

	@Override
	public List<BoardDTO> selectBoardPage(int offset, int noOfRecords) throws Exception {
		return boardDAO.selectBoardPage(offset, noOfRecords);
	}

	@Override
	public int selectBoardCount() {
		return boardDAO.selectBoardCount();
	}

}
