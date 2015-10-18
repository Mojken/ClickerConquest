package net.abysmal.clickerconquest;

import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.windows.GameWindow;
import net.abysmal.clickerconquest.windows.Window;
import net.abysmal.clickerconquest.windows.menus.Menu;

public class Main implements Runnable {

	Window menu;
	Thread t;
	boolean running = false;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		menu = new Menu();
		t = new Thread(this);
		running = true;
		t.start();
	}

	public void run() {
		while (running) {
			menu.repaint();
			if (Panel.currentScreen == 4) GameWindow.window.repaint();
			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}
		}
	}
}