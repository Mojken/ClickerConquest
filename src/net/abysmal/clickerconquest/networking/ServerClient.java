package net.abysmal.clickerconquest.networking;

import java.net.InetAddress;

public class ServerClient {

	public InetAddress	address;
	public short		ID;
	public int			port;
	public int			attempt	= 0;

	public ServerClient(short ID, InetAddress address, int port) {
		this.ID = ID;
		this.address = address;
		this.port = port;
	}

	public short getID() {
		return ID;
	}
}