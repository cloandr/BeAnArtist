package fr.eseo.gpi.beanartist.tests.modele.geom;
import fr.eseo.gpi.beanartist.modele.geom.Carré;


public class CarréTest {
	public static void main(String [] args){
		Carré unCarré = new Carré ();
		System.out.println(unCarré);
		Carré deuxCarré = new Carré(4,5,9);
		System.out.println(deuxCarré);
		deuxCarré.setHauteur(87);
		deuxCarré.setLargeur(37);
		System.out.println(deuxCarré);
	}
}
