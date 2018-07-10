package com.football.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.model.user.dto.UserDTO;
import com.football.model.user.service.SignService;
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
			mv.addObject("message", "���̵� ��й�ȣ�� Ȯ�����ּ���");
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

		HttpSession session = request.getSession();
		session.setAttribute("snsLogin", vo);

		System.out.println(vo.getUserId());
		session.setAttribute("userId", vo.getUserId());
		session.setAttribute("userName", vo.getUserName());
		session.setAttribute("userAuthority", 1);
		
		// vo = service.kakaoLogin(vo);
		mv.setViewName("redirect:/");
		return mv;
	}

}