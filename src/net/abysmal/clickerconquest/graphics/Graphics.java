package net.abysmal.clickerconquest.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import net.abysmal.clickerconquest.windows.GameWindow;
import net.abysmal.clickerconquest.windows.menus.Menu;

public class Graphics {

	static Image button = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/button.png"));
	static Image BG = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/wood-texture.jpg"));
	static Image title = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/Title.png"));
	static Image healthbar = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/healthbar.png"));
	static Image karmabar = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/karmabar.png"));
	public static File karmabarOverlay = new File("C:/Users/Mojken/Workspace/git/ClickerConquest/res/net/abysmal/clickerconquest/karmabarMask.png");
	static Image DPS = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/DPS.png"));
	static Image clickDamage = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/clickDamage.png"));
	static Image HP = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/net/abysmal/clickerconquest/HP.png"));

	public static void drawGame(Graphics2D g) {
		int[] xLayout = GameWindow.getXLayout();
		int[] yLayout = GameWindow.getYLayout();
		g.setColor(new Color(130, 100, 80));
		g.fillRect(0, 0, xLayout[8], yLayout[3]);
		g.drawImage(BG, 0, 0, xLayout[1], yLayout[9], null);
		g.drawImage(DPS, xLayout[1], yLayout[1], xLayout[2], yLayout[3], 0, 0, DPS.getWidth(null), DPS.getHeight(null), null);
		g.drawImage(clickDamage, xLayout[3], yLayout[1], xLayout[4], yLayout[3], 0, 0, clickDamage.getWidth(null), clickDamage.getHeight(null), null);
		g.drawImage(HP, xLayout[5], yLayout[1], xLayout[6], yLayout[3], 0, 0, HP.getWidth(null), HP.getHeight(null), null);
	}

	public static void drawBackground(Graphics2D g, int width, int height) {
		g.drawImage(BG, 0, 0, width, height, null);
	}

	public static void drawTitle(Graphics2D g, int x, int y, int width, int height) {
		g.drawImage(title, x, y, width, height, null);
	}

	public static void drawButton(Graphics2D g, int m, int x, int y, int width, int height, String text, int fontSize) {
		drawTile(g, button, m, x, y, x + width, y + height, m);
		drawText(g, 1, true, "Blackadder ITC", fontSize, x, y, width, height, text);
	}

	public static void drawText(Graphics2D g, int style, boolean centered, String font, int fontSize, int x1, int y1, int width, int height, String text) {
		g.setFont(new Font(font, style, fontSize));
		Color ink = new Color(45, 45, 60);
		g.setColor(ink);
		if (centered) {
			int strWidth = g.getFontMetrics().stringWidth(text);
			g.drawChars(text.toCharArray(), 0, text.length(), x1 + width / 2 - strWidth / 2, y1 + height / 2 + fontSize / 3);
		} else {
			g.drawChars(text.toCharArray(), 0, text.length(), x1, y1); // drawText(G, 0, false, "Arial", 30, 10, 10, 0, 0, text);
		}
	}

	public static void drawHealthbar(Graphics2D g, int x, int y, int width, int height, double currentHealthPercentage, boolean enemy) {
		Color health = new Color(165, 35, 15);
		int currentHealth = (int) ((width - 10) * currentHealthPercentage);
		int a = (int) (x + 5 + (width - 10 - currentHealth));
		if (enemy) {
			g.setColor(health);
			drawTile(g, healthbar, 1, x, y, x + width, y + height, 5);
			g.fillRect(a, y + 5, currentHealth, height - 10);
		} else {
			g.setColor(health);
			drawTile(g, healthbar, 1, x, y, x + width, y + height, 5);
			g.fillRect(x + 5, y + 5, currentHealth, height - 10);
		}
	}

	public static void drawKarmabar(Graphics2D g, int x, int y, int width, int height, int[] is) {
// Image karmabarFill = getImageFromArray(is, 85, 109);
		int w = karmabar.getWidth(null);
		int h = karmabar.getHeight(null);
		g.drawImage(karmabar, x, y, width + x, height + y, 0, 0, w, h, null);
		g.drawImage(getImageFromArray(is, w, h), x, y, width + x, height + y, 0, 0, w, h, null);
	}

	public static Image getImageFromArray(int[] pixels, int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		WritableRaster raster = (WritableRaster) image.getData();
		raster.setPixels(0, 0, width - 1, height - 1, pixels);
		return image;
	}

	public static void drawTile(Graphics2D g, Image path, int margin, int x1, int y1, int x2, int y2, int dMargin) {
		int w = path.getWidth(null);
		int h = path.getHeight(null);

		g.drawImage(path, x1 + dMargin, y1 + dMargin, x2 - dMargin, y2 - dMargin, margin, margin, w - margin, h - margin, null);	// Draw middle

		g.drawImage(path, x1 + dMargin, y1, x2 - dMargin, y1 + dMargin, margin, 0, w - margin, margin, null);						// Draw top edge
		g.drawImage(path, x1, y1 + dMargin, x1 + dMargin, y2 - dMargin, 0, margin, margin, h - margin, null);						// Draw left edge
		g.drawImage(path, x2 - dMargin, y1 + dMargin, x2, y2 - dMargin, w - margin, margin, w, h - margin, null);					// Draw right edge
		g.drawImage(path, x1 + dMargin, y2 - dMargin, x2 - dMargin, y2, margin, h - margin, w - margin, h, null);					// Draw bottom edge

		g.drawImage(path, x1, y1, x1 + dMargin, y1 + dMargin, 0, 0, margin, margin, null);											// Draw top-left corner
		g.drawImage(path, x2 - dMargin, y1, x2, y1 + dMargin, w - margin, 0, w, margin, null);										// Draw top-right corner
		g.drawImage(path, x1, y2 - dMargin, x1 + dMargin, y2, 0, h - margin, margin, h, null);										// Draw bottom-left corner
		g.drawImage(path, x2 - dMargin, y2 - dMargin, x2, y2, w - margin, h - margin, w, h, null);									// Draw bottom-right corner
	}
}