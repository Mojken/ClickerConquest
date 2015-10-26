package net.abysmal.clickerconquest.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.graphics.Panel;

public class ButtonHandler implements MouseListener {

	Panel panel;

	public void ButtonPress(int ID) {
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
				Main.switchContentPane(4);
			break;
			case 5:
				System.out.println(ID + ": New Game (" + Panel.buttons[ID].getScreen() + ")");
			break;
			case 6:
				Main.switchContentPane(0);
			break;
			case 8:
				System.out.println(ID + ": Join (" + Panel.buttons[ID].getScreen() + ")");
			break;
			case 9:
				Main.switchContentPane(0);
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
			default:
				System.out.println(ID + ": null (" + Panel.buttons[ID].getScreen() + ")");
			break;
		}
	}

	public ButtonHandler(Panel p) {
		panel = p;
	}

	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < Panel.buttons.length; i++) {
			if (Panel.buttons[i] != null) {
				if (e.getX() >= Panel.buttons[i].getX() && e.getX() <= Panel.buttons[i].getWidth() + Panel.buttons[i].getX()) {
					if (e.getY() >= Panel.buttons[i].getY() && e.getY() <= Panel.buttons[i].getHeight() + Panel.buttons[i].getY()) {
						if (Panel.buttons[i].getScreen() == Panel.currentScreen) ButtonPress(i);
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