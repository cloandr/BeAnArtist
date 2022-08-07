package fr.eseo.gpi.beanartist.modele.geom;

public class Carré extends Rectangle {

  public Carré(Point position, int coté) {
    super(position,coté , coté);
  }

  public Carré(int coté) {
    this(new Point(),coté);
  }
  
  public Carré(int coordX, int coordY, int coté) {
    this(new Point(coordX, coordY), coté);
  }
  
  public Carré(Point position) {
    this(position,Forme.LARGEUR_PAR_DÉFAUT);
  }
  
  public Carré() {
    this(new Point(),Forme.LARGEUR_PAR_DÉFAUT);
  }

  public void setHauteur(int hauteur) {
    super.setHauteur(hauteur);
    super.setLargeur(hauteur);
  }
  
  public void setLargeur(int largeur) {
    super.setLargeur(largeur);
    super.setHauteur(largeur);
  }

  public String toString() {
    return (super.toString());
  }
}
