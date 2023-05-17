package net.javaguides.springboot.Service;

import java.util.List;

import net.javaguides.springboot.UserDTO.UserDTO;


public interface UserService {
	
	public List<UserDTO> getList();

	public boolean Update(UserDTO user);

	public boolean Add(UserDTO user);

	public boolean DeleteById(String emailId);
	
	public boolean validRequest(UserDTO user);

}
