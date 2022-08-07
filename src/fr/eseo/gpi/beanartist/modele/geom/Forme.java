package fr.eseo.gpi.beanartist.modele.geom;

import java.text.DecimalFormat;

public abstract class Forme {

  public static final int LARGEUR_PAR_DÉFAUT = 150;
  public static final int HAUTEUR_PAR_DÉFAUT = 150;
  
  private int largeur;
  private int hauteur;
  
  private Point position;

  public Forme(Point position, int largeur, int hauteur) {
    this.position = position;
    this.largeur = largeur;
    this.hauteur = hauteur;
  }
  
  public Forme(int coordX,int coordY,int largeur, int hauteur) {
    this(new Point(coordX,coordY),largeur,hauteur);
  }

  public Forme() {
    this(new Point(),HAUTEUR_PAR_DÉFAUT,LARGEUR_PAR_DÉFAUT);
  }

  public Forme(int largeur,int hauteur) {
    this(new Point(),largeur,hauteur);
  }

  public Forme(Point position) {
    this(position,HAUTEUR_PAR_DÉFAUT,LARGEUR_PAR_DÉFAUT);
  }
  
  public Point getPosition() {
    return position;
  }

  public void setPosition(Point position) {
    this.position = position;
  }

  public int getLargeur() {
    return largeur;
  }

  public void setLargeur(int largeur) {
    this.largeur = largeur;
  }
  
  public int getHauteur() {
    return this.hauteur;
  }
  
  public void setHauteur(int hauteur) {
    this.hauteur = hauteur;
  }

  public int getX() {
    return getPosition().getX();
  }
 
  public void setX(int coordX) {
    position.déplacerVers(coordX,this.getY());
  }

  public int getY() {
    return getPosition().getY();
  }  
  
  public void setY(int coordY) {
    position.déplacerVers(this.getX(),coordY);
  }

  public int getMaxX() {
    int max = getX() + this.largeur;
    if (max < this.getX()) {
      max = this.getX();
    }
    return max;
  }

  public int getMaxY() {
    int max = getY() + this.hauteur;
    if (max < this.getY()) {
      max = this.getY();
    }
    return max;
  }

  public int getMinX() {
    int min = getX();
    if (min > this.getX() + this.largeur) {
      min = this.getX() + this.largeur;
    }
    return min;
  }
  
  public int getMinY() {
    int min = getY();
    if (min > this.getY() + this.hauteur) {
      min = this.getY() + this.hauteur;
    }
    return min;
  }

  public void déplacerVers(int coordX,int coordY) {
    Point point = new Point(coordX,coordY);
    setPosition(point);    
  }

  public void déplacerDe(int deltaX, int deltaY) {
    this.position.déplacerDe(deltaX,deltaY);
  }
  
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat();
    df.setMinimumFractionDigits(0);
    df.setMaximumFractionDigits(2);
    df.setGroupingUsed(false);
    String description = "[" + this.getClass().getSimpleName() + "] pos : (" + getX()
                         + "," + getY() + ") dim : " + this.getLargeur() + " x "
                         + this.getHauteur() + " périmètre : " + df.format(this.périmètre())
                         + " aire : " + df.format(this.aire());
    return description;
  }

  //Méthodes abstraites

  public abstract double aire();

  public abstract double périmètre();
  
  public abstract boolean contient(int coordX, int coordY);
  
  public abstract boolean contient(Point testPosition);
  
}
