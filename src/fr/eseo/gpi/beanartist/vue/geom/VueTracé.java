package fr.eseo.gpi.beanartist.vue.geom;

import fr.eseo.gpi.beanartist.modele.geom.Tracé;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueTracé extends VueForme {
  
  public VueTracé(Tracé tracé) {
    this(tracé, COULEUR_LIGNE_PAR_DÉFAUT);
  }
  
  
  public VueTracé(Tracé tracé, Color couleurLigne) {
    super(tracé, couleurLigne, false);
  }
  
  Tracé trace = (Tracé) this.getForme();
  
  public void affiche(Graphics2D g2D){
    g2D.setColor(this.getCouleurLigne());
    for (int i = 0; i < trace.getLignes().size(); i++) {
      g2D.drawLine(trace.getLignes().get(i).getP1().getX(),trace.getLignes().get(i).getP1().getY(),
             trace.getLignes().get(i).getP2().getX(),trace.getLignes().get(i).getP2().getY());
    }
  }

}
