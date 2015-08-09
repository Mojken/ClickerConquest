package net.abysmal.clickerconquest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainGame extends JFrame {

	private JPanel contentPane;
	static ImageIcon img = new ImageIcon("res/net/abysmal/clickerconquest/icon32.ico");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try{
					MainGame frame = new MainGame();
					frame.setVisible(true);
					frame.setIconImage(img.getImage());
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	public MainGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}