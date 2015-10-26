package net.abysmal.clickerconquest.windows.menus;

public class StartMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 0;
	static boolean inizialized = false;

	public StartMenu() {
		initializeButtons();
	}

	public void initializeButtons() {
		if (!inizialized) {
			int BID = 4;
			BID--;
			createButton(BID, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Quit", ID, fontSize);
			BID--;
			createButton(BID, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Settings", ID, fontSize);
			BID--;
			createButton(BID, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Multiplayer", ID, fontSize);
			BID--;
			createButton(BID, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Singleplayer", ID, fontSize);
			inizialized = true;
		}
	}
}