package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;

public class PointTest {
	public static void main(String [] args){
		Point point0 = new Point();
		Point point1 = new Point(5,12);
		System.out.println("l'origine est en "+point0.getX()+","+point0.getY());
		System.out.println("le point 1 est en "+point1.getX()+","+point1.getY());
		point0.déplacerVers(24,3);
		System.out.println("le point 0 est maintenant en "+point0.getX()+","+point0.getY());
		point1.déplacerDe(24,3);
		System.out.println("le point 1 est maintenant en "+point1.getX()+","+point1.getY());
		point0.toString();
		}
}
