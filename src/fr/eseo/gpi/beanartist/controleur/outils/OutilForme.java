package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.event.MouseEvent;

public abstract class OutilForme extends Outil {
  
  private VueForme maVue;

  public OutilForme(PanneauDessin newPanneauDessin) {
    super(newPanneauDessin);
  }
  
  public void mouseClicked(MouseEvent event){}
  
  public void mousePressed(MouseEvent event) {
    System.out.println("sourie appuyée outil forme");
    super.setDébut(new Point(event.getX(), event.getY()));
    super.setFin(new Point(event.getX(), event.getY()));
    maVue = this.créerVueForme();
    System.out.println(maVue);
    super.getPanneauDessin().ajouterVueForme(maVue);
  }
  
  public void mouseReleased(MouseEvent event) {
    super.setFin(new Point(event.getX(), event.getY()));
    super.getPanneauDessin().supprimerVueForme(maVue);
    maVue = this.créerVueForme();
    super.getPanneauDessin().ajouterVueForme(maVue);
    super.getPanneauDessin().repaint();
    
  }
  
  public void mouseDragged(MouseEvent event) {
    super.setFin(new Point(event.getX(), event.getY()));
    super.getPanneauDessin().supprimerVueForme(maVue);
    maVue = this.créerVueForme();
    super.getPanneauDessin().ajouterVueForme(maVue);
    super.getPanneauDessin().repaint();
  }
  
  protected abstract VueForme créerVueForme();
}
