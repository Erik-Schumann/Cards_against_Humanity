package de.bbsbu.ft21c.schumann.cah;

import de.bbsbu.network.SimpleClient;
import de.bbsbu.tools.Tools;

public class ServerController extends Thread {
	String input, status;
	SimpleClient sc;

	public ServerController(String ip, int port) {
		sc = new SimpleClient(ip, port);
	}

	@Override
	public void run() {
		try {
			sc.openConnection();
			sc.read();
			sc.send("get status");
			sc.read();
			status = sc.read();
			System.out.println(status);
			sc.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			Tools.delay(8000);
			try {
				if(!status.contentEquals("4")) {
				sc.openConnection();
				sc.read();
				sc.send("get status");
				sc.read();
				status = sc.read();
				System.out.println(status);
				sc.closeConnection();}

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (status.equals("1")) {
				try {
					sc.openConnection();
					sc.read();
					sc.send("get playerstatus");
					sc.read();
					sc.send("all");
					sc.read();
					input = sc.read();
					sc.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (input.equals("4")) {
					try {
						sc.openConnection();
						sc.read();
						sc.send("set status");
						sc.read();
						sc.send("2");
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
			if (status.equals("2")) {
				try {
					sc.openConnection();
					sc.read();
					sc.send("get answerstatus");
					sc.read();
					input = sc.read();
					sc.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (input.equals("4")) {
					try {
						sc.openConnection();
						sc.read();
						sc.send("set status");
						sc.read();
						sc.send("3");
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
			if (status.equals("3")) {
				try {
					sc.openConnection();
					sc.read();
					sc.send("get collectedpoints");
					sc.read();
					input = sc.read();
					sc.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (input.equals("4")) {
					try {
						sc.openConnection();
						sc.read();
						sc.send("set status");
						sc.read();
						sc.send("4");
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
			
		}
	}
}
