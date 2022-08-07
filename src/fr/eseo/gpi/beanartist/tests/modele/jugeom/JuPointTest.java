package fr.eseo.gpi.beanartist.tests.modele.jugeom;

import static org.junit.Assert.assertEquals;

import fr.eseo.gpi.beanartist.modele.geom.Point;

import org.junit.Test;

public class JuPointTest {

  @Test
  public void testConstructeurVide() { //constructeur vide
    Point p1 = new Point();
    assertEquals("vérification des coordonnées du points :", 0, p1.getX());
    assertEquals("vérification des coordonnées du points :", 0, p1.getY());
  }
  
  @Test
  public void testConstructeurNonVide() { //constructeur non vide
    Point p2 = new Point(2,4);
    assertEquals("vérification des coordonnées du points :", 2, p2.getX());
    assertEquals("vérification des coordonnées du points :", 4, p2.getY());
  }
  
  @Test
  public void testGetSet() { //get set
    Point p3 = new Point(2,4);
    p3.setX(10);
    assertEquals("vérification du changement de coordonnées du points :", 10, p3.getX());
    p3.setY(14);
    assertEquals("vérification du changement des coordonnées du points :", 14, p3.getY());  
  }
  
  @Test
  public void testDéplacerVers() {
    Point p4 = new Point(2,4);
    p4.déplacerVers(5,5);
    assertEquals("vérification du changement des coordonnées du points :", 5, p4.getX());
    assertEquals("vérification du changement des coordonnées du points :", 5, p4.getY());  
  }
  
  @Test
  public void testDéplacerDe() {
    Point p5 = new Point(2,4);
    p5.déplacerDe(5,5);
    assertEquals("vérification du changement des coordonnées du points :", 7, p5.getX());
    assertEquals("vérification du changement des coordonnées du points :", 9, p5.getY());  
  }
  
  @Test
  public void testtoString() {
    Point p6 = new Point(2,4);
    assertEquals("vérification du toString :", "(2,4)", p6.toString());
  
  }
}
