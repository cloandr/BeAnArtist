package fr.eseo.gpi.beanartist.tests.modele.jugeom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Point;

import org.junit.Test;

public class JuEllipseTest {

  @Test
  public void testConstructeurVide() { 
    Ellipse ellipse = new Ellipse();
    assertEquals("vérification de la largeur :", 150, ellipse.getLargeur());
    assertEquals("vérification de la hauteur :", 150, ellipse.getHauteur());
    assertEquals("vérification des coordonnées en X :", 0, ellipse.getX());
    assertEquals("vérification des coordonnées en Y :", 0, ellipse.getY());
  }
  
  @Test
  public void testConstructeurPositionLargeurHauteur() { 
    Point point = new Point(2,4);
    Ellipse ellipse = new Ellipse(point, 10,15);
    assertEquals("vérification de la largeur :", 10, ellipse.getLargeur());
    assertEquals("vérification de la hauteur :", 15, ellipse.getHauteur());
    assertEquals("vérification des coordonnées en X :", 2, ellipse.getX());
    assertEquals("vérification des coordonnées en Y :", 4, ellipse.getY());
  }
  
  @Test
  public void testConstructeurLargeurHauteur() { 
    Ellipse ellipse = new Ellipse(10,15);
    assertEquals("vérification de la largeur :", 10, ellipse.getLargeur());
    assertEquals("vérification de la hauteur :", 15, ellipse.getHauteur());
    assertEquals("vérification des coordonnées en X :", 0, ellipse.getX());
    assertEquals("vérification des coordonnées en Y :", 0, ellipse.getY());
  }
  
  @Test
  public void testConstructeurPosition() { 
    Point point = new Point(2,4);
    Ellipse ellipse = new Ellipse(point);
    assertEquals("vérification de la largeur :", 150, ellipse.getLargeur());
    assertEquals("vérification de la hauteur :", 150, ellipse.getHauteur());
    assertEquals("vérification des coordonnées en X :",2, ellipse.getX());
    assertEquals("vérification des coordonnées en Y :",4, ellipse.getY());
  }
  
  @Test
  public void testConstructeurAll() { 
    Ellipse ellipse = new Ellipse(2,4,10,15);
    assertEquals("vérification de la largeur :", 10, ellipse.getLargeur());
    assertEquals("vérification de la hauteur :", 15, ellipse.getHauteur());
    assertEquals("vérification des coordonnées en X :",2, ellipse.getX());
    assertEquals("vérification des coordonnées en Y :",4, ellipse.getY());
  }
  
  @Test
  public void testCalculAire() { 
    Ellipse ellipse = new Ellipse(10,15);
    assertSame("vérification du calcul de l'aire :", 117.75, ellipse.aire());
  }
  
  @Test
  public void testCalculPerimetre() { 
    Ellipse ellipse = new Ellipse(10,15);
    assertSame("vérification du calcul du perimetre:", 39.6, ellipse.périmètre());
  }
}
