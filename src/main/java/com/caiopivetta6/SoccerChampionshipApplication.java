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
import com.caiopivetta6.domain.Player;
import com.caiopivetta6.domain.Stadium;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.domain.Team;
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
	private MatchRepository matchRepository;
	
	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;
	
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
		
		//PLAYER AND TEAM

		Team team1 = new Team(null, "Hellas");
		Team team2 = new Team(null, "Junventus");

		Player player1 = new Player(null, "Roberto B.", sdf.parse("22/02/1998").toInstant(), 1.77, team1);
		Player player2 = new Player(null, "Giuseppe C.", sdf.parse("21/01/1994").toInstant(), 1.72, team1);
		Player player3 = new Player(null, "Andrea D.", sdf.parse("12/09/1992").toInstant(), 1.85, team2);
		Player player4 = new Player(null, "Diballa", sdf.parse("22/02/1998").toInstant(), 1.77, team2);

		team1.getPlayers().addAll(Arrays.asList(player1, player2));
		team2.getPlayers().addAll(Arrays.asList(player3, player4));

		

		//ADDRESS and STADIUM
		
		Address address1 = new Address(null, "Via Stadio", "Bordo Venezia", "47b", "4221423", city1);
		Address address2 = new Address(null, "Via Giovanni Grasso", "Mazzo G.", "85a", "332123", city2);
		
		Stadium stadium1 = new Stadium(null, "Marcantonio Bentegodi", address1);
		Stadium stadium2 = new Stadium(null, "San Siro", address2);
		
		address1.setStadium(stadium1);
		address2.setStadium(stadium2);
		
		team1.setStadium(stadium1);
		team2.setStadium(stadium2);
		
		stadium1.setTeam(team1);
		stadium2.setTeam(team2);
		
		teamRepository.saveAll(Arrays.asList(team1, team2));
		playerRepository.saveAll(Arrays.asList(player1, player2, player3, player4));
		stadiumRepository.saveAll(Arrays.asList(stadium1,stadium2));
		addressRepository.saveAll(Arrays.asList(address1,address2));
		
		
		
		
		
	}

}
