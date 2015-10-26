package net.abysmal.clickerconquest.graphics.objects;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.abysmal.clickerconquest.graphics.Graphics;

public class Karmabar {

	int x, y, width, height;
	double currentKarmaPercentage, karma, currentKarma;
	int[] overlay = new int[85 * 109];
	int[] pixels = new int[85 * 109 * 4];

	public Karmabar(int x, int y, int width, int height, double karma) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.karma = karma;
		currentKarma = karma;
		currentKarmaPercentage = (double) (currentKarma) / karma;

		while (currentKarma < 0)
			currentKarma = 0;
	}

	public int[] getKarmaOverlay() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(Graphics.karmabarOverlay);
			for (int y = 1; y <= 109; y++) {
				for (int x = 1; x <= 85; x++) {
					overlay[(x * y) - 1] = img.getRGB(x - 1, y - 1);
					System.out.println(pixels[(x * y) - 1]);
					if (overlay[x * y - 1] == 0x000000FF) pixels[(x * y) - 1] = 0x00000000;
					if (overlay[x * y - 1] == 0xFFFFFFFF && y > 109 - (int) (109 * currentKarmaPercentage)) pixels[(x * y) - 1] = 0x50AFA0FF;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pixels;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getKarma() {
		return karma;
	}

	public void setKarma(double karma) {
		this.karma = karma;
	}

	public double getCurrentKarma() {
		return currentKarma;
	}

	public void setCurrentKarma(double currentKarma) {
		this.currentKarma = currentKarma;
	}

	public double getCurrentKarmaPercentage() {
		currentKarmaPercentage = (double) (currentKarma) / karma;
		return currentKarmaPercentage;
	}
}