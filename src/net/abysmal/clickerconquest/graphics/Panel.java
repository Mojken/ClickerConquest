package net.abysmal.clickerconquest.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import net.abysmal.clickerconquest.windows.Window;
import net.abysmal.clickerconquest.windows.menus.Menu;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	Window		menu;
	public static int	currentScreen	= 0;

	public Panel(Window m) {
		super();
		menu = m;
	}

	@SuppressWarnings("static-access")
	public void paint(Graphics g) {
		Graphics2D G = (Graphics2D) g.create();
		if (menu instanceof Menu) net.abysmal.clickerconquest.graphics.Graphics.drawBackground(G, menu.width, menu.height);
		if (Panel.currentScreen == 0) net.abysmal.clickerconquest.graphics.Graphics.drawTitle(G, 20, 20, menu.width - 40, 100);
		for (int i = 0; i < menu.buttons.length; i++){
			if (menu.buttons[i] != null && menu.buttons[i].getScreen() == currentScreen) {
				net.abysmal.clickerconquest.graphics.Graphics.drawButton(G, menu.buttons[i].getMargin(), menu.buttons[i].getX(), menu.buttons[i].getY(), menu.buttons[i].getWidth(), menu.buttons[i].getHeight(), menu.buttons[i].getText());
			}
		}
	}
}