package net.abysmal.clickerconquest.windows.menus;

public class SettingsMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 3;
	static boolean inizialized = false;

	public SettingsMenu() {
		initializeButtons();
	}

	public void initializeButtons() {
		if (!inizialized) {
			int BID = 4;
			int BO = 10;
			BID--;
			createButton(BID + BO, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Back", ID, fontSize);
			BID--;
			createButton(BID + BO, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Something", ID, fontSize);
			BID--;
			createButton(BID + BO, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Something", ID, fontSize);
			BID--;
			createButton(BID + BO, m, h + s + ((bHeight + s) * BID), width - (m * 2), bHeight, "Something", ID, fontSize);
			inizialized = true;
		}
	}
}