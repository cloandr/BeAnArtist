package fr.eseo.gpi.beanartist.tests.modele.geom;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;

public class CercleTest {
	public static void main(String [] args){
		Cercle cercle1= new Cercle();
		System.out.println(cercle1);
		Cercle cercle2= new Cercle(2);
		System.out.println(cercle2.aire());
		System.out.println(cercle2.périmètre());
		
	}

}
