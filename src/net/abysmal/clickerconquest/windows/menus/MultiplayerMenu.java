package net.abysmal.clickerconquest.windows.menus;

public class MultiplayerMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 2;
	static boolean inizialized = false;

	public MultiplayerMenu() {
		initializeButtons();
	}

	public void initializeButtons() {
		if (!inizialized) {
			int BID = 3;
			int BO = 7;
			BID--;
			createButton(BID + BO, m, h + s + ((bHeight + s) * (BID + 1)), width - (m * 2), bHeight, "Back", ID, fontSize);
			BID--;
			createButton(BID + BO, m, h + s + ((bHeight + s) * (BID + 1)), width - (m * 2), bHeight, "Join", ID, fontSize);
			BID--;
			createButton(BID + BO, m, h + s - 50 + ((bHeight + s) * (BID + 1)), width - (m * 2), bHeight + 30, "", ID, fontSize);
			createIPField(BID + BO, m, h + s - 50 + ((bHeight + s) * (BID + 1)), width - (m * 2), bHeight + 30, "127.0.0.1:1338", ID, fontSize - 10, 21);
			inizialized = true;
		}
	}
}