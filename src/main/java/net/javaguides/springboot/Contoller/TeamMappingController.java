package net.javaguides.springboot.Contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.Service.TeamMappingService;
import net.javaguides.springboot.UserDTO.TeamMappingDTO;

@RestController
@RequestMapping("/teammapping")
public class TeamMappingController {

	@Autowired
	TeamMappingService teamMappingService;

	@GetMapping(path = "getlist", produces = "application/json")
	public List<TeamMappingDTO> getList() {

		List<TeamMappingDTO> teamMappingList = teamMappingService.getList();

		return teamMappingList;
	}

	@PostMapping(path = "add", produces = "application/json", consumes = "application/json")
	public Map<String, String> Add(@RequestBody TeamMappingDTO team) {
		
		teamMappingService.Add(team);

		HashMap<String, String> map = new HashMap<>();
		map.put("status", "success");
		map.put("message", "Record Added");

		return map;
	}

	@GetMapping(path = "delete", produces = "application/json")
	public Map<String, String> delete(@RequestBody TeamMappingDTO teamMapping) {

		teamMappingService.DeleteById(teamMapping);

		HashMap<String, String> map = new HashMap<>();
		map.put("status", "success");
		map.put("message", "Record Deleted");

		return map;

	}

}
