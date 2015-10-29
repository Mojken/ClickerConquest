package net.abysmal.clickerconquest.entities.units.melee;

import net.abysmal.clickerconquest.entities.Unit;

public class Melee extends Unit {

	public Melee(int ID, int amount, int HP, int DPS, int defence, String name, int cost, int aggro) {
		super(0, ID, amount, HP, DPS, defence, name, cost, aggro);
	}
}