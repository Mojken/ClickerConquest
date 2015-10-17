package net.abysmal.clickerconquest.windows.menus;

import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.utils.Button;
import net.abysmal.clickerconquest.utils.ButtonHandler;
import net.abysmal.clickerconquest.windows.Window;

public class Menu extends Window {

	private static final long serialVersionUID = 1L;

	public Menu() {
		super();
		scale = 2;
		height = 700 / scale;
		height *= scale;
		width = (height / 16) * 12;
		setSize(width, height);
		setLocationRelativeTo(null);
		buttons = new Button[40];
		BH = new ButtonHandler(this);
		p = new Panel(this);
		setContentPane(p);
		p.addMouseListener(BH);
		StartMenu.initializeButtons();
	}

	public static void initializeButtons() {}

	public static void createButton(int ID, int x, int y, int width, int height, String text, int screen) {
		buttons[ID] = new Button(ID, x, y, width, height, text, screen);
	}
}