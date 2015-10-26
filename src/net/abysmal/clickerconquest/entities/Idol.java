package net.abysmal.clickerconquest.entities;

public class Idol extends Entity {

	int index, level;
	
	public Idol(int index, int level) {
		this.index = index;
		this.level = level;
	}

	
	public int getIndex() {
		return index;
	}

	
	public void setIndex(int index) {
		this.index = index;
	}

	
	public int getLevel() {
		return level;
	}

	
	public void setLevel(int level) {
		this.level = level;
	}
}