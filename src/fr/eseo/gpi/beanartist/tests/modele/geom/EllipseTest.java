package fr.eseo.gpi.beanartist.tests.modele.geom;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;


public class EllipseTest {
	public static void main(String [] args){
		
		Ellipse ellip2= new Ellipse(117,74);
		Point point3= new Point();
		Ellipse ellip3= new Ellipse(point3);
		Ellipse ellip4= new Ellipse(point3,2,5);
		System.out.println(ellip2.toString());
		System.out.println(ellip2.périmètre());
		System.out.println(ellip3.aire());
		System.out.println(ellip4.toString());
	}

}
