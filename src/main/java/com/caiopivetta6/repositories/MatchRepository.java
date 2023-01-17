package com.caiopivetta6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiopivetta6.domain.Championship;

public interface MatchRepository extends JpaRepository<Championship, Integer> {

	
	
}
