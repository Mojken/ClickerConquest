package net.abysmal.clickerconquest;

import net.abysmal.clickerconquest.entities.Player;
import net.abysmal.clickerconquest.entities.Unit;

public class Game {

	Thread update;
	public static Player[] players = new Player[2];

	public Game() {
		update();
	}

	void update() {
		update = new Thread("Update") {

			public void run() {
				int counter = 0;
				while (true) {
					counter++;
					updateStats();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}

					if (counter % 300 == 0) {
						players[0].setMoney(players[0].getMoney() + players[0].getFunding());
						Main.window.c.process(players[0], 2);
						battle();
					}
				}
			}
		};
		update.start();
	}

	public void updateStats() {
		for (Player player:players) {
			if (player.getUnits() != null) {
				Unit[] units = player.getUnits();
				int clickDamage = 0;
				int DPS = 0;
				int HP = 0;

				for (Unit unit:units) {
					if (unit == null) continue;
					HP += unit.getHP() * unit.getAmount();
					if (unit.getType() == 0) DPS += unit.getDPS() * unit.getAmount();
					else if (unit.getType() == 1) clickDamage += unit.getClickDamage() * unit.getAmount();
				}
				player.setClickDamage(clickDamage == 0 ? 1:clickDamage);
				player.setDPS(DPS);
				player.setHP(HP);
			}
		}
	}

	public void battle() {
		Unit[] player0 = Game.players[0].getUnits();
		Unit[] player1 = Game.players[1].getUnits();
		System.out.println(player1[0] != null ? player1[0].getAmount():"Null");
		Unit[][] players = { player0, player1 };
		Unit temp;
		for (Unit[] player:players) {
			boolean switched;
			do {
				switched = false;
				for (int i = 0; i < player.length - 1; i++) {
					if (player[i] != null && player[i + 1] != null && player[i].getAggro() < player[i + 1].getAggro()) {
						temp = player[i];
						player[i] = player[i + 1];
						player[i + 1] = temp;
						System.out.println("Hi");
						switched = true;
					}
				}
			} while (switched);
		}

		int[][] group = new int[2][];
		group[0] = new int[4096];
		group[1] = new int[4096];

		int[] amount = { 0, 0 };
		for (Unit unit:player0)
			if (unit != null) amount[0] += unit.getAmount();

		for (Unit unit:player1)
			if (unit != null) amount[1] += unit.getAmount();

		int tempAmount[] = { amount[0], amount[1] };
		for (int a = 0; a < group.length; a++) {
			for (int i = 0; i < amount[a]; i++) {
				if (tempAmount[a] != 0) {
					group[a][i] = group[a][i] == 0 ? 1:group[a][i] + 1;
					tempAmount[a]--;
				}
			}
			amount[0] = tempAmount[0];
			amount[1] = tempAmount[1];
		}

		if (group[0] != null) {
			for (int a = 0; a < group[0].length; a++) {
				for (int i = 0; i < group[0][a]; i++) {
					if (player0[a] != null && player1[a] != null) player1[a].damage(player0[a].getDPS());
				}
			}
		}

		if (group[1] != null) {
			for (int a = 0; a < group[1].length; a++) {
				for (int i = 0; i < group[1][a]; i++) {
					if (player0[a] != null && player1[a] != null) player0[a].damage(player1[a].getDPS());
				}
			}
		}
	}
}