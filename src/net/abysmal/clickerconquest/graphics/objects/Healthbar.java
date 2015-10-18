package net.abysmal.clickerconquest.graphics.objects;

public class Healthbar {

	int x, y, width, height, health, currentHealth;
	double currentHealthPercentage;
	boolean enemy;

	public Healthbar(int x, int y, int width, int height, int health, boolean enemy) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
		this.enemy = enemy;
		currentHealth = health;
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

	public int getHealth() {
		return health;
	}

	public boolean getEnemy() {
		return enemy;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public double getCurrentHealthPercentage() {
		currentHealthPercentage = (double)(currentHealth) / health;
		return currentHealthPercentage;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
}