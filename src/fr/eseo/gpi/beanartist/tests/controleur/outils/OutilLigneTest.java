package fr.eseo.gpi.beanartist.tests.controleur.outils;

import java.awt.Color;

import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.vue.ui.FenĂȘtreBeAnArtist;



public class OutilLigneTest {

	public static void main(String[] args) {
		FenĂȘtreBeAnArtist myfen = new FenĂȘtreBeAnArtist("Be An Artist", 500,1000,Color.YELLOW);
		myfen.getPanneauDessin().setCouleurLigne(Color.RED);
		OutilLigne monOutil = new OutilLigne(myfen.getPanneauDessin());
		myfen.getPanneauDessin().setOutilCourant(monOutil);
		
	}

}
