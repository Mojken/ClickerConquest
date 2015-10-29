package net.abysmal.clickerconquest.windows;

import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.utils.ButtonHandler;
import net.abysmal.clickerconquest.utils.TextFieldHandler;

public class LoginWindow extends Panel {

	private static final long serialVersionUID = 1L;
	
	static int ID = 5;
	public static int[] xLayout;
	public static int[] yLayout;

	public LoginWindow() {
		setSize(500, 350);
		addMouseListener(new ButtonHandler());
		Main.window.addKeyListener(new TextFieldHandler());
		yLayout = getYLayout(height);
		xLayout = getXLayout(width, height);
		initializeWindow(xLayout, yLayout);
		requestFocus();
		setVisible(true);
	}

	protected int[] getYLayout(int height) {
		int[] yLayout = { height / 10, (int) ((height / 10) * 0.5), (height / 10) * 3, (int) ((height / 10) * 3.3), (int) ((height / 10) * 5.8), (int) ((height / 10) * 6.1), (int) ((height / 10) * 7.5), (height / 10) * 8};
		return yLayout;
	}
	
	protected int[] getXLayout(int width, int height) {
		width -= (height / 10) * 2;
		int[] xLayout = { height / 10, (height / 10) + width / 5, (height / 10) + (width / 5) * 4, width + (height / 10)};
		return xLayout;
	}

	protected void initializeWindow(int[] xLayout, int[] yLayout) {
		int BID = 3;
		int BO = 19;
		int fontSize = yLayout[6] - yLayout[5] - 10;
		BID--;
		createButton(BID + BO, xLayout[0], yLayout[1], xLayout[3] - xLayout[0], yLayout[2] - yLayout[1], "", ID, fontSize);
		createTextBox(BID + BO, xLayout[0], yLayout[1], xLayout[3] - xLayout[0], yLayout[2] - yLayout[1], "", ID, fontSize, 50);
		Panel.textFields[BID + BO].setFocus(true);
		BID--;
		createButton(BID + BO, xLayout[0], yLayout[3], xLayout[3] - xLayout[0], yLayout[4] - yLayout[3], "", ID, fontSize);
		createPasswordField(BID + BO, xLayout[0], yLayout[3], xLayout[3] - xLayout[0], yLayout[4] - yLayout[3], "", ID, fontSize, 100);
		BID--;
		createButton(BID + BO, xLayout[1], yLayout[5], xLayout[2] - xLayout[1], yLayout[6] - yLayout[5], "Login", ID, fontSize);
	}
}