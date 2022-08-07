package fr.eseo.gpi.beanartist.modele.geom;

public class Ellipse extends Forme {

  public Ellipse() {
    super();
  }

  public Ellipse(Point position, int largeur, int hauteur) {
    super(position,largeur,hauteur);
  }

  public Ellipse(int largeur, int hauteur) {
    super(largeur,hauteur);
  }


  public Ellipse(Point position) {
    super(position);
  }
  
  public Ellipse(int valX , int valY , int largeur , int hauteur) {
    super(new Point(valX, valY), largeur , hauteur );
  }

  
  public double aire() {
    return (double)Math.PI * 0.5 * getLargeur() * 0.5 * getHauteur();
  }

  public double périmètre() {
    double valA = 0.5 * getHauteur();
    double valB = 0.5 * getLargeur();
    double valH = ((valA - valB) / (valA + valB) * (valA - valB) / (valA + valB));
    double valQ = (3 * valH) / (10 +  Math.sqrt(4 - 3 * valH));
    return (double)Math.PI * (valA + valB) * (1 + valQ);
  }
  
  public boolean contient(int coordX, int coordY) {
    return (coordX > this.getMinX() && coordX < this.getMinX() + this.getLargeur() 
            && coordY > this.getMinY() && coordY < this.getMinY() + this.getHauteur());
  }
  
  public boolean contient(Point testPosition) {
    return contient(testPosition.getX(),testPosition.getY());
  }
}