package fr.eseo.gpi.beanartist.modele.geom;

public class Rectangle extends Forme {

  public Rectangle(Point position,int largeur, int hauteur) {
    super(position, largeur, hauteur);
  }
  
  public Rectangle(int largeur, int hauteur) {
    this(new Point(), largeur , hauteur);
  }
  
  public Rectangle(Point position) {
    this(position , Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
  }
  
  public Rectangle() {
    this(new Point(), Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
  }
  
  public Rectangle(int coordX, int coordY, int largeur , int hauteur) {
    this(new Point(coordX, coordY), largeur , hauteur);
  }

  public double aire() {
    return this.getHauteur() * this.getLargeur();
  }
  
  public double périmètre() {
    return 2 * this.getLargeur() + 2 * this.getHauteur();
  }
  
  public boolean contient(int coordX, int coordY) {
    return (coordX > this.getMinX() && coordX < this.getMinX() + this.getLargeur()
      && coordY > this.getMinY() && coordY < this.getMinY() + this.getHauteur());
  }
  
  public boolean contient(Point testPosition) {
    int coordX = testPosition.getX();
    int coordY = testPosition.getY();
    return (coordX > this.getMinX() && coordX < this.getMinX() + this.getLargeur()
      && coordY > this.getMinY() && coordY < this.getMinY() + this.getHauteur());
  }
}