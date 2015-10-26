package net.abysmal.clickerconquest.windows;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.utils.ButtonHandler;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

//	public int width = 1920;
//	public int height = 1080;
 public int width = 550;
 public int height = (width / 12) * 16;

	static int ID;
	protected Panel p;
	protected ButtonHandler BH;

	public Window() {
		createWindow();
	}

	private void createWindow() {
		setIconImage(new ImageIcon("res/net/abysmal/clickerconquest/icon32.ico").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Clicker Conquest");
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}