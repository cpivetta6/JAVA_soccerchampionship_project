package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "visitteam")
	private Team visitTeam;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "championship_id")
	private Championship championship;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "hometeam")
	private Team homeTeam;
	
	
	
	
	public Match() {
		
	}

	public Match(Integer id, Instant date, Integer homeScoreTeam, Integer visitingScoreTeam, Team visitTeam) {
		super();
		this.id = id;
		this.date = date;
		this.homeScoreTeam = homeScoreTeam;
		this.visitingScoreTeam = visitingScoreTeam;
		this.visitTeam = visitTeam;
	}
	
	
	
	

	public Team getVisitTeam() {
		return visitTeam;
	}

	public void setVisitTeam(Team visitTeam) {
		this.visitTeam = visitTeam;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	

	public Championship getChampionship() {
		return championship;
	}

	public void setChampionship(Championship championship) {
		this.championship = championship;
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
