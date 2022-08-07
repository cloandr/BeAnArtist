package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.vue.geom.VueCarré;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.Color;

public class OutilCarré extends OutilForme {
  
  public OutilCarré(PanneauDessin newPanneauDessin) {
    super(newPanneauDessin);
    System.out.println("Outil ligne");
  }
  
  protected VueCarré créerVueForme() {
    int debutX = super.getDébut().getX();
    int finX = super.getFin().getX();
    int debutY = super.getDébut().getY();
    int finY = super.getFin().getY();
    Carré carré = new Carré(Math.min(debutX, finX),Math.min(debutY, finY),Math.abs(finX - debutX));
    VueCarré vueCarré = new VueCarré(carré, super.getPanneauDessin().getCouleurLigne(), false);
    vueCarré.setRempli(super.getPanneauDessin().getModeRemplissage());
    System.out.println(carré);
    return vueCarré;
  }
}
