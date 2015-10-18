package net.abysmal.clickerconquest.entities;

public class Player extends Entity {

	String Username;
	double money = 100.0;
	double karma = 0.0;
	int health = 10000;
	int AP = 0;
	int APGain = 0;
	int DPS = 0;
	int HP = 0;
	int clickDamage = 2;
	int funding = 10;
	int idolCount = 0;
	Unit[] units = new Unit[4096];
	Idol[] idols = new Idol[13];

	public Player(String Username) {
		if (health <= 0) System.out.println(Username + " is dead!");
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getKarma() {
		return karma;
	}

	public void setKarma(double karma) {
		this.karma = karma;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAP() {
		return AP;
	}

	public void setAP(int AP) {
		this.AP = AP;
	}

	public int getAPGain() {
		return APGain;
	}

	public void setAPGain(int APGain) {
		this.APGain = APGain;
	}

	public int getDPS() {
		return DPS;
	}

	public void setDPS(int DPS) {
		this.DPS = DPS;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public int getClickDamage() {
		return clickDamage;
	}

	public void setClickDamage(int clickDamage) {
		this.clickDamage = clickDamage;
	}

	public int getFunding() {
		return funding;
	}

	public void setFunding(int funding) {
		this.funding = funding;
	}

	public Unit[] getUnits() {
		return units;
	}

	public void setUnits(Unit[] units) {
		this.units = units;
	}

}