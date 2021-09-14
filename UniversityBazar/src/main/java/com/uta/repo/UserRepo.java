package com.uta.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uta.dto.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, String>{
	
//	@Override List<UserDTO>findAll();
//	 List<UserDTO> getUserByIdService(String Id);
	

}
