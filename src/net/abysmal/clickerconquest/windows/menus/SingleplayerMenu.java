package net.abysmal.clickerconquest.windows.menus;

public class SingleplayerMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 1;
	static boolean inizialized = false;

	public SingleplayerMenu() {}

	public static void initializeButtons() {
		if (!inizialized) {
			int m = 30;										// margin
			int h = m;										// header
			int s = 20;										// spacing
			int BID = 3;									// button ID
			int BO = 4;										// button offset
			int BH = ((height - (h + (m * 2))) / BID) - s; 	// button height
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Back", ID);
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "New Game", ID);
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * BID), width - (m * 2), BH, "Continiue", ID);
			inizialized = true;
		}
	}
}