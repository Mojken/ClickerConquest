package net.abysmal.clickerconquest.windows;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.networking.Client;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public int width = 500;
	public int height = 350;
// public int width = 550;
// public int height = (width / 12) * 16;

	static int ID;
	protected Panel p;
	public Client c;

	public Window() {
		createWindow();
	}

	private void createWindow() {
		setIconImage(new ImageIcon("res/net/abysmal/clickerconquest/icon32.ico").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setTitle("Clicker Conquest");
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}