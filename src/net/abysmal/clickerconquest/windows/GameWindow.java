package net.abysmal.clickerconquest.windows;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.graphics.objects.Healthbar;
import net.abysmal.clickerconquest.utils.ButtonHandler;

public class GameWindow extends Window {

	private static final long serialVersionUID = 1L;

	static int ID;
	static boolean inizialized = false;
	public static Healthbar[] healthbars = new Healthbar[2];
	public static Window window;

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
		BH = new ButtonHandler(this);
		p = new Panel(this);
		setContentPane(p);
		p.addMouseListener(BH);
		p.currentScreen = ID;
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void initializeWindow(int ID) {
		if (!inizialized) {
			window = new GameWindow(ID);
			int m = 30;											// margin
			int BID = 4;										// button ID
			int BO = 14;										// button offset
			int BH = (int) (height - (height / 6.75)) / 18;		// button height
			int fontSize = BH - 10;
			BID--;
			createButton(BID + BO, 0, (int) (height / 6.75), (width / 5), BH, "Melee", ID, fontSize);
			BID--;
			createButton(BID + BO, (width / 5), (int) (height / 6.75), (width / 5), BH, "Ranged", ID, fontSize);
			BID--;
			createButton(BID + BO, 0, (int) (height / 6.75) + BH, (width / 5), BH, "Siege", ID, fontSize);
			BID--;
			createButton(BID + BO, (width / 5), (int) (height / 6.75) + BH, (width / 5), BH, "Special", ID, fontSize);
			Healthbar MyHealth = new Healthbar((width / 5) * 2, 0, (int) (width - ((width / 5) * 2 + ((height / 6.75)) * 1.185185)), (int) ((height / 6.75) / 4), 100, false);
			Healthbar TheirHealth = new Healthbar((width / 5) * 2, (int) ((height / 6.75) / 4), (int) (width - ((width / 5) * 2 + ((height / 6.75)) * 1.185185)), (int) ((height / 6.75) / 4), 100, true);
			healthbars[0] = MyHealth;
			healthbars[1] = TheirHealth;
			inizialized = true;

		}
	}
}