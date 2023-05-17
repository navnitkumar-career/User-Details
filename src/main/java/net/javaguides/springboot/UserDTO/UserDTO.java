package net.javaguides.springboot.UserDTO;

import java.time.LocalDateTime;

public class UserDTO {

	int id;

	String emailId;

	LocalDateTime dateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime localDateTime) {
		this.dateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", emailId=" + emailId + ", dateTime=" + dateTime + "]";
	}

}
