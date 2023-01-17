package com.caiopivetta6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiopivetta6.domain.Team;

public interface ChampionshipRepository extends JpaRepository<Team, Integer> {

	
	
}
