package net.abysmal.clickerconquest.entities.units.ranged;

import net.abysmal.clickerconquest.entities.Unit;

public class Ranged extends Unit {

	public Ranged(int ID, int amount, int HP, int clickDamage, int defence, String name, int cost, int aggro) {
		super(1, ID, amount, HP, clickDamage, defence, name, cost, aggro);
	}
}