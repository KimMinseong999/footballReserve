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
import com.football.model.futsal.service.FutsalService;
import com.football.model.futsal.service.SearchService;
import com.football.model.search.dto.SearchFilterDTO;
import com.football.util.Paging;

@RequestMapping("/search")
@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@Autowired
	FutsalService futsalService;
	
	@RequestMapping("/selectSido")
	public List<String> selectSido(){
		return searchService.selectSido();
	}
	
	@ResponseBody
	@RequestMapping("/selectGugun")
	public List<String> selectSido(String sido){
		return searchService.selectGugun(sido);
	}
	
	@ResponseBody
	@RequestMapping("/selectFutsalList")
	public Map<String,Object> selectFutsalList(HttpServletRequest request,SearchFilterDTO searchFilterDTO){
		System.out.println(searchFilterDTO.getSido());
		System.out.println(searchFilterDTO.getGugun());
		System.out.println(searchFilterDTO.getFutsalStart());
		System.out.println(searchFilterDTO.getFutsalEnd());
		System.out.println(searchFilterDTO.getFutsalMaxUser());
		
		int currentPageNo = 1;
		int maxPost = 5;
		if (request.getParameter("pages") != null)
			currentPageNo = Integer.parseInt(request.getParameter("pages"));
		Paging paging = new Paging(currentPageNo, maxPost);
		int offset = (paging.getCurrentPageNo() - 1) * paging.getmaxPost();
		
		List<FutsalDTO> futsalList = new ArrayList<>();
/*		futsalList = futsalService.selectFutsalListPage(offset, paging.getmaxPost());*/
		futsalList = searchService.selectFutsalList(searchFilterDTO,offset,paging.getmaxPost());

		paging.setNumberOfRecords(futsalService.selectFutsalCount());
		paging.makePaging();
		
		Map<String,Object> map = new HashMap<>();
		map.put("futsalList", futsalList);
		map.put("paging", paging);
		for(FutsalDTO futsal:futsalList) {
			System.out.println(futsal.getFutsalAddr() + "==  林家");
			System.out.println(futsal.getFutsalSub() + "  == 力格");
			
		}

		return map;
	}
}
