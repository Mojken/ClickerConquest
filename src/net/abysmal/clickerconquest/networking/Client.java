package net.abysmal.clickerconquest.networking;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import net.abysmal.clickerconquest.Game;
import net.abysmal.clickerconquest.entities.Idol;
import net.abysmal.clickerconquest.entities.Player;
import net.abysmal.clickerconquest.entities.Unit;

public class Client {

	private String name, address;
	private int port;
	private DatagramSocket socket;
	private InetAddress ip;
	private Thread send;
	private Thread recieve;

	public Client(String name, String address, int port) {
		this.name = name;
		this.address = address;
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getPort() {
		return port;
	}

	public void recieve() {
		recieve = new Thread("Recieve") {

			public void run() {

				byte[] data = new byte[1024];
				DatagramPacket packet = new DatagramPacket(data, data.length);

				try {
					socket.receive(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}

				String message = new String(packet.getData());

				if (message.startsWith("/d/")) {
					String stats = message.substring(3, message.length());
					process(stats, 1);
				} else if (message.startsWith("/s/")) {
					@SuppressWarnings("unused")
					String service = message.substring(3, message.length());
				}
			}
		};
		recieve.start();
	}

	public void send(final byte[] data) {
		send = new Thread("Send") {

			public void run() {
				DatagramPacket packet = new DatagramPacket(data, data.length, ip, port);
				try {
					socket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		send.start();
	}

	public boolean openConnection(String address) {
		try {
			socket = new DatagramSocket();
			ip = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void process(Player player, int type) {
		if (type == 2) {
			String message;
			String units, idols;
			Unit[] unit = Game.players[0].getUnits();
			Idol[] idol = Game.players[0].getIdols();
			String[] unitlevels = new String[unit.length];
			String[] idollevels = new String[idol.length];

			units = "" + convert(unit.length);
			for (int i = 0; i < unit.length; i++)
				unitlevels[i] = convert(unit[i].getAmmount());
			for (int i = 0; i < unit.length; i++)
				units += convert(unit[i].getType());
			for (int i = 0; i < unit.length; i++)
				units += convert(unitlevels[i].length());
			for (int i = 0; i < unit.length; i++)
				units += unitlevels[i];

			idols = "" + convert(idol.length);
			for (int i = 0; i < idol.length; i++)
				idollevels[i] = convert(idol[i].getLevel());
			for (int i = 0; i < idol.length; i++)
				idols += convert(idol[i].getIndex());
			for (int i = 0; i < idol.length; i++)
				idols += convert(idollevels[i].length());
			for (int i = 0; i < idol.length; i++)
				idols += idollevels[i];

			message = "/d/" + convert(units.length()) + units + idols;
			char[] chars = message.toCharArray();
			byte[] bytes = new byte[chars.length];
			for (int i = 0; i < message.length(); i++) {
				bytes[i] = (byte) chars[i];
			}
			send(bytes);
		}
	}

	public static void process(String message, int type) {
		if (type == 1) {
			byte[] bitLength = new byte[50];
			byte[] bitIndex = new byte[50];
			float[] stats = new float[11];
			String[] split = new String[11];
			int length = (int) (message.charAt(0));

			for (int i = 0; i < length; i++) {
				bitLength[i] = (byte) (message.charAt(0));
				message = message.substring(1);
			}

			for (int i = 0; i < length; i++) {
				bitIndex[i] = (byte) (message.charAt(0));
				message = message.substring(1);
			}

			for (int i = 0; i < length; i++) {
				if (bitIndex[i] != 7 && bitIndex[i] != 10) stats[bitIndex[i]] = convert(message.substring(0, bitLength[i]));
				else split[i] = message.substring(0, bitLength[i]);
				message = message.substring(bitLength[i]);
			}

			Game.players[0].setAP(stats[0]);
			Game.players[0].setAPGain(stats[1]);
			Game.players[0].setClickDamage(stats[2]);
			Game.players[0].setDPS(stats[3]);
			Game.players[0].setFunding(stats[4]);
			Game.players[0].setHealth(stats[5]);
			Game.players[0].setHP(stats[6]);
			Game.players[0].setIdols(Game.players[0].convertIdols(split[7]));
			Game.players[0].setKarma(stats[8]);
			Game.players[0].setMoney(stats[9]);
			Game.players[0].setUnits(Game.players[0].convertUnits(split[10]));
		}
	}

	public static String convert(int number) {
		char[] result = new char[4];
		result[0] = (char) (number >>> 24);
		result[1] = (char) ((number >> 16) & 0xFF);
		result[2] = (char) ((number >> 8) & 0xFF);
		result[3] = (char) (number & 0xFF);
	    return new String(result);
	}

	public static int convert(String message) {
		int result = 0;
	    for (int i=0; i < message.length(); i++) {
	        char c = message.charAt(i);
	        result = (result << 8) | (c & 0xFF);
	    }
	    return result;
	}
}