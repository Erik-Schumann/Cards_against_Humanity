package de.bbsbu.ft21c.schumann.cah;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.util.Random;

import de.bbsbu.network.SimpleServerCommunication;
import de.bbsbu.tools.PrefsFileStore;

public class MyServerCommunication extends SimpleServerCommunication {
	PrefsFileStore pfs, player1, player2, player3, player4;
	Socket soc;
	BufferedReader inbuf;
	BufferedWriter outbuf;
	String input;
	BufferedWriter out;

	public MyServerCommunication(Socket soc) {
		super(soc);
		this.soc = soc;

	}

	private static int Zufallszahl() {
		int Zahl;
		Random Zufall = new Random();
		Zahl = Zufall.nextInt(55);
		return Zahl;
	}

	private String getquestion(int Stelle) {
		String[] Fragen = { "TSA Richtlinien verbieten nun ___ in Flugzeugen",
				"Der Weihnachtsmann schenkte mir dieses Jahr:_____",
				"Es ist eine Schande, dass Kinder heutzutage in ___ hineingezogen werden",
				"Im Profifußball wurde ___, weil es Spielern unfaire Vorteile verschafft.",
				"Neues von J.K.: Harry Potter und die Kammer des ___",
				"Es tut mir leid Professor, aber wegen ___ konnte ich meine Hausaugaben nicht machen",
				"Was hast du aus Mexiko gebraucht?", "___? Dafür gibts ne App", "___ Einmal gepoppt, nie mehr gestoppt",
				"Was ist meine Antidroge?",
				"Während die USA und Soviet Union um den Mond kämpften, investrierte die meximanische Regierung in ___",
				"Was ist meine geheime Kraft?", "Das ist der neuste Trend:",
				"Als der Pharaoh nichts getan hat, hat Moses eine Plage von ___ herbeigerufen",
				"Wie halte ich meine Beziehung am Laufen?",
				"Es heißt in der Hannover Stadtbahn kannst du 200 Zigaretten für ___ eintauschen",
				"Statt Kohle gibt der Weihnachtsmann bösen Kindern nun: ",
				"Das Leben der Indiander wurde für immer verändert als der Weiße ihn ___ zeigte",
				"Was benutzt man in der Nachhilfe um Schülern in Großstädten zum Erfolg zu verhelfen?",
				"Vielleicht wurde Sie damit geboren, vielleicht ist es aber auch ___",
				"In seinen letzten Moment dachte Michael Jackson an ___", "Weiße Menschen sind wie ___",
				"Warum tut mir alles weh? ___", "Damit werde ich später mal mein Geld verdienen: ___",
				"Die Klassenfahrt wurde durch ___ völlig ruiniert", "__ ist was Frauen wollen",
				"Liebes Dr. Sommer Team, ich habe ein Problem mit ___ und brauche euren Rat",
				"Als Präsident der USA, würde ein Minesterium für ___ schaffen", "Was verstecken meine Eltern vor mir?",
				"Was funktioniert immer, um eine Party aufzupeppen? ___", "Was wird im Alter besser?",
				"___: Gut bis zum letzten Tropfen", "Ich habe 99 Probleme, aber ___ ist keins davon",
				"___ Es ist eine Falle!", "Was würde Oma verstören und doch irgendwie anziehen? ",
				"Während des Sex mag ich es über ___ nachzudenken", "Was hat meine letzte Beziehung beendet?",
				"Was ist diese Geräusch?", "___. So möchte ich sterben. ", "Was ist das nächste HappyMeal- Spielzeug?",
				"Was gibt es im Himmel tonnenweise?", "Was wird mich immer flachlegen dürfen? ",
				"___ mit Kindern getesten, von Müttern freigegeben", "Wieso kann ich Nachts nicht schlafen?",
				"Was ist das für ein Geruch?", "Doch bevor ich sie töte Mr. Bond, muss ich ihnen ___ zeigen",
				"Stdien belegen, dass Laborraten 50% schnell sind, wenn sie ___ augesetzt sind",
				"Und nun auf Eurosport, das Meisterschaftturnier von ___",
				"Als Milionär würde ich ___ in einer 50m Statue verewigen", "Krieg- wofür ist der gut?",
				"Wie riechen alte Leute?", "Worauf verzichte ich in der Fastenzeit?",
				"Die Alternativmedizin bedient sich nun den heilsamenen Kräften von ___",
				"Was möchtest du nicht in den chinesichen Essen finden? ", "Ich trinke um ___ zu vergessen",
				"___ ! High five Bro!" };
		return Fragen[Stelle];
	}

