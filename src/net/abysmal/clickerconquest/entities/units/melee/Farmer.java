package net.abysmal.clickerconquest.entities.units.melee;

public class Farmer extends Melee {

	public static final int HP = 100;
	public static final int DPS = 10;
	public static final int DEFENCE = 5;
	public static final int COST = 50;
	public static final int ID = 0;
	public static final int AGGRO = 5;
	public static final String NAME = "Farmer";

	public Farmer() {
		super(ID, 0, HP, DPS, DEFENCE, NAME, COST, AGGRO);
	}
	
	public Farmer(int amount) {
		super(ID, amount, HP, DPS, DEFENCE, NAME, COST, AGGRO);
	}
}