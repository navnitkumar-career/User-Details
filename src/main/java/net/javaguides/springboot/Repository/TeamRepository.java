package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Entites.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
	
	Team findByTeamName(String teamName);
}
