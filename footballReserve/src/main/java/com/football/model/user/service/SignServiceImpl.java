package com.football.model.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.model.user.dao.SignDAO;
import com.football.model.user.dto.UserDTO;

@Service
public class SignServiceImpl implements SignService{

	@Autowired
	SignDAO signDAO;
	
	@Override
	public void registUser(UserDTO userDTO) {
		signDAO.registUser(userDTO);
	}

	@Override
	public UserDTO loginUser(HttpSession session, String userId, String userPwd) {
		UserDTO userDTO = signDAO.loginUser(userId, userPwd);

		if(userDTO!=null) {
		session.setAttribute("userId", userDTO.getUserId());
		session.setAttribute("userName", userDTO.getUserName());
		session.setAttribute("userAuthority", userDTO.getUserAuthority());
		}
		return userDTO;
	}	
}
