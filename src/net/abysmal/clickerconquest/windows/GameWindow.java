package net.abysmal.clickerconquest.windows;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.graphics.objects.Healthbar;
import net.abysmal.clickerconquest.graphics.objects.Karmabar;
import net.abysmal.clickerconquest.utils.ButtonHandler;

public class GameWindow extends Panel {

	private static final long serialVersionUID = 1L;

	static int ID = 4;
	static boolean inizialized = false;
	public static Healthbar[] healthbars = new Healthbar[2];
	public static Karmabar karmabar;
	public static int[] xLayout = new int[10];
	public static int[] yLayout = new int[8];

	public GameWindow() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
		setSize(width, height);
		Main.window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		BH = new ButtonHandler(this);
		addMouseListener(BH);
		yLayout = setYLayout(height);
		xLayout = setXLayout(width, yLayout);
		initializeWindow(xLayout, yLayout);
		setVisible(true);
	}

	public static int[] setYLayout(int height) {
		int[] yLayout = { height / 27, (int) (height / 13.5), (int) (height / 13.5), (int) (height / 6.75), (int) ((height / 6.75) + (((height - (height / 6.75)) / 18) * 1)), (int) ((height / 6.75) + (((height - (height / 6.75)) / 18) * 2)), (int) ((height / 6.75) + (((height - (height / 6.75)) / 18) * 6)), (int) ((height / 6.75) + (((height - (height / 6.75)) / 18) * 10)), (int) ((height / 6.75) + (((height - (height / 6.75)) / 18) * 14)), (int) ((height / 6.75) + (((height - (height / 6.75)) / 18) * 18)), height };
		return yLayout;
	}

	public static int[] setXLayout(int width, int[] yLayout) {
		int[] xLayout = { width / 5, (int) (width / 2.5), (int) (width / 2.5) + (yLayout[3] - yLayout[1]), (int) (width / 2.5 + ((width / 5.66) * 1)), (int) ((width / 2.5) + (width / 5.66) + (yLayout[3] - yLayout[1])), (int) (width / 2.5 + ((width / 5.66) * 2)), (int) ((width / 2.5) + ((width / 5.66) * 2) + (yLayout[3] - yLayout[1])), (int) (width / 2.5 + ((width / 5.66) * 3)), width };

		return xLayout;
	}

	public static int[] getXLayout() {
		return xLayout;
	}

	public static int[] getYLayout() {
		return yLayout;
	}

	public static int getMoney(boolean enemy) {
		if (enemy) {
			return ID;
		} else {
			return ID;
		}
	}

	public static int getFunding(boolean enemy) {
		if (enemy) {
			return ID;
		} else {
			return ID;
		}
	}

	public static int getAPGain(boolean enemy) {
		if (enemy) {
			return ID;
		} else {
			return ID;
		}
	}

	public static int getDPS(boolean enemy) {
		if (enemy) {
			return ID;
		} else {
			return ID;
		}
	}

	public static int getClickDamage(boolean enemy) {
		if (enemy) {
			return ID;
		} else {
			return ID;
		}
	}

	public static int getHP(boolean enemy) {
		if (enemy) {
			return ID;
		} else {
			return ID;
		}
	}

	public void initializeWindow(int[] xLayout, int[] yLayout) {
		if (!inizialized) {
			width = 1920;
			height = 1080;
			int BID = 5;
			int BO = 14;
			int fontSize = yLayout[5] - yLayout[4] - 10;
			BID--;
			createButton(BID + BO, 0, 0, xLayout[1], yLayout[3], "", ID, yLayout[3] - 10);
			BID--;
			createButton(BID + BO, 0, yLayout[3], xLayout[0], yLayout[5] - yLayout[4], "Melee", ID, fontSize);
			BID--;
			createButton(BID + BO, xLayout[0], yLayout[3], xLayout[1] - xLayout[0], yLayout[4] - yLayout[3], "Ranged", ID, fontSize);
			BID--;
			createButton(BID + BO, 0, yLayout[4], xLayout[0], yLayout[5] - yLayout[4], "Siege", ID, fontSize);
			BID--;
			createButton(BID + BO, xLayout[0], yLayout[4], xLayout[1] - xLayout[0], yLayout[5] - yLayout[4], "Special", ID, fontSize);
			healthbars[0] = new Healthbar(xLayout[1], 0, xLayout[7] - xLayout[1], yLayout[0], 100, false);
			healthbars[1] = new Healthbar(xLayout[1], yLayout[0], xLayout[7] - xLayout[1], yLayout[0], 100, true);
			karmabar = new Karmabar(1810, 25, 85, 109, 10.0);
			inizialized = true;

		}
	}
}