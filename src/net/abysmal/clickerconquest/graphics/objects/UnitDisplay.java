package net.abysmal.clickerconquest.graphics.objects;

import net.abysmal.clickerconquest.entities.Unit;

public class UnitDisplay {

	Unit unit;
	int x, y, width, height, ID;

	public UnitDisplay(int ID, Unit unit, int x, int y, int width, int height) {
		this.unit = unit;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ID = ID;
	}

	public Unit getUnit() {
		return unit;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getID() {
		return ID;
	}
}