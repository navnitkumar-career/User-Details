package net.javaguides.springboot.Service;

import java.util.List;

import net.javaguides.springboot.UserDTO.TeamMappingDTO;


public interface TeamMappingService {
	
	public List<TeamMappingDTO> getList();



	public TeamMappingDTO Add(TeamMappingDTO teamMapping);

	void DeleteById(TeamMappingDTO teamMapping);

}
