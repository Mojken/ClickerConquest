package net.abysmal.clickerconquest.entities;

public class Unit extends Entity {
	
	int type, amount;
	
	public Unit(int type, int amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public int getType() {
		return type;
	}

	
	public void setType(int type) {
		this.type = type;
	}

	
	public int getAmmount() {
		return amount;
	}

	
	public void setAmmount(int ammount) {
		this.amount = ammount;
	}
}