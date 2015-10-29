package net.abysmal.clickerconquest.windows.menus;

import net.abysmal.clickerconquest.entities.units.melee.Farmer;
import net.abysmal.clickerconquest.entities.units.ranged.Hunter;
import net.abysmal.clickerconquest.graphics.Panel;

public class UnitMenu {

	static final int ID = 4;

	Panel panel;

	public UnitMenu(Panel panel) {
		this.panel = panel;
		initializeButtons();
	}

	private void initializeButtons() {
		int BID = 2;
		int BO = 25;
		BID--;
		panel.createUnitButton(BO + BID, new Farmer());
		BID--;
		panel.createUnitButton(BO + BID, new Hunter());
// BID--;
// panel.createUnitButton(BO + BID, 0);
// BID--;
// panel.createUnitButton(BO + BID, 0);
// BID--;
// panel.createUnitButton(BO + BID, 0);
// BID--;
// panel.createUnitButton(BO + BID, 0);
// BID--;
// panel.createUnitButton(BO + BID, 0);
// BID--;
// panel.createUnitButton(BO + BID, 0);
	}
}