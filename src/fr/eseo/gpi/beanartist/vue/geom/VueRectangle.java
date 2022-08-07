package fr.eseo.gpi.beanartist.vue.geom;

import fr.eseo.gpi.beanartist.modele.geom.Rectangle;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueRectangle extends VueForme {
  
  public VueRectangle(Rectangle rectangle, boolean rempli) {
    this(rectangle, COULEUR_LIGNE_PAR_DÉFAUT, rempli);
  }
  
  public VueRectangle(Rectangle rectangle, Color couleurLigne, boolean rempli) {
    super(rectangle, couleurLigne, rempli);
  }
  
  public void affiche(Graphics2D g2d) {
    if (this.estRempli()) {
      g2d.setColor(this.getCouleurLigne());
      g2d.fillRect(this.getForme().getX(), this.getForme().getY(),
          this.getForme().getLargeur(), this.getForme().getHauteur());
    
    } else {
      g2d.setColor(this.getCouleurLigne());
      g2d.drawRect(this.getForme().getX(), this.getForme().getY(),
          this.getForme().getLargeur(), this.getForme().getHauteur());
    }
  }
}
