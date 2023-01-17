package com.caiopivetta6.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.Championship;
import com.caiopivetta6.repositories.ChampionshipRepository;
import com.caiopivetta6.services.exceptions.ObjectNotFoundException;

@Service
public class ChampionshipService {

	@Autowired
	private ChampionshipRepository repository;
	
	public Championship find(Integer id) {
		Optional<Championship> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + Championship.class.getName()));
	}
	
}
