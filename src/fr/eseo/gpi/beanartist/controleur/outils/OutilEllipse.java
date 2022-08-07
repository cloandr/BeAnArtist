package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.vue.geom.VueEllipse;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.Color;

public class OutilEllipse extends OutilForme {
  
  public OutilEllipse(PanneauDessin newPanneauDessin) {
    super(newPanneauDessin);
  }
  
  protected VueEllipse créerVueForme(){
    int debutX = super.getDébut().getX();
    int finX = super.getFin().getX();
    int debutY = super.getDébut().getY();
    int finY = super.getFin().getY();
    Ellipse ellipse = new Ellipse(Math.min(debutX, finX),Math.min(debutY, finY),
                                  Math.abs(finX - debutX),Math.abs(finY - debutY));
    VueEllipse vueEllipse = new VueEllipse(ellipse,
        super.getPanneauDessin().getCouleurLigne(), false);
    vueEllipse.setRempli(super.getPanneauDessin().getModeRemplissage());
    System.out.println(ellipse);
    return vueEllipse;
  }
}
