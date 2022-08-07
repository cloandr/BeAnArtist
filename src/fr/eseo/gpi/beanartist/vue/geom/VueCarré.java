package fr.eseo.gpi.beanartist.vue.geom;

import fr.eseo.gpi.beanartist.modele.geom.Carré;

import java.awt.Color;

public class VueCarré extends VueRectangle {

  public VueCarré(Carré carré, boolean rempli) {
    super(carré, rempli);
  }
  
  public VueCarré(Carré carré, Color couleurLigne, boolean rempli) {
    super(carré, couleurLigne, rempli);
  }

}
