package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Player {
	private Long playerId;
	private String playerName;
	private LocalDate birthDate;
	private Integer habilityLevel;
	private BigDecimal salary;
	
	public Player(Long playerId, String playerName, LocalDate birthDate, Integer habilityLevel, BigDecimal salary) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.birthDate = birthDate;
		this.habilityLevel = habilityLevel;
		this.salary = salary;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public Long getAgeInDays() {
		return ChronoUnit.DAYS.between(this.birthDate, LocalDate.now());
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getHabilityLevel() {
		return habilityLevel;
	}

	public void setHabilityLevel(Integer habilityLevel) {
		this.habilityLevel = habilityLevel;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}


