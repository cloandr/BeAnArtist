package fr.eseo.gpi.beanartist.tests.controleur.outils;

import java.awt.Color;

import fr.eseo.gpi.beanartist.controleur.outils.OutilEllipse;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;



public class OutilEllipseTest {

	public static void main(String[] args) {
		FenêtreBeAnArtist myfen = new FenêtreBeAnArtist("Be An Artist", 500,1000,Color.YELLOW);
		myfen.getPanneauDessin().setCouleurLigne(Color.RED);
		new OutilEllipse(myfen.getPanneauDessin());

	}

}
