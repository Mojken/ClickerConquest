package net.abysmal.clickerconquest.entities.units.ranged;

public class Hunter extends Ranged {

	public static final int HP = 100;
	public static final int CLICK_DAMAGE = 10;
	public static final int DEFENCE = 2;
	public static final int COST = 50;
	public static final int ID = 0;
	public static final int AGGRO = 1;
	public static final String NAME = "Hunter";
	
	public Hunter() {
		super(ID, 0, HP, CLICK_DAMAGE, DEFENCE, NAME, COST, AGGRO);
	}
	
	public Hunter(int amount) {
		super(ID, amount, HP, CLICK_DAMAGE, DEFENCE, NAME, COST, AGGRO);
	}
}