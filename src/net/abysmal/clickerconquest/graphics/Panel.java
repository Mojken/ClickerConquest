package net.abysmal.clickerconquest.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.entities.Unit;
import net.abysmal.clickerconquest.graphics.objects.UnitDisplay;
import net.abysmal.clickerconquest.utils.Button;
import net.abysmal.clickerconquest.utils.TextField;
import net.abysmal.clickerconquest.windows.GameWindow;
import net.abysmal.clickerconquest.windows.menus.Menu;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static int currentScreen = 5;

	public static Button[] buttons = new Button[40];
	public static UnitDisplay[] unitDisplays = new UnitDisplay[40];
	public static TextField[] textFields = new TextField[400];

	public static int width = Main.window.getContentPane().getWidth();
	public static int height = Main.window.getContentPane().getHeight();

	static int ID;
	protected Panel p;

	public Panel() {
		super();
		width = Main.window.getContentPane().getWidth();
		height = Main.window.getContentPane().getHeight();
	}

	public void createButton(int ID, int x, int y, int width, int height, String text, int screen, int fontSize) {
		buttons[ID] = new Button(ID, x, y, width, height, text, screen, fontSize);
	}

	int i = 0;

	public void createUnitButton(int ID, Unit unit) {
		int height = (GameWindow.yLayout[9] - GameWindow.yLayout[5]) / 4;
		int width = GameWindow.xLayout[0];
		int index = GameWindow.yLayout[5];
		int y = (((ID % 2) == 1) ? ID - 25 : ID - 26) / 2;
		int x = (((ID % 2) == 1) ? GameWindow.xLayout[0] : 0);
		buttons[ID] = new Button(ID, x, index + (height * y), width, height, "", 4, 0);
		unitDisplays[ID] = new UnitDisplay(ID, unit, x, index + (height * y), width, height);
	}

	public void createTextBox(int ID, int x, int y, int width, int height, String text, int screen, int fontSize, int textMaxLength) {
		textFields[ID] = new TextField(ID, x, y, width, height, text, screen, fontSize, TextField.TEXTBOX, textMaxLength, TextField.CENTER);
	}

	public void createPasswordField(int ID, int x, int y, int width, int height, String text, int screen, int fontSize, int textMaxLength) {
		textFields[ID] = new TextField(ID, x, y, width, height, text, screen, fontSize, TextField.PASSWORD, textMaxLength, TextField.CENTER);
	}

	public void createIPField(int ID, int x, int y, int width, int height, String text, int screen, int fontSize, int textMaxLength) {
		textFields[ID] = new TextField(ID, x, y, width, height, text, screen, fontSize, TextField.IP, textMaxLength, TextField.CENTER);
	}

	public void createTextField(int ID, int x, int y, int width, int height, String text, int screen, int fontSize) {
		textFields[ID] = new TextField(ID, x, y, width, height, text, screen, fontSize, TextField.TEXT_FIELD, 100, TextField.CENTER);
	}

	public void createInfoField(int ID, int x, int y, int width, int height, String text, int screen, int fontSize) {
		textFields[ID] = new TextField(ID, x, y, width, height, text, screen, fontSize, TextField.TEXT_FIELD, 100, TextField.LEFT);
	}

	public void paint(Graphics g) {
		Graphics2D G = (Graphics2D) g.create();
		if (currentScreen < 4) net.abysmal.clickerconquest.graphics.Graphics.drawBackground(G, Menu.width, Menu.height);
		if (currentScreen == 0) net.abysmal.clickerconquest.graphics.Graphics.drawTitle(G, 20, 20, Menu.width - 40, 100);
		if (currentScreen == 4) net.abysmal.clickerconquest.graphics.Graphics.drawGame(G);

		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] != null && buttons[i].getScreen() == currentScreen) {
				net.abysmal.clickerconquest.graphics.Graphics.drawButton(G, buttons[i].getMargin(), buttons[i].getX(), buttons[i].getY(), buttons[i].getWidth(), buttons[i].getHeight(), buttons[i].getText(), buttons[i].getFontSize());
			}
		}

		for (TextField textField:textFields) {
			if (textField != null && textField.getScreen() == currentScreen) {
				net.abysmal.clickerconquest.graphics.Graphics.drawText(G, textField);
// System.out.println(textField.getText());
			}
		}
		
		for (UnitDisplay unitDisplay : unitDisplays) {
			if (unitDisplay != null && currentScreen == 4) net.abysmal.clickerconquest.graphics.Graphics.drawUnitDisplay(G, unitDisplay);
		}

		for (int i = 0; i < GameWindow.healthbars.length; i++) {
			if (GameWindow.healthbars[i] != null && currentScreen == 4) {
				net.abysmal.clickerconquest.graphics.Graphics.drawHealthbar(G, GameWindow.healthbars[i].getX(), GameWindow.healthbars[i].getY(), GameWindow.healthbars[i].getWidth(), GameWindow.healthbars[i].getHeight(), GameWindow.healthbars[i].getCurrentHealthPercentage(), GameWindow.healthbars[i].getEnemy());
			}
		}

		if (GameWindow.karmabar != null && currentScreen == 4) {
			net.abysmal.clickerconquest.graphics.Graphics.drawKarmabar(G, GameWindow.karmabar.getX(), GameWindow.karmabar.getY(), GameWindow.karmabar.getWidth(), GameWindow.karmabar.getHeight(), GameWindow.karmabar.getKarmaOverlay());
		}

		if (textFields != null) for (TextField textField:textFields)
			if (textField != null && textField.doUpdate()) textField.updateText(textField.getUpdate());
	}
}