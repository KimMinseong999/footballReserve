package com.football.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.model.sign.dto.UserDTO;
import com.football.model.sign.service.SignService;
import com.football.util.KakaoLogin;

@RequestMapping("/sign")
@Controller
public class SignController {

	@Autowired
	SignService signService;

	@RequestMapping("/loginForm")
	public ModelAndView moveLoginForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sign/loginForm");
		return mv;
	}

	@RequestMapping("/registForm")
	public ModelAndView moveregistForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sign/registForm");
		return mv;
	}

	@RequestMapping("/regist")
	public ModelAndView regist(UserDTO userDTO) {
		ModelAndView mv = new ModelAndView();
		signService.registUser(userDTO);
		mv.setViewName("redirect:/");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpSession session, String userId, String userPwd) {
		ModelAndView mv = new ModelAndView();
		UserDTO userDTO = signService.loginUser(session, userId, userPwd);
		if (userDTO == null) {
			mv.setViewName("/sign/loginForm");
			mv.addObject("message", "아이디나 비밀번호를 확인해주세요");
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}

	@RequestMapping("/kakaologin")
	public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
			HttpServletResponse httpServlet) {
		ModelAndView mv = new ModelAndView();
		JsonNode token = KakaoLogin.getAccessToken(code);
		JsonNode profile = KakaoLogin.getKakaoUserInfo(token.path("access_token").toString());
		UserDTO vo = KakaoLogin.changeData(profile);
		System.out.println(vo.getUserName());
		HttpSession session = request.getSession();
		session.setAttribute("snsLogin", vo);
		System.out.println(vo.getUserId()+"3");

		session.setAttribute("userId", "kakaoLoginUser"+vo.getUserId()+vo.getUserName());
		session.setAttribute("userName", vo.getUserName());
		session.setAttribute("userAuthority", 1);
		
		// vo = service.kakaoLogin(vo);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/checkId", produces="application/text;charset=utf8")
	public String checkID(@RequestParam String userId) {
		UserDTO userDTO = signService.checkId(userId);
		
		String flag;
		if(userDTO!=null) {
			flag="duplicated";//중복
		}else {
			flag="notDuplicated";//중복 아님
		}
		
		return flag;
	}

}