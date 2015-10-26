package net.abysmal.clickerconquest.windows.menus;

public class SingleplayerMenu extends Menu {

	private static final long serialVersionUID = 1L;

	static int ID = 1;
	static boolean inizialized = false;

	public SingleplayerMenu() {
		initializeButtons();
	}

	public void initializeButtons() {
		if (!inizialized) {
			int BID = 3;
			int BO = 4;
			BID--;
			createButton(BID + BO, m, h + s + ((bHeight + s) * (BID +1)), width - (m * 2), bHeight, "Back", ID, fontSize);
			BID--;
			createButton(BID + BO, m,(int) (h + s + (((bHeight * 1.25) + s) * BID)), width - (m * 2), (int) (bHeight * 1.25), "New Game", ID, fontSize);
			BID--;
			createButton(BID + BO, m,(int) (h + s + (((bHeight * 1.25) + s) * BID)), width - (m * 2), (int) (bHeight * 1.25), "Continiue", ID, fontSize);
			inizialized = true;
		}
	}
}