package fr.eseo.gpi.beanartist.tests.modele.jugeom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;

import org.junit.Test;

public class JuRectangleTest {

  @Test
  public void testConstructeurNonVidePoint() { 
    Rectangle rectangle = new Rectangle(2,2,10,15);
    assertEquals("vérification de la largeur :", 10, rectangle.getLargeur());
    assertEquals("vérification de la hauteur :", 15, rectangle.getHauteur());
    assertEquals("vérification de la position :" , 2, rectangle.getX());
    assertEquals("vérification de la position :" , 2, rectangle.getY());
  }
  
  @Test
  public void testConstructeurNonVidePosition() { 
    Rectangle rectangle = new Rectangle(10,15);
    assertEquals("vérification de la largeur :", 10, rectangle.getLargeur());
    assertEquals("vérification de la hauteur :", 15, rectangle.getHauteur());
    assertEquals("vérification de la position :" , 0, rectangle.getX());
    assertEquals("vérification de la position :" , 0, rectangle.getY());
  }
  
  @Test
  public void testConstructeurNonVidePositionHauteurLargeur() { 
    Point point = new Point(6,7);
    Rectangle rectangle = new Rectangle(point,10,15);
    assertEquals("vérification de la largeur :", 10, rectangle.getLargeur());
    assertEquals("vérification de la hauteur :", 15, rectangle.getHauteur());
    assertEquals("vérification de la position :" , 6, rectangle.getX());
    assertEquals("vérification de la position :" , 7, rectangle.getY());
  }
  
  @Test
  public void testCalculAire() { 
    Rectangle rectangle = new Rectangle(10,15);
    assertSame("verification de l'aire du rectangle :" ,150, rectangle.aire());
    
  }
  
  @Test
  public void testCalculPerimetre() { 
    Rectangle rectangle = new Rectangle(10,15);
    assertSame("verification du perimetre  du rectangle :" ,50, rectangle.périmètre());
    
  }
  
  @Test
  public void testContientTrue() { 
    Rectangle rectangle = new Rectangle(10,15);
    assertTrue("verification du contient du rectangle :" ,rectangle.contient(5,8));
  }
  
  public void testContientFalse() { 
    Rectangle rectangle = new Rectangle(10,15);
    assertTrue("verification du contient du rectangle :" ,!rectangle.contient(13,20));
  }

  @Test
  public void testConstructeurVide() { //constructeur vide
    Rectangle r1 = new Rectangle();
    assertEquals("vérification de la largeur :", 150, r1.getLargeur());
    assertEquals("vérification de la hauteur :", 150, r1.getHauteur());
  }
}
