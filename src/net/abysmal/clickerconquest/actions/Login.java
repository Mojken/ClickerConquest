package net.abysmal.clickerconquest.actions;

import net.abysmal.clickerconquest.Main;

public class Login {
	
	String username, password;
	int ID;
	
	public Login(String Name, String Password) {
		username = Name;
		password = Password;
		Main.username = username;
		switch (username) {
			case "Mojken":
				ID = 42;
				Main.PlayerID = 42;
//				System.out.println(Main.PlayerID);
//				System.out.println(Client.convert(Main.PlayerID));
			break;
			case "Deepstream":
				ID = 47105;
				Main.PlayerID = 47105;
//				System.out.println(Main.PlayerID);
//				System.out.println(Client.convert(Main.PlayerID));
			break;
		}
	}
}