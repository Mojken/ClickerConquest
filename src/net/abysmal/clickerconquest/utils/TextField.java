package net.abysmal.clickerconquest.utils;

import net.abysmal.clickerconquest.Game;
import net.abysmal.clickerconquest.entities.Unit;

public class TextField {

	private int ID, x, y, width, height, screen, fontSize, textMaxLength, type, alignment;
	private String text;
	private boolean editable, focused, centered;

	public static final int TEXTBOX = 0;
	public static final int PASSWORD = 1;
	public static final int IP = 2;
	public static final int TEXT_FIELD = 3;

	public static final int LEFT = 0;
	public static final int CENTER = 1;
	public static final int RIGHT = 2;

	public static final String STAT_MONEY = "STAT_MONEY";
	public static final String STAT_FUNDING = "STAT_FUNDING";
	public static final String STAT_APGAIN = "STAT_APGAIN";
	public static final String STAT_DPS = "STAT_DPS";
	public static final String STAT_CLICK_DAMAGE = "STAT_CLICK_DAMAGE";
	public static final String STAT_HP = "STAT_HP";
	public static final String STAT_COST = "STAT_COST";
	public static final String STAT_AMOUNT = "STAT_AMOUNT";
	public static final String STAT_DEFENCE = "STAT_DEFENCE";
	public static final String STAT_NAME = "STAT_NAME";
	public static final String STAT_DAMAGE = "STAT_DAMAGE";

	public String update = "";

	public TextField(int ID, int x, int y, int width, int height, String text, int screen, int fontSize, int type, int textLength, int alignment) {
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.screen = screen;
		this.fontSize = fontSize;
		update = text;
		updateText(update);
		if (type <= 2 && type >= 0) editable = true;
		else if (type == 3) {
			editable = false;
			centered = true;
		}
		focused = false;
		this.type = type;
		this.textMaxLength = textLength;
		this.alignment = alignment;
	}

	public TextField(int ID, int x, int y, int width, int height, int screen, int fontSize, int type, int textLength, int alignment, Unit unit, String stat) {
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.screen = screen;
		this.fontSize = fontSize;
		updateText(unit, stat);
		if (type <= 2 && type >= 0) editable = true;
		else if (type == 3) {
			editable = false;
			centered = true;
		}
		focused = false;
		this.type = type;
		this.textMaxLength = textLength;
		this.alignment = alignment;
	}

	public void updateText(String update) {
		switch (update) {
			case STAT_MONEY:
				text = "" + (int) Game.players[0].getMoney();
			break;
			case STAT_FUNDING:
				text = "" + (int) Game.players[0].getFunding();
			break;
			case STAT_APGAIN:
				text = "" + (int) Game.players[0].getAPGain();
			break;
			case STAT_DPS:
				text = "" + (int) Game.players[0].getDPS();
			break;
			case STAT_CLICK_DAMAGE:
				text = "" + (int) Game.players[0].getClickDamage();
			break;
			case STAT_HP:
				text = "" + (int) Game.players[0].getHP();
			break;
			default:
			break;
		}
	}

	public void updateText(Unit unit, String stat) {
		switch (stat) {
			case STAT_DPS:
				text = "" + (int) unit.getDPS();
			break;
			case STAT_CLICK_DAMAGE:
				text = "" + (int) unit.getClickDamage();
			break;
			case STAT_HP:
				text = "" + (int) unit.getHP();
			break;
			case STAT_COST:
				text = "\u00A2" + (int) unit.getCost();
			break;
			case STAT_AMOUNT:
				int amount = 0;
				if (Game.players[0] != null && Game.players[0].getUnits()[unit.getID() + unit.getType()] != null) amount = Game.players[0].getUnits()[unit.getID() + unit.getType()].getAmount();
				text = amount + "  ";
			break;
			case STAT_DEFENCE:
				text = "" + (int) unit.getDefence();
			break;
			case STAT_NAME:
				text = unit.getName();
			break;
			case STAT_DAMAGE:
				if (unit.type == 0) text = "" + (int) unit.getDPS();
				else if (unit.type == 1) text = "" + (int) unit.getClickDamage();
			break;
			default:
			break;
		}
	}

	public int getID() {
		return ID;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getScreen() {
		return screen;
	}

	public int getFontSize() {
		if (type == 1) {
			return fontSize + 35;
		} else return fontSize;
	}

	public String getText() {
		if (type == 1) {
			String result = "";
			while (result.length() < text.length() && result.length() < 12) {
				result = result + "×";
			}
			return result;
		} else return text;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setText(String text) {
		if (text.length() <= textMaxLength) this.text = text;
	}

	public void setFocus(boolean focus) {
		focused = focus;
	}

	public boolean isFocused() {
		return focused;
	}

	public int getType() {
		return type;
	}

	public boolean isCentered() {
		return centered;
	}

	public boolean doUpdate() {
		if (update != "") return true;
		else return false;
	}

	public String getUpdate() {
		return update;
	}

	public int getAlignment() {
		return alignment;
	}
}
