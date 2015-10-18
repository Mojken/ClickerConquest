package net.abysmal.clickerconquest.windows.menus;

public class StartMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 0;
	static boolean inizialized = false;

	public StartMenu() {}

	public static void initializeButtons() {
		if (!inizialized) {
			int h = 120;									// header
			int s = 20;										// spacing
			int m = 30;										// margin
			int BID = 4;									// button ID
			int BH = ((height - (h + (m * 2))) / BID) - s; 	// button height
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Quit", ID);
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Settings", ID);
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Multiplayer", ID);
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Singleplayer", ID);
			inizialized = true;
		}
	}
}