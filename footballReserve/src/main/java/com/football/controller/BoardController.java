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

		int currentPageNo = 1; // /(localhost:8080)페이지로 오면 처음에 표시할 페이지 (1 = 첫번째 페이지)
		int maxPost = 10; // 페이지당 표시될 게시물 최대 갯수

		if (request.getParameter("pages") != null) // 게시물이 1개도없으면(=페이지가 생성이 안되었으면)이 아니라면 == 페이징이 생성되었다면
			currentPageNo = Integer.parseInt(request.getParameter("pages")); // pages에있는 string 타입 변수를 int형으로 바꾸어서
																				// currentPageNo에 담는다.

		Paging paging = new Paging(currentPageNo, maxPost); // Paging.java에있는 currentPAgeNo, maxPost를 paging변수에 담는다.

		int offset = (paging.getCurrentPageNo() - 1) * paging.getmaxPost(); // query.xml에서 select를 할때 사용하기위한 offset 변수의
																			// 선언.
		// 현재 3페이지 이고, 그 페이지에 게시물이 10개가 있다면 offset값은 (3-1) * 10 = 20이 된다.

		/*
		 * 중요공지사항을 사용하기 위한 것 ArrayList<WriteInfo> infolist = new ArrayList<WriteInfo>();
		 * infolist = (ArrayList<WriteInfo>) writeService.writeInfoList();
		 */

		ArrayList<BoardDTO> page = new ArrayList<BoardDTO>(); // WriteInfo에 있는 변수들을 ArrayList 타입의 배열로 둔 다음 이를 page라는 변수에
																// 담는다.
		page = (ArrayList<BoardDTO>) boardService.selectBoardPage(offset, paging.getmaxPost());
		// writeService.java에 있는 writeList 함수를 이용하여 offset값과 maxPost값을 ArrayList 타입의 배열로
		// 담고, 이 배열 자체를 page 변수에 담는다.

		paging.setNumberOfRecords(boardService.selectBoardCount()); // 페이지를 표시하기 위해 전체 게시물 수를 파악하기 위한것

		paging.makePaging(); //

		// model.addAttribute("infolist", infolist); 중요 공지사항을 사용하기 위한 것.
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
		mv.setViewName("/board/updateForm");
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
		mv.setViewName("/board/insertForm");
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

}
