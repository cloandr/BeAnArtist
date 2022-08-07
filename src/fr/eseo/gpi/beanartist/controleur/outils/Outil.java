package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Outil implements MouseListener, MouseMotionListener {
  
  private PanneauDessin panneauDessin;
  private Point début;
  private Point fin;
  
  public Outil(PanneauDessin newPanneauDessin) {
    this.panneauDessin = newPanneauDessin;
  }
  
  public void associer(PanneauDessin thePanneauDessin) {
    this.libérer();
    thePanneauDessin.addMouseListener(this);
    thePanneauDessin.addMouseMotionListener(this);
    thePanneauDessin.setOutilCourant(this);
  }
  
  public PanneauDessin getPanneauDessin() {
    return this.panneauDessin;
  }
  
  public void setPanneauDessin(PanneauDessin newPanneauDessin) {
    this.panneauDessin = newPanneauDessin;
  }
  
  private void libérer() {
    if (this.panneauDessin.getMouseListeners().length > 0) {
      this.panneauDessin.removeMouseListener(this.panneauDessin.getMouseListeners()[0]);
    }
    if (this.panneauDessin.getMouseMotionListeners().length > 0) {
      this.panneauDessin.removeMouseMotionListener(this.panneauDessin.getMouseMotionListeners()[0]);
    }
  }
  
  public void setDébut(Point point) {
    this.début = point;
  }
  
  public Point getDébut() {
    return this.début;
  }
  
  public void setFin(Point point) {
    this.fin = point;
  }
  
  public Point getFin() {
    return this.fin;
  }
  
  public void mousePressed(MouseEvent event){}
  
  public void mouseClicked(MouseEvent event){}
  
  public void mouseReleased(MouseEvent event){}
  
  public void mouseEntered(MouseEvent event){}
  
  public void mouseExited(MouseEvent event){}
  
  public void mouseDragged(MouseEvent event){}
  
  public void mouseMoved(MouseEvent event){}
  
  protected abstract VueForme créerVueForme();
}
