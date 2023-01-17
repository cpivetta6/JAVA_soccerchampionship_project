package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Address;
import com.caiopivetta6.domain.City;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.repositories.AddressRepository;
import com.caiopivetta6.repositories.ChampionshipRepository;
import com.caiopivetta6.repositories.CityRepository;
import com.caiopivetta6.repositories.MatchRepository;
import com.caiopivetta6.repositories.PlayerRepository;
import com.caiopivetta6.repositories.StadiumRepository;
import com.caiopivetta6.repositories.StateRepository;
import com.caiopivetta6.repositories.TeamRepository;

@SpringBootApplication
public class SoccerChampionshipApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SoccerChampionshipApplication.class, args);
	}
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private StadiumRepository stadiumRepository;
	
	@Autowired
	private MatchRepository MatchRepository;
	
	@Autowired
	private PlayerRepository PlayerRepository;

	@Autowired
	private TeamRepository TeamRepository;
	
	@Autowired
	private ChampionshipRepository championshipRepository;
	
	@Override
	public void run(String... args) throws Exception, ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//CITY AND STATE
		
		State state1 = new State(null, "Veneto");
		State state2 = new State(null, "Piemonte");
		
		City city1 = new City(null, "Verona", state1);
		City city2 = new City(null, "Torino", state2);
		
		state1.getCity().add(city1);
		state2.getCity().add(city2);
		
		stateRepository.saveAll(Arrays.asList(state1,state2));
		cityRepository.saveAll(Arrays.asList(city1,city2));
		
		//ADDRESS
		
		Address address1 = new Address(null, "Via Stadio", "Bordo Venezia", "47b", "4221423", city1);
		Address address2 = new Address(null, "Via Giovanni Grasso", "Mazzo G.", "85a", "332123", city2);
		
		addressRepository.saveAll(Arrays.asList(address1,address2));
		
		
	}

}
