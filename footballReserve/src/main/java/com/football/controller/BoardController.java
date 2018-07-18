package com.football.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.football.model.board.dto.BoardDTO;
import com.football.model.board.dto.ReviewDTO;
import com.football.model.board.service.BoardService;
import com.football.util.Paging;

@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	Paging pagemaker;

	@RequestMapping("/list/{boardType}")
	public ModelAndView moveBoardMain(@PathVariable String boardType, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();

		int currentPageNo = 1; // /(localhost:8080)�������� ���� ó���� ǥ���� ������ (1 = ù��° ������)
		int maxPost = 10; // �������� ǥ�õ� �Խù� �ִ� ����

		if (request.getParameter("pages") != null) // �Խù��� 1����������(=�������� ������ �ȵǾ�����)�� �ƴ϶�� == ����¡�� �����Ǿ��ٸ�
			currentPageNo = Integer.parseInt(request.getParameter("pages")); // pages���ִ� string Ÿ�� ������ int������ �ٲپ
																				// currentPageNo�� ��´�.

		Paging paging = new Paging(currentPageNo, maxPost); // Paging.java���ִ� currentPAgeNo, maxPost�� paging������ ��´�.

		int offset = (paging.getCurrentPageNo() - 1) * paging.getmaxPost(); // query.xml���� select�� �Ҷ� ����ϱ����� offset ������
																			// ����.
		// ���� 3������ �̰�, �� �������� �Խù��� 10���� �ִٸ� offset���� (3-1) * 10 = 20�� �ȴ�.

		/*
		 * �߿���������� ����ϱ� ���� �� ArrayList<WriteInfo> infolist = new ArrayList<WriteInfo>();
		 * infolist = (ArrayList<WriteInfo>) writeService.writeInfoList();
		 */

		ArrayList<BoardDTO> page = new ArrayList<BoardDTO>(); // WriteInfo�� �ִ� �������� ArrayList Ÿ���� �迭�� �� ���� �̸� page��� ������
																// ��´�.
		page = (ArrayList<BoardDTO>) boardService.selectBoardPage(offset, paging.getmaxPost());
		// writeService.java�� �ִ� writeList �Լ��� �̿��Ͽ� offset���� maxPost���� ArrayList Ÿ���� �迭��
		// ���, �� �迭 ��ü�� page ������ ��´�.

		paging.setNumberOfRecords(boardService.selectBoardCount()); // �������� ǥ���ϱ� ���� ��ü �Խù� ���� �ľ��ϱ� ���Ѱ�

		paging.makePaging(); //

		// model.addAttribute("infolist", infolist); �߿� ���������� ����ϱ� ���� ��.
		mv.addObject("boardList", page);
		mv.addObject("paging", paging);

		/*
		 * List<BoardDTO> boardList = boardService.selectBoardList(boardType);
		 * 
		 * mv.addObject("boardList", boardList); mv.addObject("boardType", boardType);
		 */
		mv.setViewName("/board/list/" + boardType);
		return mv;
	}

	@RequestMapping("/delete/{boardType}/{boardNo}")
	public ModelAndView deleteBoardOne(@PathVariable String boardType, @PathVariable int boardNo) {
		ModelAndView mv = new ModelAndView();
		boardService.deleteBoardNo(boardType, boardNo);
		mv.setViewName("redirect:/board/list/" + boardType);
		return mv;
	}

	@RequestMapping("/updateForm/{boardType}/{boardNo}")
	public ModelAndView moveUpdateForm(@PathVariable String boardType, @PathVariable int boardNo) {
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = boardService.selectBoardOne(boardType, boardNo, null, null);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("/board/updateBoardForm");
		return mv;
	}

	@RequestMapping("/update/{boardType}/{boardNo}")
	public ModelAndView updateBoard(@PathVariable String boardType, @PathVariable int boardNo, String boardSub,
			String boardContent) {
		ModelAndView mv = new ModelAndView();
		boardService.updateBoard(boardType, boardNo, boardSub, boardContent);
		mv.setViewName("redirect:/board/list/" + boardType);
		return mv;
	}

	@RequestMapping("/detail/{boardType}/{boardNo}")
	public ModelAndView boardDetail(@PathVariable String boardType, @PathVariable int boardNo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = boardService.selectBoardOne(boardType, boardNo, request, response);
		List<ReviewDTO> reviewList = boardService.selectReviewList(boardType, boardNo);
		mv.addObject("boardDTO", boardDTO);
		mv.addObject("reviewList", reviewList);
		mv.setViewName("/board/detail");
		return mv;
	}

	@RequestMapping("/insertForm/{boardType}")
	public ModelAndView moveInsertForm(@PathVariable String boardType) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/insertBoardForm");
		return mv;

	}

	@RequestMapping("/insert/{boardType}")
	public ModelAndView insertBoard(BoardDTO boardDTO) {
		ModelAndView mv = new ModelAndView();
		boardService.insertBoard(boardDTO);
		mv.setViewName("redirect:/board/list/" + boardDTO.getBoardType());
		return mv;
	}

	@RequestMapping("/insertBoardReview")
	public ModelAndView insertBoardReview(ReviewDTO reviewDTO) {
		ModelAndView mv = new ModelAndView();
		boardService.insertBoardReview(reviewDTO);
		mv.setViewName("redirect:/board/detail/" + reviewDTO.getBoardType() + "/" + reviewDTO.getBoardNo());
		return mv;
	}

	@RequestMapping("/insertBoardReview/{reviewOriginNo}")
	public ModelAndView insertBoardReview(ReviewDTO reviewDTO, @PathVariable int reviewOriginNo) {
		ModelAndView mv = new ModelAndView();
		boardService.insertBoardReview(reviewDTO, reviewOriginNo);
		mv.setViewName("redirect:/board/detail/" + reviewDTO.getBoardType() + "/" + reviewDTO.getBoardNo());
		return mv;
	}
	
	@RequestMapping("/delteBoardReview/{boardType}/{boardNo}/{reviewNo}")
	public ModelAndView delteBoardReview(@PathVariable String boardType, @PathVariable int boardNo, @PathVariable int reviewNo) {
		ModelAndView mv = new ModelAndView();
		boardService.deleteBoardReview(reviewNo);
		mv.setViewName("redirect:/board/detail/" + boardType + "/" + boardNo);
		return mv;

	}

}
