package de.bbsbu.ft21c.schumann.cah;

import de.bbsbu.network.SimpleClient;
import de.bbsbu.tools.PrefsFileStore;
import de.bbsbu.tools.Tools;

public class MyServerMain {

	public static void main(String[] args) {
		PrefsFileStore pfs = new PrefsFileStore("Server.config");
		MyServer Serv = new MyServer(pfs.getString("ip", "127.0.0.1"), pfs.getInt("port", 5000));
		Serv.start();
		SimpleClient sc = new SimpleClient(pfs.getString("ip", "127.0.0.1"), pfs.getInt("port", 5000));
		Serv.reset(sc);
		ServerController sctr = new ServerController(pfs.getString("ip", "127.0.0.1"), pfs.getInt("port", 5000));
		sctr.start();
		
	}
}
