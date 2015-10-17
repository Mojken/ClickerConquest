package net.abysmal.clickerconquest.windows;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.abysmal.clickerconquest.graphics.Panel;
import net.abysmal.clickerconquest.utils.Button;
import net.abysmal.clickerconquest.utils.ButtonHandler;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public static Button[] buttons;

	public static int width, height, scale;

	static int	ID;
	protected Panel		p;

	protected ButtonHandler BH;

	public Window() {
		createWindow();
	}

	private void createWindow() {
		setVisible(true);
		setIconImage(new ImageIcon("res/net/abysmal/clickerconquest/icon32.ico").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Clicker Conquest");
	}
}