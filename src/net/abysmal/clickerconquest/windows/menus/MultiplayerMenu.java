package net.abysmal.clickerconquest.windows.menus;

public class MultiplayerMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 2;
	static boolean inizialized = false;

	public MultiplayerMenu() {}

	public static void initializeButtons() {
		if (!inizialized) {
			int m = 30;												// margin
			int h = m;												// header
			int s = 20;												// spacing
			int BID = 3;											// button ID
			int BO = 7;												// button offset
			int BH = ((height - (h + (m * 2))) / (BID + 1)) - s; 	// button height
			int fontSize = 60;
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * (BID + 1)), width - (m * 2), BH, "Back", ID, fontSize);
			BID--;
			createButton(BID + BO, m, h + s + ((BH + s) * (BID + 1)), width - (m * 2), BH, "Join", ID, fontSize);
			BID--;
			createButton(BID + BO, m, h + s - 50 + ((BH + s) * (BID + 1)), width - (m * 2), BH + 30, "", ID, fontSize);
			inizialized = true;
		}
	}
}