package fr.eseo.gpi.beanartist.tests.modele.jugeom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;

import org.junit.Test;

public class JuLigneTest {

  @Test
  public void testConstructeurVide() { 
    Ligne ligne = new Ligne();
    assertEquals("vérification de la largeur :", 150, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 150, ligne.getHauteur());
    assertEquals("vérification des coordonnées en X :", 0, ligne.getX());
    assertEquals("vérification des coordonnées en Y :", 0, ligne.getY());
  }
  
  @Test
  public void testConstructeurPoint() { 
    Point point = new Point(2,4);
    Ligne ligne = new Ligne(point);
    assertEquals("vérification de la largeur :", 150, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 150, ligne.getHauteur());
    assertEquals("vérification des coordonnées en X :", 2, ligne.getX());
    assertEquals("vérification des coordonnées en Y :", 4, ligne.getY());
  }
  
  @Test
  public void testConstructeurLargeurHauteur() { 
    Ligne ligne = new Ligne(10,15);
    assertEquals("vérification de la largeur :", 10, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 15, ligne.getHauteur());
    assertEquals("vérification des coordonnées en X :", 0, ligne.getX());
    assertEquals("vérification des coordonnées en Y :", 0, ligne.getY());
  }
  
  @Test
  public void testConstructeurAll() { 
    Point point = new Point(2,4);
    Ligne ligne = new Ligne(point,10,15);
    assertEquals("vérification de la largeur :", 10, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 15, ligne.getHauteur());
    assertEquals("vérification des coordonnées en X :", 2, ligne.getX());
    assertEquals("vérification des coordonnées en Y :", 4, ligne.getY());
  }
  
  @Test
  public void testConstructeurPositionLargeurHauteur() { 
    Ligne ligne = new Ligne(2,4,10,15);
    assertEquals("vérification de la largeur :", 10, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 15, ligne.getHauteur());
    assertEquals("vérification des coordonnées en X :", 2, ligne.getX());
    assertEquals("vérification des coordonnées en Y :", 4, ligne.getY());
  }
  
  @Test
  public void testCalculAire() { 
    Ligne ligne = new Ligne(10,15);
    assertSame("vérification du calcul ligne'aire :", 0.0, ligne.aire());
  }
  
  @Test
  public void testGetSet() { 
    Ligne ligne = new Ligne();
    assertEquals("vérification de la largeur :", 150, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 150, ligne.getHauteur());
    ligne.setHauteur(10);
    assertEquals("vérification de la largeur :", 150, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 10, ligne.getHauteur());
    ligne.setLargeur(5);
    assertEquals("vérification de la largeur :", 5, ligne.getLargeur());
    assertEquals("vérification de la hauteur :", 10, ligne.getHauteur());
  }
  
  @Test
  public void testCalculPerimetre() { 
    Ligne ligne = new Ligne(10,15);
    assertSame("vérification du calcul ligne'aire :", 18.03, ligne.périmètre());
  }
}
