package de.bbsbu.ft21c.schumann.cah;


import java.net.Socket;

import de.bbsbu.network.SimpleClient;
import de.bbsbu.network.SimpleServer;

public class MyServer extends SimpleServer{
	String ip;
	int port;
	Socket soc;
	SimpleClient sc;
	
	public MyServer (String ip, int port) {
		super(ip, port);
		this.ip = ip;
		this.port = port;
	}
	
	@Override
	public void handleConnection( Socket soc) throws Exception {
		MyServerCommunication ServCom = new MyServerCommunication(soc);
		ServCom.start();
		this.soc = soc;
	}
	public void reset(SimpleClient sc) {
		this.sc = sc;
		try {
			sc.openConnection();
			sc.read();
			sc.send("reset players");
			sc.read();
			sc.send("all");
			sc.closeConnection();
			sc.openConnection();
			sc.read();
			sc.send("set status");
			sc.read();
			sc.send("1");
			sc.closeConnection();
			sc.openConnection();
			sc.read();
			sc.send("select new question");
			sc.read();
			sc.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
