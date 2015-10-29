package net.abysmal.clickerconquest.windows.menus;

import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.utils.ButtonHandler;

public class Menu extends Panel {

	private static final long serialVersionUID = 1L;
	

	public Menu() {
		super();
		addMouseListener(new ButtonHandler());
		setVisible(true);
		initializeButtons();
	}
	
	int h = 120;										// header
	int s = 20;											// spacing
	int m = 30;											// margin
	int BID = 4;										// button ID
	int BO = 0;
	int bHeight = ((height - (h + m)) / BID) - s; 		// button height
	int fontSize = (bHeight - 40);

	public void initializeButtons() {
	}
}