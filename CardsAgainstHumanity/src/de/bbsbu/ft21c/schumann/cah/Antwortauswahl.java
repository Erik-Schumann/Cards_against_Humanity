package de.bbsbu.ft21c.schumann.cah;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Antwortauswahl extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JFrame Auswahlfenster;
	JPanel Inhalt;
	String Frage, OptionA, OptionB, OptionC, OptionD, OptionE, OptionF, OptionG, OptionH,OptionI, OptionJ, Name;
	String Auswahl;
	int Playerid;
	MyClient mc;
	public Antwortauswahl(String Name, MyClient mc, int Playerid, String question) {
		this.Name = Name; 
		this.OptionA = auswaehlenAntwort();
		this.OptionB = auswaehlenAntwort();
		this.OptionC = auswaehlenAntwort();
		this.OptionD = auswaehlenAntwort();
		this.OptionE = auswaehlenAntwort();
		this.OptionF = auswaehlenAntwort();
		this.OptionG = auswaehlenAntwort();
		this.OptionH = auswaehlenAntwort();
		this.OptionI = auswaehlenAntwort();
		this.OptionJ = auswaehlenAntwort();
		this.Playerid = Playerid;
		this.Frage = question;
		this.mc = mc;
		Auswahlfenster = new JFrame("Kartenauswahl");
		Auswahlfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Auswahlfenster.setBounds(300, 150, 1200, 800);
		Auswahlfenster.setVisible(true);
		Inhalt= new JPanel();
		Inhalt.setLayout(new GridBagLayout());
		Auswahlfenster.setContentPane(Inhalt);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel headerLabel = new JLabel("Cards against Humanity");
		headerLabel.setBorder(new LineBorder(Color.BLACK));
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		Inhalt.add(headerLabel, c);
		
		JLabel Titel_Kartenauswahl = new JLabel("Aktuelle Kartenlücke:");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(Titel_Kartenauswahl, c);
		
		JLabel Kartenauswahl_Bereich = new JLabel(Frage);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		
		Inhalt.add(Kartenauswahl_Bereich, c);

		JButton buttonA = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonA.setActionCommand( "OptionA" );
		buttonA.addActionListener( this );
		Inhalt.add(buttonA, c);

		JLabel TextfeldA = new JLabel(" "+OptionA);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldA, c);
		
		JButton buttonB = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonB.setActionCommand( "OptionB" );
		buttonB.addActionListener( this );
		Inhalt.add(buttonB, c);

		JLabel TextfeldB = new JLabel(" "+OptionB);
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldB, c);
		
		JButton buttonC = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonC.setActionCommand( "OptionC" );
		buttonC.addActionListener( this );
		Inhalt.add(buttonC, c);

		JLabel TextfeldC = new JLabel(" "+OptionC);
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldC, c);
		
		JButton buttonD = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonD.setActionCommand( "OptionD" );
		buttonD.addActionListener( this );
		Inhalt.add(buttonD, c);

		JLabel TextfeldD = new JLabel(" "+OptionD);
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldD, c);
		
		JButton buttonE = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonE.setActionCommand( "OptionE" );
		buttonE.addActionListener( this );
		Inhalt.add(buttonE, c);

		JLabel TextfeldE = new JLabel(" "+OptionE);
		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldE, c);
		
		JButton buttonF = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonF.setActionCommand( "OptionF" );
		buttonF.addActionListener( this );
		Inhalt.add(buttonF, c);

		JLabel TextfeldF = new JLabel(" "+OptionF);
		c.gridx = 2;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldF, c);
		
		JButton buttonG = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonG.setActionCommand( "OptionG" );
		buttonG.addActionListener( this );
		Inhalt.add(buttonG, c);

		JLabel TextfeldG = new JLabel(" "+OptionG);
		c.gridx = 2;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldG, c);
		
		JButton buttonH = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonH.setActionCommand( "OptionH" );
		buttonH.addActionListener( this );
		Inhalt.add(buttonH, c);

		JLabel TextfeldH = new JLabel(" "+OptionH);
		c.gridx = 2;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldH, c);
		
		JButton buttonI = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonI.setActionCommand( "OptionI" );
		buttonI.addActionListener( this );
		Inhalt.add(buttonI, c);

		JLabel TextfeldI = new JLabel(" "+OptionI);
		c.gridx = 2;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldI, c);
		
		JButton buttonJ = new JButton("Diese Karte spielen");
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight = 1;
		buttonJ.setActionCommand( "OptionJ" );
		buttonJ.addActionListener( this );
		Inhalt.add(buttonJ, c);

		JLabel TextfeldJ = new JLabel(" "+OptionJ);
		c.gridx = 2;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldJ, c);
		
		JLabel Copyrights = new JLabel("All Copyrights belong to Erik Schumann");
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(Copyrights, c);
		
		JLabel Namensbereich = new JLabel("Dein Spielername: "+Name  + "(Player "+ Playerid+")");
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(Namensbereich, c);
		
		
	}
	public static String auswaehlenAntwort() {
		String s= null; 
		String[] Antworten={"ein Zigeunerfluch","Freunde-endlich","Ein Moment der Stille", "Würstchenparty.", "Ein rechtschaffender Cop, der nichts zu verlieren hat.", "Hungersnot", "Südamerikanischer Cousin, der mir 1Mio. Euro verspricht","Fleischfressende Bakterien", "Einen Schß um die dritte Welt kümmern.", "Sexting.", "Gestaltenwandler", "Pornostars", "Vergewaltigen und Plündern", "72 Jungfrauen", "Ein Zeitreise-Paradoxon", "Kantinenfrass", "Berater", "Lähmende Schulden", "Vaterkomplexe", "Der frühere Präsident Georg W. Bush.", "Völlig nackt.", "Hormonspritzen", "Ein Ei legen", "Sich ausziehen und Nickelodeon ansehen", "Vorgeben zu verhüten", "Öffentliches Verspotten", "Spritzen teilen", "Der unausweichliche Hitzetod des Universums", "Das Wunder der Geburt", "Der Tag des jüngsten Gerichts", "Es rausholen", "Privilegien der Weißen.", "Eheliche Pflichten.","Das Blut Christi", "AXE Deo", "Schlimme LaserhaarentfernungsUnfälle", "BATMAN!!!","Landwirtschaft.", "Natürliche Selektion", "Kleiderbügelabtreibung", "Alle Kekse vor einem AIDS Spendenverkauf essen", "Michelle Obamas Arme", "World of Warcraft", "Fettleibigkeit", "Ein homoerotischer Volleyball- Zusammenschnitt", "Eine Anmache", "All-you-can-eat-Schrimps für 5€", "Kanye West", "Heißer Käse", "Raptorenattacken", "Sein Tshirt ausziehen", "Alkoholismus", "Ein Mann mittleren Alters auf Rollschuhen", "Fressen und Kotzen", "Übergroße Lollis","Selbsthass","Kinder an einer Leine", "Halbherziges Vorspiel","Die Bibel", "Russiche Kellerpornos", "Teeagerschwangerschaft", "Ghandi", "Eine merkwürdige Mailboynachricht hinterlassen", "Mundenservice Mitarbeiter", "Eine Erektion, die länger als 4 Stunden dauert", "Meine Genitalien", "Frauen an einer Abtreibungsklinik anmachen", "Wissenschaft", "Oralsex nicht erwiedern.", "Flugunfähige Vögel", "Waterboarding", "Einem Kind Süßigkeiten wegnehmen", "Ein heimlicher Arschkratzer", "Das chinesiche Gymnastikteam", "Auf Rolex umsteigen", "Ein bisschen Einnässen", "Feuchter Traum","Juden","Meine Hüften","Kräftige Oberschenkel", "Alten Leuten zuzwinkern","Meister Proper direkt hinter dir", "Sexuelle Spannungen", "Die verbotene Frucht", "Reich sein","Süße, süße Rache","Republikaner","Mit den Gefühl zurechtkommen", "Der fleißige Mexikaner", "Das Michelin-Männchen", "So sauer werden, dass man ein Ständer bekommt", "Kostenlose Proben", "Das Richtige tun.", "Halbherziger Kompromiss", "Weltfrieden", "Justin Bieber", "Angela Merkel", "Unangebrachtes Jodeln", "Polizeiliche Gewalt","Zehn- bis Zwölfjährige", "Pubertät", "Geister","Fingern", "Twittern", "Darth Vader", "Ein schlechter Handjob", "Genau was du bekommst", "Einen Rülpser erwarten und dann auf den Boden kotzen", "Mundherpes", "Obdachlose.", "Inzest", "Eine Pantomine, die einen Schlageanfall hat", "Gott", "Sachen anlecken, damit sie einen gehören", "Freunde mit Extras", "Geruch alter Leute", "Kuscheln", "Schwanzkampf","Friendly Fire", "Eine enttäuschende Geburtstagsfeier","Eine freche schwarze Frau", "Ein kleines Pferd", "Pädophile", "Hefe", "Grabschändung", "Katapulte", "Arme Leute", "Macht", "Ihr den Hintern versolen", "AIDS", "Bilder von Titten", "Richtig High werden", "Scientology", "Penis Neid", "Die Schwulen wegwünschen", "Der Ku Klux Klan", "Crystal Meth", "Terroristen", "Britney Spears mit 55", "Gloryholes", "Das Herz eines Kindes", "Hunde Babies", "Aktives Zuhören", "Ethnische Säuberung", "Bis zur Hochzeit warten", "Erektile Sysfunktion", "Meine Sammlung von HIGhtech Sexspielzeug", "Der Papst", "Weiße", "Zu viel Haaregel", "Menstruation", "Der Süden", "Die Verlezung der meiste Menschenrechte", "Schwarze", "Schlampen", "Hererwärmende Waisen", "MehaHitler", "Die wahre Bedeutung von Weihnachten", "Ein deftiger Frühstücksdöner", "Michael Jackson", "Kerle, die nicht anrufen", "Masturbation", "Einen Ständer verbergen", "Essbare Unterwäsche", "Viagra", "Suppe, die zu heiß ist","Mohammed", "Überraschungssex", "MCs", "SMS", "Alleine Alkohol trinken", "Wurstfinger", "Mehrere Stichwunden", "sich einschießen", "Kindesmissbrauch", "Zivile Opfer", "Rausziehen.","Robert Downey Jr.", "Pferdefleisch", "Ein cooler Hut", "Kim Jong-il", "Ein einsames Scharmhaar", "Die Vorzeige Minderheit", "Es von hinten besorgt kriegen", "Einem Roboter Liebe beibringen", "Der American Dream", "Trichtersaufen", "Wenn du furzt und etwas Kacke hochkommt", "Tote Babies", "Vorhaut", "Italiener", "Vererbungslehre","Mein Beziehungsstatus","Erotische Harry Potter geschichten", "Internat", "Nazis", "8gr bestes russiches Heroin", "Sephen Hawking, der versaut redet", "Gelaber", "Unterdrückung", "Meine Vagina", "110% geben", "Ihre königliche Hoheit, Elizabeth II.", "Ein Mikropenis", "Meine Seele", "Ein heißes Durcheinander", "Vikinger", "Heiße Leute", "Verführung", "Gänse", "Globale Erwärmung", "Heisse Apfeltaschen", "Frauenwahlrecht", "Ein kaputtes Kondom", "Afrikanische Kinder", "Barack Obama", "Japaner, die nicht gut in Mathe sind", "Alte japanische Leute", "Homosexualität", "Das rote Meer teilen", "Blowjob während der Autofahrt", "Mein Sexleben", "Der Klitoris", "der Urknall", "Landminen", "Freunde, die alle Snacks wegessen.", "Schlecht getimte Holocaust Witze", "Frauen in Jogurt-Werbespots", "Ein verdammter Zauberer sein", "Genitalpiercings", "Sexy Kissenschlacht", "Eier. ", "Oma","Reibung", "Männer", "Sterben", "Cards against Humanity" };
		s= Antworten[Zufallszahl(236)];
		return s;
	}
	 public static int Zufallszahl(int Begrenzung) {
		 int Zahl;
		 Random Zufall = new Random();
		 Zahl = Zufall.nextInt(Begrenzung);
		 return Zahl;
	 }
	 public void actionPerformed( ActionEvent evt)
	 {
		 if ( evt.getActionCommand().equals("OptionA") ) {
			 System.out.println(Name+";"+OptionA);
			 mc.setanswer(Playerid, OptionA);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionB") ) {
			 System.out.println(Name+";"+OptionB);
			 mc.setanswer(Playerid, OptionB);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionC") ) {
			 System.out.println(Name+";"+OptionC);
			 mc.setanswer(Playerid, OptionC);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionD") ) {
			 System.out.println(Name+";"+OptionD);
			 mc.setanswer(Playerid, OptionD);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionE") ) {
			 System.out.println(Name+";"+OptionE);
			 mc.setanswer(Playerid, OptionE);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionF") ) {
			 System.out.println(Name+";"+OptionF);
			 mc.setanswer(Playerid, OptionF);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionG") ) {
			 System.out.println(Name+";"+OptionG);
			 mc.setanswer(Playerid, OptionG);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionH") ) {
			 System.out.println(Name+";"+OptionH);
			 mc.setanswer(Playerid, OptionH);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionI") ) {
			 System.out.println(Name+";"+OptionI);
			 mc.setanswer(Playerid, OptionI);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionJ") ) {
			 System.out.println(Name+";"+OptionJ);
			 mc.setanswer(Playerid, OptionJ);
			 Auswahlfenster.dispose();
		 }}

}
