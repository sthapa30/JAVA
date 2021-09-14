package com.uta.dto;

public class ResponseUserClub {
	
	private ClubDTO clubDto;
	public ClubDTO getClubDto() {
		return clubDto;
	}
	public void setClubDto(ClubDTO clubDto) {
		this.clubDto = clubDto;
	}
	public UserDTO getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
	private UserDTO userDto;

}
