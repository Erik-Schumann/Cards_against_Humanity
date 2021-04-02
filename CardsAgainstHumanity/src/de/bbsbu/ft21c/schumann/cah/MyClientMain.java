package de.bbsbu.ft21c.schumann.cah;

import de.bbsbu.gui.SimpleInputDialog;
import de.bbsbu.tools.PrefsFileStore;
import de.bbsbu.tools.Tools;

public class MyClientMain {
	public static void main(String args[]) {
		PrefsFileStore pfs = new PrefsFileStore("Client.config");
		int Playerid = 0;
		String question;
		Antwortauswahl asw;
		Wahlfenster wf;
		Ergebnisfenster ef;
		SimpleInputDialog sid = new SimpleInputDialog("Spielerkonfiguration",
				new String[] { "Name", "Server ip", "Server port" },
				new String[] { "", pfs.getString("Serverip", "Konfigurationsdatei nicht gefunden"),
						pfs.getInt("Serverport", 5000) + "" },
				10);
		String[] sAr = sid.getInputs();
		MyClient mc = new MyClient(sAr[1], Integer.parseInt(sAr[2]));
		String Output = mc.signin(sAr[0]);

		if (Output.equals("No playerslot avaiable")) {
			System.out.println("Game already fuel");
			while (Output.equals("No playerslot avaiable")) {
				Output = mc.signin(sAr[0]);
				Tools.delay(10000);
			}
		} else {
			System.out.println("You are player " + Output);
			Playerid = Integer.parseInt(Output);
			while (mc.getstatus() == 1) {
				Tools.delay(3000);
			}
			question = mc.getquestion();
			asw = new Antwortauswahl(sAr[0], mc, Playerid, question);
			Tools.delay(5000);
			while (mc.getstatus() == 2) {
				Tools.delay(3000);
			}
			String[] lAr = mc.getcollectedanswers().split(";");
			wf = new Wahlfenster(sAr[0], mc, Playerid, question, lAr[0], lAr[1], lAr[2], lAr[3], lAr[4], lAr[5], lAr[6],
					lAr[7]);
			while (mc.getstatus() == 3) {
				Tools.delay(3000);
			}
			String[] eAr = mc.getcollectedpoints().split(";");
			ef= new Ergebnisfenster(sAr[0], mc, Playerid, question, lAr[0], lAr[1], lAr[2], lAr[3], lAr[4], lAr[5], lAr[6],lAr[7],Integer.parseInt(eAr[0]), Integer.parseInt(eAr[1]),Integer.parseInt(eAr[2]),Integer.parseInt(eAr[3]));
		}
	}
}
