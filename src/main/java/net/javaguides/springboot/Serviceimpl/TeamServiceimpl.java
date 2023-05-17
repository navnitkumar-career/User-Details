package net.javaguides.springboot.Serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.Entites.Team;
import net.javaguides.springboot.Repository.TeamRepository;
import net.javaguides.springboot.Service.TeamService;
import net.javaguides.springboot.UserDTO.TeamDTO;

@Service
public class TeamServiceimpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	ModelMapper modelMapper;

	@Transactional
	@Override
	public List<TeamDTO> getList() {

		List<Team> teamList = teamRepository.findAll();

		List<TeamDTO> team = teamList.stream().map(t -> {
			TeamDTO teams = new TeamDTO();

			modelMapper.map(t, teams);
			return teams;
		}).collect(Collectors.toList());
		return team;

	}

	@Transactional
	@Override
	public boolean Add(TeamDTO teamAdd) {
		List<Team> teamList = teamRepository.findAll();

		boolean flag = false;

		for (Team team : teamList) {
			if (team.getTeamName().equals(teamAdd.getTeamName())) {
				flag = false;
				break;
			} else {
				flag = true;
			}
		}

		if (flag) {
			Team team = new Team();
			modelMapper.map(teamAdd, team);

			teamRepository.save(team);
			return flag;
		}
		return flag;
	}


	@Transactional
	@Override
	public boolean Update(TeamDTO teamEdit) {
		List<Team> teamList = teamRepository.findAll();
		boolean flag = false;

		for (Team team : teamList) {
			if (team.getTeamName().equals(teamEdit.getTeamName())) {
				flag = false;
			} else {
				flag = true;
			}

		}
		if (flag) {
			Team team1 = teamRepository.findById(teamEdit.getId()).get();
			modelMapper.map(teamEdit, team1);

			teamRepository.save(team1);
			modelMapper.map(team1, teamEdit);
		}
		return flag;
	}

	@Override
	public boolean DeleteById(String teamName) {
		Team team = teamRepository.findByTeamName(teamName);

		if (team == null) {
			return false;
		} else {
			teamRepository.deleteById(team.getId());
			return true;
		}

	}

}
