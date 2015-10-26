package net.abysmal.clickerconquest.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.utils.Button;
import net.abysmal.clickerconquest.utils.ButtonHandler;
import net.abysmal.clickerconquest.windows.GameWindow;
import net.abysmal.clickerconquest.windows.menus.Menu;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static int currentScreen = 0;

	public static Button[] buttons = new Button[40];

	
	public static int width = Main.window.getContentPane().getWidth();
	public static int height = Main.window.getContentPane().getHeight();

	static int ID;
	protected Panel p;
	protected ButtonHandler BH;

	public Panel() {
		super();
	}

	public void createButton(int ID, int x, int y, int width, int height, String text, int screen, int fontSize) {
		buttons[ID] = new Button(ID, x, y, width, height, text, screen, fontSize);
	}

	public void paint(Graphics g) {
		Graphics2D G = (Graphics2D) g.create();
		if (currentScreen < 4) net.abysmal.clickerconquest.graphics.Graphics.drawBackground(G, Menu.width, Menu.height);
		if (currentScreen == 0) net.abysmal.clickerconquest.graphics.Graphics.drawTitle(G, 20, 20, Menu.width - 40, 100);
		if (currentScreen == 4)	net.abysmal.clickerconquest.graphics.Graphics.drawGame(G);

		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] != null && buttons[i].getScreen() == currentScreen) {
				net.abysmal.clickerconquest.graphics.Graphics.drawButton(G, buttons[i].getMargin(), buttons[i].getX(), buttons[i].getY(), buttons[i].getWidth(), buttons[i].getHeight(), buttons[i].getText(), buttons[i].getFontSize());
			}
		}

		for (int i = 0; i < GameWindow.healthbars.length; i++) {
			if (GameWindow.healthbars[i] != null && currentScreen == 4) {
				net.abysmal.clickerconquest.graphics.Graphics.drawHealthbar(G, GameWindow.healthbars[i].getX(), GameWindow.healthbars[i].getY(), GameWindow.healthbars[i].getWidth(), GameWindow.healthbars[i].getHeight(), GameWindow.healthbars[i].getCurrentHealthPercentage(), GameWindow.healthbars[i].getEnemy());
			}
		}

		if (GameWindow.karmabar != null && currentScreen == 4) {
			net.abysmal.clickerconquest.graphics.Graphics.drawKarmabar(G, GameWindow.karmabar.getX(), GameWindow.karmabar.getY(), GameWindow.karmabar.getWidth(), GameWindow.karmabar.getHeight(), GameWindow.karmabar.getKarmaOverlay());
		}
	}
}