package fr.eseo.gpi.beanartist.vue.geom;

import fr.eseo.gpi.beanartist.modele.geom.Cercle;

import java.awt.Color;

public class VueCercle extends VueEllipse {
  
  public VueCercle(Cercle cercle, boolean rempli) {
    super(cercle, rempli);
  }
  
  public VueCercle(Cercle cercle, Color couleurLigne, boolean rempli) {
    super(cercle, couleurLigne, rempli);
  }
}
