package com.football.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalFacilitiesDTO;
import com.football.model.futsal.dto.FutsalImageDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalRentalDTO;
import com.football.model.futsal.service.FutsalService;
import com.football.model.futsal.service.SearchService;
import com.football.util.Paging;

@RequestMapping("/futsal")
@Controller
public class FutsalController {

	@Autowired
	FutsalService futsalService;
	private String imgPath;
	
	@Autowired
	SearchService searchService;

	@RequestMapping("/insertFutsalForm")
	public ModelAndView moveFutsalInsertForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/futsal/insertFutsalForm");
		return mv;
	}

	@RequestMapping("/insert")
	public ModelAndView insertFutsal(HttpSession session, MultipartHttpServletRequest req, FutsalDTO futsalDTO,
			FutsalFacilitiesDTO futsalFacilitiesDTO, FutsalRentalDTO futsalRentalDTO, FutsalPPHDTO futsalPPHDTO,
			FutsalImageDTO futsalImageDTO) throws Exception {

		ModelAndView mv = new ModelAndView();
		List<MultipartFile> mf = req.getFiles("files");
		imgPath = session.getServletContext().getRealPath("/resources/images/futsalImages");// 파일 저장 폴더 경로

		mv.setViewName("/futsal/myFutsalList");
		futsalService.insertFutsal(futsalDTO, futsalFacilitiesDTO, futsalRentalDTO, futsalPPHDTO, futsalImageDTO,
				imgPath, mf);
		return mv;
	}

	@RequestMapping("/reserveForm")
	public ModelAndView reserveForm(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<String> list =searchService.selectSido();
		
		mv.addObject("sidoList",list);
		
		mv.setViewName("/futsal/reserveForm");
		return mv;
	}
	
	@RequestMapping("/reserveDetailForm/{futsalNo}")
	public ModelAndView moveReserverDetailForm(@PathVariable int futsalNo) {
		ModelAndView mv = new ModelAndView();
		FutsalDTO futsalDTO = futsalService.selectFutsalOne(futsalNo);
		mv.addObject("futsalDTO", futsalDTO);
		mv.setViewName("/futsal/reserveDetailForm");
		return mv;
	}
}
