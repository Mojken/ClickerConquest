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
			int fontSize = 60;
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Quit", ID, fontSize);
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Settings", ID, fontSize);
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Multiplayer", ID, fontSize);
			BID--;
			createButton(BID, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Singleplayer", ID, fontSize);
			inizialized = true;
		}
	}
}