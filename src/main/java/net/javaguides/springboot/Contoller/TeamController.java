package net.javaguides.springboot.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.Service.TeamService;
import net.javaguides.springboot.UserDTO.TeamDTO;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	TeamService teamService;

	@GetMapping(path = "getlist", produces = "application/json")
	public List<TeamDTO> getList() {

		List<TeamDTO> teamList = teamService.getList();

		return teamList;
	}

	@PostMapping(path = "add", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> Add(@RequestBody TeamDTO team) {

		boolean flag = teamService.Add(team);

		if (flag) {
			return ResponseEntity.ok("Added Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Team Name already exist.");
		}
	}

	@GetMapping(path = "delete/{teamName}", produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable("teamName") String teamName) {

		boolean flag = teamService.DeleteById(teamName);

		if (flag) {
			return ResponseEntity.ok("Deleted Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Team Name does not exist.");
		}

	}

	@PutMapping(path = "update", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> Update(@RequestBody TeamDTO team) {

		boolean flag = teamService.Update(team);

		if (flag) {
			return ResponseEntity.ok("Update Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Team Name already exist.");
		}
	}
}
