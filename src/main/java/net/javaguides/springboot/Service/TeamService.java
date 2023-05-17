package net.javaguides.springboot.Service;

import java.util.List;

import net.javaguides.springboot.UserDTO.TeamDTO;


public interface TeamService {
	
	public List<TeamDTO> getList();

	public boolean  Update(TeamDTO team);

	public boolean Add(TeamDTO team);

	public boolean DeleteById(String teamName);
	
	

}
