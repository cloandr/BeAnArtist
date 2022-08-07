package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.geom.Forme;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueRectangle;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.event.MouseEvent;

public class OutilSélection extends Outil {
  
  private Forme formeSélectionnée;
  
  public OutilSélection(PanneauDessin thePanneauDessin) {
    super(thePanneauDessin);
  }
  
  public void mousePressed(MouseEvent event){}
  
  public void mouseClicked(MouseEvent event) {
    boolean selectionValide = false;
    PanneauDessin panneau = super.getPanneauDessin();
    for (int index = 0; index < super.getPanneauDessin().getVueFormes().size(); index++) {
      if (panneau.getVueFormes().get(index).getForme().contient(event.getX(), event.getY())) {
        selectionValide = true;
        super.getPanneauDessin().setVueFormeCourante(
                       super.getPanneauDessin().getVueFormes().get(index));
        Forme formeCourante = panneau.getVueFormeCourante().getForme();
        super.getPanneauDessin().setSelectionVueForme(
              new VueRectangle(new Rectangle(
                  new Point(formeCourante.getX() - 5, formeCourante.getY() - 5),
                  formeCourante.getLargeur() + 10, formeCourante.getHauteur() + 10), false)); 
        super.getPanneauDessin().repaint();
      }
      if (!selectionValide) {
        super.getPanneauDessin().setSelectionVueForme(null);
        super.getPanneauDessin().setVueFormeCourante(null);
        super.getPanneauDessin().repaint();
      }
    }
  }
  
  public void mouseReleased(MouseEvent event){}
  
  public void mouseEntered(MouseEvent event){}
  
  public void mouseExited(MouseEvent event){}
  
  @Override
  public void mouseDragged(MouseEvent event) {
    PanneauDessin panneau = super.getPanneauDessin();
    if (super.getPanneauDessin().getVueFormeCourante() != null) {
      Forme formeSelectionCourante = panneau.getSelectionVueForme().getForme();
      int valCoinXSelection = formeSelectionCourante.getMaxX() - event.getX();
      int valCoinYSelection = formeSelectionCourante.getMaxY() - event.getY();
      Forme formeCourante = panneau.getVueFormeCourante().getForme();
      int valCoinXForme = formeCourante.getMaxX() - event.getX();
      int valCoinYForme = formeCourante.getMaxY() - event.getY();
      formeSelectionCourante.déplacerVers(event.getX() - 5 - valCoinXSelection,
                                          event.getY() - 5 - valCoinYSelection);
      formeCourante.déplacerVers(event.getX() - valCoinXForme, event.getY() - valCoinYForme);
      super.getPanneauDessin().repaint();
    }
  }
  
  public void mouseMoved(MouseEvent event){}
  
  protected VueForme créerVueForme() {
    return null;
  }

}
