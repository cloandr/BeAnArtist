package fr.eseo.gpi.beanartist.vue.geom;

import fr.eseo.gpi.beanartist.modele.geom.Ligne;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueLigne extends VueForme {
  
  public VueLigne(Ligne ligne) {
    this(ligne, false);
  }
  
  public VueLigne(Ligne ligne, Color couleur) {
    this(ligne, couleur, false);
  }
  
  public VueLigne(Ligne ligne, boolean rempli) {
    this(ligne, COULEUR_LIGNE_PAR_DÉFAUT, rempli);
  }
  
  public VueLigne(Ligne ligne, Color couleurLigne, boolean rempli) {
    super(ligne, couleurLigne, rempli);
  }


  public void affiche(Graphics2D g2d) {
    g2d.setColor(this.getCouleurLigne());
    g2d.drawPolyline(new int[] {this.getForme().getX(),
        this.getForme().getX() + this.getForme().getLargeur()},
        new int[] {this.getForme().getY(), this.getForme().getY() + this.getForme().getHauteur()},
        2);
  }
}
