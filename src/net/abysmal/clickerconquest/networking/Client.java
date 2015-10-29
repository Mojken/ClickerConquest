package net.abysmal.clickerconquest.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import net.abysmal.clickerconquest.Game;
import net.abysmal.clickerconquest.Main;
import net.abysmal.clickerconquest.actions.CreateNewGame;
import net.abysmal.clickerconquest.entities.Idol;
import net.abysmal.clickerconquest.entities.Player;
import net.abysmal.clickerconquest.entities.Unit;

public class Client {

	public boolean connected = false;
	private String name, address;
	private int port;
	private DatagramSocket socket;
	private InetAddress ip;
	private Thread send;
	private Thread listen;

	public Client(String name, String address) {
		this.name = name;
		if (address != null && address.split(":").length == 2) {
			this.address = address.split(":")[0];
			this.port = Integer.parseInt(address.split(":")[1]);
			boolean connected = openConnection(this.address);
			if (!connected) System.err.println("Unable to connect to " + this.address + this.port);
			if (connected) {
				String message = "/c/" + convert(Main.PlayerID).substring(2);
				send(message.getBytes());
				if (recieve().startsWith("/s/c/")) {
					this.connected = true;
					System.out.println("Connected!");
					listen();
				}
			}
		} else {
			System.err.println("Incorrect IP Format");
		}
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

	public String recieve() {
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);

		try {
			socket.receive(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (new String(packet.getData()));
	}

	public void listen() {
		listen = new Thread("Listen") {

			public void run() {
				while (connected) {
					String message = recieve();
					if (message.startsWith("/d/")) {
						process(message.substring(3), 1);
					} else if (message.startsWith("/s/")) {
						String service = message.substring(3);
						if (service.startsWith("p/")) {
							int[] players = { convert(message.substring(2, 4)), convert(message.substring(5, 7)) };
							new CreateNewGame(players);
							Main.switchContentPane(4);
						}
					}
				}
			}
		};
		listen.start();
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
			String units = "";
			String idols = "";
			Unit[] unit = Game.players[0].getUnits();
			Idol[] idol = Game.players[0].getIdols();
			String[] unitlevels = new String[unit.length];
			String[] idollevels = new String[idol.length];

			units = "" + convert(unit.length);
			for (int i = 0; i < unit.length; i++)
				if (unit[i] != null) unitlevels[i] = convert(unit[i].getAmount());
			for (int i = 0; i < unit.length; i++)
				if (unit[i] != null) units += convert(unit[i].getID());
			for (int i = 0; i < unit.length; i++)
				if (unit[i] != null) units += convert(unitlevels[i].length());
			for (int i = 0; i < unit.length; i++)
				if (unit[i] != null) units += unitlevels[i];

			idols = "" + convert(idol.length);
			for (int i = 0; i < idol.length; i++)
				if (idol[i] != null) idollevels[i] = convert(idol[i].getLevel());
			for (int i = 0; i < idol.length; i++)
				if (idol[i] != null) idols += convert(idol[i].getIndex());
			for (int i = 0; i < idol.length; i++)
				if (idol[i] != null) idols += convert(idollevels[i].length());
			for (int i = 0; i < idol.length; i++)
				if (idol[i] != null) idols += idollevels[i];

			message = "/d/" + convert(units.length() + 1) + units + idols;
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
			int length = convert(message.substring(0, 1));

			String units = message.substring(1, length);
			int[] unitIndex = new int[length];
			int[] unitLengths = new int[length];
			Unit[] Units = new Unit[4096];

			String idols = message.substring(length);
			int idolLength = convert(idols.substring(0, 1));
			int[] idolIndex = new int[idolLength];
			int[] idolLengths = new int[idolLength];
			Idol[] Idols = new Idol[4096];

			for (int i = 0; i < length; i++) {
				unitIndex[i] = convert(units.substring(0, 1));
				units = units.substring(1);
			}
			for (int i = 0; i < length; i++) {
				unitLengths[i] = convert(units.substring(0, 1));
				units = units.substring(1);
			}
			for (int i = 0; i < length; i++) {
				Units[i] = new Unit(unitIndex[i], convert(units.substring(0, unitLengths[i])));
				units = units.substring(unitLengths[i]);
			}

			for (int i = 0; i < idolLength; i++) {
				idolIndex[i] = convert(idols.substring(0, 1));
				idols = idols.substring(1);
			}
			for (int i = 0; i < idolLength; i++) {
				idolLengths[i] = convert(idols.substring(0, 1));
				idols = idols.substring(1);
			}
			for (int i = 0; i < idolLength; i++) {
				Idols[i] = new Idol(idolIndex[i], convert(idols.substring(0, idolLengths[i])));
				idols = idols.substring(idolLengths[i]);
			}

			Game.players[1].setUnits(Units);
			Game.players[1].setIdols(Idols);
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
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			result = (result << 8) | (c & 0xFF);
		}
		return result;
	}

	public void closeConnection() {
		socket.close();
	}
}