package br.com.codenation;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;

public class Team {
	private List<Player> players;
	private Long teamId;
	private String teamName;
	private LocalDate creationDate;
	private String principalUniformColor;
	private String secondaryUniformColor;
	private Long captainId;
	
	public Team(Long teamId, String teamName, LocalDate creationDate, String principalUniformColor,
			String secondaryUniformColor) {
		super();
		this.players = new ArrayList<Player>();
		this.teamId = teamId;
		this.teamName = teamName;
		this.creationDate = creationDate;
		this.principalUniformColor = principalUniformColor;
		this.secondaryUniformColor = secondaryUniformColor;
		this.captainId = -1L;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Long getTeamId() {
		return teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public Long getCaptainId() throws CapitaoNaoInformadoException{
		if(captainId == -1) {
			throw new CapitaoNaoInformadoException();
		}
		return captainId;
	}

	public void setCaptainId(Long captainId) {
		this.captainId = captainId;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public Player getPlayerByIdFromTeam(Long id) {
		return this.players.stream().filter(player -> player.getPlayerId() == id).collect(Collectors.toList()).get(0);
	}
	
	public Player getBestSalaryPlayer() {
		return this.players.stream().sorted(Comparator.comparingLong(Player::getPlayerId)).max(Comparator.comparing(Player::getSalary)).get();
				   
	}
	
	public Player getBestHabilityPlayer() {
		return this.players.stream().sorted(Comparator.comparingLong(Player::getPlayerId)).max(Comparator.comparing(Player::getHabilityLevel)).get();
	}
	
	public Player getOldestPlayer() {
		return this.players.stream().sorted(Comparator.comparingLong(Player::getPlayerId)).max(Comparator.comparing(Player::getAgeInDays)).get();
	}
	
}


