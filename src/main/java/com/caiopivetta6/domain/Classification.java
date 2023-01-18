package com.caiopivetta6.domain;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Classification {

	
	
	private Integer id;
	private Integer points;
	private Integer goals;
	private String team;
	

	
	public Classification() {
		
	}

	public Classification(Integer id, Integer points, Integer goals, String team) {
		super();
		this.id = id;
		this.points = points;
		this.goals = goals;
		this.team = team;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
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
		Classification other = (Classification) obj;
		return Objects.equals(id, other.id);
	}


	 
	
	
	
}
