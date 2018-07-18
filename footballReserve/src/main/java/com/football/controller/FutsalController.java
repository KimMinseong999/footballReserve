package com.football.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalFacilitiesDTO;
import com.football.model.futsal.dto.FutsalImageDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalRentalDTO;
import com.football.model.futsal.service.FutsalService;

@RequestMapping("/futsal")
@Controller
public class FutsalController {

	@Autowired
	FutsalService futsalService;
	private String imgPath;

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
}

/*
 * System.out.println("주차장등록 컨트롤러 진입"); UserDTO
 * userDTO=(UserDTO)SecurityContextHolder.getContext().getAuthentication().
 * getPrincipal(); ModelAndView mv = new ModelAndView();
 * System.out.println(userDTO.getUserId());
 * parkDto.setUserId(userDTO.getUserId());
 * 
 * //멀티 파일 업로드 List<MultipartFile> mf = req.getFiles("files"); imgPath =
 * session.getServletContext().getRealPath("/resources/images/park");// 파일 저장 폴더
 * 경로
 * 
 * service.sellerParkRegist(parkDto, carTypeDto, parkImgDto, parkRegiDto,
 * imgPath, mf);
 * 
 * mv.setViewName("redirect:/seller/sellerParkList");
 */