package com.football.model.user.dao;

import com.football.model.user.dto.UserDTO;

public interface SignDAO {

	public void registUser(UserDTO userDTO);

	public UserDTO loginUser(String userId, String userPwd);
	
}
