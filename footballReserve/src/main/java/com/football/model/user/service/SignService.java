package com.football.model.user.service;

import javax.servlet.http.HttpSession;

import com.football.model.user.dto.UserDTO;

public interface SignService {

	public void registUser(UserDTO userDTO);

	public UserDTO loginUser(HttpSession session, String userId, String userPwd);
}
