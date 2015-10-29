package net.abysmal.clickerconquest.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.abysmal.clickerconquest.graphics.Panel;

public class TextFieldHandler implements KeyListener {

	public TextFieldHandler() {}

	public void keyTyped(KeyEvent e) {
		for (TextField textField:Panel.textFields) {
			if (textField != null && textField.isFocused() && e.getKeyChar() != 0x8) {
				if (textField.getType() == TextField.IP) {
					 if ((e.getKeyChar() >= 0x30 && e.getKeyChar() <= 0x39) || e.getKeyChar() == ':' || e.getKeyChar() == KeyEvent.VK_PERIOD) {
						 textField.setText(textField.getText() + e.getKeyChar());
					 } break;
				}
				textField.setText(textField.getText() + e.getKeyChar());
				break;
			} else if (textField != null && textField.isFocused() && e.getKeyChar() == 0x8 && textField.getText().length() > 0) {
				textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
				break;
			}
		}
	}

	public static void setFocus(int ID) {
		for (TextField textField : Panel.textFields) {
			if (textField != null && textField.getScreen() == Panel.currentScreen) {
				textField.setFocus(false);
			}
		}
		Panel.textFields[ID].setFocus(true);
	}
	
	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}
}