package com.football.model.sign.dao;

import com.football.model.sign.dto.UserDTO;

public interface SignDAO {

	public void registUser(UserDTO userDTO);

	public UserDTO loginUser(String userId, String userPwd);

	public UserDTO checkId(String userId);
	
}
