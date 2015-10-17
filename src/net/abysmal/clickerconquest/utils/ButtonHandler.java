package net.abysmal.clickerconquest.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.windows.menus.Menu;
import net.abysmal.clickerconquest.windows.menus.MultiplayerMenu;
import net.abysmal.clickerconquest.windows.menus.SettingsMenu;
import net.abysmal.clickerconquest.windows.menus.SingleplayerMenu;

public class ButtonHandler implements MouseListener {

	Menu menu;

	@SuppressWarnings("static-access")
	public void ButtonPress(int ID) {
		switch (ID) {
			case 0:
				Panel.currentScreen = 1;
				System.out.println(ID + ": " + Panel.currentScreen);
				SingleplayerMenu.initializeButtons();
			break;
			case 1:
				Panel.currentScreen = 2;
				System.out.println(ID + ": " + Panel.currentScreen);
				MultiplayerMenu.initializeButtons();
			break;
			case 2:
				Panel.currentScreen = 3;
				System.out.println(ID + ": " + Panel.currentScreen);
				SettingsMenu.initializeButtons();
			break;
			case 3:
				System.out.println("Kbye");
				System.exit(0);
			break;
			case 4:
				System.out.println(ID + ": Continue (" + menu.buttons[ID].getScreen() + ")");
			break;
			case 5:
				System.out.println(ID + ": New Game (" + menu.buttons[ID].getScreen() + ")");
			break;
			case 6:
				Panel.currentScreen = 0;
				System.out.println(ID + ": " + Panel.currentScreen);
			break;
			case 7:
				System.out.println(ID + ": Join (" + menu.buttons[ID].getScreen() + ")");
			break;
			case 8:
				System.out.println(ID + ": Something (" + menu.buttons[ID].getScreen() + ")");
			break;
			case 9:
				System.out.println(ID + ": Something (" + menu.buttons[ID].getScreen() + ")");
			break;
			case 10:
				System.out.println(ID + ": Something (" + menu.buttons[ID].getScreen() + ")");
			break;
			default:
				System.out.println(ID + ": null (" + menu.buttons[ID].getScreen() + ")");
			break;
		}
	}

	public ButtonHandler(Menu m) {
		menu = m;
	}

	@SuppressWarnings("static-access")
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < menu.buttons.length; i++){
			if (menu.buttons[i] != null) {
				if (e.getX() >= menu.buttons[i].getX() && e.getX() <= menu.buttons[i].getWidth() + menu.buttons[i].getX()) {
					if (e.getY() >= menu.buttons[i].getY() && e.getY() <= menu.buttons[i].getHeight() + menu.buttons[i].getY()) {
						if (menu.buttons[i].getScreen() == Panel.currentScreen) ButtonPress(i);
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