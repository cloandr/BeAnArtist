package fr.eseo.gpi.beanartist.tests.modele.jugeom;

import static org.junit.Assert.assertEquals;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Point;

import org.junit.Test;

public class JuCarréTest {
  
  @Test
  public void testConstructeurCoté() { 
    Carré carré = new Carré(5);
    assertEquals("vérification de la largeur :", 5, carré.getLargeur());
    assertEquals("vérification de la hauteur :", 5, carré.getHauteur());
    assertEquals("vérification de la position en x :", 0, carré.getX());
    assertEquals("vérification de la position en y :", 0, carré.getY());
  }
  
  @Test
  public void testConstructeurAll() { 
    Carré carré = new Carré(1,2,5);
    assertEquals("vérification de la largeur :", 5, carré.getLargeur());
    assertEquals("vérification de la hauteur :", 5, carré.getHauteur());
    assertEquals("vérification de la position en x :", 1, carré.getX());
    assertEquals("vérification de la position en y :", 2, carré.getY());
  }

  @Test
  public void testConstructeurPosition() { 
    Point p = new Point(1,2);
    Carré carré = new Carré(p);
    assertEquals("vérification de la largeur :", 150, carré.getLargeur());
    assertEquals("vérification de la hauteur :", 150, carré.getHauteur());
    assertEquals("vérification de la position en x :", 1, carré.getX());
    assertEquals("vérification de la position en y :", 2, carré.getY());
  }
  
  @Test
  public void testConstructeurVide() { 
    Carré carré = new Carré();
    assertEquals("vérification de la largeur :", 150, carré.getLargeur());
    assertEquals("vérification de la hauteur :", 150, carré.getHauteur());
    assertEquals("vérification de la position en x :", 0, carré.getX());
    assertEquals("vérification de la position en y :", 0, carré.getY());
  }
  
  @Test
  public void testGetSet() { 
    Carré carré = new Carré();
    carré.setHauteur(10);
    assertEquals("vérification de la largeur :", 10, carré.getLargeur());
    assertEquals("vérification de la hauteur :", 10, carré.getHauteur());
    carré.setLargeur(5);
    assertEquals("vérification de la largeur :", 5, carré.getLargeur());
    assertEquals("vérification de la hauteur :", 5, carré.getHauteur());
  }
  
}
