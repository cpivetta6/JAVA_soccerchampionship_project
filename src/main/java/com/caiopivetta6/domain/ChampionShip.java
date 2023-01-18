package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "championship_tb")
public class Championship implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer c_year;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "championship")
	private List<Match> matches = new ArrayList<>();
	
	
	@ElementCollection
	@CollectionTable(name = "Classification")
	private Set<Classification> classifications = new LinkedHashSet<>();
	
	
	
	public Championship() {
		
	}

	public Championship(Integer id, Integer c_year) {
		super();
		this.id = id;
		this.c_year = c_year;
	}
	
	
	
	
	public Set<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(Set<Classification> classifications) {
		this.classifications = classifications;
	}

	public void getClassification_(List<Match> list) {
		
		Classification t1 = new Classification();
		Classification t2 = new Classification();
		
		t1.setTeam(list.get(0).getHomeTeam().getName());
		t2.setTeam(list.get(0).getVisitTeam().getName());
		
		t1.setId(list.get(0).getHomeTeam().getId());
		t2.setId(list.get(0).getVisitTeam().getId());
		
		int goals_t1 = 0;
		int goals_t2 = 0;
		
		int points_t1 = 0;
		int points_t2 = 0;
		
		for(Match m : list) {
			goals_t1 += m.getHomeScoreTeam();
			goals_t2 += m.getVisitingScoreTeam();
			
			if(m.getHomeScoreTeam() > m.getVisitingScoreTeam()) {
				points_t1 += 3;
			}else if(m.getHomeScoreTeam() == m.getVisitingScoreTeam()) {
				points_t1 +=1;
				points_t2 +=1;
			}else {
				points_t2 +=3;
			}
			
			t1.setGoals(goals_t1);
			t2.setGoals(goals_t2);
			
			t1.setPoints(points_t1);
			t2.setPoints(points_t2);
			
			classifications.add(t1);
			classifications.add(t2);
		}
		
	}
	
	
	
	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public Integer getC_year() {
		return c_year;
	}

	public void setC_year(Integer c_year) {
		this.c_year = c_year;
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
		Championship other = (Championship) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
