package fr.eseo.gpi.beanartist.vue.geom;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.geom.Ellipse;

public class VueEllipse extends VueForme {
  public VueEllipse(Ellipse ellipse, boolean rempli) {
    this(ellipse, COULEUR_LIGNE_PAR_DÉFAUT, rempli);
  }
  
  public VueEllipse(Ellipse ellipse, Color couleurLigne, boolean rempli) {
    super(ellipse, couleurLigne, rempli);
  }
  
  public void affiche(Graphics2D g2d) {
    if (this.estRempli()) {
      g2d.setColor(this.getCouleurLigne());
      g2d.fillOval(this.getForme().getX(), this.getForme().getY(),
          this.getForme().getLargeur(), this.getForme().getHauteur());
    } else {
      g2d.setColor(this.getCouleurLigne());
      g2d.drawOval(this.getForme().getX(), this.getForme().getY(),
          this.getForme().getLargeur(), this.getForme().getHauteur());
    }
  }
}
