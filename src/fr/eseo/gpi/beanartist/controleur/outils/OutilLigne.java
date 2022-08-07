package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.Color;

public class OutilLigne extends OutilForme {
  
  public OutilLigne(PanneauDessin newPanneauDessin) {
    super(newPanneauDessin);
    System.out.println("Outil ligne");
  }
  
  protected VueLigne créerVueForme() {
    System.out.println("1");
    Ligne ligne = new Ligne(super.getDébut());
    System.out.println("2");
    ligne.setP2(super.getFin());
    System.out.println("3");
    VueLigne vueligne = new VueLigne(ligne, super.getPanneauDessin().getCouleurLigne(), false);
    System.out.println("nouvelle ligne");
    System.out.println(ligne);
    return vueligne;
  }
}
