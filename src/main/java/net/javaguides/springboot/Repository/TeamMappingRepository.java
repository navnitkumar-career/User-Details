package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.Entites.TeamMapping;

@Repository
public interface TeamMappingRepository extends JpaRepository<TeamMapping, Integer>{

	
	@Modifying
	@Query(value = "delete from team_mapping where users_id = :userId  and team_id = :teamId", nativeQuery = true)
	void deleteTeamMappingByUserIdAndTeamId(@Param("userId") int userId, @Param("teamId") int teamId);

	
	
}
