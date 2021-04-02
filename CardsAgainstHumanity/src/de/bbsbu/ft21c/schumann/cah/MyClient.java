package de.bbsbu.ft21c.schumann.cah;

import de.bbsbu.network.SimpleClient;
import de.bbsbu.tools.PrefsFileStore;

public class MyClient {
	SimpleClient sc;
	PrefsFileStore pfs;
	String Output = null;
	String Name;

	public MyClient() {
		pfs = new PrefsFileStore("Client.config");
		sc = new SimpleClient(pfs.getString("Serverip", "127.0.0.1"), pfs.getInt("Serverport", 5000));
	}
	public MyClient(String ip, int port) {
		sc = new SimpleClient(ip, port);
	}

	public String signin(String Name) {
		String Returnstatement = null;
		this.Name = Name;
		try {
			sc.openConnection();
			System.out.println("Server>> " + sc.read());
			sc.send("sign in player 1");
			sc.read();
			Output = sc.read();
			System.out.println("Server>> " + Output);
			if (Output.equals("okay send your name")) {
				sc.send(Name + "");
				// System.out.println(sc.read());
				Returnstatement = "1";
			} else {
				try {
					sc.closeConnection();
					sc.openConnection();
					System.out.println("Server>> " + sc.read());
					sc.send("sign in player 2");
					sc.read();
					Output = sc.read();
					System.out.println("Server>> " + Output);
					if (Output.equals("okay send your name")) {
						sc.send(Name + "");
						// System.out.println(sc.read());
						Returnstatement = "2";
					} else {
						try {
							sc.closeConnection();
							sc.openConnection();
							System.out.println("Server>> " + sc.read());
							sc.send("sign in player 3");
							sc.read();
							Output = sc.read();
							System.out.println("Server>> " + Output);
							if (Output.equals("okay send your name")) {
								sc.send(Name + "");
								// System.out.println(sc.read());
								Returnstatement = "3";
							} else {
								try {
									sc.closeConnection();
									sc.openConnection();
									System.out.println("Server>> " + sc.read());
									sc.send("sign in player 4");
									sc.read();
									Output = sc.read();
									System.out.println("Server>> " + Output);
									if (Output.equals("okay send your name")) {
										sc.send(Name + "");
										// System.out.println(sc.read());
										Returnstatement = "4";
									} else {
										try {
											sc.closeConnection();
										} catch (Exception e) {
											e.printStackTrace();
										}
										Returnstatement = "No playerslot avaiable";
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.closeConnection();
		return Returnstatement;
	}// Funktion Signin
	
	public int getstatus() {
		int status= 0;
		try {
			sc.openConnection();
			sc.read();
			sc.send("get status");
			sc.read();
			status = Integer.parseInt(sc.read());
			System.out.println("Server>> status: "+status);
			sc.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String getquestion() {
		String question = null;
		try {
			sc.openConnection();
			sc.read();
			sc.send("get question");
			sc.read();
			question = sc.read();
			System.out.println("Server>> question: "+question);
			sc.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return question;
	}
	public void setanswer(int Playerid,String answer) {
		try {
			System.out.println("ms1");
			sc.openConnection();
			sc.read();
			sc.send("set answer player "+Playerid);
			System.out.println("ms2");
			sc.read();
			sc.send(answer);
			System.out.println("Server>> Player "+Playerid+ " set answer to "+answer);
			sc.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void givepoints(int player) {
		try {
			sc.openConnection();
			sc.read();
			sc.send("set point to player "+player);
			sc.read();
			System.out.println("Server>> point given to player" + player);
			sc.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getcollectedanswers() {
		String Output= "";
		try {
			sc.openConnection();
			sc.read();
			sc.send("get collected answers");
			sc.read();
			Output = sc.read();
			System.out.println("Server>> request all answers");
			sc.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Output;
	}
	public String getcollectedpoints() {
		String Output= "";
		try {
			sc.openConnection();
			sc.read();
			sc.send("get collectedpoints sing");
			sc.read();
			Output = sc.read();
			System.out.println("Server>> request all points");
			sc.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Output;
	}
}// ganze Klasse
