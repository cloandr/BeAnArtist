package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.vue.geom.VueRectangle;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.Color;

public class OutilRectangle extends OutilForme {
  
  public OutilRectangle(PanneauDessin newPanneauDessin) {
    super(newPanneauDessin);
    System.out.println("Outil ligne");
  }
  
  protected VueRectangle créerVueForme() {
    int debutX = super.getDébut().getX();
    int finX = super.getFin().getX();
    int debutY = super.getDébut().getY();
    int finY = super.getFin().getY();
    Rectangle rectangle = new Rectangle(Math.min(debutX, finX),Math.min(debutY, finY),
                                        Math.abs(finX - debutX),Math.abs(finY - debutY));
    VueRectangle vueRectangle = new VueRectangle(rectangle,
        super.getPanneauDessin().getCouleurLigne(), false);
    vueRectangle.setRempli(super.getPanneauDessin().getModeRemplissage());
    System.out.println(rectangle);
    return vueRectangle;
  }
}
