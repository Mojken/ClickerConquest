package net.abysmal.clickerconquest;

import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.networking.Client;
import net.abysmal.clickerconquest.windows.GameWindow;
import net.abysmal.clickerconquest.windows.Window;
import net.abysmal.clickerconquest.windows.menus.MultiplayerMenu;
import net.abysmal.clickerconquest.windows.menus.SettingsMenu;
import net.abysmal.clickerconquest.windows.menus.SingleplayerMenu;
import net.abysmal.clickerconquest.windows.menus.StartMenu;

public class Main implements Runnable {

	public static Window window;
	public static Panel panel;
	Thread t;
	Thread tick;
	boolean running = false;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		window = new Window();
		panel = new Panel();
		window.setContentPane(new StartMenu());
		t = new Thread(this);
		running = true;
		t.start();
	}

	public void run() {
		while (running) {
			window.repaint();
			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}
		}
	}

	public static void switchContentPane(int ID) {
		switch (ID) {
			case 0:
				Main.window.setContentPane(new StartMenu());
				Panel.currentScreen = ID;
			break;
			case 1:
				Main.window.setContentPane(new SingleplayerMenu());
				Panel.currentScreen = ID;
			break;
			case 2:
				Main.window.setContentPane(new MultiplayerMenu());
				Panel.currentScreen = ID;
			break;
			case 3:
				Main.window.setContentPane(new SettingsMenu());
				Panel.currentScreen = ID;
			break;
			case 4:
				Main.window.setContentPane(new GameWindow());
				Panel.currentScreen = ID;
			break;
		}
		window.revalidate();
	}
}