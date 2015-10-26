package net.abysmal.clickerconquest.graphics.objects;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.abysmal.clickerconquest.graphics.Graphics;

public class Karmabar {

	int x, y, width, height;
	double currentKarmaPercentage, karma, currentKarma;
	int[] overlay = new int[85 * 109 * 4];
	int[] pixels = new int[85 * 109 * 4];

	public Karmabar(int x, int y, int width, int height, double karma) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.karma = karma;
		currentKarma = karma / 2;

		while (currentKarma < 0)
			currentKarma = 0;
	}

	public int[] getKarmaOverlay() {
		try {
			BufferedImage img = ImageIO.read(Graphics.karmabarOverlay);
			for (int y = 0; y < 109; y++) {
				for (int x = 0; x < 85; x++) {
					overlay[y * 84 + x] = img.getRGB(x, y);
					if (overlay[y * 84 + x] == -16777216) {
						pixels[((y * 84 + x) * 4)] = 0x00;
						pixels[((y * 84 + x) * 4) + 1] = 0x00;
						pixels[((y * 84 + x) * 4) + 2] = 0x00;
						pixels[((y * 84 + x) * 4) + 3] = 0x00;

					} else if (overlay[y * 84 + x] == -65536 && getCurrentKarmaPercentage() >= 0.9) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -65281 && getCurrentKarmaPercentage() >= 0.8) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -16744193 && getCurrentKarmaPercentage() >= 0.7) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -16711936 && getCurrentKarmaPercentage() >= 0.6) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -16744448 && getCurrentKarmaPercentage() >= 0.5) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -16776961 && getCurrentKarmaPercentage() >= 0.4) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -256 && getCurrentKarmaPercentage() >= 0.3) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -16711681 && getCurrentKarmaPercentage() >= 0.2) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else if (overlay[y * 84 + x] == -32768 && getCurrentKarmaPercentage() >= 0.1) {
						pixels[((y * 84 + x) * 4)] = 0x6E;
						pixels[((y * 84 + x) * 4) + 1] = 0xA0;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					} else {
						pixels[((y * 84 + x) * 4)] = 0x8C;
						pixels[((y * 84 + x) * 4) + 1] = 0x80;
						pixels[((y * 84 + x) * 4) + 2] = 0x9B;
						pixels[((y * 84 + x) * 4) + 3] = 0xFF;
					}
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