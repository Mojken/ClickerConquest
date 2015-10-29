package net.abysmal.clickerconquest.actions;
import net.abysmal.clickerconquest.Game;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.entities.Player;

public class CreateNewGame {
	
	public static Player[] players = new Player[2];
	
	public CreateNewGame() {
		Game.players[0] = new Player(Main.PlayerID, false);
		Game.players[1] = new Player(47105, true);
		new Game();
	}

	public CreateNewGame(int[] players) {
		Game.players[0] = new Player(players[0], players[0] != Main.PlayerID);
		Game.players[1] = new Player(players[1], players[1] != Main.PlayerID);
		new Game();
	}
}