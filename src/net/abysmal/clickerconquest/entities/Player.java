package net.abysmal.clickerconquest.entities;

import net.abysmal.clickerconquest.windows.GameWindow;

public class Player extends Entity {

	String username;
	int ID;
	float money = 100;
	float karma = 0;
	float health = 10000;
	float AP = 0;
	float APGain = 0;
	float DPS = 0;
	float HP = 0;
	float clickDamage = 2;
	float funding = 10;
	float idolCount = 0;
	Unit[] units = new Unit[4096];
	Idol[] idols = new Idol[13];
	boolean enemy;

	public Player(int ID, boolean enemy) {
		switch (ID) {
			case 42:
				username = "Mojken";
			break;
			case 47105:
				username = "Deepstream";
			break;
		}
		this.ID = ID;
		this.enemy = enemy;
	}

	public void process() {
		if (health <= 0) System.out.println(username + " is dead!");
		if (enemy) {
			GameWindow.healthbars[1].setCurrentHealth(health);
		} else {
			GameWindow.healthbars[0].setCurrentHealth(health);
			GameWindow.karmabar.setCurrentKarma(karma);
		}
	}

	public void damage(int damage) {
		if (health > 0) health -= damage;
	}

	public Idol[] getIdols() {
		return idols;
	}

	public void setIdols(Idol[] idols) {
		this.idols = idols;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public float getKarma() {
		return karma;
	}

	public void setKarma(float karma) {
		this.karma = karma;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float stats) {
		this.health = stats;
	}

	public float getAP() {
		return AP;
	}

	public void setAP(float stats) {
		this.AP = stats;
	}

	public float getAPGain() {
		return APGain;
	}

	public void setAPGain(float stats) {
		this.APGain = stats;
	}

	public float getDPS() {
		return DPS;
	}

	public void setDPS(float stats) {
		this.DPS = stats;
	}

	public float getHP() {
		return HP;
	}

	public void setHP(float stats) {
		this.HP = stats;
	}

	public float getClickDamage() {
		return clickDamage;
	}

	public void setClickDamage(float stats) {
		this.clickDamage = stats;
	}

	public float getFunding() {
		return funding;
	}

	public void setFunding(float stats) {
		this.funding = stats;
	}

	public Unit[] getUnits() {
		return units;
	}

	public void setUnits(Unit[] units) {
		this.units = units;
	}

}