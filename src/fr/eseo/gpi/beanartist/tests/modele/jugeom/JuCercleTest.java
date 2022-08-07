package fr.eseo.gpi.beanartist.tests.modele.jugeom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.modele.geom.Point;

import org.junit.Test;

public class JuCercleTest {
  
  @Test
  public void testConstructeurCentreHauteur() { 
    Point point = new Point(2,4);
    Cercle cercle = new Cercle(point,5); 
    assertEquals("vérification de la hauteur :", 5, cercle.getHauteur());
    assertEquals("vérification du centre en x :", 2, cercle.getX());
    assertEquals("vérification du centre en y :", 4, cercle.getY());
  }
  
  @Test
  public void testConstructeurPointHauteur() { 
    Cercle cercle = new Cercle(2,4,5); 
    assertEquals("vérification de la hauteur :", 5, cercle.getHauteur());
    assertEquals("vérification du centre en x :", 2, cercle.getX());
    assertEquals("vérification du centre en y :", 4, cercle.getY());
  }
  
  @Test
  public void testConstructeurHauteur() { 
    Cercle cercle = new Cercle(5); 
    assertEquals("vérification de la hauteur :", 5, cercle.getHauteur());
    assertEquals("vérification du centre en x :", 0, cercle.getX());
    assertEquals("vérification du centre en y :", 0, cercle.getY());
  }
  
  @Test
  public void testConstructeurCentre() { 
    Point point = new Point(2,4);
    Cercle cercle = new Cercle(point); 
    assertEquals("vérification de la hauteur :", 150, cercle.getHauteur());
    assertEquals("vérification du centre en x :", 2, cercle.getX());
    assertEquals("vérification du centre en y :", 4, cercle.getY());
  }
  
  @Test
  public void testConstructeurVide() { 
    Cercle cercle = new Cercle(); 
    assertEquals("vérification de la hauteur :", 150, cercle.getHauteur());
    assertEquals("vérification du centre en x :", 0, cercle.getX());
    assertEquals("vérification du centre en y :", 0, cercle.getY());
  }
  
  @Test
  public void testGetSet() {
    Cercle cercle = new Cercle(5);
    assertEquals("vérification de la largeur :", 5, cercle.getLargeur());
    assertEquals("vérification de la hauteur :", 5, cercle.getHauteur());
    cercle.setHauteur(10);
    assertEquals("vérification de la largeur :", 10, cercle.getLargeur());
    assertEquals("vérification de la hauteur :", 10, cercle.getHauteur());
    cercle.setLargeur(15);
    assertEquals("vérification de la largeur :", 15, cercle.getLargeur());
    assertEquals("vérification de la hauteur :", 15, cercle.getHauteur());
  }
  
  public void testCalculPerimetre() { 
    Cercle cercle = new Cercle(5);
    assertSame("vérification du calcul du périmètre :", 117.75, cercle.périmètre());
  }
}
