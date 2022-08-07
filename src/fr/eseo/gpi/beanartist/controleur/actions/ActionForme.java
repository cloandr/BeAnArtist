package fr.eseo.gpi.beanartist.controleur.actions;

import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.controleur.outils.OutilCarré;
import fr.eseo.gpi.beanartist.controleur.outils.OutilCercle;
import fr.eseo.gpi.beanartist.controleur.outils.OutilEllipse;
import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.controleur.outils.OutilRectangle;
import fr.eseo.gpi.beanartist.controleur.outils.OutilTracé;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionForme extends AbstractAction {
  
  private static final long serialVersionUID = -6644882096045793484L;
  
  public static final String NOM_ACTION_LIGNE = "Tracer Ligne";
  public static final String NOM_ACTION_RECTANGLE = "Tracer Rectangle";
  public static final String NOM_ACTION_CARRÉ = "Tracer Carré";
  public static final String NOM_ACTION_CERCLE = "Tracer Cercle";
  public static final String NOM_ACTION_ELLIPSE = "Tracer Ellipse";
  public static final String NOM_ACTION_TRACÉ = "Tracer Libre";
  
  FenêtreBeAnArtist fenêtreSave;
  Outil monOutil;
  
  public ActionForme(FenêtreBeAnArtist fenêtre){
    super();
    this.fenêtreSave = fenêtre;
  }
  
  public void actionPerformed(ActionEvent event) {
    fenêtreSave.getPanneauDessin().setVueFormeCourante(null);
    fenêtreSave.getPanneauDessin().setSelectionVueForme(null);
    fenêtreSave.getPanneauDessin().repaint();
    
    if (event.getActionCommand() == NOM_ACTION_LIGNE) {
      monOutil = new OutilLigne(fenêtreSave.getPanneauDessin());
      monOutil.associer(fenêtreSave.getPanneauDessin());
      fenêtreSave.getPanneauDessin().setOutilCourant(monOutil);
    }
    
    if (event.getActionCommand() == NOM_ACTION_RECTANGLE) {
      monOutil = new OutilRectangle(fenêtreSave.getPanneauDessin());
      monOutil.associer(fenêtreSave.getPanneauDessin());
      fenêtreSave.getPanneauDessin().setOutilCourant(monOutil);
    }
    
    if (event.getActionCommand() == NOM_ACTION_CARRÉ) {
      monOutil = new OutilCarré(fenêtreSave.getPanneauDessin());
      monOutil.associer(fenêtreSave.getPanneauDessin());
      fenêtreSave.getPanneauDessin().setOutilCourant(monOutil);
    }
    
    if (event.getActionCommand() == NOM_ACTION_CERCLE) {
      monOutil = new OutilCercle(fenêtreSave.getPanneauDessin());
      monOutil.associer(fenêtreSave.getPanneauDessin());
      fenêtreSave.getPanneauDessin().setOutilCourant(monOutil);
    }
    
    if (event.getActionCommand() == NOM_ACTION_ELLIPSE) {
      monOutil = new OutilEllipse(fenêtreSave.getPanneauDessin());
      monOutil.associer(fenêtreSave.getPanneauDessin());
      fenêtreSave.getPanneauDessin().setOutilCourant(monOutil);
    }
    
    if (event.getActionCommand() == NOM_ACTION_TRACÉ) {
      monOutil = new OutilTracé(fenêtreSave.getPanneauDessin());
      monOutil.associer(fenêtreSave.getPanneauDessin());
      fenêtreSave.getPanneauDessin().setOutilCourant(monOutil);
    }
  }
}
