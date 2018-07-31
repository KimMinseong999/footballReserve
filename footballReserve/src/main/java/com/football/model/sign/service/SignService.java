package com.football.model.sign.service;

import javax.servlet.http.HttpSession;

import com.football.model.sign.dto.UserDTO;

public interface SignService {

	public void registUser(UserDTO userDTO);

	public UserDTO loginUser(HttpSession session, String userId, String userPwd);

	public UserDTO checkId(String userId);
}
