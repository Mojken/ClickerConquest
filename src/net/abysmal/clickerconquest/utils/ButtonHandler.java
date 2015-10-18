package net.abysmal.clickerconquest.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.windows.GameWindow;
import net.abysmal.clickerconquest.windows.Window;
import net.abysmal.clickerconquest.windows.menus.Menu;
import net.abysmal.clickerconquest.windows.menus.MultiplayerMenu;
import net.abysmal.clickerconquest.windows.menus.SettingsMenu;
import net.abysmal.clickerconquest.windows.menus.SingleplayerMenu;

public class ButtonHandler implements MouseListener {

	Window window;

	@SuppressWarnings("static-access")
	public void ButtonPress(int ID) {
		switch (ID) {
			case 0:
				Panel.currentScreen = 1;
				SingleplayerMenu.initializeButtons();
			break;
			case 1:
				Panel.currentScreen = 2;
				MultiplayerMenu.initializeButtons();
			break;
			case 2:
				Panel.currentScreen = 3;
				SettingsMenu.initializeButtons();
			break;
			case 3:
				System.out.println("Kbye");
				System.exit(0);
			break;
			case 4:
				GameWindow.initializeWindow(4);
			break;
			case 5:
				System.out.println(ID + ": New Game (" + window.buttons[ID].getScreen() + ")");
			break;
			case 6:
				Panel.currentScreen = 0;
			break;
			case 8:
				System.out.println(ID + ": Join (" + window.buttons[ID].getScreen() + ")");
			break;
			case 9:
				Panel.currentScreen = 0;
			break;
			case 10:
				System.out.println(ID + ": Something (" + window.buttons[ID].getScreen() + ")");
			break;
			case 11:
				System.out.println(ID + ": Something (" + window.buttons[ID].getScreen() + ")");
			break;
			case 12:
				System.out.println(ID + ": Something (" + window.buttons[ID].getScreen() + ")");
			break;
			case 13:
				Panel.currentScreen = 0;
			break;
			default:
				System.out.println(ID + ": null (" + window.buttons[ID].getScreen() + ")");
			break;
		}
	}

	public ButtonHandler(Window w) {
		window = w;
	}

	@SuppressWarnings("static-access")
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < window.buttons.length; i++) {
			if (window.buttons[i] != null) {
				if (e.getX() >= window.buttons[i].getX() && e.getX() <= window.buttons[i].getWidth() + window.buttons[i].getX()) {
					if (e.getY() >= Menu.buttons[i].getY() && e.getY() <= window.buttons[i].getHeight() + window.buttons[i].getY()) {
						if (window.buttons[i].getScreen() == Panel.currentScreen) ButtonPress(i);
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