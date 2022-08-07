package fr.eseo.gpi.beanartist.modele.geom;

public class Cercle extends Ellipse {
  
  public static final int HAUTEUR_PAR_DEFAUT = 150;

  public Cercle(Point centre,int hauteur) {
    super(centre,hauteur, hauteur); 
  }
  
  public Cercle(int coordX, int coordY, int hauteur) {
    this(new Point(coordX, coordY), hauteur);
  }
  
  public Cercle(int hauteur) {
    this(new Point(), hauteur);
  }
  
  public Cercle(Point centre) {
    this(centre, HAUTEUR_PAR_DEFAUT);
  }
  
  public Cercle() {
    this(new Point(), HAUTEUR_PAR_DEFAUT);
  }
  
  public void setHauteur(int hauteur) {
    super.setHauteur(hauteur);
    super.setLargeur(hauteur);
  }
  
  public void setLargeur(int largeur) {
    super.setLargeur(largeur);
    super.setHauteur(largeur);
  }

  @Override
  public double périmètre() {
    return Math.PI * this.getHauteur();
  }
  
  public String toString() {
    return (super.toString());
  }
}