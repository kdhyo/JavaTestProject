package com.example.mapping.domain.repository;

import com.example.mapping.domain.Team;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	@Query("SELECT t "
		+ "FROM Team t "
		+ "INNER JOIN t.member")
	List<Team> getTeamsInnerJoin();

	@Query("SELECT t "
		+ "FROM Team t "
		+ "LEFT JOIN t.member")
	List<Team> getTeamsOuterJoin();

	@Query("SELECT t "
		+ "FROM Team t "
		+ "JOIN FETCH t.member")
	List<Team> getTeamsFetchJoin();

	@Query("SELECT t FROM Team t")
	@EntityGraph(attributePaths = {"member"})
	List<Team> getTeamsFetchJoinEntityGraph();

	@Query("SELECT t "
		+ "FROM Team t "
		+ "JOIN t.member")
	List<Team> getJoin();

	@Query("SELECT t "
		+ "FROM Team t "
		+ "WHERE t.title = :title "
		+ "AND t.id = :id")
	Team findTeamsByTitle(String title, Long id);

}
