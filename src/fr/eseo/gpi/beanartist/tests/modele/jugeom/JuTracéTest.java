package fr.eseo.gpi.beanartist.tests.modele.jugeom;

import static org.junit.Assert.assertEquals;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;

import org.junit.Test;

public class JuTracéTest {

  @Test
  public void testLargeurHauteur() { 
    Point p1 = new Point(2,4);
    Point p2 = new Point(6,8);
    Tracé trace = new Tracé(p1, p2);
    assertEquals("vérification de la largeur :", 4, trace.getLargeur());
    assertEquals("vérification de la hauteur :", 4, trace.getHauteur());
  }
  
  @Test
  public void testGetSet() { 
    Point p1 = new Point(2,4);
    Point p2 = new Point(6,8);
    Tracé trace = new Tracé(p1, p2);
    trace.setX(5);
    assertEquals("vérification de la largeur :", 4, trace.getLargeur());
    assertEquals("vérification de la hauteur :", 4, trace.getHauteur());
    trace.setY(10);
    assertEquals("vérification de la largeur :", 4, trace.getLargeur());
    assertEquals("vérification de la hauteur :", 4, trace.getHauteur());
    Point p3 = new Point();
    trace.setPosition(p3);
    assertEquals("vérification de la largeur :", 4, trace.getLargeur());
    assertEquals("vérification de la hauteur :", 4, trace.getHauteur());
  }
}
