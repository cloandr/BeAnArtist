package fr.eseo.gpi.beanartist.modele.geom;

public class Point {
  
  private int coordX;
  private int coordY;

  public Point(int coordX, int coordY) {
    this.coordX = coordX;
    this.coordY = coordY;
  }

  public Point() {
    this(0,0);
  }
  
  public int getX() {
    return coordX;
  }

  public int getY() {
    return coordY;
  }
  
  public void setX(int theCoordX) {
    this.coordX = theCoordX;
  }
  
  public void setY(int theCoordY) {
    this.coordY = theCoordY;
  }
  
  public void déplacerVers(int theCoordX, int theCoordY) {
    this.coordX = theCoordX;
    this.coordY = theCoordY;
  }

  public void déplacerDe(int vectX, int vectY) {
    this.coordX += vectX;
    this.coordY += vectY;
  }
  
  public String toString() {
    return "(" + getX() + "," + getY() + ")";
  }
}
