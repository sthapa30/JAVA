package com.uta.dto;

import java.util.List;

public class ResponseClubEvent {

	private ClubDTO clubDto;

	public ClubDTO getClubDto() {
		return clubDto;
	}

	public void setClubDto(ClubDTO clubDto) {
		this.clubDto = clubDto;
	}

	public List<EventDTO> getEventDto() {
		return eventDto;
	}

	public void setEventDto(List<EventDTO> eventDto) {
		this.eventDto = eventDto;
	}

	private List<EventDTO> eventDto;

}
