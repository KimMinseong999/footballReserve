package com.football.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalReserveDTO;
import com.football.model.futsal.service.FutsalService;
import com.football.model.search.dto.SearchFilterDTO;
import com.football.model.search.service.SearchService;
import com.football.util.Paging;

@RequestMapping("/search")
@Controller
public class SearchController {

	@Autowired
	SearchService searchService;

	@Autowired
	FutsalService futsalService;

	@RequestMapping("/selectSido")
	public List<String> selectSido() {
		return searchService.selectSido();
	}

	@ResponseBody
	@RequestMapping("/selectGugun")
	public List<String> selectSido(String sido) {
		return searchService.selectGugun(sido);
	}

	@ResponseBody
	@RequestMapping("/selectFutsalList")
	public Map<String, Object> selectFutsalList(HttpServletRequest request, SearchFilterDTO searchFilterDTO) {

		int currentPageNo = 1;
		int maxPost = 10;
		if (request.getParameter("pages") != null)
			currentPageNo = Integer.parseInt(request.getParameter("pages"));
		Paging paging = new Paging(currentPageNo, maxPost);
		int offset = (paging.getCurrentPageNo() - 1) * paging.getmaxPost();

		List<FutsalDTO> futsalList = new ArrayList<>();
		futsalList = searchService.selectFutsalList(searchFilterDTO, offset, paging.getmaxPost());

		paging.setNumberOfRecords(futsalService.selectFutsalCount());
		paging.makePaging();

		Map<String, Object> map = new HashMap<>();
		map.put("futsalList", futsalList);
		map.put("paging", paging);

		return map;
	}

	@ResponseBody
	@RequestMapping("/selectReserveTime")
	public List<FutsalReserveDTO> selectReserveTime(String date, int futsalNo) {
		List<FutsalReserveDTO> futsalReserveList = searchService.selectReserveTime(date, futsalNo);
		System.out.println(futsalReserveList);
		if(futsalReserveList==null) {
			System.out.println("null¿Ã∂Û ¬Ô¿Ω");
		}
		return futsalReserveList;
	}
}
