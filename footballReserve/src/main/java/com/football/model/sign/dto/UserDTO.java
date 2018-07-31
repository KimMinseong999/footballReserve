package com.football.model.sign.dto;

import java.util.List;

import com.football.model.board.dto.BoardDTO;
import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalReserveDTO;

public class UserDTO {

	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userDt;
	private String userAuthority;
	private int userPoint;
	private int userUsage;
	private String userGrade;
	private String userKakaoId;
	private List<FutsalDTO> futsalDTO;
	private List<FutsalReserveDTO> futsalReserveDTO;
	private List<BoardDTO> boardDTO;
	
	public UserDTO() {}

	public UserDTO(String userId, String userPwd, String userName, String userEmail, String userPhone, String userDt,
			String userAuthority, int userPoint, int userUsage, String userGrade, String userKakaoId,
			List<FutsalDTO> futsalDTO, List<FutsalReserveDTO> futsalReserveDTO, List<BoardDTO> boardDTO) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userDt = userDt;
		this.userAuthority = userAuthority;
		this.userPoint = userPoint;
		this.userUsage = userUsage;
		this.userGrade = userGrade;
		this.userKakaoId = userKakaoId;
		this.futsalDTO = futsalDTO;
		this.futsalReserveDTO = futsalReserveDTO;
		this.boardDTO = boardDTO;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserDt() {
		return userDt;
	}

	public void setUserDt(String userDt) {
		this.userDt = userDt;
	}

	public String getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public int getUserUsage() {
		return userUsage;
	}

	public void setUserUsage(int userUsage) {
		this.userUsage = userUsage;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getUserKakaoId() {
		return userKakaoId;
	}

	public void setUserKakaoId(String userKakaoId) {
		this.userKakaoId = userKakaoId;
	}

	public List<FutsalDTO> getFutsalDTO() {
		return futsalDTO;
	}

	public void setFutsalDTO(List<FutsalDTO> futsalDTO) {
		this.futsalDTO = futsalDTO;
	}

	public List<FutsalReserveDTO> getFutsalReserveDTO() {
		return futsalReserveDTO;
	}

	public void setFutsalReserveDTO(List<FutsalReserveDTO> futsalReserveDTO) {
		this.futsalReserveDTO = futsalReserveDTO;
	}

	public List<BoardDTO> getBoardDTO() {
		return boardDTO;
	}

	public void setBoardDTO(List<BoardDTO> boardDTO) {
		this.boardDTO = boardDTO;
	}
}
