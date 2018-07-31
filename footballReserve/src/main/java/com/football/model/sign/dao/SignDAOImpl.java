package com.football.model.sign.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.football.model.sign.dto.UserDTO;

@Repository
public class SignDAOImpl implements SignDAO {

	@Autowired
	private SqlSession session;

	@Override
	public void registUser(UserDTO userDTO) {
		session.insert("signMapper.insertUser", userDTO);
	}

	@Override
	public UserDTO loginUser(String userId, String userPwd) {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		
		return session.selectOne("signMapper.selectUserByIdPwd", map);
	}

	@Override
	public UserDTO checkId(String userId) {
		return session.selectOne("signMapper.selectUserOneById", userId);
	}
}
