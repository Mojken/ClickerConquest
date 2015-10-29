package net.abysmal.clickerconquest.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {

	private List<ServerClient> clients = new ArrayList<ServerClient>();

	private DatagramSocket socket;
	private int port;
	private boolean running = false;
	private Thread run, send, receive;

	public Server(int port) {
		this.port = port;
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
			return;
		}
		run = new Thread(this, "Server");
		run.start();
	}

	public void run() {
		running = true;
		System.out.println("Server started on port " + port);
		receive();
	}

	private void receive() {
		receive = new Thread("Recieve") {

			public void run() {
				while (running) {
					byte[] data = new byte[1024];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					try {
						socket.receive(packet);
					} catch (IOException e) {
						e.printStackTrace();
					}
					process(packet);
				}
			}

		};
		receive.start();
	}

	private final void send(byte[] data, InetAddress address, int port) {
		send = new Thread("Send") {

			public void run() {
				DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
				try {
					socket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		send.start();
	}

	private void process(DatagramPacket packet) {
		String string = new String(packet.getData());
		if (string.startsWith("/c/")) {
			short ID = (short) (Client.convert(string.substring(3, 5)));
			clients.add(new ServerClient(ID, packet.getAddress(), packet.getPort()));
			send("/s/c/".getBytes(), packet.getAddress(), packet.getPort());
			
			if (clients.size() == 2) {
				String message = "/s/p/" + clients.get(0).ID + "/" + clients.get(1).ID;
				send(message.getBytes(), clients.get(0).address, clients.get(0).port);
				send(message.getBytes(), clients.get(1).address, clients.get(1).port);
			}

		} else {
// System.out.println(string);
		}
	}
}