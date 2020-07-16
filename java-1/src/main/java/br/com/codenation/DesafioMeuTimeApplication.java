package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private TeamManager manager ;
	
	public DesafioMeuTimeApplication() {
		this.manager = new TeamManager();
	}
	
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Team team = new Team(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		manager.addTeam(team);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(manager.hasPlayerId(id)) throw new IdentificadorUtilizadoException();
		manager.getTeamById(idTime).addPlayer(new Player(id, nome, dataNascimento, nivelHabilidade, salario));
	}

	public void definirCapitao(Long idJogador) {
		manager.getTeamByPlayerId(idJogador).setCaptainId(idJogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		return manager.getTeamById(idTime).getCaptainId();
	}

	public String buscarNomeJogador(Long idJogador) {
		return manager.getPlayerByIdFromAllTeams(idJogador).getPlayerName();
	}

	public String buscarNomeTime(Long idTime) {
		return manager.getTeamById(idTime).getTeamName();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		return manager.getTeamById(idTime).getPlayers().stream().map(player -> player.getPlayerId()).collect(Collectors.toList());
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return manager.getTeamById(idTime).getBestHabilityPlayer().getPlayerId();
												
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		return manager.getTeamById(idTime).getOldestPlayer().getPlayerId();
	}

	public List<Long> buscarTimes() {
		return manager.getAllTeams().stream().map(team -> team.getTeamId()).collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		return manager.getTeamById(idTime).getBestSalaryPlayer().getPlayerId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return manager.getPlayerByIdFromAllTeams(idJogador).getSalary();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return manager.getTopPlayers(top).stream().map(player -> player.getPlayerId()).collect(Collectors.toList());
	}

}
