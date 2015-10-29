package net.abysmal.clickerconquest.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import net.abysmal.clickerconquest.Game;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.actions.CreateNewGame;
import net.abysmal.clickerconquest.actions.Login;
import net.abysmal.clickerconquest.entities.Unit;
import net.abysmal.clickerconquest.entities.units.melee.Farmer;
import net.abysmal.clickerconquest.entities.units.ranged.Hunter;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.networking.Client;

public class ButtonHandler implements MouseListener {

	boolean connecting = false;

	public void buttonPress(int ID) {
		Unit[] units;
		switch (ID) {
			case 0:
				Main.switchContentPane(1);
			break;
			case 1:
				Main.switchContentPane(2);
			break;
			case 2:
				Main.switchContentPane(3);
			break;
			case 3:
				System.out.println("Kbye");
				System.exit(0);
			break;
			case 4:
				new CreateNewGame();
				Main.switchContentPane(4);
			break;
			case 5:
				System.out.println(ID + ": New Game (" + Panel.buttons[ID].getScreen() + ")");
			break;
			case 6:
				Main.switchContentPane(0);
			break;
			case 7:
				TextFieldHandler.setFocus(ID);
			break;
			case 8:
				if (!connecting) {
					Main.window.c = new Client(Main.username, Panel.textFields[7].getText());
					connecting = true;
					System.out.println(connecting);
				}
			break;
			case 9:
				connecting = false;
				Main.switchContentPane(0);
				Main.window.c.closeConnection();
			break;
			case 10:
				System.out.println(ID + ": Something (" + Panel.buttons[ID].getScreen() + ")");
			break;
			case 11:
				System.out.println(ID + ": Something (" + Panel.buttons[ID].getScreen() + ")");
			break;
			case 12:
				System.out.println(ID + ": Something (" + Panel.buttons[ID].getScreen() + ")");
			break;
			case 13:
				Main.switchContentPane(0);
			break;
			case 19:
				new Login(Panel.textFields[21].getText(), Panel.textFields[20].getText());
				Main.switchContentPane(0);
			break;
			case 20:
				TextFieldHandler.setFocus(ID);
			break;
			case 21:
				TextFieldHandler.setFocus(ID);
			break;
			case 25:
				if (Game.players[0].getMoney() >= Unit.units[1].getCost()) {
					units = Game.players[0].getUnits();
					if (units[1] != null) units[1] = new Hunter(units[1].getAmount() + 1);
					else units[1] = new Hunter(1);
					Game.players[0].setMoney(Game.players[0].getMoney() - Unit.units[1].getCost());
					Game.players[0].setUnits(units);
				}
			break;
			case 26:
				if (Game.players[0].getMoney() >= Unit.units[0].getCost()) {
					units = Game.players[0].getUnits();
					if (units[0] != null) units[0] = new Farmer(units[0].getAmount() + 1);
					else units[0] = new Farmer(1);
					Game.players[0].setMoney(Game.players[0].getMoney() - Unit.units[0].getCost());
					Game.players[0].setUnits(units);
				}
			break;
			default:
				System.out.println(ID + ": null (" + Panel.buttons[ID].getScreen() + ")");
			break;
		}
	}

	public ButtonHandler() {}

	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < Panel.buttons.length; i++) {
			if (Panel.buttons[i] != null) {
				if (e.getX() >= Panel.buttons[i].getX() && e.getX() <= Panel.buttons[i].getWidth() + Panel.buttons[i].getX()) {
					if (e.getY() >= Panel.buttons[i].getY() && e.getY() <= Panel.buttons[i].getHeight() + Panel.buttons[i].getY()) {
						if (Panel.buttons[i].getScreen() == Panel.currentScreen) {
							buttonPress(i);
							break;
						}
					}
				}
			}
		}
	}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
}