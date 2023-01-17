package com.caiopivetta6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiopivetta6.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	
	
}
