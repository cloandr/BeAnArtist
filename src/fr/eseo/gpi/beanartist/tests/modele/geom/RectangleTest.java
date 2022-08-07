package fr.eseo.gpi.beanartist.tests.modele.geom;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.modele.geom.Point;

public class RectangleTest {
	public static void main(String [] args){
		Point point = new Point(15,20);
		Rectangle rect4 = new Rectangle(point, 5,10);
		System.out.println("largeur : "+rect4.getLargeur()+", hauteur : "+rect4.getHauteur());
		System.out.println("abscisse du point : "+rect4.getX()+"; ordonnee du point : "+rect4.getY());
	}
}
