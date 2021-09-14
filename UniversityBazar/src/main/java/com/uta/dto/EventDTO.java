package com.uta.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVENT")
public class EventDTO {
	
	@Id
	@Column(name="EVENT_ID")
	private String eventID;
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getClubID() {
		return clubID;
	}
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	
	@Column(name="EVENT_NAME")
	private String eventName;
	
	@Column(name="EVENT_DESC")
	private String eventDescription;
	
	@Column(name="CLUB_ID")
	private String clubID;

}
