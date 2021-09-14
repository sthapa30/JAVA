package com.uta.service;

import java.util.List;

import com.uta.dto.ResponseUserClub;
import com.uta.dto.UserDTO;

public interface UserServiceInterface {
	
	public List<UserDTO> getAllUserService();
	public ResponseUserClub getUserByIdService(String Id) throws Exception;
	public String addUserService(UserDTO userDto);
	public void deleteUserService(String userId) throws Exception;

	
	

}
