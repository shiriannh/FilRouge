package entities;

import lombok.Getter;

public enum Support {
	PS3("PlayStation 3"), XBOX360("Xbox 360"), WII("wii"), WIIU("Wii U"), PS4("PlayStation 4"), XBOXONE(
			"XboxOne"), GAMECUBE("Gamecube");

	@Getter
	private String label;

	private Support(String lab) {
		this.label = lab;
	}
}
