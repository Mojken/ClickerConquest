package net.abysmal.clickerconquest.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import net.abysmal.clickerconquest.windows.GameWindow;
import net.abysmal.clickerconquest.windows.Window;
import net.abysmal.clickerconquest.windows.menus.Menu;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	Window		window;
	public static int	currentScreen	= 0;

	public Panel(Window m) {
		super();
		window = m;
	}

	@SuppressWarnings({ "static-access"})
	public void paint(Graphics g) {
		Graphics2D G = (Graphics2D) g.create();
		if (window instanceof Menu) net.abysmal.clickerconquest.graphics.Graphics.drawBackground(G, window.width, window.height);
		if (currentScreen == 0) net.abysmal.clickerconquest.graphics.Graphics.drawTitle(G, 20, 20, window.width - 40, 100);
		if (currentScreen == 4) {
			net.abysmal.clickerconquest.graphics.Graphics.drawBackground(G, (GameWindow.width / 5)*2, GameWindow.height);
			net.abysmal.clickerconquest.graphics.Graphics.drawButton(G, 4, 0, 0, (GameWindow.width / 5)*2, (int) (GameWindow.height / 6.75), "1,947,360.852", 72);
		}
		for (int i = 0; i < window.buttons.length; i++){
			if (window.buttons[i] != null && window.buttons[i].getScreen() == currentScreen) {
				net.abysmal.clickerconquest.graphics.Graphics.drawButton(G, window.buttons[i].getMargin(), window.buttons[i].getX(), window.buttons[i].getY(), window.buttons[i].getWidth(), window.buttons[i].getHeight(), window.buttons[i].getText(),60);
			}
		}
	}
}