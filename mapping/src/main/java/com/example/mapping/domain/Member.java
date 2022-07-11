package com.example.mapping.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

	@Id
	private Long id;

	private String name;

	@OneToMany(mappedBy = "member")
	private List<Team> teams = new ArrayList<>();

	public Member(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public void teamAdd(Team team) {
		teams.add(team);
	}

	@Override
	public String toString() {
		return "Member{" +
			"id=" + id +
			", name='" + name + '\'' +
			'}';
	}
}
