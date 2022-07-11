package com.example.mapping.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Team {

	@Id
	private Long id;

	private String title;

	@ManyToOne(optional = false)
	@JoinColumn(name = "member_id", referencedColumnName = "id")
	private Member member;

	public Team(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Team(long id, String title, Member member) {
		this.id = id;
		this.title = title;
		this.member = member;
		member.teamAdd(this);
	}

}
