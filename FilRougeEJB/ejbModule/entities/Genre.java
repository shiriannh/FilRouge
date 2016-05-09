package entities;

import lombok.Getter;

public enum Genre {

	SPORT("Sport"), RPG("Rpg"), AVENTURE("Aventure"), ACTION("Action"), SIMULATION("Simulation"), JRPG("Jrpg");

	@Getter
	private String label;

	private Genre(String lab) {
		this.label = lab;
	}

}
