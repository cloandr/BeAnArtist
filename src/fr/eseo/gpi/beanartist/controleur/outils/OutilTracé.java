package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.vue.geom.VueTracé;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class OutilTracé extends OutilForme {
  
  private Tracé maTrace;
  
  public OutilTracé(PanneauDessin newPanneauDessin) {
    super(newPanneauDessin);
    System.out.println("Outil tracé");
  }
  
  @Override
  public void mousePressed(MouseEvent event) {
    System.out.println("sourie appuyée outil forme trace");
    super.setDébut(new Point(event.getX(), event.getY()));
    super.setFin(new Point(event.getX(), event.getY()));
    super.getPanneauDessin().ajouterVueForme(this.créerVueForme());
  }
  
  @Override
  public void mouseReleased(MouseEvent event) {
    super.setFin(new Point(event.getX(), event.getY()));
    maTrace.ajouterLigneVers(new Point(event.getX(), event.getY()));
    super.getPanneauDessin().repaint();
    
  }
  
  @Override
  public void mouseDragged(MouseEvent event) {
    super.setFin(new Point(event.getX(), event.getY()));
    maTrace.ajouterLigneVers(new Point(event.getX(), event.getY()));
    super.getPanneauDessin().repaint();
  }
  
  @Override
  public void mouseClicked(MouseEvent event) {}
  
  protected VueTracé créerVueForme() {
    int debutX = super.getDébut().getX();
    int finX = super.getFin().getX();
    int debutY = super.getDébut().getY();
    int finY = super.getFin().getY();
    maTrace = new Tracé(new Point(debutX, debutY), new Point(finX, finY));
    VueTracé vueTrace = new VueTracé(maTrace, super.getPanneauDessin().getCouleurLigne());
    vueTrace.setRempli(super.getPanneauDessin().getModeRemplissage());
    System.out.println(maTrace);
    return vueTrace;
  }
}
