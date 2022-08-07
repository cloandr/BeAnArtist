package fr.eseo.gpi.beanartist.tests.modele.geom;

//import java.text.DecimalFormat;
//import java.text.DecimalFormatSymbols;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;

public class TracéTest {
	public static void main(String [] args){
		Tracé trace1 = new Tracé(new Point(15,20),new Point(34,89));
		System.out.println(trace1.contient(184,235));
		System.out.println(trace1.contient(195,165));
		System.out.println(trace1.contient(165,235));
		System.out.println(trace1.périmètre());
		System.out.println(trace1.aire());
		System.out.println(trace1.toString());
		
		
	}
}
