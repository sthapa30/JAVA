package com.uta.service;

import java.util.List;

import com.uta.dto.ClubDTO;
import com.uta.dto.ResponseClubEvent;


public interface ClubServiceInterface {
	
	public List<ClubDTO> getAllClubService();
	public ClubDTO getClubByIdService(String Id);
	public ResponseClubEvent getClubEventService(String Id);
	public String createClubService(ClubDTO clubDto);
	public void deleteClubService(String clubId) throws Exception;


}
