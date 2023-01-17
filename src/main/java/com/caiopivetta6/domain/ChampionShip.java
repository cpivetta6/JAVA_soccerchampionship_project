package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	@OneToMany(mappedBy = "championship")
	private List<Match> matches = new ArrayList<>();

	public Championship() {
		
	}

	public Championship(Integer id, Integer c_year) {
		super();
		this.id = id;
		this.c_year = c_year;
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
