package com.example.mapping.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.mapping.domain.Member;
import com.example.mapping.domain.Team;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Transactional
@Rollback
class TeamRepositoryTest {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	TeamRepository teamRepository;

	@PersistenceContext
	private EntityManager em;

	@BeforeEach
	void init() {
		Member member1 = new Member(1L, "유저1");
		Member member2 = new Member(2L, "유저2");

		em.persist(member1);
		em.persist(member2);

		Team team1 = new Team(1L, "팀1", member1);
		em.persist(team1);
		Team team2 = new Team(2L, "팀2", member2);
		em.persist(team2);

		em.flush();
		em.clear();
		System.out.println(" ============================================================ ");
	}

//	@AfterEach
//	void remove() {
//		teamRepository.deleteAll();
//		memberRepository.deleteAll();
//	}

	@Test
	@DisplayName("nullable = false :: findAll 테스트")
	void findAll() {
		// given
		List<Team> teams = teamRepository.findAll();
		System.out.println("============================findAll============================");

		// when
		teams.forEach(team -> System.out.println("team = " + team));

		// then
		assertThat(teams).hasSize(2);
	}

	@Test
	@DisplayName("nullable = false :: jpql inner join 테스트")
	void innerJoin() {
		// given
		List<Team> teams = teamRepository.getTeamsInnerJoin();
		System.out.println("============================findAll============================");

		// when
		teams.forEach(team -> System.out.println("team = " + team));

		// then
		assertThat(teams).hasSize(2);
	}

	@Test
	@DisplayName("nullable = false :: jpql outer join 테스트")
	void outerJoin() {
		// given
		List<Team> teams = teamRepository.getTeamsOuterJoin();
		System.out.println("============================findAll============================");

		// when
		teams.forEach(team -> System.out.println("team = " + team));

		// then
		assertThat(teams).hasSize(2);
	}

	@Test
	@DisplayName("nullable = false :: jpql fetch join 테스트")
	void fetchJoin() {
		// given
		List<Team> teams = teamRepository.getTeamsFetchJoin();
		System.out.println("============================findAll============================");

		// when
		teams.forEach(team -> System.out.println("team = " + team));

		// then
		assertThat(teams).hasSize(2);
	}

	@Test
	@DisplayName("nullable = false :: jpql 엔티티 그래프 테스트")
	void entityGraph() {
		// given
		List<Team> teams = teamRepository.getTeamsFetchJoinEntityGraph();
		System.out.println("============================findAll============================");

		// when
		teams.forEach(team -> System.out.println("team = " + team));

		// then
		assertThat(teams).hasSize(2);
	}

	@Test
	@DisplayName("nullable = false :: jpql join 테스트")
	void join() {
		// given
		List<Team> teams = teamRepository.getJoin();
		System.out.println("============================findAll============================");

		// when
		teams.forEach(team -> System.out.println("team = " + team));

		// then
		assertThat(teams).hasSize(2);
	}

	@Test
	@DisplayName("nullable = false :: findById 테스트")
	void findById() {
		// given
		Team team = teamRepository.findById(1L).get();
		System.out.println("============================findAll============================");

		// when
		System.out.println("team = " + team);

		// then
		assertThat(team.getId()).isEqualTo(1L);
	}

	@Test
	@DisplayName("nullable = false :: jpql findByTitle 테스트")
	void findByTitle() {
		// given
		Team team = teamRepository.findTeamsByTitle("팀1", 1L);
		System.out.println("============================findAll============================");

		// when
		System.out.println("team = " + team);

		// then
		assertThat(team.getId()).isEqualTo(1L);
	}

}
