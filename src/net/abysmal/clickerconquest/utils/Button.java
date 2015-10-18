package net.abysmal.clickerconquest.utils;

public class Button {

	private int ID, m, x, y, width, height, screen;
	private String text;

	public Button(int ID, int x, int y, int width, int height, String text, int screen) {
		this.ID = ID;
		this.m = 4;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.screen = screen;
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

	public int getId() {
		return ID;
	}

	public int getMargin() {
		return m;
	}

	public int getScreen() {
		return screen;
	}

	public String getText() {
		return text;
	}
}