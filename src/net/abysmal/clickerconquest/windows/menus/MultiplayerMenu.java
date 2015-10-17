package net.abysmal.clickerconquest.windows.menus;

public class MultiplayerMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 2;

	public MultiplayerMenu() {
	}

	public static void initializeButtons() {
		boolean done = false;
		if (!done) {
		int m = 30;										//margin
		int h = m;										//header
		int s = 20;										//spacing
		int BID = 3;									//button ID
		int BO = 6;										//button offset
		int BH = ((height - (h + (m * 2))) / (BID+1)) - s; 	//button height
		BID--;
		createButton(6, m, h + s + ((BH + s) * (BID+1)), width - (m * 2), BH, "Back", ID);
		BID--;
		createButton(BID + BO, m, h + s + ((BH + s) * (BID+1)), width - (m * 2), BH, "Join", ID);
		BID--;
		createButton(20, m, h + s - 50 + ((BH + s) * (BID+1)), width - (m * 2), BH + 30, "", ID);
		done = true;
		}
	}
}