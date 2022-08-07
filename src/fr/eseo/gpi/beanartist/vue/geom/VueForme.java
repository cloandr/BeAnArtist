package fr.eseo.gpi.beanartist.vue.geom;

import fr.eseo.gpi.beanartist.modele.geom.Forme;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class VueForme {
  
  public static final Color COULEUR_LIGNE_PAR_DÉFAUT = Color.black;
  
  private Color couleurLigne;
  private boolean rempli;
  protected Forme forme;
  
  public VueForme(Forme forme, boolean rempli) {
    this(forme, COULEUR_LIGNE_PAR_DÉFAUT, rempli);
  }
  
  public VueForme(Forme forme, Color couleurLigne, boolean rempli) {
    this.couleurLigne = couleurLigne;
    this.rempli = rempli;
    this.forme = forme;
  }
  
  public void setCouleurLigne(Color couleur) {
    this.couleurLigne = couleur;
  }
  
  public Color getCouleurLigne() {
    return couleurLigne;
  }
  
  public Forme getForme() {
    return forme;
  }
  
  public boolean estRempli() {
    return this.rempli;
  }
  
  public void setRempli(boolean remplir) {
    this.rempli = remplir;
  }
  
  public abstract void affiche(Graphics2D g2D);
}
