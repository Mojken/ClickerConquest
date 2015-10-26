package net.abysmal.clickerconquest.graphics.objects;

public class Healthbar {

	int x, y, width, height;
	float health, currentHealth;
	double currentHealthPercentage;
	boolean enemy;

	public Healthbar(int x, int y, int width, int height, int health, boolean enemy) {
		this.x = x;
		this.y = y;
		this.enemy = enemy;
		this.width = width;
		this.height = height;
		this.health = health;
		currentHealth = health;
		
		while (currentHealth < 0) currentHealth = 0;
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

	public float getHealth() {
		return health;
	}

	public boolean getEnemy() {
		return enemy;
	}

	public float getCurrentHealth() {
		return currentHealth;
	}

	public double getCurrentHealthPercentage() {
		currentHealthPercentage = (double)(currentHealth) / health;
		return currentHealthPercentage;
	}

	public void setCurrentHealth(float health2) {
		this.currentHealth = health2;
	}
}