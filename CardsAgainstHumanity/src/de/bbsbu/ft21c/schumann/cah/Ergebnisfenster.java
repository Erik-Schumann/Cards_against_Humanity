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

public class Ergebnisfenster extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JFrame Auswahlfenster;
	JPanel Inhalt;
	String Frage, OptionA, OptionB, OptionC, OptionD, OptionE, OptionF, OptionG, OptionH,OptionI, OptionJ, Name;
	String Auswahl;
	int Playerid;
	MyClient mc;
	public Ergebnisfenster(String Name, MyClient mc, int Playerid, String question, String Name1, String Answer1, String Name2, String Answer2, String Name3, String Answer3, String Name4, String Answer4, int points1, int points2, int points3, int points4) {
		this.Name = Name; 
		this.OptionA = Answer1 + " von " + Name1;
		this.OptionB = Answer2 + " von " + Name2;
		this.OptionC = Answer3 + " von " + Name3;
		this.OptionD = Answer4 + " von " + Name4;
		this.Playerid = Playerid;
		this.Frage = question;
		this.mc = mc;
		Auswahlfenster = new JFrame("Rundenergebnis");
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

		JLabel TextfeldAPunkte = new JLabel(points1+"");
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldAPunkte, c);
		JLabel TextfeldA = new JLabel(" "+OptionA);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldA, c);

		JLabel TextfeldBPunkte = new JLabel(points2+"");
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldBPunkte, c);
		JLabel TextfeldB = new JLabel(" "+OptionB);
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldB, c);
		JLabel TextfeldCPunkte = new JLabel(points3+"");
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldCPunkte, c);
		JLabel TextfeldC = new JLabel(" "+OptionC);
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldC, c);
		JLabel TextfeldDPunkte = new JLabel(points4+"");
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldDPunkte, c);
		JLabel TextfeldD = new JLabel(" "+OptionD);
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		Inhalt.add(TextfeldD, c);
		
		
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
	 public void actionPerformed( ActionEvent evt)
	 {
		/* if ( evt.getActionCommand().equals("OptionA") ) {
			 System.out.println(Name+";"+OptionA);
			 mc.givepoints(1);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionB") ) {
			 System.out.println(Name+";"+OptionB);
			 mc.givepoints(2);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionC") ) {
			 System.out.println(Name+";"+OptionC);
			 mc.givepoints(3);
			 Auswahlfenster.dispose();
		 }
		 if ( evt.getActionCommand().equals("OptionD") ) {
			 System.out.println(Name+";"+OptionD);
			 mc.givepoints(4);
			 Auswahlfenster.dispose();
		 }*/
}

}
