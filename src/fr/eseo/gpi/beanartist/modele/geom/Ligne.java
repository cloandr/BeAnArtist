package fr.eseo.gpi.beanartist.modele.geom;


public class Ligne extends Forme {
  public static final double EPSILON = 0.5;
   
  public Ligne() {
     this(new Point(), Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
  }
   
  public Ligne(Point point) {
     this(point, Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
  }
   
  public Ligne(int largeur, int hauteur) {
     this(new Point(), largeur, hauteur);
  }
   
  public Ligne(int abs, int ord, int largeur, int hauteur) {
     this(new Point(abs, ord), largeur, hauteur);
  }
   
  public Ligne(Point position, int largeur, int hauteur) {
     super(position, largeur, hauteur);
  }
   
  public double aire() {
    return 0;
  }
   
  public Point getP1() {
    return this.getPosition();
  }
   
  public Point getP2() {
    Point point1 = this.getP1();
    return new Point(point1.getX() + this.getLargeur(), point1.getY() + this.getHauteur());
  }
   
  public void setP1(Point newPoint) {
    this.setLargeur(this.getLargeur() - newPoint.getX() + this.getPosition().getX());
    this.setHauteur(this.getHauteur() - newPoint.getY() + this.getPosition().getY());
    this.getP1().setX(newPoint.getX());
    this.getP1().setY(newPoint.getY());
  }
   
  public void setP2(Point newPoint) {
    this.setLargeur(newPoint.getX() - this.getPosition().getX());
    this.setHauteur(newPoint.getY() - this.getPosition().getY());
  }
   
  public int getMaxX() {
    int max = getX() + this.getLargeur();
    if (max < this.getX()) {
      max = this.getX();
    }
    return max;
  }

  public int getMaxY() {
    int max = getY() + this.getHauteur();
    if (max < this.getY()) {
      max = this.getY();
    }
    return max;
  }

  public int getMinX() {
    int min = getX();
    if (min > this.getX() + this.getLargeur()) {
      min = this.getX() + this.getLargeur();
    }
    return min;
  }
    
  public int getMinY() {
    int min = getY();
    if (min > this.getY() + this.getHauteur()) {
      min = this.getY() + this.getHauteur();
    }
    return min;
  }
  
  public double périmètre() {
    int coordX = this.getLargeur();
    int coordY = this.getHauteur();
    return Math.sqrt(coordX * coordX + coordY * coordY);
  }
   
  private double sqr(double coordX) {
    return coordX * coordX;
  }
   
  private double distance(int x1, int x2, int y1, int y2) {
    return Math.sqrt(sqr(y2 - y1) + sqr(x2 - x1));
  }
   
  public boolean contient(int coordX, int coordY) {
    return contient(new Point(coordX,coordY));
  }
   
  public boolean contient(Point point0) {
    Point point1 = this.getP1();
    Point point2 = this.getP2();
    double distanceP1P = Math.abs(distance(point1.getX(),
        point0.getX(), point1.getY(), point0.getY()));
    double distanceP2P = Math.abs(distance(point0.getX(),
        point2.getX(), point0.getY(), point2.getY()));
    double distanceP1P2 = Math.abs(distance(point1.getX(),
        point2.getX(), point1.getY(), point2.getY()));
    return distanceP1P + distanceP2P - distanceP1P2 <= EPSILON;
  }
   
  public String toString() {
    return "[Ligne] p1 : (" + this.getX() + "," + this.getY() + ") p2 : (" + this.getP2().getX()
           + "," + this.getP2().getY() + ") longeur : " + this.périmètre();
  }
}