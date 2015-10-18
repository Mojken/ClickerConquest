package net.abysmal.clickerconquest.windows;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.utils.Button;
import net.abysmal.clickerconquest.utils.ButtonHandler;

public class GameWindow extends Window {

	private static final long serialVersionUID = 1L;

	static int ID;
	static boolean inizialized = false;

	@SuppressWarnings("static-access")
	public GameWindow(int ID) {
		super();
		GameWindow.ID = ID;
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
		setSize(width, height);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		buttons = new Button[40];
		BH = new ButtonHandler(this);
		p = new Panel(this);
		setContentPane(p);
		p.addMouseListener(BH);
		p.currentScreen = ID;
	}

	public static void initializeWindow(int ID) {
		if (!inizialized) {
			new GameWindow(ID);
			int m = 30;										// margin
			int h = m;										// header
			int s = 20;										// spacing
			int BID = 4;									// button ID
			int BO = 10;									// button offset
			int BH = ((height - (h + (m * 2))) / BID) - s; 	// button height
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Back", ID);
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Something", ID);
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Something", ID);
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Something", ID);
			inizialized = true;
		}
	}
}