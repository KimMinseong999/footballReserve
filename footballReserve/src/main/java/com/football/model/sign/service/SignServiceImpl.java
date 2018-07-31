package com.football.model.sign.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.model.sign.dao.SignDAO;
import com.football.model.sign.dto.UserDTO;

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

	@Override
	public UserDTO checkId(String userId) {		
		return signDAO.checkId(userId);
	}	
}
