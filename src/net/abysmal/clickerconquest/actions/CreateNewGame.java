package net.abysmal.clickerconquest.actions;
import net.abysmal.clickerconquest.Game;
import net.abysmal.clickerconquest.entities.Player;

public class CreateNewGame {
	
	public static Player[] players = new Player[2];
	
	public CreateNewGame() {
		Game.players[0] = new Player("Mojken", false);
		Game.players[1] = new Player("Deepstream", true);
	}
}