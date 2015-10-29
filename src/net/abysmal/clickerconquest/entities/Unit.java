package net.abysmal.clickerconquest.entities;

import net.abysmal.clickerconquest.entities.units.melee.Farmer;
import net.abysmal.clickerconquest.entities.units.ranged.Hunter;

public class Unit extends Entity {

	public static Unit[] units = { new Farmer(), new Hunter() };
	public int type;
	private int ID;
	private int amount = 0;
	private int HP;
	private int DPS;
	private int defence;
	private int clickDamage;
	private int cost;
	private int aggro;
	private int health;
	private String name;

	public Unit(int type, int ID, int amount, int HP, int damage, int defence, String name, int cost, int aggro) {
		this.type = type;
		this.ID = ID;
		this.amount = amount;
		this.HP = HP;
		this.defence = defence;
		this.name = name;
		this.cost = cost;
		this.aggro = aggro;
		health = HP;
		if (type == 0) this.DPS = damage;
		else if (type == 1) this.clickDamage = damage;

	}

	public Unit(int ID, int amount) {
		new Unit(units[ID].getType(), units[ID].getID(), amount, units[ID].getHP(), units[ID].getDamage(), units[ID].getDefence(), units[ID].getName(), units[ID].getCost(), units[ID].getAggro());
	}

	public int getHealth() {
		return health;
	}

	public void damage(int damage) {
		this.health -= damage;
	}

	public int getAggro() {
		return aggro;
	}

	public int getType() {
		return type;
	}

	public int getID() {
		return ID;
	}

	public int getAmount() {
		return amount;
	}

	public int getHP() {
		return HP;
	}

	public int getDPS() {
		return DPS;
	}

	public int getClickDamage() {
		return clickDamage;
	}

	public int getDefence() {
		return defence;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		if (type == 0) return DPS;
		else return clickDamage;
	}

	public int getCost() {
		return cost;
	}
}