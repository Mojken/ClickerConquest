package net.abysmal.clickerconquest.entities;

import net.abysmal.clickerconquest.networking.Client;
import net.abysmal.clickerconquest.windows.GameWindow;

public class Player extends Entity {

	String Username;
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

	public Player(String Username, boolean enemy) {}

	public void process() {
		if (health <= 0) System.out.println(Username + " is dead!");
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

	public Unit[] convertUnits(String rawUnits) {
		byte[] bitLength = new byte[50];
		byte[] bitIndex = new byte[50];
		Unit[] uints = new Unit[100];
		int length = (int) (rawUnits.charAt(0));

		for (int i = 0; i < length; i++) {
			bitLength[i] = (byte) (rawUnits.charAt(0));
			rawUnits = rawUnits.substring(1);
		}

		for (int i = 0; i < length; i++) {
			bitIndex[i] = (byte) (rawUnits.charAt(0));
			rawUnits = rawUnits.substring(1);
		}

		for (int i = 0; i < length; i++) {
			units[bitIndex[i]] = new Unit(bitIndex[i], Client.convert(rawUnits.substring(0, bitLength[i])));
			rawUnits = rawUnits.substring(bitLength[i]);
		}
		
		return uints;
	}

	public Idol[] convertIdols(String rawIdols) {
		byte[] bitLength = new byte[50];
		byte[] bitIndex = new byte[50];
		Idol[] idols = new Idol[100];
		int length = (int) (rawIdols.charAt(0));

		for (int i = 0; i < length; i++) {
			bitLength[i] = (byte) (rawIdols.charAt(0));
			rawIdols = rawIdols.substring(1);
		}

		for (int i = 0; i < length; i++) {
			bitIndex[i] = (byte) (rawIdols.charAt(0));
			rawIdols = rawIdols.substring(1);
		}

		for (int i = 0; i < length; i++) {
			idols[bitIndex[i]] = new Idol(bitIndex[i], Client.convert(rawIdols.substring(0, bitLength[i])));
			rawIdols = rawIdols.substring(bitLength[i]);
		}
		
		return idols;
	}

	public float getIdolString() {
		// TODO Auto-generated method stub
		return 0;
	}

}