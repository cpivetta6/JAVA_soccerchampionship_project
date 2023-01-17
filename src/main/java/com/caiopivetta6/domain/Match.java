package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Match_tb")
public class Match implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant date;
	private Integer homeScoreTeam;
	private Integer visitingScoreTeam;
	
	public Match() {
		
	}

	public Match(Integer id, Instant date, Integer homeScoreTeam, Integer visitingScoreTeam) {
		super();
		this.id = id;
		this.date = date;
		this.homeScoreTeam = homeScoreTeam;
		this.visitingScoreTeam = visitingScoreTeam;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Integer getHomeScoreTeam() {
		return homeScoreTeam;
	}

	public void setHomeScoreTeam(Integer homeScoreTeam) {
		this.homeScoreTeam = homeScoreTeam;
	}

	public Integer getVisitingScoreTeam() {
		return visitingScoreTeam;
	}

	public void setVisitingScoreTeam(Integer visitingScoreTeam) {
		this.visitingScoreTeam = visitingScoreTeam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