	@Override
	public void talk(BufferedReader inbuf, BufferedWriter outbuf) throws Exception {
		System.out.println();
		this.inbuf = inbuf;// String Read(BufferedReader)
		this.outbuf = outbuf;// void Send(BufferedWriter, String)
		pfs = new PrefsFileStore("Server.config");
		player1 = new PrefsFileStore("Player1.config");
		player2 = new PrefsFileStore("Player2.config");
		player3 = new PrefsFileStore("Player3.config");
		player4 = new PrefsFileStore("Player4.config");
		send(outbuf, "hello Client");
		send(outbuf, " ");
		input = read(inbuf);
		System.out.println("Client>> " + input);

		if (input.equals("?")) {
			send(outbuf, "set {ip/port/question/status/answer player {1/2/3/4}");//status 1 (searching players) 2 (collecting answers) 3 (collecting points) 4 (finished)
			System.out.print("");
			send(outbuf, "get {question/status/playerstatus/collected answers/answerstatus/collectedpoints}");
			System.out.print("");
			send(outbuf, "select {new question}");
			System.out.print("");
			send(outbuf, "sign in player {1/2/3/4}");
			System.out.print("");
			send(outbuf, "set point to player {1/2/3/4}");
			System.out.print("");
			send(outbuf, "reset {players/points}");
			System.out.print("");
			System.out.println("Client>> requested help");
		}
		if (input.equals("set ip")) {
			send(outbuf, "okay send new ip");
			System.out.print("");
			input = read(inbuf);
			System.out.print("");
			pfs.putString("ip", input);
			send(outbuf, "ip set to:" + input);
			System.out.println("Client>> set ip to " + input);
		}
		if (input.equals("set port")) {
			send(outbuf, "okay send new port");
			System.out.print("");
			input = read(inbuf);
			System.out.print("");
			pfs.putInt("port", Integer.parseInt(input));
			send(outbuf, "port set to:" + input);
			System.out.println("Client>> set port to " + input);
		}
		if (input.equals("set question")) {
			send(outbuf, "okay send new question");
			System.out.print("");
			input = read(inbuf);
			System.out.print("");
			pfs.putString("question", input);
			send(outbuf, "question set to:" + input);
			System.out.println("Client>> set question to " + input);
		}
		if (input.equals("select new question")) {
			pfs.putString("question", getquestion(Zufallszahl()));
			send(outbuf, "new question selected");
			System.out.print("");
			System.out.println("Client>> Server should select new question");
		}
		if (input.equals("get question")) {
			send(outbuf, pfs.getString("question", "Err 404: question not found"));
			System.out.print("");
			System.out.println("Client>>requested question");
		}
		if (input.equals("get status")) {
			send(outbuf, "" + pfs.getInt("status", 0));
			System.out.print("");
			System.out.println("Client>>requested status");
		}
		if (input.equals("set status")) {
			send(outbuf, "okay send new status");
			System.out.print("");
			input = read(inbuf);
			System.out.print("");
			pfs.putInt("status", Integer.parseInt(input));
			send(outbuf, "status set to:" + input);
			System.out.println("Client>> set status to " + input);
		}
		if (input.equals("sign in player 1")) {
			if (player1.getInt("playerstatus", 0) == 0) {
				send(outbuf, "okay send your name");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player1.putInt("playerstatus", 1);
				player1.putString("name", input);
				send(outbuf, "You are signed in as player 1! Welcome " + input + "!");
				System.out.println("Client>> set playerstatus1 to 1: Welcome: " + input);
			} else {
				send(outbuf, "unavailable");
			}
		}
		if (input.equals("sign in player 2")) {
			if (player2.getInt("playerstatus", 0) == 0) {
				send(outbuf, "okay send your name");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player2.putInt("playerstatus", 1);
				player2.putString("name", input);
				send(outbuf, "You are signed in as player 2! Welcome " + input + "!");
				System.out.println("Client>> set playerstatus2 to 1: Welcome: " + input);
			} else {
				send(outbuf, "unavailable");
			}
		}
		if (input.equals("sign in player 3")) {
			if (player3.getInt("playerstatus", 0) == 0) {
				send(outbuf, "okay send your name");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player3.putInt("playerstatus", 1);
				player3.putString("name", input);
				send(outbuf, "You are signed in as player 3! Welcome " + input + "!");
				System.out.println("Client>> set playerstatus3 to 1: Welcome: " + input);
			} else {
				send(outbuf, "unavailable");
			}
		}
		if (input.equals("sign in player 4")) {
			if (player4.getInt("playerstatus", 0) == 0) {
				send(outbuf, "okay send your name");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player4.putInt("playerstatus", 1);
				player4.putString("name", input);
				send(outbuf, "You are signed in as player 4! Welcome " + input + "!");
				System.out.println("Client>> set playerstatus4 to 1: Welcome: " + input);
			} else {
				send(outbuf, "unavailable");
			}
		}
		if (input.equals("set answer player 1")) {
			if (player1.getInt("playerstatus", 0) == 1) {
				send(outbuf, "okay send your answer");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player1.putInt("answergiven", 1);
				player1.putString("selectedanswer", input);
				send(outbuf, "Answer set to: " + input);
				System.out.println("Client>> player 1 set answer to: " + input);
			} else {
				send(outbuf, "unavaiable player");
			}
		}
		if (input.equals("set answer player 2")) {
			if (player2.getInt("playerstatus", 0) == 1) {
				send(outbuf, "okay send your answer");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player2.putInt("answergiven", 1);
				player2.putString("selectedanswer", input);
				send(outbuf, "Answer set to: " + input);
				System.out.println("Client>> player 2 set answer to: " + input);
			} else {
				send(outbuf, "unavaiable player");
			}
		}
		if (input.equals("set answer player 3")) {
			if (player3.getInt("playerstatus", 0) == 1) {
				send(outbuf, "okay send your answer");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player3.putInt("answergiven", 1);
				player3.putString("selectedanswer", input);
				send(outbuf, "Answer set to: " + input);
				System.out.println("Client>> player 3 set answer to: " + input);
			} else {
				send(outbuf, "unavaiable player");
			}
		}
		
		if (input.equals("get collected answers")) {	
				send(outbuf, player1.getString("name", "Player1")+";"+player1.getString("selectedanswer", "not given")+";"+player2.getString("name", "Player2")+";"+player2.getString("selectedanswer", "not given")+";"+player3.getString("name", "Player3")+";"+player3.getString("selectedanswer", "not given")+";"+player4.getString("name", "Player4")+";"+player4.getString("selectedanswer", "not given"));
				System.out.print("");
				System.out.println("Client>> requested collected answers");
		}
		if (input.equals("get answerstatus")) {	
			send(outbuf,(player1.getInt("answergiven", 0)+player2.getInt("answergiven", 0)+player3.getInt("answergiven", 0)+player4.getInt("answergiven", 0))+"");
			System.out.print("");
			System.out.println("Client>> requested answerstatus");
		}
		if (input.equals("get collectedpoints")) {	
			send(outbuf,(player1.getInt("points", 0)+player2.getInt("points", 0)+player3.getInt("points", 0)+player4.getInt("points", 0))+"");
			System.out.print("");
			System.out.println("Client>> requested sum of all points");
		}
		if (input.equals("get collectedpoints sing")) {	
			send(outbuf,(player1.getInt("points", 0)+";"+player2.getInt("points", 0)+";"+player3.getInt("points", 0)+";"+player4.getInt("points", 0))+"");
			System.out.print("");
			System.out.println("Client>> requested sum of all points");
		}
		if (input.equals("set point to player 1")) {	
			send(outbuf,"okay player 1 +1 point");
			int point = player1.getInt("points", 0)+1;
			player1.putInt("points", point);
			System.out.print("");
			System.out.println("Client>> give 1 point to player 1");
		}
		if (input.equals("set point to player 2")) {	
			send(outbuf,"okay player 2 +1 point");
			int point = player2.getInt("points", 0)+1;
			player2.putInt("points", point);
			System.out.print("");
			System.out.println("Client>> give 1 point to player 2");
		}
		if (input.equals("set point to player 3")) {	
			send(outbuf,"okay player 3 +1 point");
			int point = player3.getInt("points", 0)+1;
			player3.putInt("points", point);
			System.out.print("");
			System.out.println("Client>> give 1 point to player 3");
		}
		if (input.equals("set point to player 4")) {	
			send(outbuf,"okay player 4 +1 point");
			int point = player4.getInt("points", 0)+1;
			player1.putInt("points", point);
			System.out.print("");
			System.out.println("Client>> give 1 point to player 4");
		}
		if (input.equals("reset points")) {	
			send(outbuf,"okay all points resetted");
			player1.putInt("points", 0);
			player2.putInt("points", 0);
			player3.putInt("points", 0);
			player4.putInt("points", 0);
			System.out.print("");
			System.out.println("Client>> reset all points");
		}
		if (input.equals("get result")) {	
			send(outbuf,player1.getInt("points", 0)+";"+player2.getInt("points", 0)+";"+player3.getInt("points", 0)+";"+player4.getInt("points", 0));
			System.out.print("");
			System.out.println("Client>> requested result");
		}
		if (input.equals("set answer player 4")) {
			if (player4.getInt("playerstatus", 0) == 1) {
				send(outbuf, "okay send your answer");
				System.out.print("");
				input = read(inbuf);
				System.out.print("");
				player4.putInt("answergiven", 1);
				player4.putString("selectedanswer", input);
				send(outbuf, "Answer set to: " + input);
				System.out.println("Client>> player 4 set answer to: " + input);
			} else {
				send(outbuf, "unavaiable player");
			}
		}
		if (input.equals("get playerstatus")) {
			send(outbuf, "Which Player? {1/2/3/4/all}");
			input = read(inbuf);
			if(input.equals("1")) {
				send(outbuf, ""+player1.getInt("playerstatus", 0));
			}
			if(input.equals("2")) {
				send(outbuf, ""+player2.getInt("playerstatus", 0));
			}
			if(input.equals("3")) {
				send(outbuf, ""+player3.getInt("playerstatus", 0));
			}
			if(input.equals("4")) {
				send(outbuf, ""+player4.getInt("playerstatus", 0));
			}
			if(input.equals("all")) {
				send(outbuf, ""+(player1.getInt("playerstatus", 0)+player2.getInt("playerstatus", 0)+player3.getInt("playerstatus", 0)+player4.getInt("playerstatus", 0)));
			}
		}
		if (input.equals("reset players")) {

			send(outbuf, "Which player? {1/2/3/4/all}");
			System.out.print("");
			input = read(inbuf);
			System.out.print("");
			if (input.equals("1")) {
				player1.putInt("points", 0);
				player1.putString("selectedanswer", "not given");
				player1.putInt("answergiven", 0);
				player1.putString("name", "not given");
				player1.putInt("playerstatus", 0);
				send(outbuf, "Player " + input + " resetted!");
				System.out.println("Client>> reset player 1");
			}
			if (input.equals("2")) {
				player2.putInt("points", 0);
				player2.putString("selectedanswer", "not given");
				player2.putInt("answergiven", 0);
				player2.putString("name", "not given");
				player2.putInt("playerstatus", 0);
				send(outbuf, "Player " + input + " resetted!");
				System.out.println("Client>> reset player 2");
			}
			if (input.equals("3")) {
				player3.putInt("points", 0);
				player3.putString("selectedanswer", "not given");
				player3.putInt("answergiven", 0);
				player3.putString("name", "not given");
				player3.putInt("playerstatus", 0);
				send(outbuf, "Player " + input + " resetted!");
				System.out.println("Client>> reset player 3");
			}
			if (input.equals("4")) {
				player4.putInt("points", 0);
				player4.putString("selectedanswer", "not given");
				player4.putInt("answergiven", 0);
				player4.putString("name", "not given");
				player4.putInt("playerstatus", 0);
				send(outbuf, "Player " + input + " resetted!");
				System.out.println("Client>> reset player 4");
			}
			if (input.equals("all")) {
				player1.putInt("points", 0);
				player1.putString("selectedanswer", "not given");
				player1.putInt("answergiven", 0);
				player1.putString("name", "not given");
				player1.putInt("playerstatus", 0);

				player2.putInt("points", 0);
				player2.putString("selectedanswer", "not given");
				player2.putInt("answergiven", 0);
				player2.putString("name", "not given");
				player2.putInt("playerstatus", 0);

				player3.putInt("points", 0);
				player3.putString("selectedanswer", "not given");
				player3.putInt("answergiven", 0);
				player3.putString("name", "not given");
				player3.putInt("playerstatus", 0);

				player4.putInt("points", 0);
				player4.putString("selectedanswer", "not given");
				player4.putInt("answergiven", 0);
				player4.putString("name", "not given");
				player4.putInt("playerstatus", 0);

				send(outbuf, "All players resetted!");
				System.out.println("Client>> reset all players");
			}

		}

		System.out.println();
	}
}