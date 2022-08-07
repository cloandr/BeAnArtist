package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.vue.geom.VueCercle;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.Color;

public class OutilCercle extends OutilForme {
  
  public OutilCercle(PanneauDessin newPanneauDessin) {
    super(newPanneauDessin);
  }
  
  protected VueCercle créerVueForme(){
    int debutX = super.getDébut().getX();
    int finX = super.getFin().getX();
    int debutY = super.getDébut().getY();
    int finY = super.getFin().getY();
    Cercle cercle = new Cercle(Math.min(debutX, finX),
                               Math.min(debutY, finY),Math.abs(finX - debutX));
    VueCercle vueCercle = new VueCercle(cercle, super.getPanneauDessin().getCouleurLigne(), false);
    vueCercle.setRempli(super.getPanneauDessin().getModeRemplissage());
    System.out.println(cercle);
    return vueCercle;
  }
}
