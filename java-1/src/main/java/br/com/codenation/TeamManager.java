package br.com.codenation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

public class TeamManager {

	private List<Team> teams;
	
	public TeamManager() {
		super();
		this.teams = new ArrayList<Team>();
	}
	
	public Boolean hasPlayerId(Long id) {
		//return playersIdList.contains(id);
		  return teams.stream().anyMatch(team -> team.getPlayers().stream().anyMatch(player -> player.getPlayerId() == id));
	}
	
	public Boolean hasTeamId(Long id) {
		return teams.stream().anyMatch(team -> team.getTeamId() == id);
	}
	
	public void addTeam(Team team) throws IdentificadorUtilizadoException{
		if(hasTeamId(team.getTeamId())) {
			throw new IdentificadorUtilizadoException();
		}else {
			this.teams.add(team);
		}
	}
	
	public Team getTeamById(Long id) throws TimeNaoEncontradoException{
		List<Team> teams = this.teams.stream().filter(team -> team.getTeamId() == id).collect(Collectors.toList());
		if(teams.isEmpty()) {
			throw new TimeNaoEncontradoException();
		}else {
			return teams.get(0);
		}
				   
	}
	
	public Player getPlayerByIdFromAllTeams(Long id) throws JogadorNaoEncontradoException{
		if(!hasPlayerId(id)) {
			throw new JogadorNaoEncontradoException();
		}else{
			return this.teams.stream().filter(team -> team.getPlayers().stream().anyMatch(player -> player.getPlayerId() == id) ).collect(Collectors.toList()).get(0).getPlayerByIdFromTeam(id);
	    }
	}
	
	public Team getTeamByPlayerId(Long id) throws JogadorNaoEncontradoException{
		if(!hasPlayerId(id)) {
			throw new JogadorNaoEncontradoException();
		}else{
			return this.teams.stream().filter(team -> team.getPlayers().stream().anyMatch(player -> player.getPlayerId() == id) ).collect(Collectors.toList()).get(0);
		}
	}
	
	public List<Team> getAllTeams(){
		return this.teams.stream().sorted(Comparator.comparingLong(Team::getTeamId)).collect(Collectors.toList());
				  
	}
	
	public List<Player> getTopPlayers(Integer top){
		List<Team> allTeams = this.teams;
		List<Player> allPlayers = new ArrayList<Player>();
		List<Player> topPlayers = new ArrayList<Player>();
		
		for(Team team : allTeams) {
			allPlayers.addAll(team.getPlayers());
		}
		
		if(allPlayers.isEmpty()) {
			return allPlayers;
		}
		
		allPlayers = allPlayers.stream().sorted(Comparator.comparing(Player::getHabilityLevel).reversed()).collect(Collectors.toList());
		
		for(int i = 0; i < top; i++) {
			topPlayers.add(allPlayers.get(i));
		}
		
		return topPlayers;				   
	}
}
