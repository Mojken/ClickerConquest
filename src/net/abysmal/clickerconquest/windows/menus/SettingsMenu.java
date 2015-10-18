package net.abysmal.clickerconquest.windows.menus;

public class SettingsMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 3;
	static boolean inizialized = false;

	public SettingsMenu() {}

	public static void initializeButtons() {
		if (!inizialized) {
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